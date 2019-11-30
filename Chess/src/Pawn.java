
public class Pawn extends GamePiece{
	private boolean hasMoved;
	private boolean direction; 	// TRUE = can only move up, FALSE = can only move down
	
	// Pawns have a direction as they can only move forwards
	public Pawn(int x, int y, boolean colour, boolean direction) {
		super(x, y, colour);
		type = ChessGUI.Pieces.Pawn;
		
		this.direction = direction;
		this.hasMoved = false;
	}
	
	public boolean hasMoved() {
		return this.hasMoved;
	}
	
	@Override
	public void move(int x, int y, Tile[][] tiles) {
		// TODO Auto-generated method stub
		this.hasMoved = true;
	}
}


