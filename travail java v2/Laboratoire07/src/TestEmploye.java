
public class TestEmploye {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Nombre employ�: " + Employe.getIntNombre());
		
		Employe emp1 = new Employe("Joe", "Lebeau");
		Employe emp2 = new Employe("Robert", "Lepetit");
		
		System.out.println("Nombre employ� (1): " + emp1.getIntNombre() + "\nNombre employ� (2): " + emp2.getIntNombre()
				+ "\nNombre employ� (Classe): " + Employe.getIntNombre());
		
		//Employe emp3 = emp1;
		
		emp1 = null;
		emp2 = null;
		
		System.gc();
		
		System.out.println("Nombre employ� (1): " + emp1.getIntNombre() + "\nNombre employ� (2): " + emp2.getIntNombre()
		+ "\nNombre employ� (Classe): " + Employe.getIntNombre());
		
		//En ajoutant emp3, l'objet emp1 n'est pas d�truit, car emp3 fait r�f�rence a ceci.
	}

}
