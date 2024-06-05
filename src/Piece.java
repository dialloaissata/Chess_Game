import java.awt.*;
import java.util.ArrayList;

public abstract class Piece
{
	protected String couleurPiece;
	protected String nom;
	protected int x; // Coordonnée x de la case
	protected int y; // Coordonnée y de la case

	public Piece(int y, int x ,String nom, String couleurPiece)
	{
		this.y = y ;
		this.x = x ;
		this.couleurPiece = couleurPiece;
		this.nom = nom;
	}

	public String getNom()
	{
		return nom;
	}
	public String getCouleurPiece()
	{
		return couleurPiece;
	}
	public void setCouleurPiece(String couleurPiece)
	{
		this.couleurPiece = couleurPiece;
	}
	public abstract ArrayList<int[]> deplacementsPossibles(Piece[][] plateau, int x, int y);
	public String getColor()
	{
		return couleurPiece;
	}
	public int getX()
	{
		return this.x;
	}
	public int getY()
	{
		return this.y;
	}
	public void setX(int x)
	{
		this.x = x;
	}
	public void setY(int y)
	{
		this.y = y;
	}
	public boolean isWhite()
	{
		return this.getColor().equals("blanc");
	}
}
