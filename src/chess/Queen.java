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
	public boolean isPathValid() {
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
