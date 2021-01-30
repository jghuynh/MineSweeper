
public class Driver {
	
	
	public static void main(String[] args) {
		int size = 9;
		MineSweeperBoard board = new MineSweeperBoard(size);
		OuterBoard outerBoard = new OuterBoard(size);
		
		
		// adds the bombs, also updates the boxes around the bombs
		board.addBombs();
		
	}
}
