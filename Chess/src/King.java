
public class King extends GamePiece{
	private boolean hasMoved;		// FALSE: hasn't moved, TRUE: has moved 
	private boolean inCheck; 		// FALSE: not in check, TRUE: in check 
	private boolean inCheckmate;	// FALSE: not in checkmate, TRUE: in checkmate
	
	public King(int x, int y, boolean colour) {
		super(x, y, colour);
		this.hasMoved = false;
		this.inCheck = false;
		this.inCheckmate = false;
		type = ChessGUI.Pieces.King;
	}
	
	// Returns if this piece has moved or not (for castling)
	public boolean hasMoved() {
		return this.hasMoved;
	}
	
	// Returns 
	public boolean inCheck() {
		return inCheck;
		
	}
	
	public boolean putInCheck() {
		return inCheck;
		
	}
	
	public boolean inCheckmate() {
		return inCheckmate;
		
	}
	
	public boolean putInCheckmate() {
		return inCheck;
		
	}
	@Override
	public void move(int x, int y, Tile[][] tiles) {
		this.hasMoved = true;
		this.x = x;
		this.y = y;
	}
}
