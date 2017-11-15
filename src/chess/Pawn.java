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
	public boolean isPathValid() {
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