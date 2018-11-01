package arrays;
import cse131.ArgsProcessor;

/**
 * @author Yang
 *
 */
public class PascalsTriangle {

	public static void main(String[] args) {
		ArgsProcessor ap = new ArgsProcessor(args);
		
		int N = ap.nextInt("enter the number of rows to compute of the triangle");
		int[][] pasT = new int[N][N];
		
		for (int r = 0; r < N; r++) {
			for(int c = 0; c < N; c++) {
				if (c == 0) {
					pasT[r][c] = 1;
				}
				if (c == r) {
					pasT[r][c] = 1;
				}
				if (r<0 || c<0  || c>r) {
					pasT[r][c] = 0;
				}
				else if (r > 0 && c > 0){
					pasT[r][c] = pasT[r-1][c] + pasT[r-1][c-1];
				}
			}
		}
		
		
//		output
		
		System.out.println("\tcolumn");
		System.out.print("\t");

			for(int c = 0; c < N; c++) {
				System.out.print(c+ " ");	
			}
		
			System.out.println("\n");
			System.out.println("row");

		for (int r = 0; r < N; r++) {
			System.out.print(r + "\t");
			for(int c = 0; c < N; c++) {
				if (pasT[r][c] !=0) {
				System.out.print(pasT[r][c]+ " ");	
				}
			}				
			System.out.println();				

		}
		
		
	}

}
