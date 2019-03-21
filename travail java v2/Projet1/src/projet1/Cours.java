package projet1;

public class Cours {
	
	private String strSigle; //sigle du cours ex : 420-2P6-GG
	private String strDescription; //description du cours ex: Programmation Objet I
	private Etudiant[]tabEtudiants ; //tableau de r�f�rences d�objets Etudiants inscrits au cours
	private int intNbreEtudiants; //nombre d��tudiants inscrits au cours.
	private int intNbreMax; //nombre maximum d��tudiants pour le cours.
	
	public Cours(String strSigle, String strDescription, int intNbreEtudiants, int intNbreMax) {
		this.strSigle = strSigle;
		this.strDescription = strDescription;
		this.intNbreEtudiants = intNbreEtudiants;
		this.intNbreMax = intNbreMax;
		tabEtudiants = new Etudiant[intNbreMax];
	}

	@Override
	public String toString() {
		return "Sigle du Cours: " + strSigle + "\nDescription: " + strDescription + "\nNombre d��tudiants inscrits: "
				+ intNbreEtudiants + "\nNombre maximum: " + intNbreMax + "\n";
	}

	public String getStrSigle() {
		return strSigle;
	}
	
	public void afficherListeEtudiant(){
		if(intNbreEtudiants == 0){
			System.out.println("[Probl�me]Aucun �tudiant inscrit au cours!");
		}
		else {
			for(int r=0;r<intNbreEtudiants;r++){
				System.out.println(tabEtudiants[r].toString());
			}
		}
	}
	
	public void ajouterEtudiant (Etudiant etu){
		boolean booDejaInscrit = false;
		
		for(int k=0;k<intNbreEtudiants;k++){
			if(tabEtudiants[k].equals(etu))
				booDejaInscrit = true;
		}
		
		if(booDejaInscrit)
			System.out.println("[Probl�me]L'�tudiant fait d�j� partie du cours!");
		else{
			etu.setTabCours(this,true);
			tabEtudiants[intNbreEtudiants] = etu;
			intNbreEtudiants++;
			
			System.out.println("�tudiant ajout�");
		}
	}
	
	public void supprimerEtudiant(Etudiant etu){
		boolean booSupprimable = false;
		
		for(int h=0;h<intNbreEtudiants;h++){
			//Enl�ve l'�tudiant du cours	
			if(tabEtudiants[h].equals(etu)){
				booSupprimable = true;
				
				for(int w=h;w<intNbreEtudiants;w++){
					tabEtudiants[w] = tabEtudiants[w+1];
				}
				
				tabEtudiants[intNbreEtudiants-1] = null;
				intNbreEtudiants--;
				
				//Enl�ve le cours pour l'�tudiant
				etu.setTabCours(this, false);
			}
		}
		
		if (booSupprimable) {
			System.out.println("Supprimer");	
		}
		else {
			System.out.println("[Probl�me]L'�tudiant n'�tait pas inscrit au cours!");
		}
	}


	public Etudiant[] getTabEtudiants() {
		return tabEtudiants;
	}

	public boolean setTabEtudiants(Etudiant objEtudiant) {
		if(intNbreMax == intNbreEtudiants){
			System.out.println("[Probl�me]Le cours est d�j� plein!");
			return false;
		}
		else {
			tabEtudiants[intNbreEtudiants] = objEtudiant;
			intNbreEtudiants++;
			System.out.println("Cours ajout�");
			return true;
		}	
	}

	public int getIntNbreEtudiants() {
		return intNbreEtudiants;
	}

	public int getIntNbreMax() {
		return intNbreMax;
	}
	
}
