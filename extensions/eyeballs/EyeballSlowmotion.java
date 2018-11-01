package eyeballs;

import java.awt.Color;

import sedgewick.StdDraw;
import cse131.ArgsProcessor;

public class EyeballSlowmotion {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ArgsProcessor ap = new ArgsProcessor(args);
		StdDraw.picture(0.5, 0.5, "images/ken.jpg");
		int N = ap.nextInt("How many eyeballs?");
		int L = ap.nextInt("How many history for slow motion?");
		double[] ex = new double[N];
		double[] ey = new double[N];
		double[] dx = new double[N];
		double[] dy = new double[N];
		double[] d = new double[N];
		double[] px = new double[N];
		double[] py = new double[N];
		double[][] histX = new double[L][N];
		double[][] histY = new double[L][N];
		int[] cur = new int[N];
		for(int i = 0; i<N; i++){
			cur[i] =0;
		}

		for(int n = 0; n<N; n++){
			while(!StdDraw.mousePressed()){
				StdDraw.pause(100);
			}
			while(StdDraw.mousePressed()){
				StdDraw.pause(100);
			}
			ex[n] = StdDraw.mouseX();
			ey[n] = StdDraw.mouseY();
			for(int j =0; j<histX.length; j++){
				histX[j][n]=ex[n];
				histY[j][n]=ey[n];
			}
			

			while (!StdDraw.mousePressed() || n == N-1){
				for(int i=0; i<=n; i++){
					StdDraw.setPenColor(Color.white);
					StdDraw.setPenRadius(0.003);
					StdDraw.filledCircle(ex[i], ey[i], 0.03);
					StdDraw.setPenColor(Color.black);
					StdDraw.circle(ex[i], ey[i], 0.03);

					double mx = StdDraw.mouseX();
					double my = StdDraw.mouseY();
					dx[i] = mx - ex[i];
					dy[i] = my - ey[i];
					d[i] = Math.sqrt(Math.pow(dx[i], 2)+ Math.pow(dy[i], 2));
					double p = 0.015;
					px[i] = dx[i]/d[i]*p;
					py[i] = dy[i]/d[i]*p;


					// slow motion
					double x = ex[i]+px[i];
					double y = ey[i]+py[i];
					histX[cur[i]][i] = x;
					histY[cur[i]][i] = y;
					cur[i]++;
					if (cur[i] >= histX.length){
						cur[i] = 0;
					}
					int oldest = cur[i];
					StdDraw.setPenColor(Color.red);		
					StdDraw.filledCircle(histX[oldest][i], histY[oldest][i], .015);
				}

				StdDraw.show(50);
			}

		}

	}

}