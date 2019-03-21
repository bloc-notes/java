package premierProgramme;
import java.util.Scanner;
//Philippe Doyon
public class exemple {
	public double dblLargeur;
	public double dblHauteur;
	
	public static void main(String[] args) {			
		exemple rec = new exemple(50,25);
		//exemple rec2 = new exemple();
		double dblSurface = rec.getSurface(10, 78);
		//double dblSurface2 = rec2.getSurface();
			
		System.out.println("L'air du rectangle est de " + dblSurface);
		//System.out.println("L'air du rectangle 2 est de " + dblSurface2);
		
		System.out.println(rec.dblHauteur*rec.dblLargeur);
		//System.out.println(rec2.dblHauteur*rec2.dblLargeur);
		
	}
	
	public double getSurface(){	
		double dblAire = this.dblLargeur * this.dblHauteur;
		
		return dblAire;
	}
	
	public double getSurface(double dblLargeur, double dblHauteur){	
		
		double dblAire = dblLargeur * dblHauteur;
		return dblAire;
	}
	
	public exemple()
	{	
		System.out.println("Veuiller inscrire la largeur du rectangle : ");
		dblLargeur = new Scanner(System.in).nextDouble();
		
		System.out.println("Veuiller inscrire la hauteur du rectangle : ");
		dblHauteur = new Scanner(System.in).nextDouble();
		
	}
	
	public exemple(double dblLargeur, double dblHauteur)
	{		
		this.dblLargeur = dblLargeur;
		this.dblHauteur = dblHauteur;
		
	}	
}