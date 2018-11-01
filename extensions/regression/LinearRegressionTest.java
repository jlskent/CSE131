package regression;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import org.junit.Assert;
import org.junit.Test;

import sedgewick.StdIn;

public class LinearRegressionTest {
	@Test
	public void testSlopeIntercept() {
		for (int i=0; i<100; i++) {
			double slope = i/10d*Math.random();
			double intercept = i+1;
			double[] xs = new double[100];
			for (int j=0; j<xs.length; j++)
				xs[j] = j;
			double[] ys = new double[xs.length];
			for (int j=0; j<xs.length; j++)
				ys[j] = slope*xs[j]+intercept; 
			System.setIn(genInputStream(xs, ys));
			StdIn.resetScanner();
			LinearRegression.learn();
			Assert.assertEquals(slope, LinearRegression.slope, 0.1);
			Assert.assertEquals(intercept, LinearRegression.intercept, 0.1);
		}
		for (int i=0; i<100; i++) {
			double slope = i/10d*Math.random();
			double intercept = i+1;
			double[] xs = new double[100];
			for (int j=0; j<xs.length; j++)
				xs[j] = j;
			double[] ys = new double[xs.length];
			for (int j=0; j<xs.length; j++)
				ys[j] = slope*xs[j]+intercept + (j%2 == 0 ? 2:-2); 
			System.setIn(genInputStream(xs, ys));
			StdIn.resetScanner();
			LinearRegression.learn();
			Assert.assertEquals(slope, LinearRegression.slope, 0.1);
			Assert.assertEquals(intercept, LinearRegression.intercept, 0.1);
		}
	}
	@Test
	public void testPredictions(){
		for (int i=1; i<100; i++) {
			double slope = i/10d*Math.random();
			double intercept = i+1;
			double[] xs = new double[100];
			for (int j=0; j<xs.length; j++)
				xs[j] = j;
			double[] ys = new double[xs.length];
			for (int j=0; j<xs.length; j++)
				ys[j] = slope*xs[j]+intercept; 
			System.setIn(genInputStream(xs, ys));
			StdIn.resetScanner();
			LinearRegression.learn();
			for (int j=0; j<100; j++) {
				double x=j;
				double ans = j;
				ans = ans*LinearRegression.slope;
				ans = ans+LinearRegression.intercept;
				if (LinearRegression.slope == 0)
					throw new IllegalArgumentException("This test won't pass until"
							+ " you fix your learn method");
				Assert.assertEquals(ans, LinearRegression.predictPrice(x), 0.1);
			}
		}
	}

	private InputStream genInputStream(double[] xs, double[] ys) {
		if (xs.length != ys.length)
			throw new IllegalArgumentException("input args must have same length");

		String buf = "";
		for (int i=0; i < xs.length; ++i) {
			buf = buf + xs[i] + " " + ys[i] + "\n";
		}
		byte[] bytes = buf.getBytes();
		return new ByteArrayInputStream(bytes);
	}
}
