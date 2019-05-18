package com.marketpulse.core.pingpong;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Championship {

	public static Map<Integer, Map<String, Integer>> WINNER = new HashMap<Integer, Map<String, Integer>>();
	Refree refree = new Refree();

	/**
	 * <p>
	 * Calculate the game point for each player based on the problem statement.
	 * {@link: https://paper.dropbox.com/doc/Backend-Coding-Challenge-khIj3GOBa7YKk0qrI9oP9}
	 * </p>
	 * 
	 * @param game
	 * @param player1
	 * @param player2
	 * @param gamescore
	 * @return
	 */
	public boolean startGame(Game game, Player player1, Player player2, Map<Integer, Integer> gamescore) {

		int randomNum = Utils.getRandom();
		boolean p1pickup = player1.isNumberExistsInArray(randomNum);
		boolean p2pickup = player2.isNumberExistsInArray(randomNum);

		if ((player1.isOffensive() && !p2pickup) || (player2.isOffensive() && p1pickup)) {
			Integer score = gamescore.get(player1.getPlayerid());
			score += 1;
			gamescore.put(player1.getPlayerid(), score);
			if (score >= 5) {
				player1.setWinner(true);
			}
			player1.setScore(score);
			player2.setOffensive(true);
			player1.setOffensive(false);
		} else if ((player2.isOffensive() && !p1pickup) || (player1.isOffensive() && p2pickup)) {
			Integer score = gamescore.get(player2.getPlayerid());
			score += 1;
			gamescore.put(player2.getPlayerid(), score);
			if (score >= 5) {
				player2.setWinner(true);
			}
			player2.setScore(score);
			player1.setOffensive(true);
			player2.setOffensive(false);
		}
		if (gamescore.get(player1.getPlayerid()) < 5 && gamescore.get(player2.getPlayerid()) < 5) {
			startGame(game, player1, player2, gamescore);
		}
		return true;
	}

	/**
	 * <p>
	 * Start of championship. we are basically keeping track of match by holding the
	 * information in two hashmap. we are removing the 2 player at a time from
	 * Original map PLAYER_MATRIX once game done between them. And putting winner
	 * details in a temp map PLAYER_MATRIX_CLONE. then copying PLAYER_MATRIX_CLONE
	 * into PLAYER_MATRIX for next iteration.
	 * 
	 * After all the games are done. PLAYER_MATRIX will contain the only one entry.
	 * thats the winner details. Any player need to win 3 games to win the
	 * tournament.
	 * </p>
	 * 
	 * @param PLAYER_MATRIX
	 */
	public void startChampionship(Map<Integer, Map<String, Integer>> PLAYER_MATRIX) {

		// take 2 random player - 4 pair parallel - remove loser from the list.
		// repeat the process till the real winner.

		Set<Integer> playerids = PLAYER_MATRIX.keySet();
		Map<Integer, Map<String, Integer>> PLAYER_MATRIX_CLONE = new HashMap<Integer, Map<String, Integer>>();
		PLAYER_MATRIX_CLONE.putAll(PLAYER_MATRIX);

		while (PLAYER_MATRIX.size() > 1) {
			Integer playerid1 = Utils.getRandomPlayerid();
			Integer playerid2 = Utils.getRandomPlayerid();

			if (playerid1 != playerid2 && playerids.contains(playerid1) && playerids.contains(playerid2)) {
				Integer gameid = Utils.getRandom();
				while (Refree.GAME_MANAGER.containsKey(gameid)) {
					gameid = Utils.getRandom();
				}
				Game game = new Game();
				game.setGameid(gameid);
				Player player1 = preparePlayer(playerid1, gameid);
				game.setPlayer1(player1);
				Player player2 = preparePlayer(playerid2, gameid);
				player2.setOffensive(false);
				game.setPlayer2(player2);

				Map<Integer, Integer> gamescore = game.getGamescore();
				gamescore.put(playerid1, 0);
				gamescore.put(playerid2, 0);

				boolean startGame = startGame(game, player1, player2, gamescore);
				game.setStatus(startGame);
				refree.saveGameStatus(gameid, game);

				int winnerid = player1.isWinner() ? player1.getPlayerid() : player2.getPlayerid();
				int looserid = player1.isWinner() ? player2.getPlayerid() : player1.getPlayerid();

				PLAYER_MATRIX.remove(winnerid);
				PLAYER_MATRIX.remove(looserid);
				PLAYER_MATRIX_CLONE.remove(looserid);
			}
		}
		if (PLAYER_MATRIX_CLONE.size() == 1) {
			WINNER.putAll(PLAYER_MATRIX_CLONE);
		}
		if (PLAYER_MATRIX_CLONE.size() > 1) {
			PLAYER_MATRIX.putAll(PLAYER_MATRIX_CLONE);
			startChampionship(PLAYER_MATRIX_CLONE);
		}
	}

	public Player preparePlayer(Integer playerid, Integer gameid) {
		Player player = new Player();
		player.setPlayerid(playerid);
		player.setPlayerName(Utils.getPlayerName(playerid));
		player.setDefensiveArrayForPlayer(Utils.getDefensiveArrayForPlayer(playerid));
		player.setDefensiveSize(Utils.getPlayerDefensiveSize(playerid));
		player.setOffensive(true);
		player.setCurgameid(gameid);
		return player;
	}
}
