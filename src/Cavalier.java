import java.util.ArrayList;

public class Cavalier extends Piece
{
	public Cavalier(int y , int x, String couleurCavalier)
	{
		super(y,x,"CAVALIER", couleurCavalier);
	}
	@Override
	public ArrayList<int[]> deplacementsPossibles(Piece[][] board,int y, int x) {
		ArrayList<int[]> moves = new ArrayList<>();
		// Two steps up
		if(y-2 >= 0){
			// One step to the left

			if(x-1 >= 0 && (board[y-2][x-1] == null || board[y-2][x-1].isWhite() != this.isWhite())){
				moves.add(new int[]{y-2, x-1});
			}
			// One step to the right
			if(x+1 < 8 && (board[y-2][x+1] == null || board[y-2][x+1].isWhite() != this.isWhite())){
				moves.add(new int[]{y-2, x+1});
			}
		}

		// Two steps down
		if(y+2 < 8){
			// One step to the left
			if(x-1 >= 0 && (board[y+2][x-1] == null || board[y+2][x-1].isWhite() != this.isWhite())){
				moves.add(new int[]{y+2, x-1});
			}
			// One step to the right
			if(x+1 < 8 && (board[y+2][x+1] == null || board[y+2][x+1].isWhite() != this.isWhite())){
				moves.add(new int[]{y+2, x+1});
			}
		}

		// Two steps to the left
		if(x-2 >= 0){
			// One step up
			if(y-1 >= 0 && (board[y-1][x-2] == null || board[y-1][x-2].isWhite() != this.isWhite())){
				moves.add(new int[]{y-1, x-2});
			}
			// One step down
			if(y+1 < 8 && (board[y+1][x-2] == null || board[y+1][x-2].isWhite() != this.isWhite())){
				moves.add(new int[]{y+1, x-2});
			}
		}

		// Two steps to the right
		if(x+2 < 8){
			// One step up
			if(y-1 >= 0 && (board[y-1][x+2] == null || board[y-1][x+2].isWhite() != this.isWhite())){
				moves.add(new int[]{y-1, x+2});
			}
			// One step down
			if(y+1 < 8 && (board[y+1][x+2] == null || board[y+1][x+2].isWhite() != this.isWhite())){
				moves.add(new int[]{y+1, x+2});
			}
		}
		return moves;
	}
}


