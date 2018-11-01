package neighbors;

import org.junit.Assert;
import org.junit.Test;

public class TestNeighbors {
	@Test
	public void testPrediction(){
		for (int i = 0; i < 100; i++) {
			double[][] homes = new double[(i+1)*2][3];
			double innerRadius = 0.5*(i+1);
			double innerPrice = 2500000 + (Math.random() * 2500000);
			double outerRadius = (i+1);
			double outerPrice = Math.random()*2500000;
			for (int j=0; j<homes.length; j++) {
				if (j%2 == 0) {
					homes[j][0] = innerPrice;
					homes[j][1] = Math.random()*(innerRadius*2)-innerRadius;
					homes[j][2] = Math.random()*(innerRadius*2)-innerRadius;
					double distance = Math.sqrt(homes[j][1]*homes[j][1]+homes[j][2]*homes[j][2]);
					while(distance>innerRadius) {
						homes[j][1] = Math.random()*(innerRadius*2)-innerRadius;
						homes[j][2] = Math.random()*(innerRadius*2)-innerRadius;
						distance = Math.sqrt(homes[j][1]*homes[j][1]+homes[j][2]*homes[j][2]);
					}
				}
				else {
					homes[j][0] = outerPrice;
					homes[j][1] = Math.random()*(outerRadius*2)-outerRadius;
					homes[j][2] = Math.random()*(outerRadius*2)-outerRadius;
					double distance = Math.sqrt(homes[j][1]*homes[j][1]+homes[j][2]*homes[j][2]);
					while(distance<innerRadius) {
						homes[j][1] = Math.random()*(outerRadius*2)-outerRadius;
						homes[j][2] = Math.random()*(outerRadius*2)-outerRadius;
						distance = Math.sqrt(homes[j][1]*homes[j][1]+homes[j][2]*homes[j][2]);
					}
				}
			}
			Assert.assertEquals(innerPrice, KNearestNeighbors.predictPrice(homes, 0, 0, (i+1)), 1);
		}
	}
}
