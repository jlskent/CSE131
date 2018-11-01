package conway;

import java.util.Arrays;

/**
 * @author Yang
 *
 */
public class Conway {


	
	int rows;
	int cols;
//	boolean isLive;
	int [][] arr;
	
	

	public Conway(int rows, int cols){
		this.rows = rows;
		this.cols = cols;
		this.arr = new int [rows][cols];
	}


	public int getRows(){
		return this.rows;
	}

	public int getColumns(){
		return this.cols;
	}

	/**
	 * Sets the current status of the cell at (row, col)
	 * @param b if true, the cell is alive; if false, the cell is dead 
	 * @param row
	 * @param col
	 */
	public void setLiveness(boolean b, int row, int col){
		if (row > this.rows || col > this.cols) {
			return;
		}
		
//		1 represents alive 3 means dead; 0 is not set(considered dead)
		if (b) {
			this.arr[row][col] = 1;
		}
		if (b == false) {
			this.arr[row][col] = 3;
		}
//		System.out.println(arr[row][col]);
	}


	/**
	 *  
	 * @param row
	 * @param col
	 * @return whether or not a cell at a specific row and column is alive. 
	 *    If row or col is out of bounds, you must return false.
	 */
	public boolean isAlive(int row, int col){
//		System.out.println("comway" +  this.rows + ", " + this.cols);
//		System.out.println("alive test" +  row + ", " + col);
		if (row >= this.rows || col >= this.cols || row<0 || col<0) {
			return false;
		}
		if (arr[row][col] == 1) {
			return true;
		}
		else {
			return false;
		}
	}


	/**
	 * Make every cell not alive
	 */
	public void clear(){
		for (int i=0; i< arr.length; i++) {
			for(int j =0;j<arr[i].length;j++) {
				arr[i][j] = 3;
			}
		}
		
		
		
	}


	/**
	 * Consider the 3x3 cell array that has the cell at (row, col) at its center.
	 * Let's call all cells but that center cell the neighbors of that center cell.
	 * This method returns the number of neighbors that are alive.
	 * 
	 *   n  n  n
	 *   n  c  n
	 *   n  n  n
	 *   
	 *  Above, if c represents the cell at (row, col), each n is
	 *  a neighbor of c, according to the above definition.
	 *  The result is at most 8 and at least 0.
	 * 
	 * @param row
	 * @param col
	 * @return the number of living neighbors
	 */
	public int countLivingNeighbors(int row, int col){
		int livingPals=0;
		
		if ( isAlive(row-1,col-1)) {
			livingPals ++;
		}
		if ( isAlive(row-1,col)) {
			livingPals ++;
		}
		if ( isAlive(row-1,col+1)) {
			livingPals ++;
		}
		
		
		if ( isAlive(row,col-1)) {
			livingPals ++;
		}
		if ( isAlive(row,col+1)) {
			livingPals ++;
		}
		
		
		
		if ( isAlive(row+1,col-1)) {
			livingPals ++;
		}
		if ( isAlive(row+1,col)) {
			livingPals ++;
		}
		if ( isAlive(row+1,col+1)) {
			livingPals ++;
		}
		
		
		return livingPals;
	}

	/**
	 * Executes a generation of life.  Be sure to read the specification
	 * for this assignment, because it points out a common mistake students
	 * make when implementing this method.
	 * 
	 */
	
//	If a living cell has fewer than two living neighbors, it dies of loneliness
//	If a living cell has more than three living neighbors it dies of overcrowding
//	If a living cell has two or three neighbors, it continues to live
//	If a dead cell has exactly three living neighbors, it is resurrected by friendship
//	 you can store the liveness of ALL of the cells on that Conway object, and then alter the values of the this Conway object at the end.
	
