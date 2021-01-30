import java.util.Arrays;
import java.util.Random;

public class MineSweeperBoard {
	
	/**
	 * A board for MineSweeper
	 */
	private int[][] board;
	
	/**
	 * The length of the board (which is a square)
	 */
	private int size;
	
	 /**
	  * A default size of the board
	  */
	private int defaultSize = 14;
	
	/**
	 * The number of bombs in the board
	 */
	private int numBombs;
	
	
	public MineSweeperBoard(int size) {
		this.size = size;
		this.board = new int[this.size][this.size];
		
		if 	(this.size < 14) {
			this.numBombs = 10;
		} else if (this.size < 20) {
			this.numBombs = 40;
		} else {
			this.numBombs = 99;
		}
	}
	
	/**
	 * Constructs a MineSweeper Board with default size of 14
	 */
	public MineSweeperBoard() {
		this.board = new int[this.defaultSize][this.defaultSize];
		this.size = this.defaultSize;
		this.numBombs = 40;
	}
	
	/**
	 * Gets the size of the MineSweeper Board (or the length
	 * of the board, which is a square)
	 * 
	 * @return the size of the board
	 */
	public int getSize() {
		return this.size;
	}
	
	/**
	 * Adds all the bombs onto the board
	 */
	public void addBombs() {
		Random rand = new Random();
		
		for (int i = 0; i < this.numBombs; i ++) {
			int rowIndex = rand.nextInt(this.size);
			int colIndex = rand.nextInt(this.size);
			
			// let -1 denote a bomb
			if (this.board[rowIndex][colIndex] != -1) {
				this.board[rowIndex][colIndex] = -1;
				
				// a method that will update the neighboring 
				// squares around the bomb
				
				this.updateNumbers(rowIndex, colIndex);
			} else {
				i--;
			}
				
		}
		
		
	}
	
	/**
	 * Helper method to display the board
	 */
	public void displayBoard() {
		for (int[] row: this.board) {
			System.out.println(Arrays.toString(row));
		}
	}
	
	/**
	 * Updates the helpful numbers on the board (numbers
	 * that mark around the bomb), given a bomb's location
	 * 
	 * @param row the row Index of the bomb
	 * @param col the column Index of the bomb
	 */
	public void updateNumbers(int row, int col) {
		
		for (int r = row - 1; r <= row + 1; r ++) {
			for (int c = col - 1; c <= col + 1; c ++) {
				// check if r and c are within the board
				
				if (inBoard(r, c)) {
					if (this.board[r][c] != -1) {
						this.board[r][c] ++;
					}
				}
				
			}
		}
		
	}
	
	/**
	 * Checks if the given row index and column index are on the board dimensions
	 * @param rowIndex the row index of the board
	 * @param colIndex the column index of the board
	 * @return true if the position in the board is legal; false otherwise
	 */
	public boolean inBoard(int rowIndex, int colIndex) {
		
		if (rowIndex < 0 || colIndex < 0 || rowIndex >= this.size || colIndex >= this.size) {
			return false;
		}
		return true;
		
	}
	
	public static void main(String[] args) {
		MineSweeperBoard myBoard = new MineSweeperBoard(9);
		myBoard.addBombs();
		
		myBoard.displayBoard();
	}
	
	
}
