import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.*;

public class ChessGUI extends JFrame implements MouseListener {
	public Game game; 						// Controller
	private JMenuItem newGame, undo, redo; 	// Menuitems used for the frame's menus
	private JMenu gameMenu; 				// Main menu for the frame
	private JPanel[][] tiles, HOR_index, VER_index; // 8 x 8 tile array representing a chess board
	private JPanel currentPanel;			// Panel selected by the player 
	private JPanel table;					// The main panel for the entire frame
	
	private GamePiece selectedPiece;		// The player on the piece that the player selected
	private ArrayList<Integer> newX, newY;	// The possible moves of 
	private ArrayList<Tile> possibleMoves;

	private boolean running;

	public enum Pieces {
		Pawn, Rook, Knight, Bishop, King, Queen;
	}

	public ChessGUI() {
		super("Chess");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(600, 600);
		setLocation(400, 200);
		setResizable(false);

		currentPanel = null;
		running = false;
		possibleMoves = new ArrayList<Tile>();
		newX = new ArrayList<>();
		newY = new ArrayList<>();

		// Menubar
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		gameMenu = new JMenu("Game");
		menuBar.add(gameMenu);

		newGame = new JMenuItem("New Game");
		newGame.addActionListener(e -> {
			game = new Game();
			running = true;
			updateBoard();
			setVisible(true);
		});
		gameMenu.add(newGame);

		// Frame Icon
		ImageIcon img = new ImageIcon("src/images/icon.png");
		setIconImage(img.getImage());
		
		// Draw Table 
		table = new JPanel(new BorderLayout());
		
		// Draw indexs along the board
		int j = 0;
		int i = 0;
		JPanel leftPanel = new JPanel(new BorderLayout());
		JPanel bottomPanel = new JPanel(new BorderLayout());
		HOR_index = new JPanel[1][8];	
		VER_index = new JPanel[8][1];
		for (i = 0; i < 8; i++) {
			VER_index[i][0] = new JPanel();
			JLabel jlabely = new JLabel("" + i);
			VER_index[i][0].add(jlabely);
			VER_index[i][0].setBackground(Color.WHITE);
			leftPanel.add(VER_index[i][0]);
			
			HOR_index[0][j] = new JPanel();
			JLabel jlabelx = new JLabel("" + j);
			HOR_index[0][j].add(jlabelx);
			HOR_index[0][j].setBackground(Color.WHITE);
			bottomPanel.add(HOR_index[0][j]);
			
			j++;
		}

		
		// Draw chess board
		JPanel panel = new JPanel(new GridLayout(8, 8));
		tiles = new JPanel[8][8];

		for (j = 0; j < 8; j++) { // Checkered pattern algorithm
			for (i = 0; i < 8; i++) {
				tiles[i][j] = new JPanel();
				tiles[i][j].addMouseListener(this);
				if ((i + j) % 2 == 0) {
					tiles[i][j].setBackground(Color.WHITE);
				} else {
					tiles[i][j].setBackground(Color.DARK_GRAY);
				}
				panel.add(tiles[i][j]);
			}
		}
		
		// Add all panels to the main panel, the "table" 
		table.add(panel, BorderLayout.CENTER);		// Gameboard in the center
		table.add(leftPanel, BorderLayout.WEST);	// Vertical numbers along the left of the board
		table.add(bottomPanel, BorderLayout.SOUTH); // Horizontal numbers beneath the board
		add(table,BorderLayout.CENTER);				// Add the table to this frame
		
		setVisible(true);
	}

