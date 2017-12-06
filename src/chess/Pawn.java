// Bernard Wong - Board class
// A Pawn class to create the Pieces Pawn implementing PieceType

package chess;

public class Pawn extends Pieces implements PieceType{

	// Constructors
	public Pawn() {
	}
	
	public Pawn(int x, int y) {
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
        
		// if route is blocked
		if(isMoveBlocked(board, fromX, fromY, toX, toY) == true)
			return false;
        
        // if player 1 or 2
		if(getPlayerTurn() % 2 == 0) {
			// player can't capture own pieces
			if(Character.isUpperCase(board.boardArray[toX][toY])) {
				Game.error = "That piece is your own piece, please try again.";
				return false;
			} // if
			
			// capture diagonal pieces
			if(Character.isLowerCase(board.boardArray[toX][toY]) && toX == fromX - 1 && (toY == fromY - 1 || toY == fromY + 1))
				return true;
			
			// 1st step can move 2 step forward else 1 step
			if(fromX == 7) {
				if((toX == fromX - 2 || toX == fromX - 1) && toY == fromY)
					return true;
			}
			else {
				if(toX == fromX - 1 && toY == fromY)
					return true;
			} // if..else fromX == 7
		}
		else {
			// player can't capture own pieces
			if(Character.isLowerCase(board.boardArray[toX][toY])) {
				Game.error = "That piece is your own piece, please try again.";
				return false;
			} // if
			
			// capture diagonal pieces
			if(Character.isUpperCase(board.boardArray[toX][toY]) && toX == fromX + 1 && (toY == fromY - 1 || toY == fromY + 1))
				return true;
			
			// 1st step can move 2 step forward else 1 step
			if(fromX == 2)  {
				if((toX == fromX + 2 || toX == fromX + 1) && toY == fromY)
					return true;
			}
			else {
				if(toX == fromX + 1 && toY == fromY)
					return true;
			} // if..else fromX == 2
		} // if..else
		
		return false;
	} // isPathValid()

	// Override interface methods
	@Override
	public char pieceType(int player) {
		if(player == 1)
			return 'P';
		else
			return 'p';
	} // pieceType()
	
	// Check route clear
	public boolean isMoveBlocked(Board board, int fromX,int fromY,int toX, int toY) {
		int steps = Math.abs(toX - fromX);
		
		// if both X are same, use Y
		if(toX == fromX) {
			steps = Math.abs(toY - fromY);
		} // if
		
		// iterate through steps
		for(int i = 1; i <= steps; i++) {
			if(toX < fromX && toY == fromY) {
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
	
	// last row promotion
	public boolean promotion(Board board, int toX, int toY) {
		char promoteTo;
		
		// if player 1/2
		if(getPlayerTurn() % 2 == 0) {
			// prompt user input promote to what kind of piece
			System.out.println("Your Pawn (" + toX + "," + toY + ") can be promoted!");
			System.out.print("Please type the character you wish to promote to (Q/N/R/B): ");
			promoteTo = Game.console.next().charAt(0);
			
			switch(promoteTo) {
				case 'Q':
					board.boardArray[toX][toY] = new Queen().pieceType(1);
					return true;
				case 'N':
					board.boardArray[toX][toY] = new Knight().pieceType(1);
					return true;
				case 'R':
					board.boardArray[toX][toY] = new Rook().pieceType(1);
					return true;
				case 'B':
					board.boardArray[toX][toY] = new Bishop().pieceType(1);
					return true;
				default:
					Game.error = "Only Q/N/R/B is allowed, please try again.";
					System.out.println(Game.error);
			} // switch
		}
		else {
			// prompt user input promote to what kind of piece
			System.out.println("Your Pawn (" + toX + "," + toY + ") can be promoted!");
			System.out.print("Please type the character you wish to promote to (q/n/r/b): ");
			promoteTo = Game.console.next().charAt(0);
			
			switch(promoteTo) {
				case 'q':
					board.boardArray[toX][toY] = new Queen().pieceType(1);
					return true;
				case 'n':
					board.boardArray[toX][toY] = new Knight().pieceType(1);
					return true;
				case 'r':
					board.boardArray[toX][toY] = new Rook().pieceType(1);
					return true;
				case 'b':
					board.boardArray[toX][toY] = new Bishop().pieceType(1);
					return true;
				default:
					Game.error = "Only Q/N/R/B is allowed, please try again.";
					System.out.println(Game.error);
			} // switch
		} // if..else
		
		return false;
	} // promotion()

} // class