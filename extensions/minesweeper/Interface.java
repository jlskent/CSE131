package minesweeper;

//Interface for Minesweeper
public interface Interface {
	
	public int getRows();
	public int getCols();
	public boolean isMine(int row, int col);

}
