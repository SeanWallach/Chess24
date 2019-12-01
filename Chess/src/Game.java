
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
	
	public void pieceSelected(GamePiece p) {
		gameboard.possibleMoves(p);
	}
}
