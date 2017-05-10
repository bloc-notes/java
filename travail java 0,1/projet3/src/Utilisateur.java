import java.util.ArrayList;

public class Utilisateur {
	String strNom;
	String strPrenom;
	String strMotDePasse;
	String strListeFichier;
	ArrayList<String> alFichierUtilisateur;
	
	public Utilisateur(String strNom, String strPrenom) {
		this.strNom = strNom;
		this.strPrenom = strPrenom;
	}

	public Utilisateur(String strNom, String strPrenom, String strMotDePasse, ArrayList<String> alFichierUtilisateur){
		this.strNom = strNom;
		this.strPrenom = strPrenom;
		this.strMotDePasse = strMotDePasse;
		this.alFichierUtilisateur = alFichierUtilisateur;
	}

	public String getStrNom() {
		return strNom;
	}

	public String getStrPrenom() {
		return strPrenom;
	}

	public String getStrMotDePasse() {
		return strMotDePasse;
	}

	public void setStrMotDePasse(String strMotDePasse) {
		this.strMotDePasse = strMotDePasse;
	}

	public ArrayList<String> getAlFichierUtilisateur() {
		return alFichierUtilisateur;
	}
}