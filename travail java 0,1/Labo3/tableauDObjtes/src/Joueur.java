
public class Joueur {
private int intNumChandail;
private String strNom;
private String strPrenom;
private int intAge;
private int intPoids;

//constructeur
public Joueur( int intNumChandail, String strNom, String strPrenom,int intAge, int intPoids){
	this.intNumChandail= intNumChandail;
	this.strNom = strNom;
	this.strPrenom = strPrenom;
	this.intAge = intAge;
	this.intPoids = intPoids;
	
}
public void setPoids(int intSurcharge){
	intPoids = intPoids+ intSurcharge;
}

public void afficherInfoJoueur(){
	System.out.println(" nom: "+ strNom + " prenom: " +strPrenom);	
}
}
