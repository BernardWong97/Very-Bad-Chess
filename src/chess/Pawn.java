// Bernard Wong - Board class
// A Pawn class to create the Pieces Pawn implementing PieceType

package chess;

public class Pawn extends Pieces implements PieceType{
	int playerTurn = Game.playerTurn;

	// Constructors
	public Pawn() {
	}
	
	public Pawn(int x, int y) {
		super(x, y);
	}

	// Override abstract methods
	@Override
	public boolean isPathValid(int fromX, int fromY, int toX, int toY) {
		// current piece position false
        if(toX == fromX && toY == fromY)
            return false;
        
        // if player 1 or 2
		if(playerTurn % 2 == 0) {
			// can move 1 step forward
			if(toY == fromY + 1)
				return true;
			
			// 1st step can move 2 step forward
			if(fromY == 7)
				if(toY == fromY + 2 && toY == fromY + 1)
					return true;
		}
		else {
			// can move 1 step forward
			if(toY == fromY - 1)
				return true;
			
			// 1st step can move 2 step forward
			if(fromY == 2) 
				if(toY == fromY - 2 && toY == fromY - 1)
					return true;
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