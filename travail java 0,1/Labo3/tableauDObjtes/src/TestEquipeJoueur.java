
public class TestEquipeJoueur {


	public static void main(String[] args) {
		// créer un objet Equipe. 
	
        Equipe objEquipe = new Equipe(10, "Bob", "Gladiateur"); 
        // ajouter les joueurs à l'équipe
		Joueur ariel = new Joueur(10, "Sashcov", "Ariel", 21, 65);
		objEquipe.ajouterJoueur(ariel);
		ariel = new Joueur(20, "LeBeau", "Jean", 25, 80);
		objEquipe.ajouterJoueur(ariel);
		
		ariel = new Joueur(20, "Turcotte", "Alain", 24, 75);
		objEquipe.ajouterJoueur(ariel);
		
        // afficher la liste de joueurs
          
        objEquipe.listerJoueurs();
	}

}
