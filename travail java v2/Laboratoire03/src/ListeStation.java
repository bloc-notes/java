import java.util.StringTokenizer;
import java.io.*;

public class ListeStation {
	private Station[] tabStation = new Station[200];
	private int intNbStations = 0;
	BufferedReader brFichier;

	public ListeStation(String nomFichier) {

		try {
			brFichier = new BufferedReader(new FileReader(nomFichier));
		} catch (FileNotFoundException e) {

			e.printStackTrace();
		}
		String strLigne;
		StringTokenizer st;
		Station station;
		try {

			while ((strLigne = brFichier.readLine()) != null) {
				// System.out.println(strLigne);
				st = new StringTokenizer(strLigne, ",");
				while (st.hasMoreTokens()) {
					// remplir le tableau
					station = new Station(st.nextToken(), st.nextToken(), Short.parseShort(st.nextToken().trim()));
					tabStation[intNbStations] = station;
					intNbStations++;
				}
			}
		} catch (Exception e) {
			System.out.println(e.toString());
			// e.printStackTrace();
		}
	}

	public void triAltitudeDecroissant() {
		Station[] TabTrie = null;
		int intNbElementsTries = 0;
		int intPlaceInsertion;
		boolean blnPlaceTrouve;
		TabTrie = new Station[intNbStations];

		// pour chaque élément du tableau reçu en argument

		for (int i = 0; i < intNbStations; i++) {
			// rechercher la position dans le tableau trié
			intPlaceInsertion = 0;
			blnPlaceTrouve = false;
			while (intPlaceInsertion < intNbElementsTries && !blnPlaceTrouve) {

				// vérifier si c'est l'endroit pour insérer sinon avancer
				try {
					if (tabStation[i].getShAltitude() > TabTrie[intPlaceInsertion].getShAltitude())
						blnPlaceTrouve = true;
					else
						intPlaceInsertion++;
				} catch (Exception e) {
					// TODO: handle exception
					blnPlaceTrouve = true;
				}
			}

			// décaler en commençant par la fin
			for (int j = intNbElementsTries - 1; j >= intPlaceInsertion; j--) {
				TabTrie[j + 1] = TabTrie[j];
			}

			// ajouter la valeur au bon endroit
			TabTrie[intPlaceInsertion] = tabStation[i];

			// augmenter le nombre d'éléments de 1

			intNbElementsTries++;
		}

		tabStation = TabTrie.clone();
	}

	public void triProvinceCroissant() {
		Station objTemporaire; // Pour échanger deux éléments
		int intIndiceDebut; // Indice à partir duquel on recherche le plus petit
		String strPetit; // Valeur du plus petit
		int intIndicePetit = 0; // Indice où on a trouvé le plus petit
		int intRecherche; // Indice pour le for de la recherche du plus petit

		for (intIndiceDebut = 0; intIndiceDebut < intNbStations; intIndiceDebut++) {
			// Trouver le plus petit pour le déplacer en position iIndiceDebut

			strPetit = "ZZ"; // initialiser recherche du plus petit
			for (intRecherche = intIndiceDebut; intRecherche < intNbStations; intRecherche++) { // Balayer
																								// la
																								// partie
																								// non
																								// triée
				try {
					if (tabStation[intRecherche].getStrProvince().compareTo(strPetit) < 0) {
						strPetit = tabStation[intRecherche].getStrProvince(); // Valeur
																				// du
																				// plus
																				// petit
						intIndicePetit = intRecherche;
					} // Indice du plus petit
				} catch (Exception e) {
					// TODO: handle exception
				}
			}
			// faire l'échange pour mettre le plus petit à l'indice iIndiceDebut
			objTemporaire = tabStation[intIndiceDebut];
			tabStation[intIndiceDebut] = tabStation[intIndicePetit];
			tabStation[intIndicePetit] = objTemporaire;
		}
	}

	public void triProvinceAltitudeCroissant() {
		Boolean booNouveauPassage = false;
		Station staVariableTempo;
		do {
			booNouveauPassage = false;
			for (int q = 0; q < tabStation.length - 1; q++) {
				try {
					if (tabStation[q].getStrProvince().compareTo(tabStation[q + 1].getStrProvince()) > 0) {
						staVariableTempo = tabStation[q];
						tabStation[q] = tabStation[q + 1];
						tabStation[q + 1] = staVariableTempo;
						booNouveauPassage = true;
					} else if (tabStation[q].getStrProvince().compareTo(tabStation[q + 1].getStrProvince()) == 0
							&& tabStation[q].getShAltitude() > tabStation[q + 1].getShAltitude()) {
						staVariableTempo = tabStation[q];
						tabStation[q] = tabStation[q + 1];
						tabStation[q + 1] = staVariableTempo;
						booNouveauPassage = true;
					}
				} catch (Exception e) {
					// TODO: handle exception
				}
			}
		} while (booNouveauPassage);
	}

	// Recherche dicotomique (ajout exercice 3)
	/*
	 * Si le parametre envoyer est un short, la recherche ne fonctionne pas. Il
	 * faut envoyer un int
	 */
	public void rechercheDicotomiqueAltitudeDecroissant(short valeur) {
		triAltitudeDecroissant();

		boolean blnTrouve;
		int retour;
		int intBinf = 0;
		int intBsup = intNbStations - 1;

		int iMilieu = -1; // indice central (valeur comparée)
		// vrai lorsque trouvé
		int pasTrouve = -1;

		// valeur hors limites en cas d'échec
		blnTrouve = false; // pas trouvé jusqu'à preuve du contraire

		while (intBinf <= intBsup && !blnTrouve) {
			iMilieu = (intBinf + intBsup) / 2; // moyenne entière
			if (tabStation[iMilieu].getShAltitude() == valeur) {
				blnTrouve = true; // on a trouve
			} else if (tabStation[iMilieu].getShAltitude() < valeur)
				intBsup = iMilieu - 1;
			else
				intBinf = iMilieu + 1;

		}
		if (blnTrouve)
			retour = iMilieu;
		else
			retour = pasTrouve;

		// trouver les autre valeur égal
		int intIndexMin = retour;
		int intIndexMax = retour;

		for (int b = retour; (b < intNbStations)
				&& tabStation[retour].getShAltitude() == tabStation[b].getShAltitude(); b++) {
			intIndexMax = b;
		}

		for (int b = retour; (b > -1) && tabStation[retour].getShAltitude() == tabStation[b].getShAltitude(); b--) {
			intIndexMin = b;
		}
		String strMessageIntervale = intIndexMin == intIndexMax ? " qui ce trouve seulement a l'index: " + retour
				: " puis la valeur est présente entre :" + intIndexMin + " et " + intIndexMax;

		System.out.println("indice de l'objet rechercher " + retour + strMessageIntervale);
	}

	public void afficherStation(int intNbLignes) {
		for (int a = 0; a < intNbLignes; a++) {
			tabStation[a].afficherInfoStation();
			System.out.println(a);
		}
	}

}
