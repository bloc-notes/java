
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
			System.out.println("Erreur: retriat invalide\rNum�ro de compte: " + lngNumCompte + "\rMontant demand�: " + dblMontant + "$");
		}
		else {
			System.out.println("Fonds insuffisants\rNum�ro de compte: " + lngNumCompte + "\rMontant demand�: " + dblMontant + "$" + "\rMontant disponible: "
					+ dblBalance + "$");
		}
	}
	
	public void depose(double dblMontant){
		if(dblMontant >=0){
			dblBalance += dblMontant;
		}
		else{
			System.out.println("Erreur: d�pot invalide\rNum�ro de compte: " + lngNumCompte + "\rMontant du d�pot " + dblMontant + "$");
		}
	}
	
	public void afficherInfoCompte(){
		System.out.println("Num�ro de compte: " + lngNumCompte + "\rNom: " + strNomEtPrenom + "\rBalance: " + dblBalance + "$");
	}
}
