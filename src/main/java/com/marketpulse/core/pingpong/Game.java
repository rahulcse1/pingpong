package com.marketpulse.core.pingpong;

import java.util.HashMap;
import java.util.Map;

public class Game {

	// need for monitoring the game/ saving the game info
	private Integer gameid;
	private Player player1, player2;
	private boolean status;
	private Map<Integer, Integer> gamescore;

	public Integer getGameid() {
		return gameid;
	}

	public void setGameid(Integer gameid) {
		this.gameid = gameid;
	}

	public Player getPlayer1() {
		return player1;
	}

	public void setPlayer1(Player player1) {
		this.player1 = player1;
	}

	public Player getPlayer2() {
		return player2;
	}

	public void setPlayer2(Player player2) {
		this.player2 = player2;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public Map<Integer, Integer> getGamescore() {
		if (gamescore == null) {
			gamescore = new HashMap<Integer, Integer>();
		}
		return gamescore;
	}
	
}