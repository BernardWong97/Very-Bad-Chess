// Bernard Wong - Board class
// A Pieces abstract class to have abstract methods

package chess;

public abstract class Pieces {
	// Data members
	private int x, y;
	private char selectedPiece;

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
	
	public char getSelectedPiece() {
		return selectedPiece;
	} // getSelectedPiece()
	
	public void setX(int x) {
		this.x = x;
	} //getX()
	
	public void setY(int y) {
		this.y = y;
	} //setY()
	
	public void setSelectedPiece(char selectedPiece) {
		this.selectedPiece = selectedPiece;
	} // setSelectedPiece
	
	// Implement methods
	// method select the piece player chose
	public boolean selectPiece(int selectPieceX, int selectPieceY, char selectedPiece) {
		setX(selectPieceX);
		setY(selectPieceY);
		setSelectedPiece(selectedPiece);
		
		System.out.print("You have selected: ");
		switch (getSelectedPiece()) {
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
	
	public boolean movePiece(Board board, int moveX, int moveY) {
		boolean isValid = false;
		
		// check valid move through each class
		switch(getSelectedPiece()) {
		case 'K':
		case 'k':
			isValid = new King().isPathValid(getX(), getY(), moveX, moveY);
		case 'Q':
		case 'q':
			isValid = new Queen().isPathValid(getX(), getY(), moveX, moveY);
		case 'B':
		case 'b':
			isValid = new Bishop().isPathValid(getX(), getY(), moveX, moveY);
		case 'N':
		case 'n':
			isValid = new Knight().isPathValid(getX(), getY(), moveX, moveY);
		case 'R':
		case 'r':
			isValid = new Rook().isPathValid(getX(), getY(), moveX, moveY);
		case 'P':
		case 'p':
			isValid = new Pawn().isPathValid(getX(), getY(), moveX, moveY);
		} // switch
		
		if(isValid) {
			board.boardArray[moveX][moveY] = board.boardArray[getX()][getY()];
			board.boardArray[getX()][getY()] = '-';
		}
		else {
			System.out.println("Invalid move, please try again");
			System.out.println("=====================================================");
			return false;
		} // if..else
		
		return true;
	} // movePiece()
	
	// Abstract methods
	public abstract boolean isPathValid(int fromX, int fromY, int toX, int toY);
} // abstract class
