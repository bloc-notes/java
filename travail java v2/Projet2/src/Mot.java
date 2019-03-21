import java.awt.Point;

public class Mot {
	
	private String strChaine ="";
	private Point objPoint = null;
	private Deplacement dire = null;
	
	public Mot(String strChaine) {
		super();
		this.strChaine = strChaine;
	}

	@Override
	public String toString() {
		return String.format("%-15s", strChaine.toUpperCase()) + String.format("%-15s", "(" + objPoint.x + ", " +objPoint.y + ")") + dire;
	}

	public String getStrChaine() {
		return strChaine;
	}

	public void setObjPoint(int x, int y) {
		this.objPoint = new Point(x, y);
	}

	public void setDire(Deplacement dire) {
		this.dire = dire;
	}

	public Point getObjPoint() {
		return objPoint;
	}

	public Deplacement getDire() {
		return dire;
	}
	
	
}
