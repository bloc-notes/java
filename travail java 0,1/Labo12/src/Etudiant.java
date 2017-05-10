import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;

public class Etudiant {
	private String strNom;
	private String strPrenom;
	private float[] tabNotes = new float[3];

	public Etudiant(String strNom, String strPrenom) {
		// TODO Auto-generated constructor stub
		this.strNom = strNom;
		this.strPrenom = strPrenom;
		this.tabNotes[0] = 0;
		this.tabNotes[1] = 0;
		this.tabNotes[2] = 0;
	}

	public Etudiant() {
		// TODO Auto-generated constructor stub
		this.strNom = "          ";
		this.strPrenom = "          ";
		this.tabNotes[0] = 0;
		this.tabNotes[1] = 0;
		this.tabNotes[2] = 0;
	}

	public void setNotes(float fltNotes1, float fltNotes2, float fltNotes3) {
		this.tabNotes[0] = fltNotes1;
		this.tabNotes[1] = fltNotes2;
		this.tabNotes[2] = fltNotes3;
	}

	public void setNotes(float fltNotes, int intIndex) {
		this.tabNotes[intIndex] = fltNotes;
	}

	public void ecrireEtudiant(DataOutputStream fs) throws IOException {
		// fs = new DataOutputStream(new FileOutputStream("F:\\WorkSpace
		// Java\\Labo12\\fs.txt"));
		fs.writeChars(this.strNom);
		fs.writeChars(this.strPrenom);
		fs.writeFloat(this.tabNotes[0]);
		fs.writeFloat(this.tabNotes[1]);
		fs.writeFloat(this.tabNotes[2]);
	}

	public void lireEtudiant(DataInputStream fe) throws IOException {
		// fe = new DataInputStream(new FileInputStream("F:\\WorkSpace
		// Java\\Labo12\\fs.txt"));
		/*
		 * String strNom = null; for (int i = 1; i < 10; i++) { strNom +=
		 * fe.readChar(); }
		 */

		char charNom1 = fe.readChar();
		char charNom2 = fe.readChar();
		char charNom3 = fe.readChar();
		char charNom4 = fe.readChar();
		char charNom5 = fe.readChar();
		char charNom6 = fe.readChar();
		char charNom7 = fe.readChar();
		char charNom8 = fe.readChar();
		char charNom9 = fe.readChar();
		char charNom10 = fe.readChar();
		
		/*for (int i = 0; i < 9; i++) {
			strNom += fe.readChar();
		}*/

		strNom = Character.toString(charNom1) + Character.toString(charNom2) + Character.toString(charNom3)
				+ Character.toString(charNom4) + Character.toString(charNom5) + Character.toString(charNom6)
				+ Character.toString(charNom7) + Character.toString(charNom8) + Character.toString(charNom9)
				+ Character.toString(charNom10);


		
		/*for (int i = 0; i < 10; i++) {
			strPrenom += fe.readChar();
		}*/
		
		char charPrenom1 = fe.readChar();
		char charPrenom2 = fe.readChar();
		char charPrenom3 = fe.readChar();
		char charPrenom4 = fe.readChar();
		char charPrenom5 = fe.readChar();
		char charPrenom6 = fe.readChar();
		char charPrenom7 = fe.readChar();
		char charPrenom8 = fe.readChar();
		char charPrenom9 = fe.readChar();
		char charPrenom10 = fe.readChar();

		strPrenom = Character.toString(charPrenom1) + Character.toString(charPrenom2)
				+ Character.toString(charPrenom3) + Character.toString(charPrenom4) + Character.toString(charPrenom5)
				+ Character.toString(charPrenom6) + Character.toString(charPrenom7) + Character.toString(charPrenom8)
				+ Character.toString(charPrenom9) + Character.toString(charPrenom10);

		this.tabNotes[0] = fe.readFloat();
		this.tabNotes[1] = fe.readFloat();
		this.tabNotes[2] = fe.readFloat();
		

		/*Etudiant e1 = new Etudiant(strNom, strPrenom);
		e1.setNotes(fltNote1, fltNote2, fltNote3);

		return e1;*/
	}

	public String toString() {

		return "Nom: " + strNom + " Prénom: " + strPrenom + " Notes: " + tabNotes[0] + " " + tabNotes[1] + " "
				+ tabNotes[2];
	}

	public void lireDirectEtudiant(RandomAccessFile fa, int num) throws IOException {
		fa.seek(52*(num-1));
		
		char charNom1 = fa.readChar();
		char charNom2 = fa.readChar();
		char charNom3 = fa.readChar();
		char charNom4 = fa.readChar();
		char charNom5 = fa.readChar();
		char charNom6 = fa.readChar();
		char charNom7 = fa.readChar();
		char charNom8 = fa.readChar();
		char charNom9 = fa.readChar();
		char charNom10 = fa.readChar();
		
		strNom = Character.toString(charNom1) + Character.toString(charNom2) + Character.toString(charNom3)
		+ Character.toString(charNom4) + Character.toString(charNom5) + Character.toString(charNom6)
		+ Character.toString(charNom7) + Character.toString(charNom8) + Character.toString(charNom9)
		+ Character.toString(charNom10);
		
		char charPrenom1 = fa.readChar();
		char charPrenom2 = fa.readChar();
		char charPrenom3 = fa.readChar();
		char charPrenom4 = fa.readChar();
		char charPrenom5 = fa.readChar();
		char charPrenom6 = fa.readChar();
		char charPrenom7 = fa.readChar();
		char charPrenom8 = fa.readChar();
		char charPrenom9 = fa.readChar();
		char charPrenom10 = fa.readChar();
		
		strPrenom = Character.toString(charPrenom1) + Character.toString(charPrenom2)
		+ Character.toString(charPrenom3) + Character.toString(charPrenom4) + Character.toString(charPrenom5)
		+ Character.toString(charPrenom6) + Character.toString(charPrenom7) + Character.toString(charPrenom8)
		+ Character.toString(charPrenom9) + Character.toString(charPrenom10);
		
		this.tabNotes[0] = fa.readFloat();
		this.tabNotes[1] = fa.readFloat();
		this.tabNotes[2] = fa.readFloat();
		
	}
}
