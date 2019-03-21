
public class TestEmploye {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Nombre employé: " + Employe.getIntNombre());
		
		Employe emp1 = new Employe("Joe", "Lebeau");
		Employe emp2 = new Employe("Robert", "Lepetit");
		
		System.out.println("Nombre employé (1): " + emp1.getIntNombre() + "\nNombre employé (2): " + emp2.getIntNombre()
				+ "\nNombre employé (Classe): " + Employe.getIntNombre());
		
		//Employe emp3 = emp1;
		
		emp1 = null;
		emp2 = null;
		
		System.gc();
		
		System.out.println("Nombre employé (1): " + emp1.getIntNombre() + "\nNombre employé (2): " + emp2.getIntNombre()
		+ "\nNombre employé (Classe): " + Employe.getIntNombre());
		
		//En ajoutant emp3, l'objet emp1 n'est pas détruit, car emp3 fait référence a ceci.
	}

}
