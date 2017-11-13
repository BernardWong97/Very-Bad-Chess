package chess;

public class Pawn extends Pieces implements PieceType{

	public Pawn(int x, int y) {
		super(x, y);
	}

	@Override
	public boolean isPathValid() {
		return false;
	}

	@Override
	public char pieceType() {
		return 'P';
	}

}
