import java.util.ArrayList;

public class Tour extends Piece
{
	public Tour(int y , int x,String couleurTour)
	{
		super(y , x,"TOUR", couleurTour);
	}
	@Override
	public ArrayList<int[]> deplacementsPossibles(Piece[][] board,int y, int x)
	{
		ArrayList<int[]> moves = new ArrayList<>();
		boolean canMove = true ;
		// Check moves to the right
		for (int i = x + 1; i < 8 && canMove; i++)
		{
			if (board[y][i] == null) {
				moves.add(new int[]{y, i});
			} else if (board[y][i].isWhite() != this.isWhite()) {
				moves.add(new int[]{y, i});
				canMove = false;
			} else {
				canMove = false ;
			}
		}

		canMove = true ;
		// Check moves to the left
		for (int i = x - 1; i >= 0 && canMove; i--) {
			if (board[y][i] == null) {
				moves.add(new int[]{y, i});
			} else if (board[y][i].isWhite() != this.isWhite()) {
				moves.add(new int[]{y, i});
				canMove = false;
			} else {
				canMove = false;
			}
		}

		canMove = true ;
		// Check moves to the bottom
		for (int i = y + 1; i < 8 && canMove; i++) {
			if (board[i][x] == null) {
				moves.add(new int[]{i, x});
			} else if (board[i][x].isWhite() != this.isWhite()) {
				moves.add(new int[]{i, x});
				canMove = false;
			} else {
				canMove = false ;
			}
		}

		canMove = true ;
		// Check moves to the top
		for (int i = y - 1; i >= 0 && canMove; i--) {
			if (board[i][x] == null) {
				moves.add(new int[]{i, x});
			} else if (board[i][x].isWhite() != this.isWhite()) {
				moves.add(new int[]{i, x});
				canMove = false;
			} else {
				canMove = false;
			}
		}
		return moves;
	}
}

