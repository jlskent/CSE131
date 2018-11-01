package exercises6;

import static org.junit.Assert.*;

import org.junit.Test;
import java.util.Random;
/**
 * @author yang
 *
 */
public class AddTest {

	@Test
	public void test() {
		assertEquals(0, Add.add(0, 0));
		//
		// write other test cases here:
		//
		
		


		
		for (int i=0;i<100;i++) {
			int a = (int) ((Math.random()-0.5)*10);
			int b = (int) ((Math.random()-0.5)*1000);
//			assertEquals(i+i+1, Add.add(i,i+1));
			int sum = a+b;
			System.out.println(a + "+" +b+ "=" +sum);
			System.out.println("result"+Add.addAny(a,b));

			assertEquals(sum, Add.addAny(a,b));
		}
	}

}
