
public class Principale {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		GrilleJeu objGrille = new GrilleJeu("grille1.txt");
		
		objGrille.RechercheMot();
		objGrille.Affiche(objGrille.BarreMot());		
	}
}