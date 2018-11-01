package mario;

import cse131.ArgsProcessor;

public class Mario {

	public static void main(String[] args) {
		
		//
		// Surprise!  This part is done for you.
		//    Don't change this and don't ask for any other inputs
		//      or testing will fail
		//
		ArgsProcessor ap = new ArgsProcessor(args);
		int size    = ap.nextInt("What size mountain do you want?");
		int pattern = ap.nextInt("What pattern (1, 2, 3, or 4)?");
		
		if (size < 1)
			throw new IllegalArgumentException("Size must be at least 1");
		if (pattern < 1 || pattern > 4)
			throw new IllegalArgumentException("Invalid pattern, must be 1, 2, 3, or 4.  Mario aborts");
		
		//
		// Create the mountain by printing to System.out
		//

	}

}
