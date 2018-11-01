package regression;

import java.awt.Color;

import cse131.ArgsProcessor;
import sedgewick.StdDraw;
import sedgewick.StdIn;

public class RegressionGrapher {
	public static void main(String[] args) {
		ArgsProcessor.changeStdIn("datafiles/housing/pricesarea.csv");
		double[] xy = StdIn.readDoubles();
		double[][] homes = new double[xy.length/2][2];
		for (int i=0; i<xy.length; i += 2) {
			homes[i/2][0] = xy[i];
			homes[i/2][1] = xy[i+1];
		}
		StdDraw.clear();
		double xMin = Double.MAX_VALUE, xMax = Double.MIN_VALUE;
		double yMin = Double.MAX_VALUE, yMax = Double.MIN_VALUE;
		StdDraw.setPenRadius(0.005);
		for (int i=0; i<homes.length; i++) {
			xMin = Math.min(xMin, homes[i][0]);
			yMin = Math.min(yMin, homes[i][1]);
			xMax = Math.max(xMax, homes[i][0]);
			yMax = Math.max(yMax, homes[i][1]);
		}
		StdDraw.setXscale(xMin, xMax);
		StdDraw.setYscale(yMin, yMax);
		StdDraw.setPenColor();
		for (int i = 0; i < homes.length; i++) {
			StdDraw.point(homes[i][0], homes[i][1]);
		}
		StdDraw.setPenColor(Color.CYAN);
		ArgsProcessor.changeStdIn("datafiles/housing/pricesarea.csv");
		StdIn.resetScanner();
		LinearRegression.learn();
		for (double d=xMin; d<xMax; d=(d+((xMax-xMin)/100))) {
			StdDraw.point(d, LinearRegression.predictPrice(d));
		}
	}
}
