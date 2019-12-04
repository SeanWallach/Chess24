import java.awt.Color;
import java.util.ArrayList;

public class GameBoard {
	public Tile[][] tiles;
	public GamePiece[][] boardpieces;
	public Tile[][] possibleMoves;	// FIX 
	
	// Creates a new board with empty tiles
	public GameBoard() {
		tiles = new Tile[8][8];
		boardpieces = new GamePiece[8][8];
		possibleMoves = new Tile[8][8];

		for (int i = 0; i < 8; i++) {	// Checkered pattern algorithm
			for (int j = 0; j < 8; j++) {	// Checkered pattern algorithm
				if ((i + j) % 2 == 0) {
					tiles[i][j] = new Tile(i, j, false, true);		// White
				} else {
					tiles[i][j] = new Tile(i, j, false, false);		// Black
				}
			}
		}

		setUp();
	}

	// Set up board with black on top and white on bottom
	public void setUp() {
		for (int i = 0; i < 8; i++) { // Cycle through columns
			for (int j = 0; j < 8; j++) { // Cycle through rows
				// Rook placements
				if (i == 0 || i == 7) {
					if (j == 0) {
						Rook r = new Rook(i, j, false);			// Black
						tiles[i][j].setOnTop(r);				// Place on top of tile at i, j
						boardpieces[i][j] = r;					// Add gamepiece to array of gamepiece
					} else if (j == 7) {
						Rook r = new Rook(i, j, true);			// White
						tiles[i][j].setOnTop(r);
						boardpieces[i][j] = r;
					}
				}

				// Knight placements
				if (i == 1 || i == 6) {
					if (j == 0) {
						Knight k = new Knight(i, j, false); 	// Black
						tiles[i][j].setOnTop(k);				// Place on top of tile at i, j
						boardpieces[i][j] = k;					// Add gamepiece to array of gamepiece
					} else if (j == 7) {
						Knight k = new Knight(i, j, true);		// White
						tiles[i][j].setOnTop(k);
						boardpieces[i][j] = k;
					}
				}

				// Bishop placements
				if (i == 2 || i == 5) {
					if (j == 0) {
						Bishop b = new Bishop(i, j, false);		// Black
						tiles[i][j].setOnTop(b);				// Place on top of tile at i, j
						boardpieces[i][j] = b;					// Add gamepiece to array of gamepiece
					} else if (j == 7) {
						Bishop b = new Bishop(i, j, true);		// White
						tiles[i][j].setOnTop(b);
						boardpieces[i][j] = b;
					}
				}

				// Queen placements
				if (i == 3 && j == 0) {
					Queen q = new Queen(i, j, false);			// Black
					tiles[i][j].setOnTop(q);					// Place on top of tile at i, j
					boardpieces[i][j] = q;						// Add gamepiece to array of gamepiece
				} else if (i == 3 && j == 7) {
					Queen q = new Queen(i, j, true);			// White
					tiles[i][j].setOnTop(q);
					boardpieces[i][j] = q;
				}

				// King placements
				if (i == 4 && j == 0) {
					King k = new King(i, j, false);				// Black
					tiles[i][j].setOnTop(k);					// Place on top of tile at i, j
					boardpieces[i][j] = k;						// Add gamepiece to array of gamepiece
				} else if (i == 4 && j == 7) {
					King k = new King(i, j, true);				// White
					tiles[i][j].setOnTop(k);
					boardpieces[i][j] = k;
				}

				// Pawn placements
				if (j == 1) {
					Pawn p = new Pawn(i, j, false, false);		// Black
					tiles[i][j].setOnTop(p);					// Place on top of tile at i, j
					boardpieces[i][j] = p;;						// Add gamepiece to array of gamepiece
				} else if (j == 6) {
					Pawn p = new Pawn(i, j, true, true);		// White
					tiles[i][j].setOnTop(p);
					boardpieces[i][j] = p;
				}
			}
		}

		//// TEST SECTION ////
		Pawn p = new Pawn(0, 4, false, false);
		tiles[0][4].setOnTop(p);
		boardpieces[0][4] = p;
		
		Queen q = new Queen(3, 3, true);
		tiles[3][3].setOnTop(q);
		boardpieces[3][3] = q;
		
	}

