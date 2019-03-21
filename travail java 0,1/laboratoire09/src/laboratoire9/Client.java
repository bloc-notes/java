package laboratoire9;

public class Client {
	
	public Client(String strNom, String strPrenom, int intAge, Adresse objAdresse) {
		super();
		this.strNom = strNom;
		this.strPrenom = strPrenom;
		this.intAge = intAge;
		this.objAdresse = objAdresse;
	}
	String strNom;
	String strPrenom;
	int intAge;
	Adresse objAdresse;

	public String toString() {
		return strNom + ", " + strPrenom + ", " + intAge + "\n" + objAdresse.toString();
	}

	public String getStrNom() {
		return strNom;
	}
}