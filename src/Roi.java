import java.util.ArrayList;

public class Roi extends Piece
{
	public Roi(int y , int x,String couleurRoi)
	{
		super( y , x,"ROI", couleurRoi);
	}
	@Override
	public ArrayList<int[]> deplacementsPossibles(Piece[][] plateau, int x, int y) {
		ArrayList<int[]> deplacements = new ArrayList<>();
		int[][] deplacementsPossibles = {{-1,-1}, {-1,0}, {-1,1}, {0,-1}, {0,1}, {1,-1}, {1,0}, {1,1}};

		for (int i = 0; i < deplacementsPossibles.length; i++)
		{
			int newX = x + deplacementsPossibles[i][0];
			int newY = y + deplacementsPossibles[i][1];
			if (newX >= 0 && newX <= 7 && newY >= 0 && newY <= 7) {
				if (plateau[newX][newY] == null || !plateau[newX][newY].getCouleurPiece().equals(couleurPiece)) {
					deplacements.add(new int[]{newX,newY});
				}
			}
		}
		return deplacements;
	}
}

