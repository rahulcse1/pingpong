package com.marketpulse.core.pingpong;

import java.util.Map;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

public class AppTest extends TestCase {

	Championship championship = new Championship();

	public AppTest(String testName) {
		super(testName);
	}

	public static Test suite() {
		return new TestSuite(AppTest.class);
	}

	public void testStartGame() {

		Integer gameid = 1;
		Integer playerid1 = 1;
		Integer playerid2 = 2;

		Game game = new Game();

		Player player1 = championship.preparePlayer(playerid1, gameid);
		game.setPlayer1(player1);
		Player player2 = championship.preparePlayer(playerid2, gameid);
		player2.setOffensive(false);
		game.setPlayer2(player2);

		Map<Integer, Integer> gamescore = game.getGamescore();
		gamescore.put(playerid1, 0);
		gamescore.put(playerid2, 0);

		boolean startGame = false;
		// player need to win 3 games to win the championship.
		for (int i = 0; i < 3; i++) {
			startGame = championship.startGame(game, player1, player2, gamescore);
		}
		assertTrue(startGame);
	}

	public void testPreparePlayer() {

		Integer gameid = 1;
		Integer playerid1 = 1;

		Player player = championship.preparePlayer(playerid1, gameid);

		assertEquals(player.getPlayerName(), "Joey");
		assertEquals((int) player.getDefensiveSize(), 7);
		assertEquals(player.isOffensive(), true); // by default setting true.
	}
}
