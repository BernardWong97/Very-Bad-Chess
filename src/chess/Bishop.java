// Bernard Wong - Board class
// A Bishop class to create the Pieces Bishop implementing PieceType

package chess;

public class Bishop extends Pieces implements PieceType{

	// Constructors
	public Bishop() {
	}
	
	public Bishop(int x, int y) {
		super(x, y);
	}

	// Override abstract methods
	@Override
	public boolean isPathValid(Board board, int fromX, int fromY, int toX, int toY) {
		// current piece position false
        if(toX == fromX && toY == fromY) {
        	Game.error = "This is the position of the current selected piece, please try again.";
            return false;
        } // if
        
		// player can't capture own pieces
		if(getPlayerTurn() % 2 == 0) {
			if(Character.isUpperCase(board.boardArray[toX][toY])) {
				Game.error = "That piece is your own piece, please try again.";
				return false;
			} // inner if
		}
		else{
			if(Character.isLowerCase(board.boardArray[toX][toY])) {
				Game.error = "That piece is your own piece, please try again.";
				return false;
			} // inner if
		} // if player 1 / player 2
		
		// if route is blocked
		if(isMoveBlocked(board, fromX, fromY, toX, toY) == true)
			return false;
        
        // can move diagonally
        if(Math.abs(toX - fromX) == Math.abs(toY - fromY))
        	return true;
        
		return false;
	} // isPathValid()

	// Override interface methods
	@Override
	public char pieceType(int player) {
		if(player == 1)
			return 'B';
		else
			return 'b';
	} // pieceType()
	
	// Check route clear
	public boolean isMoveBlocked(Board board, int fromX,int fromY,int toX,int toY) {
		int steps = Math.abs(toX - fromX);
		
		// iterate through steps
		for(int i = 1; i < steps; i++) {
			if(toX < fromX && toY > fromY) {
				if(board.boardArray[fromX - i][fromY + i] != '-') {
					Game.error = "Path is blocked, please try again.";
					return true;
				} // inner if
			} // if NorthEast
			else if(toX < fromX && toY < fromY) {
				if(board.boardArray[fromX - i][fromY - i] != '-') {
					Game.error = "Path is blocked, please try again.";
					return true;
				} // inner if
			} // if NorthWest
			else if(toX > fromX && toY < fromY) {
				if(board.boardArray[fromX + i][fromY + i] != '-') {
					Game.error = "Path is blocked, please try again.";
					return true;
				} // inner if
			} // if SouthEast
			else {
				if(board.boardArray[fromX + i][fromY - i] != '-') {
					Game.error = "Path is blocked, please try again.";
					return true;
				} // inner if
			} // if..else SouthWest
		} // for
			  
		return false;
	} // isMoveBlocked()

} // class
