
public class TravailleurPiece extends Employe{
	
	private double retributionParPiece;
	private int quantite;
	
	public TravailleurPiece(String prenom, String nomFamille, double retributionParPiece, int quantite) {
		super(prenom, nomFamille);
		this.retributionParPiece = retributionParPiece;
		this.quantite = quantite;
	}
	
	@Override
	public double gains() {
		// TODO Auto-generated method stub
		return quantite * retributionParPiece;
	}
}