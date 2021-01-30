
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
	 * The number of bombs on the board
	 */
	private int numBombs;
	
	/**
	 * The size of the board (the length of one side)
	 */
	private int size;
	
	/**
	 * Default constructs an outer board to show to players
	 */
	public OuterBoard() {
		this(14);
	}
	
	public OuterBoard(int size) {
		this.size = this.defaultSize;
		this.board = new String [this.size][this.size];
		
		if (this.size < 5) {
			this.numBombs = 7;
		} else if (this.size < 14) {
			this.numBombs = 10;
		} else if (this.size < 20) {
			this.numBombs = 40;
		} else {
			this.numBombs = 99;
		}
	}
	
	

}
