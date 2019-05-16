package com.marketpulse.core.pingpong;

import java.util.Arrays;

/**
 * <p>
 * Player domain class that hold the information for player.
 * </p>
 */
public class Player {

	private Integer playerid;
	private String playerName;
	private Integer defensiveSize;
	private boolean isOffensive;
	private boolean winner;
	private Integer curgameid;
	private Integer[] defensiveArrayForPlayer;
	private Integer score;

	public Integer getPlayerid() {
		return playerid;
	}

	public void setPlayerid(Integer playerid) {
		this.playerid = playerid;
	}

	public String getPlayerName() {
		return playerName;
	}

	public void setPlayerName(String playerName) {
		this.playerName = playerName;
	}

	public Integer getDefensiveSize() {
		return defensiveSize;
	}

	public void setDefensiveSize(Integer defensiveSize) {
		this.defensiveSize = defensiveSize;
	}

	public boolean isOffensive() {
		return isOffensive;
	}

	public void setOffensive(boolean isOffensive) {
		this.isOffensive = isOffensive;
	}

	public boolean isWinner() {
		return winner;
	}

	public void setWinner(boolean winner) {
		this.winner = winner;
	}

	public Integer getCurgameid() {
		return curgameid;
	}

	public void setCurgameid(Integer curgameid) {
		this.curgameid = curgameid;
	}

	public Integer[] getDefensiveArrayForPlayer() {
		return defensiveArrayForPlayer;
	}

	public void setDefensiveArrayForPlayer(Integer[] defensiveArrayForPlayer) {
		this.defensiveArrayForPlayer = defensiveArrayForPlayer;
	}

	public boolean isNumberExistsInArray(Integer number) {
		return Arrays.asList(defensiveArrayForPlayer).contains(number);
	}

	public Integer getScore() {
		return score;
	}

	public void setScore(Integer score) {
		this.score = score;
	}

	@Override
	public String toString() {
		StringBuffer object = new StringBuffer();
		object.append("PlayerId = ").append(playerid).append("\n");
		object.append("PlayerName = ").append(playerName).append("\n");
		object.append("Score = ").append(score).append("\n");
		object.append("Winner = ").append(winner).append("\n");
		return object.toString();
	}
}
