
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Iterator;

public class DossierEtudiant {

	String nom;
	String prenom;
	String numeroTel;
	String programmeDEtude;

	public DossierEtudiant(String nom, String prenom, String numeroTel, String programmeDEtude) {
		this.nom = nom;
		this.prenom = prenom;
		this.numeroTel = numeroTel;
		this.programmeDEtude = programmeDEtude;
	}

	public String toString() {
		return nom + " " + prenom + ", " + numeroTel + ", " + programmeDEtude;
	}

	public static void main(String[] args) {
		DossierEtudiant a = new DossierEtudiant("Cristiano", "Ronaldo", "514-779-9872", "Real-Madrid");
		DossierEtudiant b = new DossierEtudiant("Gareth", "Bale", "514-233-4352", "Informatique");
		DossierEtudiant c = new DossierEtudiant("Phillipe", "Doyonn", "514-344-5433", "Comptabilite");
		DossierEtudiant d = new DossierEtudiant("Dave", "Brigaddy", "514-1145-2346", "Informatique");
		DossierEtudiant e = new DossierEtudiant("Keylor", "Navas", "514-654-2347", "Science-Nature");

		Hashtable<String, DossierEtudiant> maTable = new Hashtable<String, DossierEtudiant>();

		maTable.put("1111111", a);
		maTable.put("222222", b);
		maTable.put("3333333", c);
		maTable.put("444444", d);
		maTable.put("5555555", e);

		Enumeration<DossierEtudiant> elementsTable1 = maTable.elements();
		Enumeration<String> keys = maTable.keys();

		Iterator it = maTable.keySet().iterator();
		
		
		/*while (it.hasNext()) {
			System.out.println(it.next());
		}*/
		System.out.println("*****Avec enumeration*****");
		while (keys.hasMoreElements()) {
			String cle = keys.nextElement();
			System.out.println(cle + " - " + maTable.get(cle));
			
		}
		
		System.out.println("\n******Avec Iterator*****");
		while (it.hasNext()) {
			String cle2 = (String) it.next();
			System.out.println( cle2 + " - " + maTable.get(cle2));
			
		}
		

		 //System.out.println(maTable.keySet().iterator());
		/*while (elementsTable1.hasMoreElements()) {
			System.out.println(elementsTable1.nextElement());
		}
		
		while (elementsTable.hasMoreElements()) {
			System.out.println(elementsTable.nextElement());
		}*/
		
		/*while (elementsTable.hasMoreElements()) {
			System.out.println(elementsTable.nextElement() + maTable.get(elementsTable.nextElement()));
			
		}*/
	}

}
