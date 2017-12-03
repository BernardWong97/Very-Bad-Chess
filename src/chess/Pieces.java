// Bernard Wong - Board class
// A Pieces abstract class to have abstract methods

package chess;

public abstract class Pieces {
	// Data members
	private int x, y;

	// Constructors
	public Pieces() {
	}
	
	public Pieces(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	// get and set
	public int getX() {
		return x;
	} //getX()
	
	public int getY() {
		return y;
	} //getY()
	
	public void setX(int x) {
		this.x = x;
	} //getX()
	
	public void setY(int y) {
		this.y = y;
	} //setY()
	
	// Implement methods
	// method select the piece player chose
	public boolean selectPiece(int selectPieceX, int selectPieceY, char selectedPiece) {
		x = selectPieceX;
		y = selectPieceY;
		
		System.out.print("You have selected: ");
		switch (selectedPiece) {
			case 'K':
			case 'k':
				System.out.println("King (" + getX() + ", " + getY() + ")");
				break;
			case 'Q':
			case 'q':
				System.out.println("Queen (" + getX() + ", " + getY() + ")");
				break;
			case 'B':
			case 'b':
				System.out.println("Bishop (" + getX() + ", " + getY() + ")");
				break;
			case 'N':
			case 'n':
				System.out.println("Knight (" + getX() + ", " + getY() + ")");
				break;
			case 'R':
			case 'r':
				System.out.println("Rook (" + getX() + ", " + getY() + ")");
				break;
			case 'P':
			case 'p':
				System.out.println("Pawn (" + getX() + ", " + getY() + ")");
				break;
			default:
				System.out.println("No chess piece on this coordinates, please try again.");
				return false;
		} // switch
		return true;
	} // selectPiece()
	
	public void movePiece(Board board, int moveX, int moveY) {
		board.boardArray[moveX][moveY] = board.boardArray[getX()][getY()];
		board.boardArray[getX()][getY()] = '-';
	} // movePiece()
	
	// Abstract methods
	public abstract boolean isPathValid(int fromX, int fromY, int toX, int toY);
} // abstract class
