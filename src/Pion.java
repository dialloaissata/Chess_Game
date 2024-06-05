import java.util.ArrayList;

public class Pion extends Piece
{
	boolean premierCoup = true;

	public Pion(int y , int x,String couleurPion)
	{
		super(y ,x,"PION", couleurPion);
	}

	@Override
		public ArrayList<int[]> deplacementsPossibles(Piece[][] board,int x, int y ) {
		ArrayList<int[]> moves = new ArrayList<>();

		if (!this.isWhite()) {

			// Check one step forward
			if (x < 7 && board[x + 1][y] == null) {
				moves.add(new int[]{x + 1, y});
			}
			// Check two steps forward
			if (x == 1 && board[x + 1][y] == null && board[x + 2][y] == null) {
				moves.add(new int[]{x + 2, y});
			}
			// Check diagonal captures
			if (x < 6 && y > 0 && board[x + 1][y - 1] != null && !board[x + 1][y - 1].isWhite()) {
				moves.add(new int[]{x + 1, y - 1});
			}
			if (x < 6 && y < 7 && board[x + 1][y + 1] != null && !board[x + 1][y + 1].isWhite()) {
				moves.add(new int[]{x + 1, y + 1});
			}

		} else {
			// Check one step forward
			if (x > 0 && board[x - 1][y] == null) {
				moves.add(new int[]{x - 1, y});
			}
			// Check two steps forward
			if (x == 6 && board[x - 1][y] == null && board[x - 2][y] == null) {
				moves.add(new int[]{x - 2, y});
			}
			// Check diagonal captures
			if (x > 1 && y > 0 && board[x - 1][y - 1] != null && board[x - 1][y - 1].isWhite()) {
				moves.add(new int[]{x - 1, y - 1});
			}
			if (x > 1 && y < 7 && board[x - 1][y + 1] != null && board[x - 1][y + 1].isWhite()) {
				moves.add(new int[]{x - 1, y + 1});
			}

		}
		return moves;
	}
}
