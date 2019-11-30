import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.*;

public class ChessGUI extends JFrame implements ActionListener{
	public Game game;
	private JMenuItem newGame, undo, redo;
	private JMenu gameMenu;
	private JPanel[][] tiles;
	
	private GamePiece selectedPiece;
	
	public enum Pieces {
		Pawn, Rook, Knight, Bishop, King, Queen;
	}
	
	public ChessGUI() {	
		super("Chess");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(600, 600);		
		setLocation(400,200);
		setResizable(false);
		
		// Menubar
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		gameMenu = new JMenu("Game");
		menuBar.add(gameMenu);
		
		newGame = new JMenuItem("New Game");
		newGame.addActionListener(e -> {
			game = new Game();
			updateBoard();
			setVisible(true);
		});
		gameMenu.add(newGame);
		
		//Frame Icon
		ImageIcon img = new ImageIcon("src/images/icon.png");
		setIconImage(img.getImage());
		
		// Draw chess board 
		JPanel panel = new JPanel(new GridLayout(8, 8));	
		tiles = new JPanel[8][8];
					
		for(int j = 0; j < 8; j++) {	// Checkered pattern algorithm
			for(int i = 0; i <8; i++) {
				tiles[i][j] = new JPanel();
				if ((i+j)%2 == 0) {
					tiles[i][j].setBackground(Color.WHITE);
				} else {
					tiles[i][j].setBackground(Color.DARK_GRAY);
				}
				panel.add(tiles[i][j]);
			}
		}
		
		add(panel, BorderLayout.CENTER);
		
		setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent event) {

	}
	
	public void updateBoard() {
		for(int i = 0; i < 8; i++) {
			for(int j = 0; j < 8; j++) {
				if(!game.getGameBoard().getTile(i, j).isEmpty()) {
					selectedPiece = game.getGameBoard().getTile(i, j).getOnTop();	// Get piece from the current tiles
					Pieces p = selectedPiece.getType();								// Get that pieces type
					BufferedImage piecePic;											// Picture retrieved from filesystem
					
					if (p == Pieces.Pawn) {							// Pawn
						if (selectedPiece.getColour() == true) {	// White piece
							try {
								piecePic = ImageIO.read(new File("src/images/WPawn.png"));
								JLabel picLabel = new JLabel(new ImageIcon(piecePic));
								tiles[i][j].add(picLabel);
							} catch (IOException e) {
								e.printStackTrace();
							}
						} else {									// Black piece
							try {
								piecePic = ImageIO.read(new File("src/images/BPawn.png"));
								JLabel picLabel = new JLabel(new ImageIcon(piecePic));
								tiles[i][j].add(picLabel);
							} catch (IOException e) {
								e.printStackTrace();
							}
						}
					} else if (p == Pieces.Rook) {					// Rook
						if (selectedPiece.getColour() == true) {	// White piece
							try {
								piecePic = ImageIO.read(new File("src/images/WRook.png"));
								JLabel picLabel = new JLabel(new ImageIcon(piecePic));
								tiles[i][j].add(picLabel);
							} catch (IOException e) {
								e.printStackTrace();
							}
						} else {									// Black piece
							try {
								piecePic = ImageIO.read(new File("src/images/BRook.png"));
								JLabel picLabel = new JLabel(new ImageIcon(piecePic));
								tiles[i][j].add(picLabel);
							} catch (IOException e) {
								e.printStackTrace();
							}
						}
					} else if (p == Pieces.Knight) {				// Knight
						if (selectedPiece.getColour() == true) {	// White piece
							try {
								piecePic = ImageIO.read(new File("src/images/WKnight.png"));
								JLabel picLabel = new JLabel(new ImageIcon(piecePic));
								tiles[i][j].add(picLabel);
							} catch (IOException e) {
								e.printStackTrace();
							}
						} else {									// Black piece
							try {
								piecePic = ImageIO.read(new File("src/images/BKnight.png"));
								JLabel picLabel = new JLabel(new ImageIcon(piecePic));
								tiles[i][j].add(picLabel);
							} catch (IOException e) {
								e.printStackTrace();
							}
						}
					} else if (p == Pieces.Bishop) {				// Bishop
						if (selectedPiece.getColour() == true) {	// White piece
							try {
								piecePic = ImageIO.read(new File("src/images/WBishop.png"));
								JLabel picLabel = new JLabel(new ImageIcon(piecePic));
								tiles[i][j].add(picLabel);
							} catch (IOException e) {
								e.printStackTrace();
							}
						} else {									// Black piece
							try {
								piecePic = ImageIO.read(new File("src/images/BBishop.png"));
								JLabel picLabel = new JLabel(new ImageIcon(piecePic));
								tiles[i][j].add(picLabel);
							} catch (IOException e) {
								e.printStackTrace();
							}
						}
					} else if (p == Pieces.Queen) {					// Queen
						if (selectedPiece.getColour() == true) {	// White piece
							try {
								piecePic = ImageIO.read(new File("src/images/WQueen.png"));
								JLabel picLabel = new JLabel(new ImageIcon(piecePic));
								tiles[i][j].add(picLabel);
							} catch (IOException e) {
								e.printStackTrace();
							}
						} else {									// Black piece
							try {
								piecePic = ImageIO.read(new File("src/images/BQueen.png"));
								JLabel picLabel = new JLabel(new ImageIcon(piecePic));
								tiles[i][j].add(picLabel);
							} catch (IOException e) {
								e.printStackTrace();
							}
						}
					} else if (p == Pieces.King) {					// King
						if (selectedPiece.getColour() == true) {	// White piece
							try {
								piecePic = ImageIO.read(new File("src/images/WKing.png"));
								JLabel picLabel = new JLabel(new ImageIcon(piecePic));
								tiles[i][j].add(picLabel);
							} catch (IOException e) {
								e.printStackTrace();
							}	
						} else {									// Black piece
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

	public static void main(String[] args) {
		new ChessGUI();
	}
}
