package studio6;

import cse131.ArgsProcessor;

/**
 * @author Yang
 *
 */
public class Beer {

	
//	recursive function
	String bottlesOfBeer(int n) {
		if (n == 0 ) {
			return "no beer";
		}
		else {
			return String.valueOf(n)  + " bottles on the wall, " + String.valueOf(n) +" bottles of beer, you take one down, pass it around, " + String.valueOf(n-1) + " bottles of beear on the wall.\n" + bottlesOfBeer(n-1);
		}
	}
	
/*note: for the line of the return, the recursive call is put into last because any other string will not be executed after it calls */
	
public static void main(String[] args) {
	ArgsProcessor ap = new ArgsProcessor(args);
	int n = ap.nextInt("enter the number of bottles: n");
	while (n<=0) {
		n = ap.nextInt("enter a valid number");
	}
	
	Beer beer = new Beer();
	System.out.println(beer.bottlesOfBeer(n));
	
	
	}

}
