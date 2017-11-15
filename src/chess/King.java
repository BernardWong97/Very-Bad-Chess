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
	public boolean isPathValid() {
		return false;
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
