import java.util.ArrayList;

public class Game {
	public GameBoard gameboard;
	public boolean isRunning;
	
	public Game() {
		gameboard = new GameBoard();
		isRunning = true;
	}
	
	public GameBoard getGameBoard() {
		return gameboard;
	}
	
	public ArrayList<Tile> pieceSelected(GamePiece p) {
		return gameboard.possibleMoves(p);
	}

	public boolean moveSelected(int x, int y) {
		return gameboard.moveSelected(x, y);
	}
}
