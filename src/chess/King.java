package chess;

public class King extends Pieces implements PieceType{

	public King(int x, int y) {
		super(x, y);
	}

	@Override
	public boolean isPathValid() {
		return false;
	}

	@Override
	public char pieceType() {
		return 'K';
	}

}
