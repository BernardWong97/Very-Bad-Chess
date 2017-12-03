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
	public boolean isPathValid(int fromX, int fromY, int toX, int toY) {
        if(toX != fromX - 1 && toX != fromX + 1 && toX != fromX + 2 && toX != fromX - 2) {
        	return false;
        }
        if(toY != fromY - 2 && toY != fromY + 2 && toY != fromY - 1 && toY != fromY + 1) {
        	return false;
        }   
		return false;
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
