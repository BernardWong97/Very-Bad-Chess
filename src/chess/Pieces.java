// Bernard Wong - Board class
// A Pieces abstract class to have abstract methods

package chess;

public abstract class Pieces {
	// Data members
	private int x, y, playerTurn = Game.playerTurn;;
	private char selectedPiece;

	// Constructors
	public Pieces() {
	}
	
	public Pieces(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	// gets and sets
	public int getX() {
		return x;
	} //getX()
	
	public int getY() {
		return y;
	} //getY()
	
	public int getPlayerTurn() {
		return playerTurn;
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
	
	public void setPlayerTurn(int playerTurn) {
		this.playerTurn = playerTurn;
	} //setPlayerTurn()
	
	public void setSelectedPiece(char selectedPiece) {
		this.selectedPiece = selectedPiece;
	} // setSelectedPiece()
	
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
				Game.error = "No chess piece on this coordinates, please try again.";
				System.out.println(Game.error);
				System.out.println("=====================================================");
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
			isValid = new King().isPathValid(board, getX(), getY(), moveX, moveY);
			break;
		case 'Q':
		case 'q':
			isValid = new Queen().isPathValid(board, getX(), getY(), moveX, moveY);
			break;
		case 'B':
		case 'b':
			isValid = new Bishop().isPathValid(board, getX(), getY(), moveX, moveY);
			break;
		case 'N':
		case 'n':
			isValid = new Knight().isPathValid(board, getX(), getY(), moveX, moveY);
			break;
		case 'R':
		case 'r':
			isValid = new Rook().isPathValid(board, getX(), getY(), moveX, moveY);
			break;
		case 'P':
		case 'p':
			isValid = new Pawn().isPathValid(board, getX(), getY(), moveX, moveY);
			break;
		} // switch
		
		if(isValid) {
			board.boardArray[moveX][moveY] = board.boardArray[getX()][getY()];
			board.boardArray[getX()][getY()] = '-';
			
			// check if pawn can be promoted
			if((board.boardArray[moveX][moveY] == 'P' || board.boardArray[moveX][moveY] == 'p') && (moveX == 1 || moveX == 8)) {
				Pawn pawn = new Pawn();
				boolean canPromote = false;
				while(!canPromote){
					canPromote = pawn.promotion(board, moveX, moveY);
				} // while
			} // if
		}
		else {
			Game.error = "Invalid move, please try again.";
			System.out.println(Game.error);
			System.out.println("=====================================================");
			return false;
		} // if..else
		
		return true;
	} // movePiece()
	
	// Abstract methods
	public abstract boolean isPathValid(Board board, int fromX, int fromY, int toX, int toY);
} // abstract class
