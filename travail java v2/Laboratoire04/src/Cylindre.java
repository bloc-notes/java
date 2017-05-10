public class Cylindre extends Cercle {

	public double dblHauteur;

	public Cylindre(double dblCentreX, double dblCentreY, double dblRayon, double dblHauteur) {
		super(dblCentreX, dblCentreY, dblRayon);
		this.dblHauteur = dblHauteur;
	}

	public Cylindre(Cercle objCercle, double dblHauteur) {
		super(objCercle.dblCentreX, objCercle.dblCentreY, objCercle.dblRayon);
		// TODO Auto-generated constructor stub
		this.dblHauteur = dblHauteur;
	}
	
	public static void main(String[] args) {
		Cercle objCercle = new Cercle(22, 15, 6);
		Cylindre objCylindre1 = new Cylindre(objCercle, 26);
		Cylindre objCylindre2 = new Cylindre(62, 60, 15, 40);
		
		System.out.println("Cylindre  1\nHauteur: " + objCylindre1.dblHauteur + "\nSurface: " + objCylindre1.getSurface() + "\nVolume: "+ 
				objCylindre1.getVolume());
		
		System.out.println("Cylindre  2\nHauteur: " + objCylindre2.dblHauteur + "\nSurface: " + objCylindre2.getSurface() + "\nVolume: "+ 
				objCylindre2.getVolume());
	}

	public double getVolume() {

		return dblHauteur * super.getSurface();
	}

	public double getSurface() {
		return 2 * super.getSurface() + dblHauteur * super.getPerimetre();
	}

}