	public void updateBoard() {
		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				if (!game.getGameBoard().getTile(i, j).isEmpty()) {
					selectedPiece = game.getGameBoard().getTile(i, j).getOnTop(); // Get piece from the current tiles
					Pieces p = selectedPiece.getType(); // Get that pieces type
					BufferedImage piecePic; // Picture retrieved from filesystem

					if (p == Pieces.Pawn) { // Pawn
						if (selectedPiece.getColour() == true) { // White piece
							try {
								piecePic = ImageIO.read(new File("src/images/WPawn.png"));
								JLabel picLabel = new JLabel(new ImageIcon(piecePic));
								tiles[i][j].add(picLabel);
							} catch (IOException e) {
								e.printStackTrace();
							}
						} else { // Black piece
							try {
								piecePic = ImageIO.read(new File("src/images/BPawn.png"));
								JLabel picLabel = new JLabel(new ImageIcon(piecePic));
								tiles[i][j].add(picLabel);
							} catch (IOException e) {
								e.printStackTrace();
							}
						}
					} else if (p == Pieces.Rook) { // Rook
						if (selectedPiece.getColour() == true) { // White piece
							try {
								piecePic = ImageIO.read(new File("src/images/WRook.png"));
								JLabel picLabel = new JLabel(new ImageIcon(piecePic));
								tiles[i][j].add(picLabel);
							} catch (IOException e) {
								e.printStackTrace();
							}
						} else { // Black piece
							try {
								piecePic = ImageIO.read(new File("src/images/BRook.png"));
								JLabel picLabel = new JLabel(new ImageIcon(piecePic));
								tiles[i][j].add(picLabel);
							} catch (IOException e) {
								e.printStackTrace();
							}
						}
					} else if (p == Pieces.Knight) { // Knight
						if (selectedPiece.getColour() == true) { // White piece
							try {
								piecePic = ImageIO.read(new File("src/images/WKnight.png"));
								JLabel picLabel = new JLabel(new ImageIcon(piecePic));
								tiles[i][j].add(picLabel);
							} catch (IOException e) {
								e.printStackTrace();
							}
						} else { // Black piece
							try {
								piecePic = ImageIO.read(new File("src/images/BKnight.png"));
								JLabel picLabel = new JLabel(new ImageIcon(piecePic));
								tiles[i][j].add(picLabel);
							} catch (IOException e) {
								e.printStackTrace();
							}
						}
					} else if (p == Pieces.Bishop) { // Bishop
						if (selectedPiece.getColour() == true) { // White piece
							try {
								piecePic = ImageIO.read(new File("src/images/WBishop.png"));
								JLabel picLabel = new JLabel(new ImageIcon(piecePic));
								tiles[i][j].add(picLabel);
							} catch (IOException e) {
								e.printStackTrace();
							}
						} else { // Black piece
							try {
								piecePic = ImageIO.read(new File("src/images/BBishop.png"));
								JLabel picLabel = new JLabel(new ImageIcon(piecePic));
								tiles[i][j].add(picLabel);
							} catch (IOException e) {
								e.printStackTrace();
							}
						}
					} else if (p == Pieces.Queen) { // Queen
						if (selectedPiece.getColour() == true) { // White piece
							try {
								piecePic = ImageIO.read(new File("src/images/WQueen.png"));
								JLabel picLabel = new JLabel(new ImageIcon(piecePic));
								tiles[i][j].add(picLabel);
							} catch (IOException e) {
								e.printStackTrace();
							}
						} else { // Black piece
							try {
								piecePic = ImageIO.read(new File("src/images/BQueen.png"));
								JLabel picLabel = new JLabel(new ImageIcon(piecePic));
								tiles[i][j].add(picLabel);
							} catch (IOException e) {
								e.printStackTrace();
							}
						}
					} else if (p == Pieces.King) { // King
						if (selectedPiece.getColour() == true) { // White piece
							try {
								piecePic = ImageIO.read(new File("src/images/WKing.png"));
								JLabel picLabel = new JLabel(new ImageIcon(piecePic));
								tiles[i][j].add(picLabel);
							} catch (IOException e) {
								e.printStackTrace();
							}
						} else { // Black piece
							try {
								piecePic = ImageIO.read(new File("src/images/BKing.png"));
								JLabel picLabel = new JLabel(new ImageIcon(piecePic));
								tiles[i][j].add(picLabel);
							} catch (IOException e) {
								e.printStackTrace();
							}
						}
					}
				}
			}
		}
	}

	@Override
	public void mouseClicked(MouseEvent e) {

	}

	@Override
	public void mousePressed(MouseEvent e) {
		// First click (going from)
		if (possibleMoves.isEmpty()) {
			if (running) { // only process mouse clicks on panel if a game is running
				for (int j = 0; j < 8; j++) { // Checkered pattern algorithm
					for (int i = 0; i < 8; i++) { // Checkered pattern algorithm
						if (currentPanel == tiles[i][j]) {
							selectedPiece = game.getGameBoard().getTile(i, j).getOnTop();
							if (selectedPiece != null) {
								possibleMoves = game.pieceSelected(selectedPiece);

								// DEBUGGING
								System.out.println("\n=======================");
								System.out.print("Possible moves for ");
								if (selectedPiece.getColour()) {
									System.out.println("white " + selectedPiece.getType() + ":");
								} else {
									System.out.println("black " + selectedPiece.getType() + ":");
								}
								
								
								if (!possibleMoves.isEmpty()) {
									for (Tile t: possibleMoves) {
										System.out.println("\nx: " + t.getX() + "\ny: " + t.getY());
									}
								}
								
								tiles[i][j].setBackground(Color.YELLOW);
							}
						}
					}
				}
			}
		// Second click (going to)
		} else {
			for (int j = 0; j < 8; j++) { // Checkered pattern algorithm
				for (int i = 0; i < 8; i++) { // Checkered pattern algorithm
					if (currentPanel == tiles[i][j]) {
						// DISABLE YELLOW COLOR HERE
						
						for (Tile t: possibleMoves) { 				// Iterate through all possible moves found on the first mouse click
							if (t.getX() == i && t.getY() == j) {	// Get each x and y
								//Create 
								boolean moveSelected = game.moveSelected(i, j);
								// Gameboard returns whether or not it moved the piece								if (moveSelected) {
								if (moveSelected) {
									
								}
								
								System.out.println("\nYou just moved " + selectedPiece.getType() + " to x,y = [" + i + ", " + j + "]");
								possibleMoves.clear();
							}
						}
					}
				}
			}
		
		}
		
				
	}

	@Override
	public void mouseReleased(MouseEvent e) {

	}

	@Override
	public void mouseEntered(MouseEvent e) {
		currentPanel = (JPanel) e.getComponent();
	}

	@Override
	public void mouseExited(MouseEvent e) {

	}

	public static void main(String[] args) {
		new ChessGUI();
	}
}
