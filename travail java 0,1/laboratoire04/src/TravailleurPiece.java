
public class TravailleurPiece extends Employe {
	private double dblRetributionParPiece;
	private int intQuantite;
	
	public TravailleurPiece(String strPrenom, String strNomFamille, double dblRetributionParPiece, int intQuantite) {
		super(strPrenom, strNomFamille);
		this.dblRetributionParPiece = dblRetributionParPiece;
		this.intQuantite = intQuantite;
	}
	
	
	public double gains() {
		// TODO Auto-generated method stub
		return (intQuantite * dblRetributionParPiece);
	}
	
	public static void main(String[] args) {
		Employe objEmployerP = new Patron("toto", "Doyon", 80000);
		System.out.println(objEmployerP.gains());
		
		Employe objEmployerEsclave = new TravailleurPiece("bobo", "cornichon", 40, 1);
		System.out.println((objEmployerEsclave.gains()));	
	}
}
