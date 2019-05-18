package com.marketpulse.core.pingpong;

import java.util.HashMap;

/**
 * <p>
 * Refree class provides information about the games and player. we can get the
 * information about particular game. Score of both player and who win etc.
 * </p>
 */
public class Refree {

	// refree class will also works as game manager .. Refree monitor everything.
	public static HashMap<Integer, Game> GAME_MANAGER = new HashMap<Integer, Game>();

	Player thewinner;

	/**
	 * <p>
	 * save the game info. currently map hold the information.
	 * </p>
	 * TODO: save in database.
	 * 
	 * @param gameid
	 * @param game
	 */
	public static void saveGameStatus(Integer gameid, Game game) {
		GAME_MANAGER.put(gameid, game);
	}

	public static void generateReport() {
		// all the games with player details and score.
		listAllGames();
	}

	/**
	 * list out all the games played in the championship.
	 */
	private static void listAllGames() {
		GAME_MANAGER.forEach((k, v) -> {
			System.out.println("================== Game Details for Game Id : " + k + " ==================");
			System.out.println("Game Score against id : " + v.getGamescore());
			System.out.println("Player 1 details : " + v.getPlayer1());
			System.out.println("Player 2 details : " + v.getPlayer2());
			System.out.println("Winner of this game : "
					+ (v.getPlayer1().isWinner() ? v.getPlayer1().getPlayerName() : v.getPlayer2().getPlayerName()));
		});
	}

	/**
	 * <p>
	 * Return the particular game information.
	 * </p>
	 * 
	 * @param gameid
	 * @return
	 */
	public static Game getGameDetails(Integer gameid) {
		return GAME_MANAGER.get(gameid);
	}

	/**
	 * final winner.
	 */
	public static void winner() {
		System.out.println("================== Final winner of this game ==================");
		Championship.WINNER.forEach((k, v) -> {
			System.out.println("Player, who won the tournament: " + v.keySet().iterator().next());
		});
	}
	
}
