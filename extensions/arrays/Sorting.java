package arrays;
import java.util.Arrays;

import cse131.ArgsProcessor;

/**
 * @author Yang
 *
 */
public class Sorting {
	
	public static void main(String[] args) {
		
		
//		user input
		ArgsProcessor ap = new ArgsProcessor(args);
		int N = ap.nextInt("size of the collection");
		while (N<=1) {
			N = ap.nextInt("Please enter a positive integer");
		}
		int[] arr = new int[N];
		for (int i =0; i< N; i++) {
			arr[i] = ap.nextInt("Please provide integers one by one");
		}
		
		System.out.println("original:" + Arrays.toString(arr));
		
//		test only
//		int N = 20;
//		int[] arr = {8,65,97,76,13,27,14,10, 2, 5, 5, 3, 9, 6, 1, 4, 8, 7, 49, 3};
	
		
		int sortCount = 0;
		int temp;
		while (sortCount < N) {

//			flag of the index of sorting->smaller number
			int index = sortCount;
//			System.out.println("---------------------------------sorted count " + sortCount + " sorting index " + index);

//			scan unsorted, grab the index if there is a smaller number from it
			for (int i =index+1; i<N; i++) {
				if (arr[index] > arr[i]) {
//					System.out.println("switching     " +arr[index] + " and " +arr[i] );
//					System.out.println("sorting index " +index + " and " +i );
					index = i;
				}
			}	
			
			
//			switch values with current sorting index
			if (index != sortCount) {
				temp = arr[index];
				arr[index] = arr[sortCount];
				arr[sortCount] = temp;
//				System.out.println("process:" + Arrays.toString(arr));
			}
				
//			System.out.println("---a loop complete");
			sortCount++;
		}
		
		
//		printing result
		System.out.println("result:" + Arrays.toString(arr));
		
//		printing mean
		int sum = 0;
		for (int aNumber: arr) {
			sum += aNumber;
		}
		double mean = (double)sum/(double)arr.length;
		System.out.println("Mean:" + String.format("%.2f", mean));

//		printing median
		int median;
		if(arr.length%2 ==0) {
			median = (arr[N/2] + arr[N/2+1]) /2;
		}
		else {
			median = arr[(N+1)/2];
		}
		System.out.println("Median: " + median);
		
//		printing smallest and largest
		System.out.println("Min: " + arr[0]);
		System.out.println("Max: " + arr[N-1]);
		System.out.println("Range: " + (arr[N-1]-arr[0]));

		
		
		
	}

}