	public void step(){
//		not exactly right, next should be the old, this is evolving
		Conway next = new Conway(this.rows, this.cols);
//		null pointer error becasue next.arr is initialized already
//		next.arr  =  new int[this.rows][];

//		copy the array
		for (int i=0; i< this.arr.length; i++) {
			for(int j =0;j< this.arr[i].length; j++) {
				next.arr[i][j] = this.arr[i][j];
			}
		}
		
		
		for (int i=0; i < next.arr.length; i++) {
			for(int j =0; j < next.arr[i].length; j++) {
				
				int livingNeighbor = next.countLivingNeighbors(i,j);
				System.out.println("location " + i+ "," +j + " living status " + next.arr[i][j] + ", living neighbor"+ livingNeighbor);
				
				if (livingNeighbor <2 || livingNeighbor >3) {
//					this.arr[i][j] = 3;
					this.setLiveness(false, i, j);

				}
				if ( livingNeighbor ==3 ) {
					System.out.println("comeback");

//					this.arr[i][j] = 1;
					this.setLiveness(true, i, j);
				}
				


			}
		}
		
	}

	/**
	 * creates a blinker
	 */
	public void blinker() {

		if (this.getRows() < 3 || this.getColumns() < 3) {
			System.out.println("Grid is too small for premade pattern Blinker. " +
					"Conway must be at least 3x3");
		}
		else {
			this.setLiveness(true, 1, 0);
			this.setLiveness(true, 1, 1);
			this.setLiveness(true, 1, 2);
		}
	}

	public void fourBlinkers() {
		clear();
		if (this.getRows() < 9 || this.getColumns() < 9) {
			System.out.println("Grid is too small for premade pattern Four Blinkers. " +
					"Conway must be at least 9x9");
		}
		else {
			for (int i = 3; i < 6; i++) {
				for (int j = 3; j < 6; j++) {
					this.setLiveness(true, i, j);
				}
			}
		}
	}


	public void gosperGliderGun() {
		clear();
		if (this.getRows() < 50 || this.getColumns() < 50) {
			System.out.println("Grid is too small for premade pattern Gosper Glider Gun. " +
					"Conway must be at least 50x50");
		}
		else {
			this.setLiveness(true,0,27);
			this.setLiveness(true,1,25);
			this.setLiveness(true,1,27);
			this.setLiveness(true,2,15);
			this.setLiveness(true,2,16);
			this.setLiveness(true,2,23);
			this.setLiveness(true,2,24);
			this.setLiveness(true,2,37);
			this.setLiveness(true,2,38);
			this.setLiveness(true,3,14);
			this.setLiveness(true,3,18);
			this.setLiveness(true,3,23);
			this.setLiveness(true,3,24);
			this.setLiveness(true,3,37);
			this.setLiveness(true,3,38);
			this.setLiveness(true,4,3);
			this.setLiveness(true,4,4);
			this.setLiveness(true,4,13);
			this.setLiveness(true,4,19);
			this.setLiveness(true,4,23);
			this.setLiveness(true,4,24);
			this.setLiveness(true,5,3);
			this.setLiveness(true,5,4);
			this.setLiveness(true,5,13);
			this.setLiveness(true,5,17);
			this.setLiveness(true,5,19);
			this.setLiveness(true,5,20);
			this.setLiveness(true,5,25);
			this.setLiveness(true,5,27);
			this.setLiveness(true,6,13);
			this.setLiveness(true,6,19);
			this.setLiveness(true,6,27);
			this.setLiveness(true,7,14);
			this.setLiveness(true,7,18);
			this.setLiveness(true,8,15);
			this.setLiveness(true,8,16);


		}
	}

	public void glider() {
		clear();
		if (this.getRows() < 10 || this.getColumns() < 10) {
			System.out.println("Grid is too small for premade pattern Four Blinkers. " +
					"Conway must be at least 10x10");
		}
		else {

			this.setLiveness(true,1,1);
			this.setLiveness(true,1,3);
			this.setLiveness(true,2,2);
			this.setLiveness(true,2,3);
			this.setLiveness(true,3,2);

		}
	}

	public void yourDesignOne() {

	}

	public void yourDesignTwo() {

	}


	public void logAndCapture() {
		
		
		

	}

}