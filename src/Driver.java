
public class Driver {
	
	
	public static void main(String[] args) {
		int size = 9;
		MineSweeperBoard board = new MineSweeperBoard(size);
		OuterBoard outerBoard = new OuterBoard(board);
		
		
		// adds the bombs, also updates the boxes around the bombs
		board.addBombs();
		board.displayBoard();
//		outerBoard.revealBoxes(3,  4);
		
		/*
		 * grab user input: rowIndex, colIndex
		 * Spawn a MineSweeperBoard, 
		 * then check if the board[rowIndex][colIndex] != 0:
		 * respawn board
		 * else: do nothing
		 */
		
		
		
//		outerBoard.displayBoard();
		
	}
}
