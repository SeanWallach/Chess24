
public class Pawn extends GamePiece{
	private boolean hasMoved;
	private boolean direction; 	// TRUE = can only move up, FALSE = can only move down
	
	// Pawns have a direction as they can only move forwards
	public Pawn(int x, int y, boolean colour, boolean direction) {
		super(x, y, colour);		
		this.hasMoved = false;
		this.direction = direction;		
		type = ChessGUI.Pieces.Pawn;
	}
	
	public boolean hasMoved() {
		return this.hasMoved;
	}
	
	@Override
	public void move(int x, int y, Tile[][] tiles) {
		this.hasMoved = true;
		this.x = x; 
		this.y = y;
	}
}


