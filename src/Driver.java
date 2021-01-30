
public class Driver {
	
	
	public static void main(String[] args) {
		int size = 9;
		MineSweeperBoard board = new MineSweeperBoard(size);
		OuterBoard outerBoard = new OuterBoard(board);
		
		
		// adds the bombs, also updates the boxes around the bombs
		board.addBombs();
		board.displayBoard();
		outerBoard.revealBoxes(3,  4);
//		outerBoard.displayBoard();
		
	}
}
