import java.util.ArrayList;

public class Reine extends Piece
{
	public Reine(int y , int x,String couleurReine)
	{
		super(y ,x,"REINE", couleurReine);
	}
	@Override
	public ArrayList<int[]> deplacementsPossibles(Piece[][] board,int y, int x)
	{
		ArrayList<int[]> moves = new ArrayList<>();
		// generate moves like bishop
		// Upper Left Diagonal
		for (int i = y - 1, j = x - 1; i >= 0 && j >= 0; i--, j--) {
			if (board[i][j] == null) {
				moves.add(new int[]{i, j});
			} else if (board[i][j].isWhite() != this.isWhite()) {
				moves.add(new int[]{i, j});
				break;
			} else {
				break;
			}
		}

		// Upper Right Diagonal
		for (int i = y - 1, j = x + 1; i >= 0 && j < 8; i--, j++) {
			if (board[i][j] == null) {
				moves.add(new int[]{i, j});
			} else if (board[i][j].isWhite() != this.isWhite()) {
				moves.add(new int[]{i, j});
				break;
			} else {
				break;
			}
		}

		// Lower Left Diagonal
		for (int i = y + 1, j = x - 1; i < 8 && j >= 0; i++, j--) {
			if (board[i][j] == null) {
				moves.add(new int[]{i, j});
			} else if (board[i][j].isWhite() != this.isWhite()) {
				moves.add(new int[]{i, j});
				break;
			} else {
				break;
			}
		}

		// Lower Right Diagonal
		for (int i = y + 1, j = x + 1; i < 8 && j < 8; i++, j++) {
			if (board[i][j] == null) {
				moves.add(new int[]{i, j});
			} else if (board[i][j].isWhite() != this.isWhite()) {
				moves.add(new int[]{i, j});
				break;
			} else {
				break;
			}
		}
		// generate moves like rook

		// Check moves to the right
		for (int i = x + 1; i < 8; i++) {
			if (board[y][i] == null) {
				moves.add(new int[]{y, i});
			} else if (board[y][i].isWhite() != this.isWhite()) {
				moves.add(new int[]{y, i});
				break;
			} else {
				break;
			}
		}

		// Check moves to the left
		for (int i = x - 1; i >= 0; i--) {
			if (board[y][i] == null) {
				moves.add(new int[]{y, i});
			} else if (board[y][i].isWhite() != this.isWhite()) {
				moves.add(new int[]{y, i});
				break;
			} else {
				break;
			}
		}

		// Check moves to the bottom
		for (int i = y + 1; i < 8; i++) {
			if (board[i][x] == null) {
				moves.add(new int[]{i, x});
			} else if (board[i][x].isWhite() != this.isWhite()) {
				moves.add(new int[]{i, x});
				break;
			} else {
				break;
			}
		}

		// Check moves to the top
		for (int i = y - 1; i >= 0; i--) {
			if (board[i][x] == null) {
				moves.add(new int[]{i, x});
			} else if (board[i][x].isWhite() != this.isWhite()) {
				moves.add(new int[]{i, x});
				break;
			} else {
				break;
			}
		}

		return moves;
	}
}

