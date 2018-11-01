package studio6;

/**
 * @author Yang
 *
 */

//some exercise for recursion - Unit test

public class Methods {
	static int fact(int n) {
		if (n > 0) {
			return n * fact(n-1);
		}
		
		else {return 1;}
	}
	
	static int fib(int n) {
		if (n > 1) {
			return fib(n-1) + fib(n-2);
		}
		
		else {return n;}
	}
	
	
	static boolean isOdd(int n) {
		if (n > 0) {
			return !isOdd(n-1);
		}
		
		else {return false;}
	}
	
	
	static int sum(int a, int b) {
		if (b > 0) {
			return sum(a+1, b-1);
		}
		
		else {return a;}
	}
	
		
	
	static int sumDownBy2(int n) {
		if (n >= 2) {
			return n + sumDownBy2(n-2);
		}
		
		if (n==1) {
			return 1;
		}
		
		else {return 0;}
	}
	
	
	static double harmonicSum(double n) {
		
		if (n == 1 ) {
			return 1;
		}
		else {
			return 1/n + harmonicSum(n-1);
		}
		
	}
	
	static int mult(int a, int b) {
		if (b == 0) {
			return 0;
		}
		else {
			b--;
			return a + mult(a,b);
		}
		
	}
	
	
	
//	TODO
	
//	Substitution Model A

//	Here is a simple but interesting recursive function.
//	   f(x) =    x-10     if x > 100
//	        = f(f(x+11))  if x <= 100
//	Using the substitution model, sketch the computation of f(99).
//	Be prepared to show your substitution model computation to a TA when you demo.
//	Sketch the computation of f(87).
//	Be prepared to answer the following questions about the above code:
//	Will this function terminate for all positive integers supplied as arguments.
//	What do you expect this function to do for values of x > 100?
//	How will it behave for values <= 100?
	
//	Here is another interesting recursive function:
//		  g(x,y)  = y+1               if x = 0
//		          = g(x-1,1)          if x > 0 and y = 0
//		          = g(x-1, g(x, y-1)) if x > 0 and y > 0
//		Using the substitution model, sketch the computations of
//		g(1,0)
//		g(1,2)
//		g(2,2)
//		Will this function terminate for all positive integers supplied as arguments?
//		How do you expect this function behave with respect to x and y?
//		Implement it and try it out for values of x < 4 and various values of y.
//		Now try it for x = 4 and various values of y.
//		What do you see?
//		You may be interested to know that the red square button will terminate your application.
//		Why does the function behave this way?


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
		
		

//			sketch
	
	/*		f(99) = f(f(99+11));
			      = f(f(110));
			      = f(100);
			      = f(f(100+11));
			      = f(f(111));
			      = f(101);
			      = 91;*/
			
	/*		f(87) = f(f(87+11))
			      = f(f(98))
			      = f(f(f(98+11)))
			      = f(f(f(109)))
			      = f(f(99))
				  = f(f(f(99+11)))
			      = f(f(f(110)))
				  = f(f(100))
				  = f(f(f(111)))
				  = f(f(101))
	              = f(99)
			      = .。。
			      = 91*/
			
	/*		g(1,0) = g(0,1);
				   = 1+1
				   = 2*/
			
	/*		g(1,2) = g(1-1, g(1, 2-1))
				   = g(0, g(1,1))
				   = g(1,1) + 1
			       = g(1-1, g(1,1-1)) +1
				   = g(0, g(1,0)) +1;
				   = g(1,0) + 1 + 1;
				   = g(1-1, 1) + 1 + 1;
				   = g(0,1) + 1 + 1 ;
				   = 1 + 1 +1 +1
				   = 4*/
				
			
	/*		g(2, 2) = g(2-1, g(2, 2-1))
	              = g(1, g(2,1))
	              = g(1, g(2-1,g(2, 1-1))
	              = g(1, g(1, g(2, 0))
	              = g(1, g(1, g(2-1 ,1)))
			        = g(1, g(1, g(1,1)))
					= g(1, g(1, g(1-1, g(1,1-1))))
			        = g(1, g(1, g(0, g(1,0))))
					= g(1, g(1, g(1,0)+1))
					= g(1, g(1, 2+1))
					= g(1, g(1,3))
					= g(1, g(1-1,g(1,3-1)))
					= g(1, g(0, g(1,2)))
					= g(1, g(1,2)+1)
					= g(1, 4+1)
					= g(1,5)
	        		= g(1-1, g(1, 5-1))
					= g(0, g(1,4))
					= g(1,4) + 1
					= g(1-1, g(1, 4-1)) +1
					= g(0, g(1,3)) + 1
					= g(1,3) + 1 + 1
					...
					= g(1,2) +1 +1 +1
					= 7*/

}
