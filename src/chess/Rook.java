// Bernard Wong - Board class
// A Rook class to create the Pieces Rook implementing PieceType

package chess;

public class Rook extends Pieces implements PieceType{

	// Constructors
	public Rook() {
	}
	
	public Rook(int x, int y) {
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
		
        // can move horizontally
        if(toX == fromX)
        	return true;
        // can move vertically
        if(toY == fromY)
        	return true;
        
        return false;
	} // isPathValid()

	// Override interface methods
	@Override
	public char pieceType(int player) {
		if(player == 1)
			return 'R';
		else
			return 'r';
	} // pieceType()

} // class