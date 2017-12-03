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
	public boolean isPathValid(int fromX, int fromY, int toX, int toY) {
        if(toX == fromX) {
        	return true;
        }
        if(toY == fromY) {
        	return true;
        }
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