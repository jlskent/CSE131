package eyeballs;

import java.awt.Color;

import sedgewick.StdDraw;
import cse131.ArgsProcessor;

/**
 * @author Yang
 *
 */
public class Eyeballs {

	public static void main(String[] args) {
		ArgsProcessor ap = new ArgsProcessor(args);
		int numBalls = ap.nextInt("How many eyeballs?");
		while (numBalls <= 0) {
			numBalls = ap.nextInt("need a valid number, man");
		}
		
        StdDraw.setXscale(-1.0, 1.0);
        StdDraw.setYscale(-1.0, 1.0);
        StdDraw.picture(0, 0, "images/ken.jpg");
        
//		number of history
        int N = 10000;
		
//		position of the mouse
        double[] mx = new double[N];
        double[] my = new double[N];
        
        double[] dx = new double[N];
        double[] dy = new double[N];
        
        
        
        boolean isReleased = false;
        
//		initial position of N eyeballs
        double[] ex = new double[numBalls];
        double[] ey = new double[numBalls];
        
//		r of the eyeball and pupil
        double r = 0.03;
        double rP = 0.015;
        
//		it is the radius of the eyeball minus the radius of the pupil
        double p = r- rP;
            
        
//First loop
//prompt users to draw 3 balls with mouse click
		int i = 0;
		while (i< numBalls) {
					
//			System.out.println(i + " circles");
			while (!StdDraw.mousePressed() && isReleased == true) {

//				System.out.println("detecting mouse x y");
			    StdDraw.show(50);
			    isReleased = false;
			}
			
//			record the coordinates and draw eyeballs
			if (StdDraw.mousePressed() && isReleased == false  ) {
				ex[i] = StdDraw.mouseX();
				ey[i] = StdDraw.mouseY();
				System.out.println("i "+ i + " (" + ex[i] +  "," + ey[i] +")");
				StdDraw.setPenColor(Color.BLACK);
				StdDraw.circle(ex[i], ey[i], r);
				StdDraw.setPenColor(Color.RED);
				StdDraw.filledCircle(ex[i], ey[i], rP);
				i++;
//			    StdDraw.show(50);
				isReleased = true;
			}
		}

		
		
		
//Second loop
//follow mouse, iterate movement of pupil for k histories
		int k = 0;
		while (k<N) {
			
			StdDraw.clear();

//			get mouse location
			mx[k] = StdDraw.mouseX();
			my[k] = StdDraw.mouseY();
//			System.out.println("my mouse location " + mx[k] + ", " + my[k]);		

//			animate the eyeball
			for (int n=0; n<numBalls; n++) {
//				System.out.println("n "+ n + " (" + ex[n] +  "," + ey[n] +")");
				StdDraw.setPenColor(Color.BLACK);
				StdDraw.circle(ex[n], ey[n], r);
				
//				in moment k, calculation for new pupil center
				dx[k] = mx[k] - ex[n];
				dy[k] = my[k] - ey[n];
				double d = Math.sqrt(Math.pow(dx[k], 2) + Math.pow(dy[k], 2));
//				double ratio = p/d;
				double px = dx[k] * p/d;
				double py = dy[k] * p/d;
				StdDraw.setPenColor(Color.RED);
				StdDraw.filledCircle(ex[n] + px, ey[n] + py, rP);

			}
			k++;
		    StdDraw.show(50);
		}
//Second loop

    	
		
		

	}
//	end of main
	
	
	

}
