//Philippe Doyon
public class Cercle {
	
	double dblCentreX;
	double dblCentreY;
	double dblRayon;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Cercle 1 
		Cercle premierCer = new Cercle(0,5,5);
		
		double dblPerimetre = premierCer.getPerimetre();
		double dblAire = premierCer.getSurface();
		
		System.out.println("Premier cercle :\rCoordonné = (" + premierCer.dblCentreX + ";" + 
				premierCer.dblCentreY + ")\rRayon = " + premierCer.dblRayon + "\rPérimètre = " + dblPerimetre 
				+"\rAire = " + dblAire);
		
		//Cercle 2 
		Cercle deuxiemeCer = new Cercle(5,8,11);
		
		dblPerimetre = deuxiemeCer.getPerimetre();
		dblAire = deuxiemeCer.getSurface();
		
		System.out.println("***************\rDeuxième cercle :\rCoordonné = (" + deuxiemeCer.dblCentreX + ";" 
				+ deuxiemeCer.dblCentreY + ")\rRayon = " + deuxiemeCer.dblRayon + "\rPérimètre = " +
				dblPerimetre + "\rAire = " + dblAire);
	}
	
	public Cercle(double dblCentreX, double dblCentreY, double dblrayon){
		this.dblCentreX = dblCentreX;
		this.dblCentreY = dblCentreY;
		this.dblRayon = dblrayon;
	}
	
	public double getPerimetre(){
		double dblPerimetre = 2 * Math.PI * dblRayon;
		
		return dblPerimetre;
	}
	
	public double getSurface(){
		double dblAire = Math.PI * Math.pow(dblRayon, 2);
		
		return dblAire;
	}
}
