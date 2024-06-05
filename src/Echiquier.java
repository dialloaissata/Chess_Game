public class Echiquier {
	protected static int SIZE_LINE_GRID = 8; // lignes
	protected static int SIZE_COLUMN_GRID = 8; // colonnes
	protected Piece[][] grille;
	public boolean[][] highLightCase = new boolean[SIZE_LINE_GRID][SIZE_COLUMN_GRID];

	public Echiquier()
	{
		grille = new Piece[SIZE_LINE_GRID][SIZE_COLUMN_GRID];
		this.initNormal();
	}

	public void resetHighlight()
	{
		for(int i = 0; i< Echiquier.SIZE_LINE_GRID; i++)
		{
			for(int j = 0; j< Echiquier.SIZE_COLUMN_GRID; j++)
			{
				highLightCase[i][j] = false;
			}
		}
	}

	public void initNormal() {
		// init les pions noirs
		for (int i = 0; i < SIZE_LINE_GRID; i++) {
			grille[1][i] = new Pion(1, i, "noir");
		}
		// init les autres pièces noires
		grille[0][0]= new Tour(0, 0, "noir");
		grille[0][1]= new Cavalier(0, 1, "noir");
		grille[0][2]= new Fou(0, 2, "noir");
		grille[0][3]= new Reine(0, 3, "noir");
		grille[0][4]= new Roi(0, 4, "noir");
		grille[0][5] = new Fou(0, 5, "noir");
		grille[0][6]= new Cavalier(0, 6, "noir");
		grille[0][7]= new Tour(0, 7, "noir");

		// init les pions blancs
		for (int i = 0; i < SIZE_COLUMN_GRID; i++) {
			grille[6][i]= new Pion(6, i, "blanc");
		}
		// init les autres pièces blanches
		grille[7][0]= new Tour(7, 0, "blanc");
		grille[7][1]= new Cavalier(7, 1, "blanc");
		grille[7][2]= new Fou(7, 2, "blanc");
		grille[7][3]= new Reine(7, 3, "blanc");
		grille[7][4]= new Roi(7, 4, "blanc");
		grille[7][5]= new Fou(7, 5, "blanc");
		grille[7][6]= new Cavalier(7, 6, "blanc");
		grille[7][7]= new Tour(7, 7, "blanc");
	}
	public Piece getPieceAt(int row, int col) {
		return grille[row][col];
	}
	public void setPieceAt(int row, int col, Piece piece) {
		grille[row][col] = piece;
	}
	public void removePieceAt(int row, int col) {
		Piece pieceToRemove = getPieceAt(row, col);
		if (pieceToRemove == null) {
			throw new IllegalArgumentException("No piece at " + row + " " + col);
		}
		grille[row][col] = null ;
	}
	public Piece[][] getPlateau() {
		return this.grille;
	}
	public boolean deplacerPiece(int sourceRow, int sourceCol, int endRow, int endCol) {
		Piece startPiece = getPieceAt(sourceRow, sourceCol);
		Piece endPiece = getPieceAt(endRow, endCol);

		if (startPiece == null) {
			return false;
		}
		if (endPiece != null && endPiece.getCouleurPiece().equals(startPiece.getCouleurPiece())) {
			return false;
		}

		if(endPiece != null && !(endPiece.getCouleurPiece().equals(startPiece.getCouleurPiece())))
		{
			removePieceAt(endRow, endCol);
			setPieceAt(endRow, endCol, startPiece);
			setPieceAt(sourceRow, sourceCol, null);
			startPiece.setX(endRow);
			startPiece.setY(endCol);
		}
		else
		{
			setPieceAt(endRow, endCol, startPiece);
			setPieceAt(sourceRow, sourceCol, null);
			startPiece.setX(endRow);
			startPiece.setY(endCol);
		}
		return true;
	}
}

