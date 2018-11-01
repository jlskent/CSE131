package mario;

import static org.junit.Assert.*;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import cse131.CaptureOutput;

import org.junit.Test;

public class MarioTest {

	Random random = new Random();

	@Test
	public void test() {

		final int numTests = random.nextInt(10)+5; // 5 to 14 tests
		final List<Integer> patterns = new ArrayList<Integer>(numTests);
		final List<Integer> sizes = new ArrayList<Integer>(numTests);
		for (int i=0; i < numTests; ++i) {
			patterns.add(random.nextInt(3)+1);   // each in the interval [1,4]
			sizes.add(random.nextInt(10)+1);     // each of size 1...10
		}

		Runnable r = new Runnable() {
			public void run() {
				for (int i=0; i < numTests; ++i) {
					int size = sizes.get(i);
					int pattern = patterns.get(i);
					System.out.println("=====>\n" + size + "\n" + pattern);
					Mario.main(
							new String[] { ""+size, ""+pattern}
							);
					System.out.println("<===== " + "done");
				}
			}
		};

		CaptureOutput capt = new CaptureOutput(r);
		capt.run();
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(capt.getInputStream()));
			String line = br.readLine();
			boolean collecting = false;
			String testcase = "";
			int pattern = 0;
			int size    = 0;
			boolean gotInput = false;
			while (line != null) {
				//
				// Collected a pattern?  Test it
				//
				if (!collecting && !testcase.equals("")) {
					System.out.println("Test: size " + size + " pattern " + pattern + "\n" + testcase);
					boolean result = false;
					switch(pattern) {
					case 1: result = Cases.case1(testcase, size);
						break;
					case 2: result = Cases.case2(testcase, size);
						break;
					case 3: result = Cases.case3(testcase, size);
						break;
					case 4:  result = Cases.case4(testcase, size);
						break;
					default:
							throw new Error("not possible");
					}
					if (!result)
						System.out.println("Test is about to fail.  Look at the pattern above and see what might be wrong.");
					assertTrue("Test failed, see console output for what might be wrong", result);
					System.out.println("Passed!\n");
					testcase = "";
				}
				
				//
				// Starts a pattern, followed by the size and then the pattern number
				//
				if (line.startsWith("=====>")) {
					collecting = true;
					size    = Integer.parseInt(br.readLine());
					pattern = Integer.parseInt(br.readLine());
				}
				//
				// end of pattern
				//
				else if (line.startsWith("<=====")) {
					if (!gotInput)
						fail("Your code failed to produce any output");
					collecting = false;
					gotInput   = false;
				}
				else {
					testcase = testcase + line + "\n";
					gotInput = true;
				}
				line = br.readLine();
			}
		} catch(Throwable t) {
			throw new Error(""+t);
		}

	}

}

class Cases {


	
	public static void main(String[] args) {

		// Dotun:  test all the methods here:
		System.out.println("pattern 2 with size 4 "+case2(gen2DArray("#    \n##   \n###   \n#### \n#####\n",4),4));
		System.out.println("pattern 4 with size 5 "+case4(gen2DArray("#####\n#### \n###  \n##   \n#    \n", 5), 5));
		System.out.println("pattern 4 with size 4 "+case4(gen2DArray("####\n### \n##  \n#  \n", 4), 4));
		System.out.println("pattern 1 with size 5 "+case1(gen2DArray("    #\n   ##\n  ###\n ####\n#####\n", 5),5));
		System.out.println("pattern 1 with size 4 "+case1(gen2DArray("   #\n  ##\n ###\n####\n", 4), 4));
		System.out.println("pattern 3 with size 5 "+case3(gen2DArray("#####\n ####\n  ###\n   ##\n    #\n", 5), 5));
		System.out.println("pattern 3 with size 4 "+case3(gen2DArray("####\n ###\n  ##\n   #\n", 4), 4));
		System.out.println("pattern 2 with size 5 "+case2(gen2DArray("#\n##\n###\n####\n#####\n", 5), 5));
	}

	// case 2 is the only one the needs a full definition
	// all others reduce to case 2
	public static boolean case2(char[][] mountain, int lines) {

		for (int row=0; row<lines; ++row) {
			for (int col=0; col<lines; ++col) {
				char c = mountain[row][col];
				if (col<row+1) {
					if (c != '#')
						return false;
				}
				else {
					if (c != ' ')
						return false;
				}
			}
		}
		return true;
	}

	public static boolean case2(String mountain, int lines) {
		return case2(gen2DArray(mountain, lines), lines);
	}

	public static boolean case1(char[][] mountain, int lines) {		
		return case2(reflectVert(mountain, lines), lines);
	}

	public static boolean case1(String mountain, int lines) {
		return case1(gen2DArray(mountain, lines), lines);
	}

	public static boolean case3(char[][] mountain, int lines) {
		return case2(reflectHoriz(reflectVert(mountain, lines), lines), lines);
	}

	public static boolean case3(String mountain, int lines) {
		return case3(gen2DArray(mountain, lines), lines);
	}

	public static boolean case4(char[][] mountain, int lines) {
		return case2(reflectHoriz(mountain, lines), lines);
	}
	
	public static boolean case4(String mountain, int lines) {
		return case4(gen2DArray(mountain, lines), lines);
	}

	
	private static char[][] reflectHoriz(char[][] mountain, int lines) {

		char[][] horizRMountain = new char[lines][lines];
		for (int row=lines-1; row>=0; --row) {
			for (int col=0; col<lines; ++col) {
				horizRMountain[(lines-1)-row][col]=mountain[row][col];
			}
		}
		return horizRMountain;
	}

	private static char[][] reflectVert(char[][] mountain, int lines) {

		char[][] vertRMountain  = new char[lines][lines];
		for (int row=0; row<lines; ++row) {
			for (int col=lines-1; col>=0; --col) {
				vertRMountain[row][(lines-1)-col] = mountain[row][col];
			}
		}
		return vertRMountain;
	}

	private static char[][] gen2DArray(String mountain, int lines) {
		String[] levels = mountain.split("\n");
		char[][] levels2D = new char[lines][lines];

		for (int r=0; r<lines; ++r) {
			for (int c=0; c<lines; ++c) {
				if (c<levels[r].length()) {
					levels2D[r][c] = levels[r].charAt(c);
				}
				else {
					levels2D[r][c] = ' ';
				}
			}
		}
		return levels2D;
	}

}
