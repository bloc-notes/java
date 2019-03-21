
public class Equipe {
private int intNbJoueurs=0;
private String strNom;
private String strEntraineur;
private Joueur[] tabJoueurs; 

public Equipe( int intNbJoueursMax, String strEntraineur, String strNom){
	this.strNom= strNom;
	this.strEntraineur= strEntraineur;
	tabJoueurs= new Joueur[intNbJoueursMax];	
}

public void ajouterJoueur(Joueur unJoueur){
	if (intNbJoueurs < tabJoueurs.length){
		tabJoueurs[intNbJoueurs]= unJoueur;
		intNbJoueurs= intNbJoueurs+1;}
}

public void listerJoueurs(){
	for (int i = 0; i<intNbJoueurs;i++){
		tabJoueurs[i].afficherInfoJoueur();
	}
	
	System.out.println("===============================================");
	for (Joueur unJoueur : tabJoueurs){
		if(unJoueur!=null)
		unJoueur.afficherInfoJoueur();
	}
}
}

