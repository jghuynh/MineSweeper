import java.util.Arrays;
import java.util.Scanner;

public class Driver {
	// Check this out: https://pwmarcz.pl/blog/kaboom/
	
	public static void main(String[] args) {
		
		boolean isLegalCoordinates = false;
		boolean isLegalSize = false;
		Scanner myScanner;
		int size = 0;
		int rowIndex = 0;
		int colIndex = 0;
		
		while (!isLegalSize) {
			myScanner = new Scanner(System.in);
			System.out.println("Please enter the difficulty: easy, medium, or hard");
			String difficulty = myScanner.nextLine().toLowerCase().strip();
			
			if (difficulty.equals("easy") || difficulty.equals("e")) {
				size = 9;
				isLegalSize = true;
			} else if (difficulty.equals("medium") || difficulty.equals("m")) {
				size = 14;
				isLegalSize = true;
			} else if (difficulty.equals("hard") || difficulty.equals("h")) {
				size = 21;
				isLegalSize = true;
			} else {
				System.out.println("Oops! Please choose a legal level.");
			}
			
		}
		
		while (!isLegalCoordinates) {
			myScanner = new Scanner(System.in);
		
			System.out.println("Please input the coordinates you would like to uncover.\n"
					+ "Format: row, col");
			String coordinates = myScanner.nextLine().replaceAll(" ", "");
			
			String[] coordinateArray = coordinates.split(",");
			
			
			System.out.println(Arrays.toString(coordinateArray));
			
			try {
				rowIndex =  Integer.parseInt(coordinateArray[0].strip());
				colIndex = Integer.parseInt(coordinateArray[1].strip());
				isLegalCoordinates = true;
			} catch (NumberFormatException e) {
				System.err.println("Oops! Please input a number");
			}
		}
		
		
		
		MineSweeperBoard board = new MineSweeperBoard(size);
		OuterBoard outerBoard = new OuterBoard(board);
		board.addBombs();
		System.out.println("Value:" + board.getBoard()[rowIndex][colIndex]);
		
		while (board.getBoard()[rowIndex][colIndex] != 0) {
			System.out.println("Didn't get a 0...");
			board = new MineSweeperBoard(size);
			outerBoard = new OuterBoard(board);
			
		}
				
		// adds the bombs, also updates the boxes around the bombs
		
//		board.displayBoard();
		outerBoard.revealBoxes(rowIndex, colIndex);
		outerBoard.displayBoard();
		
		/*
		 * checking if -1
		 * if the box is -1
		 * print("Oh noes! That's a bomb! You lose.")
		 */
		
//		outerBoard.displayBoard();
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
