package subsetsum;

import static org.junit.Assert.*;
import java.lang.Math;
import org.junit.Test;

public class SubsetSumTester {
	
	/**
	 * This method will generate the a sum of a random subset in the set
	 * @param set the set of integers to be chosen from
	 * @param solSize the length that the solution will be
	 * @return a sum that has at least one solution in the set
	 */
	public static int genSum (int[] set, int solSize) {
		int sum = 0;
		int[] used = new int[solSize];
				
		//Randomly take numbers out of the set and add them to sum
		for (int x=0; x<solSize; x++) {
			int randNum;
			boolean tryAgain;
			
			do {
				tryAgain = false;
				randNum = (int)(Math.random() * set.length);
				
				//Make sure this number hasn't been used already
				for (int y=0; y<x; y++) {
					if (randNum == used[y]) {
						tryAgain = true;
						break;
					}
				}
			} while (tryAgain);
			
			//Add this index into used
			used[x] = randNum;
			
			//Add this number to the sum
			sum += set[randNum];
		}
		
		return sum;
	}
	
	@Test
	public void testFindSubset() {
		int SOLSIZE = 7;
		
		for (int a=7; a<151; a++) {
			int[] set;
			int sum;
			
			set = new int[a];
			
			//Assign random numbers between 1 and 200000 into the set (repeats accepted)
			for (int x=0; x<set.length; x++) {
				set[x] = 100000 - (int)(Math.random() * 200001);
			}
			
			//Get a sum that is made from SOLSIZE numbers from the set
			sum = genSum(set, SOLSIZE);
			
			//Get their solution set
			int[] theirSol = SubsetSum.findSubset(set, sum);
			
			//Get the sum of their set
			int theirSum = 0;
			for (int x=0; x<theirSol.length; x++) {
				theirSum += theirSol[x];
			}
			
			//Print out information about this test neatly
			printInfo(set, theirSol, sum, theirSum);
			
			//Check to see if their sum adds up to the provided sum
			assertEquals("The sum of these numbers is not equal to the given sum",sum,theirSum);
			
			//Check to see if their solution is the right size
			assertEquals("There are too many or too few numbers in your subset",SOLSIZE,theirSol.length);
			
			//Make sure that all the values in their solution are in the set
			int[] usedIndices = new int[theirSol.length];
			//Loop to go through all the numbers in their solution set
			for (int x=0; x<theirSol.length; x++) {
				boolean continueL1 = false;
				
				//Loop to go through all the numbers in the original set
				for (int y=0; y<set.length; y++) {
					boolean continueL2 = false;
					
					//Loop to make sure that numbers are not reused
					for(int z=0; z<x; z++) {
						if (y == usedIndices[z]) {
							continueL2 = true;
							break;
						}
					}
					
					//If continue2 is set, then the index y is equal to another number in the set
					if (continueL2)
						continue;
					
					//See if this value in their solution is equal to this number in the set
					if (theirSol[x] == set[y]) {
						usedIndices[x] = y;
						continueL1 = true;
						break;
					}
				}
				
				//If continueL1 is set, then the number at index x in their solution is in the set
				if (continueL1)
					continue;
				
				fail("One or more of the numbers in your solution was not in the provided set. " + theirSol[x] + " is not in the provided set");
			}
		}
		
	}
	
	@Test
	public void bigSetTest() {
		int SOLSIZE = 7;
		int[] set = new int[70000];
		int sum;
		
		System.out.println("Big set test:\nSet size: " + set.length);
		
		//Assign random numbers between 1 and 50000 into the set (repeats accepted)
		for (int x=0; x<set.length; x++) {
			set[x] = 100000 - (int)(Math.random() * 200001);
		}
		
		//Get a sum that is made from SOLSIZE numbers from the set
		sum = genSum(set, SOLSIZE);
		
		System.out.println("Target sum: " + sum);
		
		//Get their solution set
		int[] theirSol = SubsetSum.findSubset(set, sum);
		
		//Get the sum of their set
		int theirSum = 0;
		for (int x=0; x<theirSol.length; x++) {
			theirSum += theirSol[x];
		}
		
		//Print out information about this test neatly
		System.out.println("Your sum: " + theirSum);
		
		//Check to see if their sum adds up to the provided sum
		assertEquals("The sum of these numbers is not equal to the given sum",sum,theirSum);
		
		//Check to see if their solution is the right size
		assertEquals("There are too many or too few numbers in your subset",SOLSIZE,theirSol.length);
		
		//Make sure that all the values in their solution are in the set
		boolean allInSet = true;
		int errorOnIndex = -1;
		int[] usedIndices = new int[theirSol.length];
		//Loop to go through all the numbers in their solution set
		for (int x=0; x<theirSol.length; x++) {
			boolean continueL1 = false;
			
			//Loop to go through all the numbers in the original set
			for (int y=0; y<set.length; y++) {
				boolean continueL2 = false;
				
				//Loop to make sure that numbers are not reused
				for(int z=0; z<x; z++) {
					if (y == usedIndices[z]) {
						continueL2 = true;
						break;
					}
				}
				
				//If continue2 is set, then the index y is equal to another number in the set
				if (continueL2)
					continue;
				
				//See if this value in their solution is equal to this number in the set
				if (theirSol[x] == set[y]) {
					usedIndices[x] = y;
					continueL1 = true;
					break;
				}
			}
			
			//If continueL1 is set, then the number at index x in their solution is in the set
			if (continueL1)
				continue;
			
			allInSet = false;
			errorOnIndex = x;
			break;
		}
		
		if (!allInSet) {
			fail("One or more of the numbers in your solution was not in the provided set. " + theirSol[errorOnIndex] + " is not in the provided set");
		}
		
	}
	
	public void printInfo(int[] set, int[] theirSol, int sum, int theirSum) {
		String setString = "";
		for (int x=0; x<set.length; x++) {
			setString += set[x];
			if (x+1 != set.length)
				setString += " ";
		}
		String sumString = String.valueOf(sum);
		String theirSetString = "";
		for (int x=0; x<theirSol.length; x++) {
			theirSetString += theirSol[x];
			if (x+1 != theirSol.length)
				theirSetString += " ";
		}
		String theirSumString = String.valueOf(theirSum);
		System.out.print("Provided set\t");
		for (int x=16; x<setString.length(); x++) {
			System.out.print(" ");
		}
		System.out.print("\t\tTarget Sum");
		for (int x=10; x<sumString.length(); x++) {
			System.out.print(" ");
		}
		System.out.print("\t\tYour Solution");
		for (int x=13; x<theirSetString.length(); x++) {
			System.out.print(" ");
		}
		System.out.println("\t\tSum of Your Solution");
		System.out.print(setString);
		for (int x=setString.length(); x<12; x++) {
			System.out.print(" ");
		}
		System.out.print("\t\t" + sumString);
		for (int x=sumString.length(); x<10; x++) {
			System.out.print(" ");
		}
		System.out.print("\t\t" + theirSetString);
		for (int x=theirSetString.length(); x<13; x++) {
			System.out.print(" ");
		}
		System.out.println("\t\t" + theirSumString + "\n\n");
	}
}
