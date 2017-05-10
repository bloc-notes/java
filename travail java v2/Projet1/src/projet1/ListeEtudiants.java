package projet1;

import java.io.*;
import java.util.StringTokenizer;

public class ListeEtudiants {
	private Etudiant lstEtudiants[]= new Etudiant[100];
	private int intNbreElements;
	
	public ListeEtudiants (String strNomFichier){
		BufferedReader brFichier = null;
		String strLigne;
		StringTokenizer st;
		Etudiant objEtudiant;
		int intDa;
		String strNom;
		String strProgramme;
		
		intNbreElements = 0;
		
		try {
			brFichier = new BufferedReader(new FileReader(strNomFichier));
		} catch (FileNotFoundException e) {

			e.printStackTrace();
		}
		
		try {

			while ((strLigne = brFichier.readLine()) != null) {
				st = new StringTokenizer(strLigne, ",");
				while (st.hasMoreTokens()) {
					intDa = Integer.parseInt(st.nextToken());
					strNom = st.nextToken().replaceAll("^\\s+", "");
					strProgramme = st.nextToken();
					
					for(EnumProgramme objProgramme: EnumProgramme.values()){
						if(objProgramme.getStrNomProgramme().equals(strProgramme)){
							objEtudiant = new Etudiant(intDa, strNom, objProgramme ,st.nextToken());
							inserer(objEtudiant);
						}
					}							
				}
			}
		} catch (Exception e) {
			// e.printStackTrace();
		}		
	}
	
	private void inserer (Etudiant objEtudiant){
		int intPlaceInsertion = 0;
		boolean blnPlaceTrouve = false;
		
		// pour chaque élément du tableau reçu en argument
		for (int i = 0; i < intNbreElements && !blnPlaceTrouve; i++) {
			// rechercher la position dans le tableau trié
			// vérifier si c'est l'endroit pour insérer sinon avancer
			try {
				if (lstEtudiants[i].getIntNumDA() > objEtudiant.getIntNumDA()) {
					blnPlaceTrouve = true;
					intPlaceInsertion = i;
				} else
					intPlaceInsertion = i + 1;
			} catch (Exception e) {
				// TODO: handle exception
				blnPlaceTrouve = true;
			}
		}

		// décaler en commençant par la fin
		for (int j = intNbreElements - 1; j >= intPlaceInsertion; j--) {
			lstEtudiants[j + 1] = lstEtudiants[j];
		}
		// ajouter la valeur au bon endroit
		lstEtudiants[intPlaceInsertion] = objEtudiant;

		intNbreElements++;
	}
	
	public Etudiant trouver (int intNumDA){
		boolean blnTrouve;
		Etudiant objEtudiant;
		int intBinf = 0;
		int intBsup = intNbreElements - 1;
		int intMilieu = -1; // indice central (valeur comparée)

		// valeur hors limites en cas d'échec
		blnTrouve = false; // pas trouvé jusqu'à preuve du contraire

		while (intBinf <= intBsup && !blnTrouve) {
			intMilieu = (intBinf + intBsup) / 2; // moyenne entière
			if (lstEtudiants[intMilieu].getIntNumDA() == intNumDA) {
				blnTrouve = true; // on a trouve
			} else if (lstEtudiants[intMilieu].getIntNumDA() > intNumDA)
				intBsup = intMilieu - 1;
			else
				intBinf = intMilieu + 1;
		}
		
		if (blnTrouve)
			objEtudiant = lstEtudiants[intMilieu];
		else
			objEtudiant = null;
		
		return objEtudiant;
	}

	public Etudiant[] getLstEtudiants() {
		return lstEtudiants;
	}

	public int getIntNbreElements() {
		return intNbreElements;
	}
}
