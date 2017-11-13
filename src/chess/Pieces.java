package chess;

public abstract class Pieces {
	int x, y;

	public Pieces(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public abstract boolean isPathValid();
}
