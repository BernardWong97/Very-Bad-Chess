package chess;

public class Bishop extends Pieces implements PieceType{

	public Bishop(int x, int y) {
		super(x, y);
	}

	@Override
	public boolean isPathValid() {
		return false;
	}

	@Override
	public char pieceType() {
		return 'B';
	}

}
