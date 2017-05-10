package laboratoire12;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class InfoEtudiant {

	public static void main(String[] args) throws FileNotFoundException, IOException {
		// TODO Auto-generated method stub
		InfoEtudiant objInfoE = new InfoEtudiant();
		
		objInfoE.ecrireDonnees();
		objInfoE.LireDonnees();
	}
	
	public void ecrireDonnees() throws IOException, FileNotFoundException{
		DataOutputStream fs = new DataOutputStream(new FileOutputStream("etudiant.dat"));
		
		Etudiant e1 = new Etudiant("Doyon     ", "Philippe  ");
		Etudiant e2 = new Etudiant("Drouin    ", "Mathieu   ");
		Etudiant e3 = new Etudiant("Sarasin   ", "Camille   ");
		
		//e1.setNotes(60.5, 75.6, 89.3);
		
		e1.ecrireEtudiant(fs);
		e2.ecrireEtudiant(fs);
		e3.ecrireEtudiant(fs);
		
		System.out.println("Données écrites");
		System.out.println(e1.toString());
		e2.toString();
		e3.toString();
	}
	
	public void LireDonnees() throws IOException, FileNotFoundException{
		DataInputStream fe = new DataInputStream (new FileInputStream("etudiant.dat"));
		
		Etudiant e1 = new Etudiant();
		Etudiant e2 = new Etudiant();
		Etudiant e3 = new Etudiant();
		
		e1.lireEtudiant(fe);
		e2.lireEtudiant(fe);
		e3.lireEtudiant(fe);
		
		System.out.println("Données écrites");
		e1.toString();
		e2.toString();
		e3.toString();	
	}

}
