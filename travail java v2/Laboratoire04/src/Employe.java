
public abstract class Employe {
	private String prenom;
	private String nomFamille;
	
	public Employe(String prenom, String nomFamille) {
		this.prenom = prenom;
		this.nomFamille = nomFamille;
	}

	public String getPrenom() {
		return prenom;
	}

	public String getNomFamille() {
		return nomFamille;
	}
	
	public abstract double gains();
}
