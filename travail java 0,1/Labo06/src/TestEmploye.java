
public class TestEmploye
	{

		public static void main(String[] args)
			{
				// TODO Auto-generated method stub
				Employe.getIntNombre();
				
				Employe emp1 = new Employe("Ronaldo", "Cristiano");
				Employe emp2 = new Employe("Mesut", "Ozil");
				Employe emp3 = emp1; // L'employe 3 ne passe jamais par la methode finalize
				
				emp1 = null;
				emp2 = null;
				
				System.gc();
				
				Employe.getIntNombre();
			}

	}
