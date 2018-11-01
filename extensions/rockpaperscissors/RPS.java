package RockPaperScissors;

import cse131.ArgsProcessor;

public class RPS {
	/**
	 * @author Yang
	 *
	 */
	public static void main(String[] args) {
		ArgsProcessor ap = new ArgsProcessor(args);
		int numRounds = ap.nextInt("How many rounds to play?");
		int numberUserWin = 0;
		String[] array = { "R", "P", "S", "R" };

		for (int r = 0; r < numRounds; r++) {
			// each round
			System.out.println("-----------Round " + r);

			// simulate the computer
			String move;
			double random = Math.random() * 3;
			if (random < 1) {
				move = "R";
			} else if (1 < random && random < 2) {
				move = "P";
			} else {
				move = "S";
			}
			// simulate the computer

			// user input
			String userMove = ap.nextString("What is your move? choose among R,P,S");
			System.out.println("Computer " + move + ", Human " + userMove);
			// user input

			// determine who wins
			for (int i = 0; i < 3; i++) {
				if (move.equals(array[i]) && userMove.equals(array[i + 1])) {
					System.out.println("USER WINS");
					numberUserWin += 1;
				}
			}
			// determine who wins

		}
		// end of rounds
		System.out.println("Human wins " + numberUserWin + " times");
	}
}

