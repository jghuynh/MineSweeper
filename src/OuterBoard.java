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
	 * Reveals the given box and the surrounding boxes, if applicable
	 * @param rowIndex the row index
	 * @param colIndex the column index
	 */
	public void revealBoxes(int rowIndex, int colIndex) {
		this.board[rowIndex][colIndex] = Integer.toString(this.innerBoard[rowIndex][colIndex]);
		
		
		// at the very end
		this.displayBoard();
	}
	
	public static void main(String[] args) {
		OuterBoard outerBoard = new OuterBoard();
		outerBoard.displayBoard();
	}
	
	

}
