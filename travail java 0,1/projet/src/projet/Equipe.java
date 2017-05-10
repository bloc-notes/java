package projet;

public class Equipe {
	private String strNom;
	private NomDivision nomDivision;
	private int intPoints;
	private Joueur[] tabJoueurs;
	private int intNbJoueurs = 0;
	
	public Equipe(String strNom, NomDivision nomDivision, int intPoints, int intNbJoueursMax){
		this.strNom = strNom;
		this.intPoints = intPoints;
		this.nomDivision = nomDivision;
		
		this.tabJoueurs = new Joueur[intNbJoueursMax];
	}
	
	public String toString() {
		return "\nNom: " + strNom + "\nDivision: " + nomDivision + "\nPoints: " + intPoints + "\nNombre de joueurs: " + intNbJoueurs;
	}
	
	/*
	 * Affiche la liste des joueurs de l’équipe
	 */
	public void afficherListeJoueurs(){
		for(int z=0; z< intNbJoueurs;z++){
			System.out.println(tabJoueurs[z].toString());
		}
	}
	
	/*
	 * Ajoute le joueur reçu en argument à la liste des joueurs 
	 */
	public void ajouterJoueur(Joueur j){
		if (intNbJoueurs <= tabJoueurs.length-1){
			tabJoueurs = this.getTabJoueurs();
			tabJoueurs[intNbJoueurs] = j;
			this.intNbJoueurs++;
		}
		else
			System.out.println("Équipe pleinne");
	}
	
	public void supprimerJoueur (Joueur j){
		int b = 0;
		for(; tabJoueurs[b] != j ;b++){			
		}
		for(; b < tabJoueurs.length -1;b++ ){
			tabJoueurs[b] = tabJoueurs[b+1];
		}
		tabJoueurs[tabJoueurs.length-1] = null;
		this.intNbJoueurs--;
	}

	public String getStrNom() {
		return strNom;
	}

	public NomDivision getNomDivision() {
		return nomDivision;
	}

	public int getIntPoints() {
		return intPoints;
	}

	public Joueur[] getTabJoueurs() {
		return tabJoueurs;
	}

	public int getIntNbJoueurs() {
		return intNbJoueurs;
	}
	
	
	
}