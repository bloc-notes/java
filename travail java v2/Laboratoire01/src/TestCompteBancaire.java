
public class TestCompteBancaire {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CompteBancaire objCompteBancaire = new CompteBancaire("Lebeau Martin", 12345, 1200.50);
		
		objCompteBancaire.retire(-45);
		objCompteBancaire.retire(2500);
		objCompteBancaire.retire(120);
		
		objCompteBancaire.depose(-20);
		objCompteBancaire.depose(150);
		
		objCompteBancaire.afficherInfoCompte();
	}

}
