package projet;

import java.util.Scanner;

public class MenuPrincipal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public void demarrerMenuPrincipal(ListeEquipe lstEquipe, ListeJoueur lstJoueur) {
		Boolean blnQuitter = false; // Déside si quitte ou non
		while (blnQuitter == false){
			System.out.println("\nBienvenue dans la LNH. Voici les options disponibles: " + "\n1-Liste des équipes(alpha)" + "\n2-Liste des équipes d'une division" +
					"\n3-Liste des joueurs d'une équipe" + "\n4-Liste des joueurs par position" + "\n5-Liste de tous les joueur(poids)" + "\n6-Changer équipe" + 
					"\n7-Quitter" + "\n\nVotre choix?");
			
			@SuppressWarnings("resource")
			int intOption = new Scanner(System.in).nextInt();
			switch (intOption) {
			case 1:
				listerEquipes(lstEquipe);
				break;
			case 2:
				listerEquipeDivision(lstEquipe);
				break;
			case 3:
				listerJoueursEquipe(lstEquipe);
				break;
			case 4:
				listerJoueursPosition(lstJoueur);
				break;
			case 5:
				listerJoueursPoidsDecroissant(lstJoueur);
				break;
			case 6:
				changerEquipe(lstEquipe, lstJoueur);
				break;
			case 7:
				blnQuitter = this.quitter();
				break;
				default: System.out.println("Nous avons seulement sept options pour l'instant. Désoler :'(");
				break;
			}
		}			
	}
	
	private   void listerEquipes (ListeEquipe  lstEquipe) {		
		for (int w = 0;w < lstEquipe.getNbreElements();w++){
			System.out.println(lstEquipe.getLstEquipe()[w].toString());
		}
	}
	
	private void listerEquipeDivision (ListeEquipe  lstEquipe){
		System.out.println("Nom de la division:");
		@SuppressWarnings("resource")
		String strDivision = new Scanner(System.in).next();
		
		boolean blnDivisionValide = false;
		for(NomDivision nomDiv : NomDivision.values()){
			if(strDivision.toUpperCase().equals(nomDiv.toString()))
				blnDivisionValide = true;
		}
		
		if (blnDivisionValide == true){
			for(int d=0; d<lstEquipe.getNbreElements();d++){
				if(NomDivision.valueOf(strDivision.toUpperCase()).equals(lstEquipe.getLstEquipe()[d].getNomDivision())){
					System.out.println(lstEquipe.getLstEquipe()[d].toString());
				}
			}
		}
		else
			System.out.println("Division inexistante\n");
	}
	
	private void listerJoueursEquipe(ListeEquipe lstEquipe){
		System.out.println("Nom de l'équipe:");
		@SuppressWarnings("resource")
		String strEquipe = new Scanner(System.in).next();
		
		boolean blnValidation = false;
		int intIndexEquipe = -1;
		for(int k=0;k<lstEquipe.getNbreElements();k++){
			if (strEquipe.toUpperCase().equals(lstEquipe.getLstEquipe()[k].getStrNom().toUpperCase())){
				blnValidation = true;
				intIndexEquipe = k;
			}				
		}
		
		if (blnValidation == true){			
			
			lstEquipe.getLstEquipe()[intIndexEquipe].afficherListeJoueurs();
		}
		else
			System.out.println("\nÉquipe inexistante");
	}
	
	private  void listerJoueursPosition (ListeJoueur lstJoueur){
		System.out.println("Position de joueur:");
		@SuppressWarnings("resource")
		String strPosition = new Scanner(System.in).next();
		
		boolean blnValide = false;
		for(PositionJoueur nomPosi : PositionJoueur.values()){
			if(strPosition.toUpperCase().equals(nomPosi.toString()))
				blnValide = true;
		}
		
		if (blnValide == true){
			for(int d=0; d<lstJoueur.getNbreElements();d++){
				if(PositionJoueur.valueOf(strPosition.toUpperCase()).equals(lstJoueur.getLstJoueur()[d].getPosition())){
					System.out.println(lstJoueur.getLstJoueur()[d].toString());
				}
			}
		}
		else
			System.out.println("Position inexistante\n");
	}
	
	private void listerJoueursPoidsDecroissant (ListeJoueur lstJoueur){
		for (int w = 0;w < lstJoueur.getNbreElements();w++){
			System.out.println(lstJoueur.getLstJoueur()[w].toString());
		}
	}
	
	private void changerEquipe(ListeEquipe lstEquipe, ListeJoueur lstJoueur) {
		System.out.println("Nom de l'équipe:");
		@SuppressWarnings("resource")
		String strEquipe = new Scanner(System.in).next();
		
		System.out.println("Numéro du joueur:");
		@SuppressWarnings("resource")
		int intNumero = new Scanner(System.in).nextInt();
		
		if(lstEquipe.trouver(strEquipe) != null){
			if(lstJoueur.trouver(intNumero) != null){
				System.out.println("Nom de la nouvelle équipe:");
				@SuppressWarnings("resource")
				String strNouvelleEquipe = new Scanner(System.in).next();
				
				Joueur objJoueurDéplacer = lstJoueur.trouver(intNumero);
				
				if(lstEquipe.trouver(strNouvelleEquipe) != null)
				{
					for (int s=0;s<lstJoueur.getNbreElements();s++){
						if(lstJoueur.trouver(intNumero).equals(lstJoueur.getLstJoueur()[s])){
							lstJoueur.getLstJoueur()[s].getEquipe().supprimerJoueur(lstJoueur.getLstJoueur()[s]);
							
							lstEquipe.trouver(strNouvelleEquipe).ajouterJoueur(objJoueurDéplacer);
							
							lstJoueur.getLstJoueur()[s].setEquipe(lstEquipe.trouver(strNouvelleEquipe));
						}
					}
				}
				else
					System.out.println("Nouvelle équipe inexistant");
					
			}
			else
				System.out.println("joueur inexistant");
		}
		else
			System.out.println("Équipe inexistante");
	}
	
	private boolean quitter(){
		System.out.println("Voulez-vous vraiment quitter? :(");
		
		boolean blnQuitter;
		@SuppressWarnings("resource")
		String strReponse = new Scanner(System.in).next();
		
		if (strReponse.compareTo("oui") == 0)
			blnQuitter = true;
		else
			blnQuitter = false;
		return blnQuitter;
	}
}
