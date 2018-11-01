package lab6;

import sedgewick.StdDraw;

/**
 * @author Yang
 *
 */
public class Triangle {
	/**
	 * 
	 * @param bottom center x coordinate
	 * @param bottom center y coordinate
	 * @param side length
	 */
	public static void draw(double x, double y, double a){

		
		

//		constant work
		if (a<0.025) {
			double[] xs = {x,x+a,x+a/2};
			double[] ys = {y,y,y+a/2*Math.sqrt(3)};
			StdDraw.filledPolygon(xs, ys);
		}
		
//		exit
		if (a<0.025) {
			return;
		}
		
//		recur
		else {
			draw(x,y,a/2);
			draw(x+a/2,y,a/2);
			draw(x+a/4,y+a*1/4*Math.sqrt(3),a/2);
			}
		
		
	}
	
	public static void main(String[] args) {	
		draw(0,0,1);
		StdDraw.show(10);
	}

}
	