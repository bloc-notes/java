package projet1;

import java.io.*;
import java.util.StringTokenizer;

public class ListeCours {
	private Cours lstCours[] = new Cours[50]; //pour stocker les cours
	private int intNbreElements; //nombre de cours dans le tableau
	
	public ListeCours ( String strNomFichier){
		BufferedReader brFichier = null;
		String strLigne;
		StringTokenizer st;
		Cours objCours;
		
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
					objCours = new Cours(st.nextToken(), st.nextToken().replaceAll("^\\s+", ""),
							Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
					
					lstCours[intNbreElements] = objCours;
					intNbreElements++;
				}
			}
		} catch (Exception e) {
			// e.printStackTrace();
		}
		triTableauCours();
	}
	
	//Tri-Bulle pour le tableau lstCours
	private void triTableauCours(){
		Boolean booNouveauPassage = false;
		Cours objCoursVariableTempo;
		do {
			booNouveauPassage = false;
			for (int q = 0; q < lstCours.length - 1; q++) {
				try {
					// StringTokenizer stSigle = new StringTokenizer(lstCours[q].getStrSigle(), "-");
					
					if (lstCours[q].getStrSigle().compareToIgnoreCase(lstCours[q + 1].getStrSigle()) > 0) {
						objCoursVariableTempo = lstCours[q];
						lstCours[q] = lstCours[q + 1];
						lstCours[q + 1] = objCoursVariableTempo;
						booNouveauPassage = true;
					} 

				} catch (Exception e) {
					// TODO: handle exception
				}
			}
		} while (booNouveauPassage);
	}
	
	public Cours trouver(String strSigle){
		boolean blnTrouve;
		Cours objCours;
		int intBinf = 0;
		int intBsup = intNbreElements - 1;
		int intMilieu = -1; // indice central (valeur comparée)

		// valeur hors limites en cas d'échec
		blnTrouve = false; // pas trouvé jusqu'à preuve du contraire

		while (intBinf <= intBsup && !blnTrouve) {
			intMilieu = (intBinf + intBsup) / 2; // moyenne entière
			if (lstCours[intMilieu].getStrSigle().compareToIgnoreCase(strSigle) == 0) {
				blnTrouve = true; // on a trouve
			} else if (lstCours[intMilieu].getStrSigle().compareToIgnoreCase(strSigle) > 0)
				intBsup = intMilieu - 1;
			else
				intBinf = intMilieu + 1;
		}
		
		if (blnTrouve)
			objCours = lstCours[intMilieu];
		else
			objCours = null;
		
		return objCours;
	}

	public Cours[] getLstCours() {
		return lstCours;
	}

	public int getIntNbreElements() {
		return intNbreElements;
	}
}
