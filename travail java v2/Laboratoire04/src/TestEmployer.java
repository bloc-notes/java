
public class TestEmployer {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Employe objEmployerP = new Patron("toto", "Doyon", 80000);
		System.out.println(objEmployerP.gains());
		
		Employe objEmployerE = new TravailleurPiece("bobo", "cornichon", 40, 2);
		System.out.println((objEmployerE.gains()));
	}
}