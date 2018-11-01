package watermelons;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Watermelons {
	
	/**
	 * Computes the sum of each distinct pair of entries in the incoming array.
	 * A given pair of entries has its sum computed only once.  So if you
	 * compute the sum for entries 2 and 4, and that sum appears in your answer
	 * array, then you do not also compute the sum of entries 4 and 2.
	 * Depending on the input, the same sum value may appear multiple times in the result.
	 * For example, if all of the incoming values are 0, then so are all of the returned values.
	 * @param nums an array of integers, possibly containing duplicates
	 * @return an array containing the sums of pairs as described above
	 */
	public static int[] allPairSums(int[] nums) {
//		count of the possible pairs without getting rid of duplicates. number of pairs: n = a(a-1)/2 
		int n = nums.length * (nums.length-1) /2;
		int [] sumPairs = new int[n];

	
//		create a 2d arraylist to store index i,j and sum, of all the pairs before filtering them
		List<List<Integer>> list = new ArrayList<List<Integer>>(); 
//		instantiate all columns of 2d array
	    for(int i = 0; i < list.size(); i++)  {
	    	list.add(new ArrayList<Integer>());
	    }
		
	    
		for (int i=0; i<nums.length; i++) {
//			System.out.println(" a loop");
			for (int j = 0; j<nums.length;j++) {
				if (j == i ) {
					continue;
				}
//				System.out.println("(" + i + "," + j +") ");
				List<Integer> rawPairsWithIndex = new ArrayList<>(Arrays.asList(i,j,nums[i] + nums[j]));
				list.add(rawPairsWithIndex);
			}
		}
		
		
//		already got the list with info needed, now handle duplicate i-j vs j-i
//		rawPairsWithIndex: arraylist of [i,j,sum]
		
		for(int i=0; i<list.size();i++) {
			for(int j=0; j<list.size();j++) {
				if (j !=i && list.get(i).get(0) == list.get(j).get(1) && list.get(i).get(1) == list.get(j).get(0)) {
					list.remove(j);
				}
			}
		}
		
//		now you have unique pairs(of course I can handle everything and will not need another function)		
//		System.out.println(list);
		
		
//		now you add the sums from this list to the array, cheers!
		for(int i=0; i<list.size();i++) {
			sumPairs[i] = list.get(i).get(2).intValue();
		}
		return sumPairs;
	}
	
	/**
	 * The method below must COMPUTE and return a solution as described
	 * on the web page for this extension.  
	 * 
	 * You must compute the solution by trying
	 * lots of possibilities, and finding the one that yields the right answer.
	 * 
	 * You can run the provided unit test to see if you are right.
	 * @param pairSums is array of watermelon pairwise sums.  In other words,
	 *    each element of pairSums represents the sum of one pair of watermelons in our puzzle.
	 * @return
	 */
//	10 sumPairs, 5 watermelons
	public static int[] getSolution(int[] originalSums) {
		int[] watermelon = new int[5];
		int maxSum = 0;
		int[] answer = new int[5];
		
		for (int i = 0; i < originalSums.length; i++) {
//			maxSum = Math.max(originalSums[i], originalSums[i+1]);
			maxSum = 30;
		}
//		
		

		for (int i =1; i<maxSum; i++) {
			for (int j =1; j<maxSum; j++) {
				for (int k =1; k<maxSum; k++) {
					for (int l =1; l<maxSum; l++) {
						for (int m =1; m<maxSum; m++) {			
							int[] theWatermelon = {i,j,k,l,m};
							System.out.println("the test "+ Arrays.toString(theWatermelon));
							int[] theSum = allPairSums(theWatermelon);
							if(sameIntArrays(theSum, originalSums)) {
								answer = theWatermelon;
								System.out.println("the sum "+ Arrays.toString(theSum));
								System.out.println("originalsum " + Arrays.toString(originalSums));
								System.out.println("the answer "+ Arrays.toString(answer));
								return answer;
							}								
						}
					}
				}
			}
		}
		System.out.println("hint: try to set a larger number");
		return answer;
		
	}
	
	/**helper function
	 * Compare two arrays for equality.  They must first be
	 * sorted, so that Arrays.equals can do its thing element
	 * by element, as is it wants.
	 * 
	 * However, what if the caller doesn't want the arrays to
	 * be disturbed?  We therefore clone the arrays (copies are
	 * made of them) before we do the compare, and we compare the
	 * clones.
	 * @param one: an array, not mutated
	 * @param two: another array, not mutated
	 * @return true iff the arrays' contents are the same
	 */
	public static boolean sameIntArrays(int[] one, int[] two) {
		int[] cone = (int[]) one.clone();
		int[] ctwo = (int[]) two.clone();
		Arrays.sort(cone);
		Arrays.sort(ctwo);
		return Arrays.equals(cone, ctwo);
	}

	
	
	public static void main(String[] args) {
//		for self test only
		
//		int[] test = {20, 10, 30, 40};
//		allPairSums(test);
//		System.out.println(allPairSums(test));
		
		
		int[] testSolution = {20, 22, 23, 24, 25, 26, 27, 28, 30, 31};
		getSolution(testSolution);
		


	    }
		
		
		
		
	
	
	
}
