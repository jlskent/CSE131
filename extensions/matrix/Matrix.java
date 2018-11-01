package matrix;

import java.util.Arrays;

/**
 * @author Yang
 *
 */
public class Matrix {
	
	private double[][] values;
		
	/**
	 * The Matrix is based on the supplied two-dimensional array of values.
	 * Be sure to make your own copy of the values, so that changes to the
	 *    array outside of this class do not affect your work.
	 * @param values
	 */
	public Matrix(double[][] in) {
				
		this.values = new double[in.length][];	

		for (int i = 0 ; i < in.length; i++) {
				values[i] = Arrays.copyOf(in[i], in[i].length);
		}

//		System.out.println("--------------------input");
//		System.out.println(Arrays.deepToString(in));
//		System.out.println("--------------------saved");
//		System.out.println(Arrays.deepToString(values));
		
	}
	
	public double getValue(int row, int col) {
		return this.values[row][col];  // Do not change this!
	}
	
	public int getNumRows() {
		return values.length;  // Do not change!
	}
	
	public int getNumCols() {
		return values[0].length; // Do not change!
	}
	
	/**
	 * You must complete this method, or the equals(Object) test will always
	 *   return false. 
	 * Arrays one and two are considered
	 * equal if and only if:
	 *   1) They have the same shape (number of rows and columns agree)
	 *   2) The contents of the two arrays are the same, element by element
	 * @param one
	 * @param two
	 * @return true iff the arrays have the same shape and contents
	 */
	private static boolean arraysAreEqual(double[][] one, double[][] two) {
		if (one.length != two.length) {
			return false;
		}
		
		
		for (int i =0; i< one.length; i++) {
			if (one[i].length != two[i].length) {
				return false;
			}
		}
		
		for (int i =0; i< one.length; i++) {
			for (int j =0; j< one[i].length; j++) {
				if (one[i][j] != two[i][j]) {
					return false;
				}
			}
		}
		
		return true; 
	}
	
	/**
	 * This was generated initially by eclipse, but
	 *   eclipse does not know how to compare two-dimensional arrays.
	 *   We therefore call arraysAreEequal to do that job.
	 */
	public boolean equals(Object obj) {
		// If this and obj are the same object, they must be equal
		if (this == obj)
			return true;
		// If obj is null ("this" cannot be null), then they are not equal
		if (obj == null)
			return false;
		// If the two objects are not the same type, they are not equal
		if (getClass() != obj.getClass())
			return false;
		//
		// If we get here, we have two objects of the same type.
		// Calling your helper method to determine the arrays' equality.
		Matrix other = (Matrix) obj;
		return arraysAreEqual(this.values, other.values);
	}
	
	public Matrix plus(Matrix other) {
			if (arraysAreEqual(this.values, other.values)) {
				for (int i =0; i< this.values.length; i++) {
					for (int j =0; j< this.values[i].length; j++) {
						this.values[i][j] = this.values[i][j] + other.values[i][j];
					}
				}
				return this;
			}
			else {
	            throw new IllegalArgumentException("verify input");
//				return null; 	

			}
		}
	
	/**
	 * Returns a **new Matrix** that is the product of this and the other one.
	 * Does not change this Matrix at all.
	 * @param other
	 * @return
	 */
	public Matrix times(Matrix other) {
			boolean match = true;
			int aRows = this.values.length;
	        int aColumns = this.values[0].length;
	        int bRows = other.values.length;
	        int bColumns = other.values[0].length;
			if (aRows != bColumns) {
				match = false;
			}

	        double[][] result = new double[aRows][bColumns];

		
			System.out.println("original    "+this.toString());

		
			if (match == true) {
		        for(int i = 0; i < aRows; i++) {         // rows from m1
		            for(int j = 0; j < bColumns; j++) {     // columns from m2
		                for(int k = 0; k < aColumns; k++) { // columns from m1
		                    result[i][j] += this.values[i][k] * other.values[k][j];
		                }
		            }
		        }
				
				Matrix output = new Matrix(result);
		        
				return output;
			}
			
			else {
	            throw new IllegalArgumentException("not match");

			}
//			
//			
//			
//			if (match == true) {
//				for (int i =0; i< this.values.length; i++) {
//					for (int j =0; j< this.values[i].length; j++) {
//						this.values[i][j] = this.values[i][j] * other.values[i][j];
//						System.out.println("result " + this.toString());
//
//					}
//				}
//				return this;
//			}
//			
//			
//
//			else {
//	            throw new IllegalArgumentException("A:Rows: " + this.values.length + " did not match B:Columns " + other.values[0].length + ".");
//			}

			
		}
	
	/**
	 * Returns a **new Matrix** that is the transpose of this one.
	 * Does not change this Matrix at all.
	 * @return
	 */
	public Matrix transpose() {
		int newRow = this.getNumCols();
		int newCol = this.getNumRows();
		double [][] temp = new double[newRow][newCol];
		
//		System.out.println("original " + this.toString());
		
		
	   for (int i = 0; i < this.values.length; i++) {
	        for (int j = 0; j < this.values[i].length; j++) {
	        	temp[j][i] = this.values[i][j];
	        }
	    }
//		System.out.println("new array " + Arrays.deepToString(temp));

		Matrix newOne = new Matrix(temp);
		
		
		return newOne;
	}

	/**
	 * Modifies this Matrix by scaling row i by the supplied factor.
	 * @param i the row to scale, where 0 is the top row
	 * @param factor the amount by which to scale each element of row i
	 */
	public void scaleRow(int i, double factor) {
		
		if(i<0 || i>= this.values.length || factor<=0) {
		    throw new IllegalArgumentException("verify input");
		}
		
		for (int k =0; k<values.length; k++) {		
			if (k==i) {
				for (int j=0; j<values[i].length; j++) {
					values[k][j] = values[k][j] * factor;
				}
			}
		}
		
		
	}

	/**
	 * Modifies this matrix by adding row i to row j.  Row 0 is the top row.
	 * @param i
	 * @param j
	 */
	public void addRows(int i, int j) {
					
		for (int n =0; n<values[j].length; n++) {	
			values[j][n] = values[j][n] + values[i][n];
			
		}
		
	}
	
	/**
	 * Modifies the Matrix by exchanging row i with row j
	 * @param i
	 * @param j
	 */
	public void exchangeRows(int i, int j){

		double[] temp = new double[values[i].length];
		temp = Arrays.copyOf(values[i], values[i].length);
		values[i] = values[j];
		values[j] = temp;
	
	}

	/**
	 * My gift to you.  This returns a String representation of
	 * the Matrix.  The contents of each row is separated by a tab (\t)
	 * so that columns (kind of) line up.  Each row is separated by a
	 * newline (\n) so that the output looks like a matrix.  The output
	 * of this method should <i>not</i> be used to compare matrices for
	 * equality:  use the .equals(Object) method instead!
	 */
	public String toString() {
		String ans = "";
		for (int i=0; i < values.length; ++i) {
			ans = ans + "\n";
			// Loop below assumes all rows have the same number of columns
			for (int j=0; j < values[0].length; ++j) {
				ans = ans + values[i][j] + "\t";
			}
		}
		return ans;
	}

}
