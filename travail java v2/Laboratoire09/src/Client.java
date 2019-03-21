
public class Client {
	String nom, prenom;
	int age;
	Adresse objAdresse;
	
	public Client(String nom, String prenom, int age, Adresse objAdresse) {
		this.nom = nom;
		this.prenom = prenom;
		this.age = age;
		this.objAdresse = objAdresse;
	}

	@Override
	public String toString() {
		return nom + ", " + prenom + "," + age + "\n" + objAdresse;
	}
}
