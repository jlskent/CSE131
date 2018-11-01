/**
 * 
 */
package exercises6;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * @author yangfolder
 *
 */
public class SumTest {

	@Test
	public void test() {
		
		
		
		
		for (int i=0; i<1000; i++) {
			assertEquals( i*(i+1)/2, Sum.sum(i));
			
		}
		
		
		
		
		
		
		
//		fail("Not yet implemented");
	}

}
