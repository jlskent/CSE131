package studio6;
/**
 * @author yang
 *
 */


//Base case:
//	A big circle in the middle 
//recur call:
//	locate 4 points on circle and draw 4 small ones by recursion


import sedgewick.StdDraw;


public class Circles {
	
	
	private static void recursiveCircles(double xCenter, double yCenter, double radius) {
		

//		recur exit
		if (radius < 0.5/(3*3*3)) {
			return;
		}
		
//		do some work
		StdDraw.circle(xCenter, yCenter, radius);

//		recur 4 times
		recursiveCircles(xCenter-radius,yCenter,radius/3);
		recursiveCircles(xCenter+radius,yCenter,radius/3);
		recursiveCircles(xCenter,yCenter-radius,radius/3);
		recursiveCircles(xCenter,yCenter+radius,radius/3);
		
		
	}

	public static void main(String[] args) {
		StdDraw.setXscale(-1, +1);
		StdDraw.setYscale(-1, +1);
		recursiveCircles(0, 0, 0.5);
	}
}
