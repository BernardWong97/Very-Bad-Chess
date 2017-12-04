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
	public boolean isPathValid(int fromX, int fromY, int toX, int toY) {
		// current piece position false
        if(toX == fromX && toY == fromY)
            return false;
        // can move horizontally
		if(toX == fromX)
			return true;
		// can move vertically
		if(toY == fromY)
			return true;
		// can move diagonally
		if(toX - fromX == toY - fromY)
			return true;
		
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
