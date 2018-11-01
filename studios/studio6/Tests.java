package studio6;

import static org.junit.Assert.*;

import org.junit.Test;

public class Tests {

	@Test
	public void testFactorial() {
		assertEquals(1, Methods.fact(0));
		assertEquals(1, Methods.fact(1));
		assertEquals(120, Methods.fact(5));
	}
	
	@Test
	public void testFib() {
		assertEquals(0, Methods.fib(0));
		assertEquals(1, Methods.fib(1));
		assertEquals(144, Methods.fib(12));
	}
	
	@Test
	public void testOdd() {
		for (int i=0; i < 1000; ++i) {
			assertEquals("Testing " + i, i%2==1, Methods.isOdd(i));
		}
	}
	
	@Test
	public void testSum() {
		for (int a=0; a < 1000; ++a) {
			for (int b=0; b < 1000; ++b) {
				assertEquals("Testing " + a + "+" + "b", a+b, Methods.sum(a,b));
			}
		}
	}
	
	private static int mysdb2(int n) {
		int ans = 0;
		for (int i=n; i >= 0; i=i-2) {
			ans += i;
		}
		return ans;
	}

	private double myhs(int n) {
		double ans = 0.0;
		for (int i=1; i <= n; ++i) {
			ans += 1.0/i;
		}
		return ans;
	}
		
	@Test
	public void testSumDownBy2() {
		for (int n=0; n < 1000; ++n) {
			assertEquals("Value for " + n, mysdb2(n), Methods.sumDownBy2(n));
		}
	}
	
	@Test
	public void testHarmonicSum() {
		for (int i=1; i < 1000; ++i) {
			assertEquals("Value for " + i, myhs(i), Methods.harmonicSum(i), .01);
		}
	}

	@Test
	public void testMult(){
		for (int a = 1; a < 100; ++a) {
			for (int b = 1; b < 100; ++b){
				assertEquals("Testing " + a + " * " + b, a*b, Methods.mult(a, b) );
			}
		}
	}
	
	
	
	
	static int f(int x) {
		if (x > 100) {
			return x-10;
		}
		else {
			return f(f(x+11));
		}
	}
	
	
	static int g(int x, int y) {
		if (x == 0 ) {
			return y+1;
		}
		if (x > 0 && y == 0) {
			return g(x-1 , 1);
		}
		else {
			return g(x-1, g(x, y-1));
		}

	}
	
	
	@Test
	public void f(){
		System.out.println(f(99));
		System.out.println(f(87));
		System.out.println(f(5));
		System.out.println(f(200));
		System.out.println(f(300));
		System.out.println(f(333));

		assertEquals(f(99), Methods.f(99) );
		}
	@Test
	public void g(){
		
		System.out.println(g(1,0));
		System.out.println(g(1,2));
		System.out.println(g(2,2));
//		System.out.println(g(4,2));

		assertEquals(g(1,2), Methods.g(1,2) );
	}
	
	

}
