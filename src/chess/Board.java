// Bernard Wong - Board class
// A Board class to creates the chess board

package chess;

public class Board {
	// Data members
	char[][] boardArray = new char[10][10];
	char xLabel = 49, yLabel = 49;

	// Constructors
	public Board() {
		createBoard();
		placePieces();
	}

	// Method create chess board
	private void createBoard(){
		
		// Populate array with dashes
		for(int i = 0; i < boardArray.length; i++) {
			for(int j = 0; j < boardArray.length; j++) {
				boardArray[i][j] = '-';
			} // inner for
		} // for
		
		// X labels (1 to 8 vertically)
		for(int i = 1; i <= 8; i++) {
			boardArray[i][0] = xLabel;
			boardArray[i][9] = xLabel;
			xLabel++;
		} // for
		
		// Y labels (a to h horizontally)
		for(int j = 1; j <= 8; j++) {
			boardArray[0][j] = yLabel;
			boardArray[9][j] = yLabel;
			yLabel++;
		} // for
		
	} // createBoard()
	
	// Method place pieces onto the board
	private void placePieces() {
		// Data members
		int player1Piece;
		int player2Piece;
		char pieces1 = '-', pieces2 = '-';
		
		// Pieces objects
		King kings = new King();
		Queen queens = new Queen();
		Bishop bishops = new Bishop();
		Knight knights = new Knight();
		Rook rooks = new Rook();
		Pawn pawns = new Pawn();
		
		// Iterate column
		for(int i = 1; i <= 8; i++) {
			// generate random pieces
			player1Piece = (int)(Math.random() * 5 + 1);
			player2Piece = (int)(Math.random() * 5 + 1);
			switch(player1Piece) {
				case 1:
					pieces1 = queens.pieceType(1);
					break;
				case 2:
					pieces1 = bishops.pieceType(1);
					break;
				case 3:
					pieces1 = knights.pieceType(1);
					break;
				case 4:
					pieces1 = rooks.pieceType(1);
					break;
				case 5:
					pieces1 = pawns.pieceType(1);
					break;
			} // switch
		
			switch(player2Piece) {
				case 1:
					pieces2 = queens.pieceType(2);
					break;
				case 2:
					pieces2 = bishops.pieceType(2);
					break;
				case 3:
					pieces2 = knights.pieceType(2);
					break;
				case 4:
					pieces2 = rooks.pieceType(2);
					break;
				case 5:
					pieces2 = pawns.pieceType(2);
					break;
			} // switch
		
			// Place pieces onto the board
			boardArray[8][i] = pieces1;
			boardArray[7][i] = pieces1;
			boardArray[1][i] = pieces2;
			boardArray[2][i] = pieces2;
			
			// 5th column must be Kings
			if(i == 5) {
				boardArray[8][i] = kings.pieceType(1);
				boardArray[1][i] = kings.pieceType(2);
			} // if
		} // for
		
	} // placePieces
	
	// method display chess board
	public void displayBoard() {
		for(int i = 0; i < boardArray.length; i++) {
			for(int j = 0; j < boardArray.length; j++) {
				System.out.print(boardArray[i][j]);
			} // inner for
			System.out.println();
		} // for
	} // displayBoard()
	
	// Method display legend
	public void displayLegend() {
		System.out.println("=============================================================================");
		System.out.println("-------------------------Welcome to the Very Bad Chess-----------------------");
		System.out.println("=============================================================================");
		System.out.println("Very Bad Chess is just like chess, but with totally random pieces and 1 King.");
		System.out.println("Legend:");
		System.out.println("- Uppercases are Player 1 pieces and Lowercases are Player 2 pieces.");
		System.out.println("- K/k is King.");
		System.out.println("- Q/q is Queen.");
		System.out.println("- B/b is Bishop.");
		System.out.println("- N/n is Knight.");
		System.out.println("- R/r is Rook.");
		System.out.println("- P/p is Pawn.");
		System.out.println("Good Luck & Have Fun.");
		System.out.println("=============================================================================");
	} // displayLegend()
	
	// method prompt player 1
	public void displayPlayer1() {
		System.out.println("=============================================================================");
		System.out.println("-Player 1 Turn-");
		System.out.println("Please enter the piece coordinates you want to select(1-8)");
	} // displayPlayer1
	
	// method prompt player 2
	public void displayPlayer2() {
		System.out.println("=============================================================================");
		System.out.println("-Player 2 Turn-");
		System.out.println("Please enter the piece coordinates you want to select(1-8)");
	} // displayPlayer2
	
	// method validate player 1 or 2
	public boolean validatePiece(int turn, char pieceType) {
		// Player 1
		if(turn == 0) {
			if(Character.isLowerCase(pieceType)) {
				System.out.println("You have chosen a Piece belongs to Player 2, please try again.");
				System.out.println("=============================================================================");
				return false;
			} // if pieceType belongs to player 2
		}
		else if(turn == 1){
			if(Character.isUpperCase(pieceType)) {
				System.out.println("You have chosen a Piece belongs to Player 1, please try again.");
				System.out.println("=============================================================================");
				return false;
			} // if pieceType belongs to player 1
		} // if player turn
		return true;
	} // validatePiece()

} // class
