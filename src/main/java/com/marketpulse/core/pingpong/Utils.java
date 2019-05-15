package com.marketpulse.core.pingpong;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class Utils {

	public static Integer TOTAL_PLAYER = 8;

	public static Map<Integer, Map<String, Integer>> PLAYER_MATRIX = new HashMap<Integer, Map<String, Integer>>();

	public static Map<Integer, Integer[]> PLAYER_DEFENSIVE_ARRAY = new HashMap<Integer, Integer[]>();

	static {
		PLAYER_MATRIX.put(1, Collections.singletonMap("Joey", 7));
		PLAYER_MATRIX.put(2, Collections.singletonMap("Monica", 6));
		PLAYER_MATRIX.put(3, Collections.singletonMap("Chandler", 6));
		PLAYER_MATRIX.put(4, Collections.singletonMap("Ross", 5));
		PLAYER_MATRIX.put(5, Collections.singletonMap("Phoebe", 5));
		PLAYER_MATRIX.put(6, Collections.singletonMap("Rachel", 6));
		PLAYER_MATRIX.put(7, Collections.singletonMap("Sachin", 4));
		PLAYER_MATRIX.put(8, Collections.singletonMap("Rohan", 5));
	}

	public static String getPlayerName(Integer playerid) {
		Map<String, Integer> player = PLAYER_MATRIX.get(playerid);
		return player.keySet().iterator().next();
	}

	public static Integer getPlayerDefensiveSize(Integer playerid) {
		Map<String, Integer> player = PLAYER_MATRIX.get(playerid);
		return player.values().iterator().next();
	}

	public static Map<Integer, Integer[]> getDefensiveArray() {
		PLAYER_DEFENSIVE_ARRAY.put(1, new Integer[] { getRandom(), getRandom(), getRandom(), getRandom(), getRandom(),
				getRandom(), getRandom() });
		PLAYER_DEFENSIVE_ARRAY.put(2,
				new Integer[] { getRandom(), getRandom(), getRandom(), getRandom(), getRandom(), getRandom() });
		PLAYER_DEFENSIVE_ARRAY.put(3,
				new Integer[] { getRandom(), getRandom(), getRandom(), getRandom(), getRandom(), getRandom() });
		PLAYER_DEFENSIVE_ARRAY.put(4,
				new Integer[] { getRandom(), getRandom(), getRandom(), getRandom(), getRandom() });
		PLAYER_DEFENSIVE_ARRAY.put(5,
				new Integer[] { getRandom(), getRandom(), getRandom(), getRandom(), getRandom() });
		PLAYER_DEFENSIVE_ARRAY.put(6,
				new Integer[] { getRandom(), getRandom(), getRandom(), getRandom(), getRandom(), getRandom() });
		PLAYER_DEFENSIVE_ARRAY.put(7, new Integer[] { getRandom(), getRandom(), getRandom(), getRandom() });
		PLAYER_DEFENSIVE_ARRAY.put(8,
				new Integer[] { getRandom(), getRandom(), getRandom(), getRandom(), getRandom() });
		return PLAYER_DEFENSIVE_ARRAY;
	}

	public static Integer[] getDefensiveArrayForPlayer(Integer playerid) {
		Integer[] defesiveArray = getDefensiveArray().get(playerid);
		return defesiveArray;
	}

	public static Integer getRandom() {
		int max = 10;
		int min = 1;
		Integer x = (int) (Math.random() * ((max - min) + 1)) + min;
		return x;
	}

	public static Integer getRandomPlayerid() {
		int max = 8;
		int min = 1;
		Integer x = (int) (Math.random() * ((max - min) + 1)) + min;
		return x;
	}
}