// Bernard Wong - Board class
// A Pieces abstract class to have abstract methods

package chess;

public abstract class Pieces {
	// Data members
	int x, y;

	// Constructors
	public Pieces() {
	}
	
	public Pieces(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	// Implement methods
	// method select the piece player chose
	public void selectPiece(int selectPieceX, int selectPieceY, char selectedPiece) {
		x = selectPieceX;
		y = selectPieceY;
		
		System.out.print("You have selected: ");
		switch (selectedPiece) {
			case 'K':
			case 'k':
				System.out.println("King (" + x + ", " + y + ")");
				break;
			case 'Q':
			case 'q':
				System.out.println("Queen (" + x + ", " + y + ")");
				break;
			case 'B':
			case 'b':
				System.out.println("Bishop (" + x + ", " + y + ")");
				break;
			case 'N':
			case 'n':
				System.out.println("Knight (" + x + ", " + y + ")");
				break;
			case 'R':
			case 'r':
				System.out.println("Rook (" + x + ", " + y + ")");
				break;
			case 'P':
			case 'p':
				System.out.println("Pawn (" + x + ", " + y + ")");
				break;
			default:
				System.out.println("No chess piece on this coordinates");
		} // switch
		
	} // selectPiece()
	
	public void movePiece(Board board, int moveX, int moveY) {
		board.boardArray[moveX][moveY] = board.boardArray[x][y];
		board.boardArray[x][y] = '-';
	} // movePiece()
	
	// Abstract methods
	public abstract boolean isPathValid();
} // abstract class
