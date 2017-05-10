//Philippe Doyon
public class Cylindre extends Cercle {
	double dblHauteurCyl;
	

	public Cylindre(double dblCentreX, double dblCentreY, double dblrayon, double dblHauteurCyl) {
		super(dblCentreX, dblCentreY, dblrayon);
		this.dblHauteurCyl = dblHauteurCyl;		
	}
	
	public Cylindre(double dblHauteurCyl, Cercle objCercle) {
		super(objCercle.dblCentreX, objCercle.dblCentreY,objCercle.dblRayon);
		this.dblHauteurCyl = dblHauteurCyl;		
	}
	
	public double getVolume(){
		
		return (dblHauteurCyl * super.getSurface());
	}
	
	public double getSurface(){
		
		return (2*super.getSurface() + dblHauteurCyl * super.getPerimetre());
	}
	
	public static void main(String[] args){
		Cercle objCerleCyl = new Cercle(2, 3, 7);
		
		Cylindre objCylindre = new Cylindre(2, 3, 2, 10);
		System.out.println("1er Cylindre\nHauteur: " +  objCylindre.dblHauteurCyl + "\nSurface: " + objCylindre.getSurface() + "\nVolume: " + objCylindre.getVolume());
		
		Cylindre objCylindre2 = new Cylindre(10, objCerleCyl);
		System.out.println("2eme Cylindre\nHauteur: " + objCylindre2.dblHauteurCyl + "\nSurface: " + objCylindre2.getSurface() + "\nVolume: " + objCylindre2.getVolume());
	}
}
