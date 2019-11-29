
public abstract class GamePiece {
	protected int x, y;
	protected boolean colour; 	// FALSE = black, TRUE = white
	protected ChessGUI.Pieces type;
	
	// GamePiece constructor creates a piece with x and y coordinates and colour
	public GamePiece(int x, int y, boolean colour) {
		this.x = x;
		this.y = y;
		this.colour = colour;
	}
	
	// Returns this pieces X coordinate on the board
	public int getX() {
		return this.x;
	}
	
	// Returns this pieces Y coordinate on the board
	public int getY() {
		return this.y;
	}
	
	// Returns this pieces colour. FALSE = black, TRUE = white
	public boolean getColour() {
		return this.colour;
	}
	
	// Returns type of the piece from a list of enum pieces in ChessGUI
	public ChessGUI.Pieces getType() {
		return type;
	}
	
	// Abstract movement rules for this piece
	public abstract void move(int x, int y, Tile[][] tiles);
}
