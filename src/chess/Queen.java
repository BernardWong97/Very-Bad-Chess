// Bernard Wong - Board class
// A Queen class to create the Pieces Queen implementing PieceType

package chess;

public class Queen extends Pieces implements PieceType{

	// Constructors
	public Queen() {
	}
	
	public Queen(int x, int y) {
		super(x, y);
	}

	// Override abstract methods
	@Override
	public boolean isPathValid(Board board, int fromX, int fromY, int toX, int toY) {
		// current piece position false
        if(toX == fromX && toY == fromY) {
        	Game.error = "This is the position of the current selected piece, please try again.";
            return false;
        } // if
        
		// player can't capture own pieces
		if(getPlayerTurn() % 2 == 0) {
			if(Character.isUpperCase(board.boardArray[toX][toY])) {
				Game.error = "That piece is your own piece, please try again.";
				return false;
			} // inner if
		}
		else{
			if(Character.isLowerCase(board.boardArray[toX][toY])) {
				Game.error = "That piece is your own piece, please try again.";
				return false;
			} // inner if
		} // if player 1 / player 2
		
        // can move horizontally
		if(toX == fromX)
			return true;
		// can move vertically
		if(toY == fromY)
			return true;
		// can move diagonally
		if(Math.abs(toX - fromX) == Math.abs(toY - fromY))
			return true;
		
		return false;
	} // isPathValid()

	// Override interface methods
	@Override
	public char pieceType(int player) {
		if(player == 1)
			return 'Q';
		else
			return 'q';
	} // pieceType()

} // class
