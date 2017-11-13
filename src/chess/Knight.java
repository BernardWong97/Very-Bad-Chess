package chess;

public class Knight extends Pieces implements PieceType{

	public Knight(int x, int y) {
		super(x, y);
	}

	@Override
	public boolean isPathValid() {
		return false;
	}

	@Override
	public char pieceType() {
		return 'N';
	}

}
