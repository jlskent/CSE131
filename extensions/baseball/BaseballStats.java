package baseball;

import cse131.ArgsProcessor;

public class BaseballStats {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ArgsProcessor ap = new ArgsProcessor(args);
		
		String name = ap.nextString("What is the name of the player");
		int at_Bats = ap.nextInt("The number of at-bats the player has");
		int hits = ap.nextInt("the hits of the player");
		double battingAvg = Math.round((double)hits / (double)at_Bats *1000) /1000.0;

		
		boolean isAllStar;
		if (at_Bats > 200 && battingAvg >= 0.27) {
			isAllStar = true;
		}
		else {
			isAllStar = false;
		}
		

		
		
		String output = name  + " " + battingAvg + "\nAll star worthy? " + isAllStar;
		
		System.out.println(output);

		

	}

}
