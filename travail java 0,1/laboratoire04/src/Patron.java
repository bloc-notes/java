
public class Patron extends Employe{
	private double dblSalaireHebdo;
	
	public Patron(String strPrenom, String strNomFamille, double dblSalaireHebdo) {
		super(strPrenom, strNomFamille);
		this.dblSalaireHebdo = dblSalaireHebdo;
		// TODO Auto-generated constructor stub
	}
	

	public double gains() {
		// TODO Auto-generated method stub
		return (dblSalaireHebdo);
	}
}