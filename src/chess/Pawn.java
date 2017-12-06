// Bernard Wong - Board class
// A Pawn class to create the Pieces Pawn implementing PieceType

package chess;

public class Pawn extends Pieces implements PieceType{

	// Constructors
	public Pawn() {
	}
	
	public Pawn(int x, int y) {
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
        
        // if player 1 or 2
		if(getPlayerTurn() % 2 == 0) {
			// player can't capture own pieces
			if(Character.isUpperCase(board.boardArray[toX][toY])) {
				Game.error = "That piece is your own piece, please try again.";
				return false;
			} // if
			
			// 1st step can move 2 step forward else 1 step
			if(fromX == 7) {
				if((toX == fromX - 2 || toX == fromX - 1) && toY == fromY)
					return true;
			}
			else {
				if(toX == fromX - 1 && toY == fromY)
					return true;
			} // if..else fromX == 7
		}
		else {
			// player can't capture own pieces
			if(Character.isLowerCase(board.boardArray[toX][toY])) {
				Game.error = "That piece is your own piece, please try again.";
				return false;
			} // if
			
			// 1st step can move 2 step forward else 1 step
			if(fromX == 2)  {
				if((toX == fromX + 2 || toX == fromX + 1) && toY == fromY)
					return true;
			}
			else {
				if(toX == fromX + 1 && toY == fromY)
					return true;
			} // if..else fromX == 2
		} // if..else
		
		return false;
	} // isPathValid()

	// Override interface methods
	@Override
	public char pieceType(int player) {
		if(player == 1)
			return 'P';
		else
			return 'p';
	} // pieceType()

} // class