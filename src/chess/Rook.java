package chess;

public class Rook extends Pieces implements PieceType{

	public Rook(int x, int y) {
		super(x, y);
	}

	@Override
	public boolean isPathValid() {
		return false;
	}

	@Override
	public char pieceType() {
		return 'R';
	}

}
