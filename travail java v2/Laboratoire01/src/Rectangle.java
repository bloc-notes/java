
public class Rectangle {
	static double dblLargeur = 15;
	static double dblHauteur = 8.23;
	
	public static void main(String[] args) {
		double dblAirRectangle = dblLargeur * dblHauteur;
		Rectangle rec = new Rectangle();
		
		System.out.println("Méthode1: " + dblAirRectangle + "\rMéthode2: " + rec.getSurface());
	}
	
	public double getSurface(){ 	
		return dblLargeur * dblHauteur;
	}
}
