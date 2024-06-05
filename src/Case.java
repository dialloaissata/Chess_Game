import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

public class Case extends JFrame implements MouseListener
{
	JPanel mainPanel; // * Panneau principal
	JPanel chessBoard; // * Panneau correspondant au damier
	static final int SIZE_CASE_X = 75;
	static final int SIZE_CASE_Y = 75;
	Echiquier echiquier;
	static final Color BLACK_CASE = Color.gray;
	static final Color WHITE_CASE = Color.white;
	static final Color HIGHLIGHT_CASE = Color.red;
	private Piece selectedPiece = null;
	public Case() {
		// Taille d'un element graphique
		Dimension boardSize = new Dimension(SIZE_CASE_X * Echiquier.SIZE_COLUMN_GRID, SIZE_CASE_Y * Echiquier.SIZE_LINE_GRID);
		// Definition du panel principal
		mainPanel = new JPanel();
		getContentPane().add(mainPanel); // Ajout du panel principal a la fenetre principale (JFrame)
		mainPanel.setPreferredSize(boardSize);
		mainPanel.addMouseListener(this); // Ajout de la gestion des clics

		// Definition du panel contenant le damier
		chessBoard = new JPanel();
		mainPanel.add(chessBoard); // Ajout du panel damier au panel principal
		chessBoard.setLayout(new GridLayout(Echiquier.SIZE_COLUMN_GRID, Echiquier.SIZE_LINE_GRID)); // le damier sera une grille N * M
		chessBoard.setPreferredSize(boardSize);
		chessBoard.setBounds(0, 0, boardSize.width, boardSize.height);

		// Dans le damier, ajout de N*M panneau, chacun correspondant a une case de la grille
		for (int i = 0; i < Echiquier.SIZE_COLUMN_GRID * Echiquier.SIZE_LINE_GRID; i++) {
			JPanel square = new JPanel(new BorderLayout());
			square.setBorder(BorderFactory.createLineBorder(Color.black));
			chessBoard.add(square);
		}

		// Instantciation de l'echiquier
		echiquier = new Echiquier();
		// Affiche la grille
		drawGrid();
	}

	/**
	 * Methode d'affichage de la grille
	 */
	public void drawGrid() {
		JPanel square;
		int index = 0;
		// Pour chaque case de la grille
		for (int row = 0; row < Echiquier.SIZE_LINE_GRID; row++) {
			for (int col = 0; col < Echiquier.SIZE_COLUMN_GRID; col++) {
				square = (JPanel) chessBoard.getComponent(index);
				// Dessin case noire/ case blanche
				int colorIndex = (row + col) % 2;
				square.setBackground((colorIndex == 0) ? BLACK_CASE : WHITE_CASE);

				// Obtention de la piece sur la case et ajout d'une image dans un JLabel
				Piece piece = echiquier.getPieceAt(row, col);
				if (piece != null) {
					String couleur = piece.getCouleurPiece();
					String nomPiece = piece.getNom();
					String nomimg = nomPiece.toUpperCase() + "_" + couleur.toUpperCase() + ".png";
					JLabel image = new JLabel(new ImageIcon("img/" + nomimg));
					square.add(image);
				}

				if (echiquier.highLightCase[row][col]) {
					square.setBackground(HIGHLIGHT_CASE);
				}
				// Incrémentation de l'indice pour passer à la case suivante
				index++;
			}
		}
	}

	private void removeSquare(JPanel oldSquare){
		oldSquare.removeAll();
		oldSquare.repaint();
		oldSquare.revalidate();
	}


	public void mousePressed(MouseEvent e)
	{
		// Conversion de la position cliquée en position de la grille
		int colX = e.getX() / (Case.SIZE_CASE_X);
		int rowY = e.getY() / (Case.SIZE_CASE_Y);

		int selectedComponentIndex = rowY * Echiquier.SIZE_COLUMN_GRID + colX ;

		Piece piece = echiquier.getPieceAt(rowY, colX);
		// Pièce non null et non mis en evidence (Pour ne pas qu'en cliquant sur la piece adverse au lieu de la
		// bouffer on affiche les mouvements possibles de la pièce adverse.
		if(piece != null && !echiquier.highLightCase[rowY][colX]){
			// On cliqué sur l'un des pions.
			// Liste des coordonnées possibles du joueur.
			ArrayList<int[]> moves = piece.deplacementsPossibles(echiquier.getPlateau(),rowY, colX);
			echiquier.resetHighlight();

			// On met en evidence tous les mouvements possibles du joueur.
			for(int[] move : moves){
				int  i = move[0];
				int j = move[1];
				echiquier.highLightCase[i][j] = true ;
			}

			selectedPiece = piece ;
            /*selectedRow = selectedPiece.getRow();
            selectedCol = selectedPiece.getCol();*/
		}
		// Si on clique sur une tuile mise en evidence.
		if (echiquier.highLightCase[rowY][colX]) {
			echiquier.resetHighlight();
			// C'est là qu'on  fait les tests de déplacements.
			int sourceRow = selectedPiece.getY();
			int sourceCol = selectedPiece.getX();
			int componentIndex = sourceRow * Echiquier.SIZE_COLUMN_GRID + sourceCol;
			JPanel oldSquare = (JPanel) chessBoard.getComponent(componentIndex);
			this.removeSquare(oldSquare);

			echiquier.deplacerPiece(sourceRow, sourceCol, rowY, colX);
			selectedPiece = null;
		}
		// Mise à jour de l'affichage
		drawGrid();
	}

    public void mouseReleased(MouseEvent e) {}
    public void mouseClicked(MouseEvent e) {}
    public void mouseEntered(MouseEvent e){}
    public void mouseExited(MouseEvent e) {}

	public static void main(String[] args)
	{
		// Definir et afficher la fenetre graphique correspondant au damier
		JFrame frame = new Case();
		frame.setDefaultCloseOperation(DISPOSE_ON_CLOSE );
		frame.pack();
		frame.setResizable(false);
		frame.setLocationRelativeTo( null );
		frame.setVisible(true);
	}
}
