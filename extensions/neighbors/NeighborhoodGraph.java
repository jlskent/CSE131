package neighbors;

import java.awt.Color;

import cse131.ArgsProcessor;
import sedgewick.StdDraw;
import sedgewick.StdIn;

public class NeighborhoodGraph {
	public static void main(String[] args) {
		ArgsProcessor.changeStdIn("datafiles/housing/priceslocation.csv");
		double[] pxy = StdIn.readDoubles();
		double[][] homes = new double[pxy.length/3][3];

		for (int i=0; i<pxy.length; i += 3) {
			homes[i/3][0] = pxy[i];
			homes[i/3][1] = pxy[i+1];
			homes[i/3][2] = pxy[i+2];
		}
		StdDraw.show(10);
		graph(homes);
		StdDraw.show(10);
		StdDraw.setPenRadius(0.02);
		while(true) {
			if (StdDraw.mousePressed()) {
				double[] mouse = click();
				double normalX = -80.4391+(0.2315*mouse[0])/23110;
				double normalY = 25.9573+(0.2077*mouse[1])/23110;
				System.out.println("A home at " + normalX + ", " + normalY +
						" would be worth $" + KNearestNeighbors.predictPrice(homes, normalX, normalY, 5));
				while (StdDraw.mousePressed())
					StdDraw.show(10);
			}
			StdDraw.show(10);
		}
	}
	public static double findDistance(double x1, double y1, double x2, double y2) {
		double R = 6371000;
		double y1Rad = Math.toRadians(y1);
		double y2Rad = Math.toRadians(y2);
		double dx = Math.toRadians(x2 - x1);
		double dy = Math.toRadians(y2 - y1);
		double a = Math.sin(dy/2) * Math.sin(dy/2) + 
				Math.cos(y1Rad) * Math.cos(y2Rad) * Math.sin(dx/2)*Math.sin(dx/2);
		double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1-a));
		double d = R * c;
		return d;
	}
	public static void graph(double[][] homes) {
		StdDraw.setXscale(0, 23110); //longest distance between the same dimension of two points in data
		StdDraw.setYscale(0, 23110);
		StdDraw.setPenRadius(0.01);
		StdDraw.picture(11555, 11555, "images/BrowardMap.png", 25421, 25421);
		double maxPrice = Double.MIN_VALUE;
		double minPrice = Double.MAX_VALUE;
		for (int i=0; i<homes.length; i++) {
			maxPrice = Math.max(maxPrice, homes[i][0]);
			minPrice = Math.min(minPrice, homes[i][0]);
		}
		double range = maxPrice-minPrice;
		for (int i=0; i<homes.length; i++) {
			int c1 = Math.max((int)(255*(homes[i][0]-(minPrice+range/2))/(range/2)),0);
			int c2 = Math.max((int)(255*((minPrice+range/2)-homes[i][0])/(range/2)),0);
			int c3 = 255;
			Color c = new Color(c3,c2,c1);
			StdDraw.setPenColor(c);
			StdDraw.point(findDistance(-80.4391, homes[i][2], homes[i][1], homes[i][2]), 
					findDistance(homes[i][1], 25.9573, homes[i][1], homes[i][2]));
		}
	}
	public static double[] click() {
		double[] mouse = new double[2];
		mouse[0] = StdDraw.mouseX();
		mouse[1] = StdDraw.mouseY();
		return mouse;
	}
}
