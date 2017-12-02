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
	
	// Method 
	private void placePieces() {
		// create and place King objects
		King kings = new King();
		boardArray[8][5] = kings.pieceType(1);
		boardArray[1][5] = kings.pieceType(2);
		
		// create and place Queen objects
		Queen queens = new Queen();
		boardArray[8][4] = queens.pieceType(1);
		boardArray[1][4] = queens.pieceType(2);
		
		// create and place Bishop objects
		Bishop bishops = new Bishop();
		boardArray[8][3] = bishops.pieceType(1);
		boardArray[8][6] = bishops.pieceType(1);
		boardArray[1][3] = bishops.pieceType(2);
		boardArray[1][6] = bishops.pieceType(2);
		
		// create and place Bishop objects
		Knight knights = new Knight();
		boardArray[8][2] = knights.pieceType(1);
		boardArray[8][7] = knights.pieceType(1);
		boardArray[1][2] = knights.pieceType(2);
		boardArray[1][7] = knights.pieceType(2);
		
		// create and place Bishop objects
		Rook rooks = new Rook();
		boardArray[8][1] = rooks.pieceType(1);
		boardArray[8][8] = rooks.pieceType(1);
		boardArray[1][1] = rooks.pieceType(2);
		boardArray[1][8] = rooks.pieceType(2);
		
		// create and place Pawn objects
		Pawn pawns = new Pawn();
		for(int i = 1; i < 9; i++) {
			boardArray[7][i] = pawns.pieceType(1);
			boardArray[2][i] = pawns.pieceType(2);
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
	
	// method prompt player 1
	public void displayPlayer1() {
		System.out.println("=====================================================");
		System.out.println("-Player 1 Turn-");
		System.out.println("Please enter the piece coordinates you want to select(1-8)");
	} // displayPlayer1
	
	// method prompt player 2
	public void displayPlayer2() {
		System.out.println("=====================================================");
		System.out.println("-Player 2 Turn-");
		System.out.println("Please enter the piece coordinates you want to select(1-8)");
	} // displayPlayer2
	
	// method validate player 1 or 2
	public boolean validatePiece(int turn, char pieceType) {
		// Player 1
		if(turn == 0) {
			if(Character.isLowerCase(pieceType)) {
				System.out.println("You have chosen a Piece belongs to Player 2, please try again.");
				System.out.println("=====================================================");
				return false;
			} // if pieceType belongs to player 2
		}
		else if(turn == 1){
			if(Character.isUpperCase(pieceType)) {
				System.out.println("You have chosen a Piece belongs to Player 1, please try again.");
				System.out.println("=====================================================");
				return false;
			} // if pieceType belongs to player 1
		} // if player turn
		return true;
	} // validatePiece()

} // class
