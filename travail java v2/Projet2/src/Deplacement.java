import java.awt.Point;

public enum Deplacement {
	
	O(-1, 0, "Ouest"), 
	E(1, 0, "Est"), 
	N(0, -1, "Nord"), 
	S(0, 1, "Sud"), 
	NO(-1, -1, "Nord Ouest"), 
	NE(1, -1, "Nord Est"), 
	SO(-1, 1, "Sud Ouest"),
	SE(1, 1, "Sud Est");
	
	private String strNom;
	private Point sens;
	
	private Deplacement(int x, int y, String nom) {
		sens = new Point(x, y);
		strNom = nom;
	}
	
	public Point getSens() { return sens; }
	public String toString() { return strNom; }
}