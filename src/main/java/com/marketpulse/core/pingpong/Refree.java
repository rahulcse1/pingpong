package com.marketpulse.core.pingpong;

import java.util.HashMap;

public class Refree {

	// refree class will also works as game manager .. Refree monitor everything.
	public static HashMap<Integer, Game> GAME_MANAGER = new HashMap<Integer, Game>();

	Player thewinner;

	public static void saveGameStatus(Integer gameid, Game game) {
		GAME_MANAGER.put(gameid, game);
	}

	public static void generateReport() {
		// all the games with player details and score.
		listAllGames();
	}

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

	public static void winner() {
		System.out.println("================== Final winner of this game ==================");
		Championship.WINNER.forEach((k, v) -> {
			System.out.println("Player, who won the tournament: " + v.keySet().iterator().next());
		});
	}
}
