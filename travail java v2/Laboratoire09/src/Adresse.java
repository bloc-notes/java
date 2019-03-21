
public class Adresse {
	String rue, ville, codePostal;
	
	public Adresse(String rue, String ville, String codePostal) {
		this.rue = rue;
		this.ville = ville;
		this.codePostal = codePostal;
	}

	@Override
	public String toString() {
		return "adresse : " + rue + "," + ville + ", " + codePostal;
	}
}
