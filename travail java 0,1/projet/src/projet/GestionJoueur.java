package projet;

public class GestionJoueur {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListeEquipe lstEquipe = new ListeEquipe("equipes.txt");
		ListeJoueur lstJoueur = new ListeJoueur("joueurs.txt", lstEquipe);
		
		MenuPrincipal objMenu = new MenuPrincipal();
		objMenu.demarrerMenuPrincipal(lstEquipe, lstJoueur);
		
	}
}