
public class Employe {

	private String strPrenom;
	private String strNomFamille;
	private static int intNombre = 0;
	
	public Employe(String strPrenom, String strNomFamille) {
		this.strPrenom = strPrenom;
		this.strNomFamille = strNomFamille;
		
		intNombre++;
		
		System.out.println("Appel du constructeur\nPrénom: " + strPrenom + "\nNom de Famille: " + strNomFamille);
	}

	public String getStrPrenom() {
		return strPrenom;
	}

	public String getStrNomFamille() {
		return strNomFamille;
	}

	public static int getIntNombre() {
		return intNombre;
	}
	
	protected void finalize(){
		intNombre--;
		System.out.println("Appel du finalize\nPrénom: " + strPrenom + "\nNom de Famille: " + strNomFamille + "\nNombre: " + intNombre);
	}
	
}
