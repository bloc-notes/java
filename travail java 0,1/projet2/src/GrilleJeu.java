import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class GrilleJeu {
	// Variable qui contienne le contenue du fichier
	private int intLigne;
	private int intColonne;
	private char TabChrGrille[][];
	private ArrayList<String> alMots = new ArrayList<String>();
	private ArrayList<Mot> alObjMot = new ArrayList<Mot>();

	// lecture du fichier contenant la grille, les mots et les dimentions
	public GrilleJeu(String strNomFichier) {
		BufferedReader brFichier = null;
		try {
			brFichier = new BufferedReader(new FileReader(strNomFichier));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		String strLigne;
		StringTokenizer st;
		try {
			strLigne = brFichier.readLine();
			st = new StringTokenizer(strLigne, ",");

			intLigne = Integer.parseInt(st.nextToken().trim());
			intColonne = Integer.parseInt(st.nextToken().trim());

			TabChrGrille = new char[intLigne][intColonne];

			for (int q = 0; q < intLigne; q++) {
				strLigne = brFichier.readLine();
				st = new StringTokenizer(strLigne, " ");
				for (int w = 0; w < intColonne; w++) {
					TabChrGrille[q][w] = st.nextToken().toUpperCase().charAt(0);
				}
			}

			while ((strLigne = brFichier.readLine()) != null) {
				if (!(strLigne.trim().equals(""))) {
					alMots.add(strLigne.toUpperCase().trim());
				}
			}
		} catch (Exception e) {
			// rien
		}
	}

	// Trouve les mots et les stocks
	public void RechercheMot() {
		boolean booFiniRecherche;
		for (int f = 0; (f < alMots.size()) && (alMots.get(f) != null); f++) {
			booFiniRecherche = false;
			for (int m = 0; (m < intLigne) && (booFiniRecherche == false); m++) {
				for (int n = 0; (n < intColonne) && (booFiniRecherche == false); n++) {
					int intIndiceMot = 0;
					// recherche première lettre du mot
					if (alMots.get(f).charAt(intIndiceMot) == TabChrGrille[m][n]) {
						DirectionMot dm;

						intIndiceMot++;

						// recherche direction mot
						for (int h = 0; (h < (DirectionMot.values().length)) && (booFiniRecherche == false); h++) {
							try {
								dm = DirectionMot.values()[h];
								int intPossibleDirectionL = m + dm.getIntLigne();
								int intPossibleDirectionC = n + dm.getIntColonne();
								intIndiceMot =  1;

								for (; (intIndiceMot < alMots.get(f).length()) && (TabChrGrille[intPossibleDirectionL]
										[intPossibleDirectionC] == alMots.get(f).charAt(intIndiceMot)); intIndiceMot++) {
									// Mot trouver et entreposé dans liste
									if (intIndiceMot + 1 == alMots.get(f).length()) {
										Mot motEntreposer = new Mot(alMots.get(f), dm, m, n);
										alObjMot.add(motEntreposer); 
										booFiniRecherche = true;
									}
									intPossibleDirectionL += dm.getIntLigne();
									intPossibleDirectionC += dm.getIntColonne();
								}								
							} catch (ArrayIndexOutOfBoundsException a) {
								// Sortie du tableau
							}
						}
					}
				}
			}
		}
	}

	// Barre les mots pour trouver mots mystères
	public String BarreMot() {
		//Barre mot
		for (int c = 0; c < alObjMot.size(); c++) {
			int intPotitionLigne = alObjMot.get(c).getIntPositionLigne();
			int intPotitionColonne = alObjMot.get(c).getIntPositionColonne();
			for (int k = 0; k < alObjMot.get(c).getStrMots().length(); k++) {
				TabChrGrille[intPotitionLigne][intPotitionColonne] = '*';

				intPotitionLigne += alObjMot.get(c).getDirection().getIntLigne();
				intPotitionColonne += alObjMot.get(c).getDirection().getIntColonne();
			}
		}
		//Trouve mots magiques
		String strMotsMagiques = "";
		
		for (int a = 0; a < intLigne; a++) {
			for (int s = 0; s < intColonne; s++) {
				strMotsMagiques += (TabChrGrille[a][s] != '*') ? TabChrGrille[a][s] : "";
			}
		}
		return(strMotsMagiques);
	}
	//affiche les résultats demander
	public void Affiche(String strMotsMagiques) {
		for (int u = 0; u < alObjMot.size(); u++) {
			System.out.println("Nom: " + alObjMot.get(u).getStrMots().toLowerCase() + " Point de départ: " + 
					alObjMot.get(u).getIntPositionLigne() + ","+ alObjMot.get(u).getIntPositionColonne() +
					" Sens: " + alObjMot.get(u).getDirection());
		}
		
		System.out.println();
		
		for (int a = 0; a < intLigne; a++) {
			
			for (int s = 0; s < intColonne; s++) {
				System.out.print(TabChrGrille[a][s] + " ");
			}
			System.out.println();
		}

		System.out.println("\nLe phrase mystère est: " + strMotsMagiques.toLowerCase());
	}
}