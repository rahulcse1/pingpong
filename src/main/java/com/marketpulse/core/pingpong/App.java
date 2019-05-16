package com.marketpulse.core.pingpong;

/**
 * 
 * <p>
 * Main class to run the App. This class serve as entry point for the
 * Championship.
 * </p>
 *
 *
 */
public class App {
	
	public static void main(String[] args) {
		System.out.println("==================  The Ping Pong Challenge ======================");
		Championship championship = new Championship();
		championship.startChampionship(Utils.PLAYER_MATRIX);
		Refree.generateReport();
		Refree.winner();
		System.out.println("==================  The Ping Pong Challenge done ==================");
	}
}
