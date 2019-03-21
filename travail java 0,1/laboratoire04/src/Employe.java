
public abstract class Employe {
	private String strPrenom;
	private String strNomFamille;
	
	public Employe(String strPrenom, String strNomFamille) {
		this.strPrenom = strPrenom;
		this.strNomFamille = strNomFamille;
	}

	public String getStrPrenom() {
		return strPrenom;
	}

	public String getStrNomFamille() {
		return strNomFamille;
	}
	
	public abstract double gains();
}