
public class Tile {
	private int x,y;			// x and y coordinates on the gameboard
	private boolean empty;		// TRUE = empty, FALSE = occupied
	private GamePiece onTop;	// GamePiece that occupies tile
	private boolean isEdge;		// TRUE = is on the edge, FALSE = not on the edge 
	private ChessGUI.Pieces type;
	private boolean colour; 		// TRUE = white, FALSE = black;
	
	// Creates tile with specified x and y, and whether or not the tile is on the edge of the board 
	public Tile(int x, int y, boolean isEdge, boolean colour) {
		this.x = x;
		this.y = y;
		this.empty = true;
		this.isEdge = isEdge;
		this.colour = colour;
	}
	
	public int getX() {
		return this.x;
	}
	
	public void setX(int x) {
		this.x = x;
	}
	
	public int getY() {
		return this.y;
	}
	
	public void setY(int y) {
		this.y = y;
	}
	
	public boolean getColour() {
		return this.colour;
	}
	
	// Returns occupation status of this tile
	public boolean isEmpty() {
		return this.empty;
	}
	
	// Sets this tile to be empty
	public void setEmpty() {
		this.onTop = null;
		this.empty = true;
	}
	
	// Returns gamepiece that occupies this tile
	public GamePiece getOnTop() {
		if (!empty) {
			return this.onTop;
		} 
		System.out.println("\n===============================");
		System.out.println("This tile is empty!");
		System.out.println("===============================");
		return null;
	}
	
	// Sets the specified piece on top of this tile
	public void setOnTop(GamePiece p) {
		if (empty) {
			this.onTop = p;
			this.empty = false;
			this.type = p.type;
		} else {
			System.out.println("\n===============================");
			System.out.println("This tile is already occupied!");
			System.out.println("===============================");
		}
	}
	
	// Returns whether or not this tile is an edge piece
	public boolean isEdgeTile() {
		return this.isEdge;
	}
	
	public ChessGUI.Pieces getType() {
		if (empty) {
			System.out.println("\n===============================");
			System.out.println("This tile is empty!");
			System.out.println("===============================");
			return null;
		} 
		return this.type;
	}
}