	// Moves a piece to an available tile
	public void movePiece(GamePiece p, int x, int y) {
		// If tile at x and y are occupied, we remove the piece
		if (!tiles[x][y].isEmpty()) {
			// must change to 2d array 
			//	boardpieces.remove(tiles[x][y].getOnTop()); // removes piece that is being placed from the list of
														// boardpieces
		}
		tiles[x][y].setOnTop(p);
	}

	// Returns the tile specified at i and j
	public Tile getTile(int i, int j) {
		return this.tiles[i][j];
	}

	// UNUSED
	// Returns this gameboard's tiles
	public Tile[][] getTiles() {
		return this.tiles;
	}
	
	// Checks if the move you a player made was a legal one, if yes, returns true
	// If move was illegal, returns false
	public boolean moveSelected(int x, int y) {
		// Iterate through each possible move
		System.out.println("\nGAMEBOARD: possible moves: " + possibleMoves);
		for (int i = 0; i < 8; i++) { // Cycle through columns
			for (int j = 0; j < 8; j++) { // Cycle through rows				
				// if the x and y match that of possibleMove, we return true, meaning that it was a legal move
				if (x == possibleMoves[i][j].getX() && y == possibleMoves[i][j].getX()) {
					//boardpieces[][] move();
					// DEBUGGING
					System.out.println("x: " + x + " " + possibleMoves[i][j].getX() + " y: " + y + " " + possibleMoves[i][j].getY() ); 
					System.out.println("GAMEBOARD: Nice move");
					return true;
				}
			}
		}
		System.out.println("GAMEBOARD: Invalid move");
		return false;
	}
	
	// Movement rules for each piece, returns list of possible tiles GamePiece P can move to
	public Tile[][] possibleMoves(GamePiece p) {
		// Possible moves for Pawn 
		possibleMoves = new Tile[8][8];
		if (p.getType() == ChessGUI.Pieces.Pawn) {

			// Black piece
			if (!p.getColour()) {
				// If Pawn hasn't moved, can double move
				if (!((Pawn) p).hasMoved()) {
					if (tiles[p.getX()][p.getY() + 2].isEmpty()) {
						possibleMoves[p.getX()][p.getY() + 2] = (tiles[p.getX()][p.getY() + 2]);
					}
				}
				// Also check square in front of pawn
				if (tiles[p.getX()][p.getY() + 1].isEmpty()) {					
					possibleMoves[p.getX()][p.getY() + 1] = (tiles[p.getX()][p.getY() + 1]);
				}

			// White piece
			} else {
				// If Pawn hasn't moved, can double move
				if (!((Pawn) p).hasMoved()) {
					if (tiles[p.getX()][p.getY() - 2].isEmpty()) {
						possibleMoves[p.getX()][p.getY() - 2] = (tiles[p.getX()][p.getY() - 2]);
					}
				}
				// Also check square in front of pawn
				if (tiles[p.getX()][p.getY() - 1].isEmpty()) {
					possibleMoves[p.getX()][p.getY() - 1] = (tiles[p.getX()][p.getY() - 1]);
				}
			}

		//  Possible moves for Rook 
		} else if (p.getType() == ChessGUI.Pieces.Rook) {
			
			// Black piece
			if (p.getColour()) {
				
				// ITERATE THROUGH COLUMNS/ROWS
				//for (int i = 0; i < tiles[p.getX()][p.getY()].get)
				
				if (tiles[p.getX()][p.getY()].isEmpty()) {
					possibleMoves[p.getX()][p.getY()] =(tiles[p.getX()][p.getY() - 1]);
				}

			// White piece
			} else {
				if (tiles[p.getX()][p.getY() + 1].isEmpty()) {
					possibleMoves[p.getX()][p.getY()] = (tiles[p.getX()][p.getY() + 1]);
				}
			}

		} else if (p.getType() == ChessGUI.Pieces.Knight) {

		} else if (p.getType() == ChessGUI.Pieces.Bishop) {

		} else if (p.getType() == ChessGUI.Pieces.Queen) {

		} else if (p.getType() == ChessGUI.Pieces.King) {

		} else {

		}
		
		return possibleMoves;
	}
}
