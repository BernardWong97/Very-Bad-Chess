// Bernard Wong - Board class
// A Bishop class to create the Pieces Bishop implementing PieceType

package chess;

public class Bishop extends Pieces implements PieceType{

	// Constructors
	public Bishop() {
	}
	
	public Bishop(int x, int y) {
		super(x, y);
	}

	// Override abstract methods
	@Override
	public boolean isPathValid(int fromX, int fromY, int toX, int toY) {
        if(toX - fromX == toY - fromY) {
        	return true;
        } 
		return false;
	} // isPathValid()

	// Override interface methods
	@Override
	public char pieceType(int player) {
		if(player == 1)
			return 'B';
		else
			return 'b';
	} // pieceType()

} // class
