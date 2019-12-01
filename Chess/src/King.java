
public class King extends GamePiece{
	private boolean hasMoved;
	
	public King(int x, int y, boolean colour) {
		super(x, y, colour);
		this.hasMoved = false;
		type = ChessGUI.Pieces.King;
	}
	
	public boolean hasMoved() {
		return this.hasMoved;
	}
	
	@Override
	public void move(int x, int y, Tile[][] tiles) {
		this.hasMoved = true;
		
	}
}
