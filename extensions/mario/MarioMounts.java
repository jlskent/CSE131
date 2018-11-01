package Mario;

import cse131.ArgsProcessor;

public class MarioMounts {

	public static void main(String[] args) {
		ArgsProcessor ap = new ArgsProcessor(args);
		int n = ap.nextInt("What is the size of the mountain?");	

		//mountain ascends to the right
		for(int i=1; i<=n; ++i){
			for (int j=1; j<=n-i; ++j){
				System.out.print(" ");
			}
			for (int j=n; j>n-i; --j){
				System.out.print("#");
			}
			System.out.println();
		}

		System.out.println();

		//mountain descends to the right
		for(int i=1; i<=n; ++i){
			for (int j=1; j<=i; ++j){
				System.out.print("#");
			}
			System.out.println();
		}

		System.out.println();

		//mountain ascends to the right upside down
		for(int i=1; i<=n; ++i){
			for (int j=n; j>n-i+1; --j){
				System.out.print(" ");
			}
			for (int j=1; j<=n-i+1; ++j){
				System.out.print("#"); 
			}
			System.out.println();
		}
		
		System.out.println();
		
		//mountain descends to the right upside down
				for(int i=1; i<=n; ++i){
					for (int j=1; j<=n-i+1; ++j){
						System.out.print("#");
					}
					System.out.println();
				}

	}

}
