import java.util.Arrays;

public class OuterBoard {
	
	/**
	 * The board that players will see
	 */
	private String [][] board;
	
	/**
	 * The default size of the board
	 */
	private int defaultSize = 14;
	
	/**
	 * The MineSweeperBoard board
	 */
	private final int[][] innerBoard;
	
	/**
	 * The number of bombs on the board
	 */
//	private int numBombs;
	
	/**
	 * The size of the board (the length of one side)
	 */
	private int size;
	
	/**
	 * Default constructs an outer board to show to players
	 */
	public OuterBoard() {
		this.size = this.defaultSize;
		this.board = new String[this.size][this.size];
		this.innerBoard = new int [this.size][this.size];
	}
	
	/**
	 * Constructs the outer board for players to see and play
	 * @param board the original MineSweeperBoard
	 */
	public OuterBoard(MineSweeperBoard board) {
		this.size  = board.getSize();
		this.board = new String[this.size][this.size];
		this.innerBoard = board.getBoard();
	}
	
	/**
	 * Helper method to display the board
	 */
	public void displayBoard() {
		for (String[] row: this.board) {
			System.out.println(Arrays.toString(row));
		}
	}
	
	/**
	 * Marks a value as a flag, given the row and column indeces
	 * 
	 * @param rowIndex the row index
	 * @param colIndex the column index
	 */
	public void doFlag(int rowIndex, int colIndex) {
		this.board[rowIndex][colIndex] = "f";
	}
	
	/**
	 * Checks if the current position on the outer board is legal
	 * @param rowIndex the row index
	 * @param colIndex the column index
	 * @return true if the current space is on the outer board; false otherwise
	 */
	public boolean inBoard(int rowIndex, int colIndex) {
		
		if (rowIndex < 0 || colIndex < 0 || rowIndex >= this.size || colIndex >= this.size) {
			return false;
		}
		return true;
		
	}
	
	/**
	 * Reveals the given box and the surrounding boxes, if applicable
	 * @param rowIndex the row index
	 * @param colIndex the column index
	 */
	public void revealBoxes(int rowIndex, int colIndex) {
		System.out.println(rowIndex + "," + colIndex);
		
		// base case; if current box is not 0
		if (this.innerBoard[rowIndex][colIndex] != 0) {
			return; // stop
		}
		
		// if the current box is 0
		for (int r = rowIndex - 1; r <= rowIndex + 1; r ++) {
			for (int c = colIndex - 1; c <= colIndex + 1; c ++) {
				if (this.inBoard(r, c)) {
					revealBoxes(r, c);
				}
				
			}
		}
		
		this.displayBoard();
	}
	
	public static void main(String[] args) {
		OuterBoard outerBoard = new OuterBoard();
		outerBoard.displayBoard();
	}
	
	

}
