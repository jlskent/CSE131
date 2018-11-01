package minesweeper;

import cse131.ArgsProcessor;

/**
 * @author Yang
 *
 */
public class MineSweeper {

	public static void main(String[] args) {

		ArgsProcessor ap = new ArgsProcessor(args);
		 int cols = ap.nextInt("How many columns?");
		 int rows = ap.nextInt("How many rows?");
		 double percent = ap.nextDouble("What is the probability of a bomb?");


		// test only
//		int cols = 5;
//		int rows = 3;
//		double percent = 0.3;


// generate matrix with bombs
		boolean[][] bombs = new boolean[rows + 2][cols + 2];
		for (int i = 1; i <= rows; i++) {
			for (int j = 1; j <= cols; j++) {
				bombs[i][j] = (Math.random() < percent);
			}
		}
// generate matrix with bombs


		
//numbers of adjacent bombs for a cell, store in array
		int[][] right = new int[rows + 2][cols + 2];
		for (int i = 1; i <= rows; i++) {
			for (int j = 1; j <= cols; j++) {
//				check adjacent
				for (int ii = i - 1; ii <= i + 1; ii++) {
					for (int jj = j - 1; jj <= j + 1; jj++) {
						if (bombs[ii][jj])
							right[i][j]++;
					}
				}
			}
		}
//numbers of adjacent bombs for a cell, store in array

		
		
// print out result  
		for (int i = 1; i <= rows; i++) {
			for (int j = 1; j <= cols; j++) {
				
//				print left
				if (bombs[i][j])
					System.out.print("* ");
				else
					System.out.print(". ");
//				print left

				
//				print the right part when reach the end of the left
				if (j==cols) {
					System.out.print("   ");
//					loop again for j loop
					for (j = 1; j <= cols; j++) {
						if (bombs[i][j])
							System.out.print(right[i][j] + " ");
						else {
							System.out.print(". ");
						}
					}
				}
//				print the right part when reach the end of the left
			}
			
			
			System.out.println();
		}
// print out result  



	}

}
