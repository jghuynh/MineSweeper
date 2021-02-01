import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

public class OuterBoard {
	
	/**
	 * The board that players will see
	 */
	private String [][] board;
	
	/**
	 * The default size of the board
	 */
	private final static int defaultSize = 14;
	
	private HashMap<Integer, HashSet<Integer>> coordinatesVisited;
	// [0, 0]
	// [3, 5]
	// Orrrr
	// a hashset where
	// (0, 1) = 1,
	// (0, 4) = 4
	// (3, 5) = 35
	
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
		this(new MineSweeperBoard(defaultSize));
	}
	
	/**
	 * Constructs the outer board for players to see and play
	 * @param board the original MineSweeperBoard
	 */
	public OuterBoard(MineSweeperBoard board) {
		this.size  = board.getSize();
		this.board = new String[this.size][this.size];
		this.innerBoard = board.getBoard();
		this.coordinatesVisited = new HashMap<Integer, HashSet<Integer>>();
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
		/*
		 * TODO: I have an infinite whileloop or something
		 * TODO: semantic error; not accurately revealing all 0s
		 */
		
		System.out.println(rowIndex + "," + colIndex);
		if (this.inBoard(rowIndex, colIndex)) {
			// base case; if current box is not 0
			if (this.innerBoard[rowIndex][colIndex] != 0) {
				this.board[rowIndex][colIndex] = Integer.toString(innerBoard[rowIndex][colIndex]);
				return; // stop
			}
			
			// if the current box is 0
			for (int r = rowIndex - 1; r <= rowIndex + 1; r ++) {
				for (int c = colIndex - 1; c <= colIndex + 1; c ++) {
					if (this.inBoard(r, c)) {
//						this.coordinatesVisited.putIfAbsent(r, new HashSet<Integer>());
						
						// if we haven't seen this x-coordinate
						if (!this.coordinatesVisited.containsKey(r)) {
							this.coordinatesVisited.put(r, new HashSet<Integer>());
							revealBoxes(r, c);
						} else {
							// if we have seen the x-coordinate but not the y-coordinate
							if (!this.coordinatesVisited.get(r).contains(c)) {
								this.coordinatesVisited.get(r).add(c);
								revealBoxes(r, c);
							}
						}
						
						
					}
					
				}
			}
		} else {
			System.out.println("Oops! Please input a pair of legal coordintes!");
		}
		
		
		this.displayBoard();
	}
	
	public static void main(String[] args) {
		MineSweeperBoard board = new MineSweeperBoard(9);
		OuterBoard outerBoard = new OuterBoard(board);
		board.addBombs();
		board.displayBoard();
		outerBoard.revealBoxes(0, 5);
		outerBoard.displayBoard();
		
		
		
	
		
	}
	
	

}
