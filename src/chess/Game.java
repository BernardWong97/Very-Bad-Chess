// Bernard Wong - Board class
// A Game class where the game executes

package chess;

import java.util.Scanner;

public class Game {
	// Data members
	public static Scanner console = new Scanner(System.in);
	public static Board chessBoard = new Board();
	public static Pieces chessPiece = new King();
	public static int selectPieceX, selectPieceY, moveToX, moveToY, playerTurn = 0;
	public static boolean gameOver = false;
	public static String error;
	
	public static void main(String[] args) {
		// do..while game over stop loop
		do {
			chessBoard.displayBoard();
			
			// change player turn
			if(playerTurn % 2 == 0) {
				// prompt inputs
				chessBoard.displayPlayer1();
				System.out.print("X: ");
				selectPieceX = console.nextInt();
				System.out.print("Y: ");
				selectPieceY = console.nextInt();
				
				// select the piece and validate if it is a valid piece for player 1
				if(selectPieceX > 8 || selectPieceX < 1 || selectPieceY > 8 || selectPieceY < 1) {
					error = "Please enter 1 to 8 for coordinates only, try again.";
					System.out.println(error);
					System.out.println("=====================================================");
					continue;
				} // if validate if coordinates is in the chess board
				if(chessBoard.validatePiece(playerTurn, chessBoard.boardArray[selectPieceX][selectPieceY]) == false)
					continue;
				if(chessPiece.selectPiece(selectPieceX, selectPieceY, chessBoard.boardArray[selectPieceX][selectPieceY]) == false)
					continue;
				
				// select where the piece go
				System.out.print("Move to X: ");
				moveToX = console.nextInt();
				System.out.print("Move to Y: ");
				moveToY = console.nextInt();
				if(moveToX > 8 || moveToX < 1 || moveToY > 8 || moveToY < 1) {
					error = "Please enter 1 to 8 for coordinates only, try again.";
					System.out.println(error);
					System.out.println("=====================================================");
					continue;
				} // if validate if coordinates is in the chess board
				
				// if validate if movement is valid
				if(chessPiece.movePiece(chessBoard, moveToX, moveToY) == false)
					continue;
				
				System.out.println("=====================================================");
			}else {
				// prompt input
				chessBoard.displayPlayer2();
				System.out.print("X: ");
				selectPieceX = console.nextInt();
				System.out.print("Y: ");
				selectPieceY = console.nextInt();
		
				// select the piece and validate if it is a valid piece for player 2
				if(selectPieceX > 8 || selectPieceX < 1 || selectPieceY > 8 || selectPieceY < 1) {
					error = "Please enter 1 to 8 for coordinates only, try again.";
					System.out.println(error);
					System.out.println("=====================================================");
					continue;
				} // if validate if coordinates is in the chess board
				if(chessBoard.validatePiece(playerTurn, chessBoard.boardArray[selectPieceX][selectPieceY]) == false)
					continue;
				if(chessPiece.selectPiece(selectPieceX, selectPieceY, chessBoard.boardArray[selectPieceX][selectPieceY]) == false)
					continue;
				
				// select where the piece go
				System.out.print("Move to X: ");
				moveToX = console.nextInt();
				System.out.print("Move to Y: ");
				moveToY = console.nextInt();
				if(moveToX > 8 || moveToX < 1 || moveToY > 8 || moveToY < 1) {
					error = "Please enter 1 to 8 for coordinates only, try again.";
					System.out.println(error);
					System.out.println("=====================================================");
					continue;
				} // if validate if coordinates is in the chess board
				
				// if validate if movement is valid
				if(chessPiece.movePiece(chessBoard, moveToX, moveToY) == false)
					continue;
				
				System.out.println("=====================================================");
			} // if..else

			playerTurn++; // increment player's turn
			if(playerTurn == 10) gameOver = true; //test
		} while(gameOver != true); // do..while
		
		// Game Over output
		System.out.println("Game Over!");
		
	} // main

} // class
