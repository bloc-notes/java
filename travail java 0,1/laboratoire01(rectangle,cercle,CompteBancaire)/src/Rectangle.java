import java.util.Scanner;
//Philippe Doyon
public class Rectangle {
	public double dblLargeur;
	public double dblHauteur;
	
	public static void main(String[] args) {			
		Rectangle rec = new Rectangle();
		
		double dblSurface = rec.getSurface();
			
		System.out.println("L'air du rectangle est de " + dblSurface);
		
		System.out.println("L'air du rectangle est de " + rec.dblHauteur * rec.dblLargeur);		
	}
	
	public double getSurface(){	
		double dblAire = dblLargeur * dblHauteur;
		
		return dblAire;
	}
	
	public Rectangle()
	{	
		System.out.println("Veuiller inscrire la largeur du rectangle : ");
		dblLargeur = new Scanner(System.in).nextDouble();
		
		System.out.println("Veuiller inscrire la hauteur du rectangle : ");
		dblHauteur = new Scanner(System.in).nextDouble();		
	}
	
	public Rectangle(double dblLargeur, double dblHauteur)
	{		
		this.dblLargeur = dblLargeur;
		this.dblHauteur = dblHauteur;		
	}	
}
