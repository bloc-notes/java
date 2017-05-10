package laboratoire12;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public class Etudiant {
	String strNom;
	String strPrenom;
	float[] tabNotes = new float[3];
	
	public Etudiant(String strNom, String strPrenom) {
		this.strNom = strNom;
		this.strPrenom = strPrenom;
		this.tabNotes[0] = 0;
		this.tabNotes[1] = 0;
		this.tabNotes[2] = 0;
	}
	
	public Etudiant() {
		strNom = "";
		strPrenom = "";
		tabNotes[0] = 0;
		tabNotes[1] = 0;
		tabNotes[2] = 0;
	}
	
	public void setNotes(float fltValeur1, float fltValeur2, float fltValeur3){
		tabNotes[0] = fltValeur1;
		tabNotes[1] = fltValeur2;
		tabNotes[2] = fltValeur3;
	}
	
	public void setNotes(int intIndex, float fltValeur){
		tabNotes[intIndex] = fltValeur;
	}
	
	public void ecrireEtudiant (DataOutputStream fs) throws IOException{
		fs.writeChars(strNom);
		fs.writeChars(strPrenom);
		System.out.println(tabNotes[0]);
		fs.writeFloat(tabNotes[0]);
		fs.writeFloat(tabNotes[1]);
		fs.writeFloat(tabNotes[2]);
	}
	
	public void lireEtudiant(DataInputStream fe) throws IOException{
		for(int x =0; x<20;x++){
			if(x<=0 && x>=9){
				strNom += fe.readChar();
			}
			else{
				strPrenom+=fe.readChar();
			}
		}
	}

	@Override
	public String toString() {
		return "Nom: " + strNom + "Prénom: " + strPrenom + "Note: " + tabNotes[0] + " " + 
				tabNotes[1] + " " + tabNotes[2];
	}
}