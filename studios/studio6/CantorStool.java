/**
 * 
 */
package studio6;

import java.awt.Color;

import sedgewick.StdDraw;

/**
 * @author yang
 *
 */
public class CantorStool {

	
	
//	start point coordinates, starting width
//	upper left corner
	static void draw(double x, double y, double w,double h) {
		
//		some work
//		center coordinate for function
		StdDraw.setPenColor(Color.lightGray);
		StdDraw.filledRectangle(x+w/2, y-h/2, w/2, h/2);
		StdDraw.setPenColor(Color.black);
		StdDraw.rectangle(x+w/2, y-h/2, w/2, h/2);
		
		
		
		
//		basecase
		if (h<0.125) {
			StdDraw.setPenColor(Color.lightGray);
			StdDraw.filledRectangle(x+w/2, y-h, w/2, h);
			StdDraw.setPenColor(Color.black);
			StdDraw.rectangle(x+w/2, y-h, w/2, h);
			return;
		}
		
		
		
		
//		recur
		else {
		draw(x,y-h,w/3,h/2);
		draw(x+w/3*2,y-h,w/3,h/2);
		}
		
		
		
		
	}
	
	
	
	public static void main(String[] args) {

		draw(0,1,1,0.5);
	}
	
	
}
