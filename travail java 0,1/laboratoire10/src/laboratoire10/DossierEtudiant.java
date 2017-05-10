package laboratoire10;

public class DossierEtudiant {
	
	String strNom;
	String strPrenom;
	String strTelephone;
	String strProgrammeDEtude;
	
	public DossierEtudiant(String strNom, String strPrenom, String strTelephone, String strProgrammeDEtude) {
		super();
		this.strNom = strNom;
		this.strPrenom = strPrenom;
		this.strTelephone = strTelephone;
		this.strProgrammeDEtude = strProgrammeDEtude;
	}

	@Override
	public String toString() {
		return "DossierEtudiant [strNom=" + strNom + ", strPrenom=" + strPrenom + ", strTelephone=" + strTelephone
				+ ", strProgrammeDEtude=" + strProgrammeDEtude + "]";
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DossierEtudiant objDoss1 = new DossierEtudiant("Doyon", "Philippe", "438-395-6935", "Informatique");
		DossierEtudiant objDoss2 = new DossierEtudiant("Sashcov", "Ariel", "514-696-6666", "Technique à la survie humaine");
		DossierEtudiant objDoss3 = new DossierEtudiant("Ronaldo", "Cristiano","514-777-7777", "Real Madrid");
		DossierEtudiant objDoss4 = new DossierEtudiant("Doyon", "Alexandre", "514-663-6899", "Science nature");
		DossierEtudiant objDoss5 = new DossierEtudiant("Pilon", "Thali", "416-951-6230", "Science humaine");
		
		
	}
}
