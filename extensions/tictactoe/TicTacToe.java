package tictactoe;

public class TicTacToe  {

	// avoids Javdoc entry: all methods for this work are static
	private TicTacToe() {

	}

	/**
	 * Generate an initial board
	 * @return a 3x3 String[][] array with each element set to a single blank string (" ").
	 */
	public static String[][] genBoard() {
		String[][] ans = new String[3][3];
		for(int r = 0; r<3; r++){
			for(int c = 0; c<3; c++){
				ans[r][c] = " ";
			}
		}
		return ans; 
	}

	/**
	 * Check that the specified player is "x" or "o" and throw an
	 *   IllegalArgumentException if it is not.
	 * @param player should be "x" or "o"
	 */
	public static void verifyValidPlayer(String player) {
		if (player.equals("x") || player.equals("o")) {
			return; // all is well
		}
		else {
			throw new IllegalArgumentException("Player must be a single x or o, but was instead " + player);
		}
	}

	/**
	 * Check that the row is between 0 and 2, inclusively, throwing IllegalArgumentException if not.
	 * @param row should be between 0 and 2, inclusively
	 */
	public static void verifyValidRow(int row) {
		if (row < 3 && row >= 0){
			return;
		}
		else{
			throw new IllegalArgumentException("Row must be between 0 and 2 inclusively, but was instead " + row);
		}
	}

	/**
	 * Check that the col is between 0 and 2, inclusively, throwing IllegalArgumentException if not.
	 * @param col should be between 0 and 2, inclusively
	 */
	public static void verifyValidCol(int col) {
		if (col < 3 && col >= 0){
			return;
		}
		else{
			throw new IllegalArgumentException("Cow must be between 0 and 2 inclusively, but was instead " + col);
		}
	}


	/**
	 * Returns a standard view of the current board
	 * @param board the current 3x3 tic tac toe board
	 * @return a String that looks like a tic tac toe board
	 */
	public static String prettyString(String[][] board) {
		String ans = "";
		for (int r=0; r < board.length; ++r) {
			for (int c=0; c < board[r].length; ++c) {
				ans += "| " + board[r][c] + " ";
			}
			ans += "|\n";
		}
		return ans;
	}

	/**
	 * Record a move of the player at the row and column.  You must
	 * <UL>
	 *   <LI> Make sure the player is valid (call {@link #verifyValidPlayer(java.lang.String)})
	 *   <LI> Make sure the row and column are valid (call {@link #verifyValidRow(int)} and {@link #verifyValidCol(int)})
	 *   <LI> Make sure the board has no move at the row and column.  In other words,
	 *     it should have just a single space there.  If the board already
	 *     has a move there, return false.
	 *   <LI> Record the move at the row and column by storing the player
	 *     String at board[row][col], and return true.
	 * </UL>
	 * 
	 * @param player an "x" or an "o"
	 * @param board a 3x3 String[][] array
	 * @param row an integer between 0 and 2 inclusively
	 * @param col an integer between 0 and 2 inclusively
	 * @return true iff the move was successful
	 */
	public static boolean makeMove(String player, String[][] board, int row, int col) {
		verifyValidPlayer(player);
		verifyValidRow(row);
		verifyValidCol(col);
		if (board[row][col] != " "){
			return false;
		}
		else{
			board[row][col] = player;
			return true;
		}
	}

	/**
	 * Is the board completely full of x and o moves?
	 * @param board a 3x3 String[][] array
	 * @return true iff the board is full
	 */
	public static boolean boardFull(String[][] board) {
		int count = 0;
		for (int r = 0; r<3; r++){
			for(int c = 0; c<3; c++){
				if(board[r][c] != " ") count++;
			}
		}
		if (count != 9 ) return false;
		else return true;
	}

	/**
	 * Does the board contain a win for the player?  If it does, this method must return true 
	 *   even if the board also contains a win for the other player.
	 * @param player An "x" or "o". Any other input should throw an IllegalArgumentException
	 * @param board A 3x3 String[][] array
	 * @return true iff the board contains some win for the specified player
	 */
	public static boolean winFor(String player, String[][] board) {
		verifyValidPlayer(player);

		for (int r = 0; r<3; r++){
			int count = 0;
			for(int c = 0; c<3; c++){
				if (board[r][c] == player) count++;
			}
			if (count == 3) return true;
		}
		
		for (int c = 0; c<3; c++){
			int count = 0;
			for(int r = 0; r<3; r++){
				if (board[r][c] == player) count++;
			}
			if (count == 3) return true;
		}
		
		int countDia1 = 0, countDia2 = 0;
		for (int r = 0; r<3; r++){
			if(board[r][r]==player) countDia1++;
			if(board[r][2-r]==player) countDia2++;
		}
		if (countDia1 == 3 || countDia2 == 3) return true;
		
		else return false;

	}

}
