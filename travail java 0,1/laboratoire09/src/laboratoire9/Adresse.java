package laboratoire9;

public class Adresse {
	public Adresse(String adresse, String strVille, String strCodePostal) {
		super();
		this.Adresse = adresse;
		this.strVille = strVille;
		this.strCodePostal = strCodePostal;
	}
	public String Adresse;
	String strVille;
	String strCodePostal;

	public String toString() {
		return "Adresse: " + Adresse + ", " + strVille + ", " + strCodePostal;
	}
}