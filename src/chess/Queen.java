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
		
        // can move horizontally
		if(toX == fromX)
			return true;
		// can move vertically
		if(toY == fromY)
			return true;
		// can move diagonally
		if(Math.abs(toX - fromX) == Math.abs(toY - fromY))
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
	
	// Check route clear
	public boolean isMoveBlocked(Board board, int fromX,int fromY,int toX,int toY) {
		int steps = Math.abs(toX - fromX);
		
		// if both X are same, use Y
		if(toX == fromX) {
			steps = Math.abs(toY - fromY);
		} // if
		
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
			else if(toX > fromX && toY > fromY){
				if(board.boardArray[fromX + i][fromY - i] != '-') {
					Game.error = "Path is blocked, please try again.";
					return true;
				} // inner if
			} // if SouthWest
			else if(toX == fromX && toY < fromY) {
				if(board.boardArray[fromX][fromY - i] != '-') {
					Game.error = "Path is blocked, please try again.";
					return true;
				} // inner if
			} // if West
			else if(toX == fromX && toY > fromY) {
				if(board.boardArray[fromX][fromY + i] != '-') {
					Game.error = "Path is blocked, please try again.";
					return true;
				} // inner if
			} // if East
			else if(toX < fromX && toY == fromY) {
				if(board.boardArray[fromX - i][fromY] != '-') {
					Game.error = "Path is blocked, please try again.";
					return true;
				} // inner if
			} // if North
			else if(toX > fromX && toY == fromY) {
				if(board.boardArray[fromX + i][fromY] != '-') {
					Game.error = "Path is blocked, please try again.";
					return true;
				} // inner if
			} // if South
		} // for
			  
		return false;
	} // isMoveBlocked()

} // class
