
public class CompteBancaire {
	private String strNomEtPrenom;
	private long lngNumCompte;
	private double dblBalance;
	
	public CompteBancaire(String strNomEtPrenom, long lngNumCompte, double dblBalance) {
		super();
		this.strNomEtPrenom = strNomEtPrenom;
		this.lngNumCompte = lngNumCompte;
		this.dblBalance = dblBalance;
	}
	
	public double getBalance(){
		return dblBalance;
	}
	
	long getNumero(){
		return lngNumCompte;
	}
	
	String getNomEtPrenom(){
		return strNomEtPrenom;
	}
	
	public void retire(double dblMontant){
		if (dblMontant >=0 && dblMontant <= dblBalance) {
			dblBalance-=dblMontant;
			System.out.println("Nouvelle balance :" + dblMontant + "$");
		}
		else if (dblMontant<0) {
			System.out.println("Erreur: retriat invalide\rNuméro de compte: " + lngNumCompte + "\rMontant demandé: " + dblMontant + "$");
		}
		else {
			System.out.println("Fonds insuffisants\rNuméro de compte: " + lngNumCompte + "\rMontant demandé: " + dblMontant + "$" + "\rMontant disponible: "
					+ dblBalance + "$");
		}
	}
	
	public void depose(double dblMontant){
		if(dblMontant >=0){
			dblBalance += dblMontant;
		}
		else{
			System.out.println("Erreur: dépot invalide\rNuméro de compte: " + lngNumCompte + "\rMontant du dépot " + dblMontant + "$");
		}
	}
	
	public void afficherInfoCompte(){
		System.out.println("Numéro de compte: " + lngNumCompte + "\rNom: " + strNomEtPrenom + "\rBalance: " + dblBalance + "$");
	}
}
