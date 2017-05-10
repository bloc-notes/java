package projet1;

public class Etudiant {
	
	private int intNumDA ; //pour identification unique de l��tudiant
	private String strPrenomNom;//prenom et nom de l��tudiant
	private EnumProgramme programme;//Programme auquel l��tudiant est inscrit
	private String strDateAdmission; //en format AAAA ou AAAA-MM
	private Cours tabCours[]=new Cours[5];//l��tudiant peut �tre inscrit � 5 cours au maximum
	private int intNbreCours ; // nombre de cours effectivement suivis

	public Etudiant(int intNumDA, String strPrenomNom, EnumProgramme programme, String strDateAdmission) {
		this.intNumDA = intNumDA;
		this.strPrenomNom = strPrenomNom;
		this.programme = programme;
		this.strDateAdmission = strDateAdmission;
	}
	@Override
	public String toString() {
		return "Num�ro: " + intNumDA + "\nPr�nom et Nom: " + strPrenomNom + "\nProgramme: " + programme.getStrNomProgramme()
				+ "\nDate d'admission: " + strDateAdmission + "\n";
	}
	
	public void afficherListeCours(){
		if(intNbreCours != 0){
			System.out.println("Affiche liste cours pour l'�tudiant demand�.\n-------------------");
			for(int v=0;v<intNbreCours;v++){
				System.out.println(tabCours[v].toString() + "\n-------------------");
			}
		}
		else{
			System.out.println("[Probl�me]L'�tudiant n'est pas inscrit � un cours!");
		}
	}
	
	public void ajouterCours(Cours c){
		boolean booDejaInscrit = false;
		
		for(int k=0;k<intNbreCours;k++){
			if(tabCours[k].equals(c))
				booDejaInscrit = true;
		}
		
		if(booDejaInscrit)
			System.out.println("[Probl�me]L'�tudiant fait d�j� partie du cours!");
		else{
			if(c.setTabEtudiants(this)){
				tabCours[intNbreCours] = c;
				intNbreCours++;
			}
		}
		
	}
	
	public void supprimerCours (Cours c){
		/*
		boolean booSupprimable = false;
		
		for(int h=0;h<intNbreCours;h++){
			//Enl�ve le cours pour l'�tudiant
			if(tabCours[h].equals(c)){
				booSupprimable = true;
				
				for(int w=h;w<intNbreCours;w++){
					tabCours[w] = tabCours[w+1];
				}
				
				tabCours[intNbreCours-1] = null;
				intNbreCours--;
				
				//Enl�ve l'�tudiant du cours
				c.supprimerEtudiant(this);
			}
		}
		
		if (booSupprimable) {
			System.out.println("Supprimer\n-------------------");	
		}
		else {
			System.out.println("[Probl�me]L'�tudiant n'�tait pas inscrit au cours   !\n-------------------");
		}
		*/
		
		c.supprimerEtudiant(this);
	}

	public int getIntNumDA() {
		return intNumDA;
	}
	public Cours[] getTabCours() {
		return tabCours;
	}
	
	//booAction == vrai (ajoute) et faux (supprime)
	public void setTabCours(Cours objCours, boolean booAction) {
		if(booAction){
			tabCours[intNbreCours]=objCours;
			intNbreCours++;
		}
		else {
			for(int h=0;h<intNbreCours;h++){
				//Enl�ve le cours pour l'�tudiant
				if(tabCours[h].equals(objCours)){
					
					for(int w=h;w<intNbreCours;w++){
						tabCours[w] = tabCours[w+1];
					}
					
					tabCours[intNbreCours-1] = null;
					intNbreCours--;
				}
			}
		}
		
	}
	public int getIntNbreCours() {
		return intNbreCours;
	}
	public EnumProgramme getProgramme() {
		return programme;
	}
}
