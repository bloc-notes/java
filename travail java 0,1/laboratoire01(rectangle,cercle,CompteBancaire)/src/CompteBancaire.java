
public class CompteBancaire {
	private String strNomEtPrenom;
	private long lngNumCompte;
	private double dblBalance;
	
	/*
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//CompteBancaire cb = new CompteBancaire("Bob Graton", 88057, 120);
			
	}*/
	
	public CompteBancaire(String strNomEtPrenom,long lngNumCompte, double dblBalance){
		this.strNomEtPrenom = strNomEtPrenom;
		this.lngNumCompte = lngNumCompte;
		this.dblBalance = dblBalance;
	}
	
	public double getBalance(){
		return dblBalance;
	}
	
	public long getNumero(){		
		return lngNumCompte;		
	}
	
	public String getNomEtPrenom(){
		return strNomEtPrenom;
	}
	
	public void retirer(double dblmontant){
		if(dblmontant < 0)
			System.out.println("Erreur: retrait invalide\rNuméro de compte: " + lngNumCompte + 
					"\rMontant demandé: " + dblmontant + "$");
		else if(dblmontant > dblBalance)
			System.out.println("Fond insuffisant\rNuméro de Compte: " + lngNumCompte + "\rMontant demandé: " 
					+ dblmontant + "$\rMontant disponible: " + dblBalance + "$");
		else {
			dblBalance = dblBalance - dblmontant;
			System.out.println("Nouvelle balance: " + dblBalance);
		}			
	}
	
	public void deposer(double dblmontant){
		if(dblmontant < 0)
			System.out.println("Erreur: dépôt invalide\rNuméro de compte: " + lngNumCompte + 
					"\rMontant du dépôt: " + dblmontant + "$");
		else{
			dblBalance = dblBalance + dblmontant;
			System.out.println("Nouvelle balance: " + dblBalance);
		}		
	}
	
	public void afficherInfoCompte(){
		System.out.println("Numéro de compte: " + lngNumCompte + "\rNom: " + strNomEtPrenom + "\rBalance: "
				+ dblBalance + "$");
		
	}
}
