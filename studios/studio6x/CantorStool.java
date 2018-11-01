package studio6;

import java.awt.Color;

import sedgewick.StdDraw;

public abstract class CantorStool {
	private static void recursiveRectangle(double xCenter, double yCenter, double halfWidth,double halfHeight) {
		if (halfWidth < 0.025) {
			return;
		}
		StdDraw.setPenColor(Color.GRAY);
		StdDraw.filledRectangle(xCenter, yCenter+halfHeight, halfWidth, halfHeight);
		if (halfWidth < 0.5) {
			recursiveRectangle(xCenter-2*halfWidth/3, yCenter-halfHeight, halfWidth/3,halfHeight);
			recursiveRectangle(xCenter+2*halfWidth/3, yCenter-halfHeight, halfWidth/3,halfHeight);
			
		}
		recursiveRectangle(xCenter-2*halfWidth/3, yCenter-halfHeight, halfWidth/3,halfHeight/2);
		recursiveRectangle(xCenter+2*halfWidth/3, yCenter-halfHeight, halfWidth/3,halfHeight/2);
	}


public static void main(String[] args) {
	StdDraw.setXscale(-1, +1);
	StdDraw.setYscale(-1, +1);
	recursiveRectangle(0,0,1,0.5);
}
}