package chess;

public class Board {
	char[][] board = new char[10][10];
	char xLable = 49, yLable = 97;

	public Board() {
	}
	
	public void createBoard(){
		
		for(int i = 0; i < board.length; i++) {
			for(int j = 0; j < board.length; j++) {
				board[i][j] = '-';
			}
		}
		
		for(int i = 1; i <= 8; i++) {
			board[i][0] = xLable;
			board[i][9] = xLable;
			xLable++;
		}
		
		for(int j = 1; j <= 8; j++) {
			board[0][j] = yLable;
			board[9][j] = yLable;
			yLable++;
		}
		
	}
	
	public void displayBoard() {
		for(int i = 0; i < board.length; i++) {
			for(int j = 0; j < board.length; j++) {
				System.out.print(board[i][j]);
			}
			System.out.println();
		}
	}
	
	public static void main(String[] args) {
		Board board = new Board();
		board.createBoard();
		board.displayBoard();
	}

}
