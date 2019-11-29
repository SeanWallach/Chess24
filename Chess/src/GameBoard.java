import java.util.ArrayList;

public class GameBoard {
	public Tile[][] tiles;
	public ArrayList<GamePiece> boardpieces;
	
	// Creates a new board with empty tiles
	public GameBoard() {
		tiles = new Tile[8][8];
		boardpieces = new ArrayList<GamePiece>();
		
		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				tiles[i][j] = new Tile(i, j, false);
			}
		}
	}
	
	// Set up board 
	public void setUp() {
		for (int i = 0; i < 8; i++) {	// Cycle through columns
			for (int j = 0; j < 8; j++) {	// Cycle through rows
				// Rook placements
				if (i == 0 || i == 7) {		
					if (j == 0) {
						Rook r = new Rook(i, j, false);
						tiles[i][j].setOnTop(r);
						boardpieces.add(r);
					} else if (j == 7) {
						Rook r = new Rook(i, j, true);
						tiles[i][j].setOnTop(r);
						boardpieces.add(r);
					}
				}
				
				// Knight placements
				if (i == 1 || i == 6) {
					if (j == 0) {
						Knight k = new Knight(i, j, false);
						tiles[i][j].setOnTop(k);
						boardpieces.add(k);
					} else if (j == 7) {
						Knight k = new Knight(i, j, true);
						tiles[i][j].setOnTop(k);
						boardpieces.add(k);
					}
				}
				
				// Bishop placements
				if (i == 2 || i == 5) {
					if (j == 0) {
						Bishop b = new Bishop(i, j, false);
						tiles[i][j].setOnTop(b);
						boardpieces.add(b);
					} else if (j == 7) {
						Bishop b = new Bishop(i, j, true);
						tiles[i][j].setOnTop(b);
						boardpieces.add(b);
					}
				}
				
				// Queen placements
				if (i == 3 && j == 0) {
					Queen q = new Queen(i, j, false);
					tiles[i][j].setOnTop(q);
					boardpieces.add(q);
				} else if (i == 3 && j == 7) {
					Queen q = new Queen(i, j, true);
					tiles[i][j].setOnTop(q);
					boardpieces.add(q);
				}
				
				// King placements
				if (i == 4 && j == 0) {
					King k = new King(i, j, false);
					tiles[i][j].setOnTop(k);
					boardpieces.add(k);
				} else if (i == 4 && j == 7) {
					King k = new King(i, j, true);
					tiles[i][j].setOnTop(k);
					boardpieces.add(k);
				}
				
				// Pawn placements
				if (j == 1) {
					Pawn p = new Pawn(i, j, false);
					tiles[i][j].setOnTop(p);
					boardpieces.add(p);
				} else if (j == 6) {
					Pawn p = new Pawn(i, j, true);
					tiles[i][j].setOnTop(p);
					boardpieces.add(p);
				}
			}
		} 
	}
	
	// Moves a piece to an available tile
	public void movePiece(GamePiece p, int x, int y) {
		// If tile at x and y are occupied, we remove the piece
		if (!tiles[x][y].isEmpty()) {	
			boardpieces.remove(tiles[x][y].getOnTop());	// removes piece that is being placed from the list of boardpieces
		} 
		tiles[x][y].setOnTop(p);
		
	}
	
	public Tile getTile(int i, int j) {
		return tiles[i][j];
	}
	public ArrayList<GamePiece> possibleMoves() {
		return null;
	}
}
