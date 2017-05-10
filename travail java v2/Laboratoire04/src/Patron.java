
public class Patron extends Employe{
	private double salaireHebdo;
	
	public Patron(String prenom, String nomFamille, double salaireHebdo) {
		super(prenom, nomFamille);
		this.salaireHebdo = salaireHebdo;
	}
	
	public double gains() {
		return salaireHebdo;
	}
}