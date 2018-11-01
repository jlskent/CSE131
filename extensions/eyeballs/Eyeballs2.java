package eyeballs;

import java.awt.Color;

import sedgewick.StdDraw;
import cse131.ArgsProcessor;

/**
 * @author Yang
 *
 */
public class Eyeballs2 {

	public static void main(String[] args) {
		ArgsProcessor ap = new ArgsProcessor(args);
		int numBalls = ap.nextInt("How many eyeballs?");
		while (numBalls <= 0) {
			numBalls = ap.nextInt("need a valid number, man");
		}
		
//        StdDraw.setXscale(-1.0, 1.0);
//        StdDraw.setYscale(-1.0, 1.0);
//        StdDraw.picture(0, 0, "images/ken.jpg");
        
        
//		position of the mouse
        double[] mx = new double[1000];
        double[] my = new double[1000];
        
        double[] dx = new double[1000];
        double[] dy = new double[1000];
        
        
        
        boolean isReleased = false;
        
//		initial position of N eyeballs
        double[] ex = new double[numBalls];
        double[] ey = new double[numBalls];
        
//		it is the radius of the eyeball minus the radius of the pupil
        double p = 0.015;
//		r of the eyeball
        double r = 0.03;
        
            
        
//First loop
//prompt users to draw 3 balls with mouse click
		int i = 0;
		while (i< numBalls) {
					
//			System.out.println(i + " circles");
			while (!StdDraw.mousePressed() && isReleased == true) {
				StdDraw.clear();
				
//				System.out.println("detecting mouse x y");
			    StdDraw.show(50);
			    isReleased = false;
			}
			
//			record the coordinates and draw eyeballs
			if (StdDraw.mousePressed() && isReleased == false) {
				ex[i] = StdDraw.mouseX();
				ey[i] = StdDraw.mouseY();
				System.out.println("i "+ i + " (" + ex[i] +  "," + ey[i] +")");
				StdDraw.setPenColor(Color.BLACK);
				StdDraw.circle(ex[i], ey[i], r);
				StdDraw.setPenColor(Color.RED);
				StdDraw.filledCircle(ex[i], ey[i], r-p);
				i++;
//			    StdDraw.show(50);
				isReleased = true;
			}
		}

		
		

//Second loop
//follow mouse, iterate movement of pupil for k histories
		int k = 0;
		while (isReleased == true) {
			
			StdDraw.clear();

//			get mouse location
			mx[k] = StdDraw.mouseX();
			my[k] = StdDraw.mouseY();
//			System.out.println("my mouse location " + mx[k] + ", " + my[k]);		

//			get the pupil locations and draw them
			for (int n=0; n<numBalls; n++) {
//				System.out.println("original eyeball location n "+ n + " (" + ex[n] +  "," + ey[n] +")");
				StdDraw.setPenColor(Color.BLACK);
				StdDraw.circle(ex[n], ey[n], r);
				StdDraw.setPenColor(Color.RED);
				StdDraw.filledCircle(ex[n], ey[n], r-p);
				
//				in moment k, calculation for new pupil center, new var to track history of pupil needed
				dx[k] = mx[k] - ex[n];
				dy[k] = mx[k] - ey[n];
				double d = Math.sqrt(Math.pow(dx[k], 2) + Math.pow(dy[k], 2));
				double ratio = p/d;
				double px = dx[k] * ratio;
				double py = dy[k] * ratio;
				StdDraw.setPenColor(Color.RED);
				StdDraw.filledCircle(ex[n] + px, ey[n] + py, r-p);

			}
			k++;
		    StdDraw.show(50);

		}
    	
    	
		
		

	}
//	end of main
	
	
	

	
	

}
