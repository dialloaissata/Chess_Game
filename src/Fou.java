import java.util.ArrayList;

public class Fou extends Piece
{
	public Fou(int y , int x,String couleurFou)
	{
		super(y ,x,"FOU", couleurFou);
	}
	@Override
	public ArrayList<int[]> deplacementsPossibles(Piece[][] board,int y, int x) {
		ArrayList<int[]>  moves = new ArrayList<>();

		// Upper Left Diagonal
		for(int i=y-1, j=x-1; i>=0 && j>=0; i--, j--){
			if(board[i][j] == null) {
				moves.add(new int[]{i, j});
			}
			else if(board[i][j].isWhite() != this.isWhite()){
				moves.add(new int[]{i, j});
				break;
			}
			else {
				break;
			}
		}

		// Upper Right Diagonal
		for(int i=y-1, j=x+1; i>=0 && j<8; i--, j++){
			if(board[i][j] == null) {
				moves.add(new int[]{i, j});
			}
			else if(board[i][j].isWhite() != this.isWhite()){
				moves.add(new int[]{i, j});
				break;
			}
			else {
				break;
			}
		}

		// Lower Left Diagonal
		for(int i=y+1, j=x-1; i<8 && j>=0; i++, j--){
			if(board[i][j] == null) {
				moves.add(new int[]{i, j});
			}
			else if(board[i][j].isWhite() != this.isWhite()){
				moves.add(new int[]{i, j});
				break;
			}
			else {
				break;
			}
		}

		// Lower Right Diagonal
		for(int i=y+1, j=x+1; i<8 && j<8; i++, j++){
			if(board[i][j] == null) {
				moves.add(new int[]{i, j});
			}
			else if(board[i][j].isWhite() != this.isWhite()){
				moves.add(new int[]{i, j});
				break;
			}
			else {
				break;
			}
		}
		return moves;
	}
}
