
public class Etudiant {
	private int numDa;
	private String  nomEtPrenom;
	
	
public Etudiant(int numDa, String nomEtPrenom) {
		this.numDa = numDa;
		this.nomEtPrenom = nomEtPrenom;
	}


public int getNumDa() {
	return numDa;
}


public void setNumDa(int numDa) {
	this.numDa = numDa;
}


public String getNomEtPrenom() {
	return nomEtPrenom;
}


public void setNomEtPrenom(String nomEtPrenom) {
	this.nomEtPrenom = nomEtPrenom;
}

public String toString(){
	return "num Da " + numDa +" Nom et Prenom: " +  nomEtPrenom ;
	
}

}
