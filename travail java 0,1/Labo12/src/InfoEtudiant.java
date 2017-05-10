import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class InfoEtudiant {

	public static void ecrireDonnees()throws IOException {
		DataOutputStream fs = new DataOutputStream(new FileOutputStream("etudiant.dat"));
		Etudiant e1 = new Etudiant("Ariel     ","Sashcov   ");
		Etudiant e2 = new Etudiant("Andy      ","Chen      ");
		Etudiant e3 = new Etudiant("Yacine    ","Sahli     ");
		
		e1.setNotes(99, 100, 86);
		e2.setNotes(99, 100, 80);
		e3.setNotes(90, 98, 90);
		
		e1.ecrireEtudiant(fs);
		e2.ecrireEtudiant(fs);
		e3.ecrireEtudiant(fs);
		
		System.out.println("Données Écrites");
		System.out.println(e1);
		System.out.println(e2);
		System.out.println(e3);
		
		fs.close();
	}
	
	public static void lireDonnees() throws IOException{
		DataInputStream fe = new DataInputStream(new FileInputStream("etudiant.dat"));
		Etudiant e1 = new Etudiant();
		
		System.out.println("\nDonnées Lues");
		e1.lireEtudiant(fe);
		System.out.println(e1);
		
		e1.lireEtudiant(fe);
		System.out.println(e1);
		
		e1.lireEtudiant(fe);
		System.out.println(e1);
		
		
		fe.close();
	}
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		ecrireDonnees();
		lireDonnees();
	}
}
