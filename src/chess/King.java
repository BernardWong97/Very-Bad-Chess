// Bernard Wong - Board class
// A King class to create the Pieces King implementing PieceType

package chess;

public class King extends Pieces implements PieceType{

	// Constructors
	public King() {
	}
	
	public King(int x, int y) {
		super(x, y);
	}

	// Override abstract methods
	@Override
	public boolean isPathValid(Board board, int fromX, int fromY, int toX, int toY) {
		// current piece position false
        if(toX == fromX && toY == fromY)
            return false;
        
		// player can't capture own pieces
		if(getPlayerTurn() % 2 == 0) {
			if(Character.isUpperCase(board.boardArray[toX][toY]))
				return false;
		}
		else{
			if(Character.isLowerCase(board.boardArray[toX][toY]))
				return false;
		} // if player 1 / player 2
		
        // only can move 1 step each directions
		if(toX > fromX + 1 || toX < fromX - 1 || toY > fromY + 1 || toY < fromY - 1)
			return false;

		return true;
	} // isPathValid()

	// Override interface methods
	@Override
	public char pieceType(int player) {
		if(player == 1)
			return 'K';
		else
			return 'k';
	} // pieceType()


} // class
