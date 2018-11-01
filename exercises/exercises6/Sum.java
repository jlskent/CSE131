/**
 * 
 */
package exercises6;

/**
 * @author yang
 *
 */


//Complete both so that sum is computed as defined by the explicitly recursive formula:
//sum(n) = sum(n-1) + n, if n > 0
//sum(n) = 0, otherwise
//Write some tests for sum and run the unit test file to make sure your function works.


public class Sum {
	
	static int sum(int n) {
//		if base case
		
		if (n>0) {
			return n + sum(n-1);
		}
		else {
			return 0;
		}
		
		
	}
	
	

}
