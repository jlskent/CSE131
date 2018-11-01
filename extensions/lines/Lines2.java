package lines;

import java.awt.Color;

import sedgewick.StdDraw;

public class Lines2 {

	/**
	 * 
	 * @param x1 x coordinate of starting point
	 * @param y1 y coordinate of starting point
	 * @param x2 x coordinate of ending point
	 * @param y2 y coordinate of ending point
	 */
	
//	The only methods you are allowed to use from StdDraw are point, setPenRadius, and setPenColor.
//	This means you must draw your line one point at a time. Use recursion.

	public static void drawLine(double x1, double y1, double x2, double y2) {
//		draw 10000 dots between two points
		double xPlus;
		double yPlus;
		double factor = 0;
		
//		check if x2>x1 & y2>y1

		double x2_1 = x2-x1;
		double y2_1 = y2-y1;
		
		if(x1 == x2) {
			xPlus = 0;
		}
		else {
			xPlus = (x2-x1)/Math.abs(x2-x1);
		}

		if (y1 == y2) {
			yPlus = 0;
		}
		else {
			yPlus = (y2-y1)/Math.abs(y2-y1);
		}
		
		if (x1 !=x2 && y1!=y2) {
			System.out.println("y2-y1 " + y2_1 + " x2-x1 "  + x2_1);

			factor = Math.abs(y2-y1)/Math.abs(x2-x1);
		}
		
		
		System.out.println("factor: " + factor);
//		System.out.println(xPlus + " " + yPlus);
		
		StdDraw.setPenColor(Color.BLACK);
		StdDraw.setPenRadius(0.005);
		StdDraw.point(x1, y1);

//		System.out.println("x1y1  (" + x1 + "," +y1 + ")  x2y2 (" + x2 + "," + y2 + ")" + "    divider " + N);
		
		if ( Math.abs(x2-x1) > 0.01 || Math.abs(y2-y1) >0.01)	{
			drawLine(x1 + xPlus*0.01, y1 + yPlus*0.01*factor, x2, y2);
		}
		else {
			StdDraw.point(x2, y2);
		}
		

		
		
	}
	
	
	/**
	 * Code to test the drawLine method visually
	 */
	public static void main(String[] args) {
		
		//
		// Test the drawing program
		//
		drawLine(0,0,1,1); // lower left to upper right
		drawLine(0,1,1,0); // upper left to lower right
		
//		drawLine(0.25,0.25, 0.25, 0.75);

		//
		// Draw rectangles of decreasing width and height
		//
		for (double r = 0.25; r < 0.5; r = r+.005) {
			double s = 1-r;
			drawLine(r,r, r, s);
			drawLine(r, s, s, s);
			drawLine(s, s, s, r);
			drawLine(s, r, r, r);
		}
		System.out.println("done drawing");
	}

}
