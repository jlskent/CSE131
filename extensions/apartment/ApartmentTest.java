package apartment;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import org.junit.Assert;
import org.junit.Test;

public class ApartmentTest {

	@Test
	public void testfindOptimalStoppingPoint() {
		Random random = new Random();
		ArrayList<Double> list = new ArrayList<Double>();
		double count = 0.0;
		int options = (int)(Math.random()*100)+300;
		int trials = 10000;

		list.add(1.0);
		for (int i = 0; i < (options-1); ++i) {
			list.add(random.nextDouble());	
		}
		
		int K = Apartment.findOptimalStoppingPoint(options, trials);
		for(int trial = 0; trial< trials; ++trial) {
			double max = 0;
			Collections.shuffle(list);
			Double[] ratings = new Double[options];
			list.toArray(ratings);		
			
			for (int i=0; i<K; ++i) {
				if (ratings[i] > max)
					max = ratings[i];
			}
			for (int i=K; i<ratings.length; ++i) {
				if (ratings[i] > max) {
					max = ratings[i];
					break;
				}
				else if (i == ratings.length-1) {
					max = ratings[i];
				}
			}
			if (max == 1.0)
				count += 1;
		}
		Assert.assertEquals(1/Math.E, (count/trials), 0.02);
	}
}
