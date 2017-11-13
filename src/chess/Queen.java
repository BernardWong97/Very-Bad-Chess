package chess;

public class Queen extends Pieces implements PieceType{

	public Queen(int x, int y) {
		super(x, y);
	}

	@Override
	public boolean isPathValid() {
		return false;
	}

	@Override
	public char pieceType() {
		return 'Q';
	}

}
