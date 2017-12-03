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
	public boolean isPathValid(int fromX, int fromY, int toX, int toY) {
		if(toX > fromX + 1 || toX < fromX - 1 || toY > fromY + 1 || toY < fromY - 1) {
			return false;
		}
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
