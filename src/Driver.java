
public class Driver {
	
	
	public static void main(String[] args) {
		
		MineSweeperBoard board = new MineSweeperBoard(9);
		
		// adds the bombs, also updates the boxes around the bombs
		board.addBombs();
		
	}
}
