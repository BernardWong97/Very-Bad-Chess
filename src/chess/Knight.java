// Bernard Wong - Board class
// A Knight class to create the Pieces Knight implementing PieceType

package chess;

public class Knight extends Pieces implements PieceType{

	// Constructors
	public Knight() {
	}
	
	public Knight(int x, int y) {
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
        
        // move L shape
        if(toX != fromX - 1 && toX != fromX + 1 && toX != fromX + 2 && toX != fromX - 2)
        	return false;
        if(toY != fromY - 2 && toY != fromY + 2 && toY != fromY - 1 && toY != fromY + 1)
        	return false;
        
		return true;
	} // isPathValid()

	// Override interface methods
	@Override
	public char pieceType(int player) {
		if(player == 1)
			return 'N';
		else
			return 'n';
	} // pieceType()

} // class
