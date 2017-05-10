
public class TestCompteBancaire {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CompteBancaire objCompteBancaire = new CompteBancaire("Martin Lebeau", 12345, 1200.5);
		
		objCompteBancaire.retirer(-45);
		objCompteBancaire.retirer(2500);
		objCompteBancaire.retirer(120);
		
		objCompteBancaire.deposer(-20);
		objCompteBancaire.deposer(150);
		
		objCompteBancaire.afficherInfoCompte();
	}

}
