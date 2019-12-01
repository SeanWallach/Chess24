
public class Rook extends GamePiece{
	private boolean hasMoved;
	
	public Rook(int x, int y, boolean colour) {
		super(x, y, colour);
		this.hasMoved = false;
		type = ChessGUI.Pieces.Rook;
	}
	
	public boolean hasMoved() {
		return this.hasMoved;
	}

	@Override
	public void move(int x, int y, Tile[][] tiles) {
		
	}
}
