import java.io.*;
import java.util.*;

public class Grille {
	
	private ArrayList<Mot> arrrMots = new ArrayList<>();
	
	public Grille (String strNomfichier){
		BufferedReader brFichier = null;
		int intLongueurY = 0;
		int intLargeurX = 0;
		char[][] tabGrille = null;
		
		try {
			brFichier = new BufferedReader(new FileReader(strNomfichier));
		} catch (FileNotFoundException e) {

			e.printStackTrace();
		}
		String strLigne;
		StringTokenizer st;
		try {
			
			//Dimention de la grille
			strLigne = brFichier.readLine();
			st = new StringTokenizer(strLigne, ",");
			
			intLargeurX = Integer.parseInt(st.nextToken().trim());
			intLongueurY = Integer.parseInt(st.nextToken().trim());
			
			//Dimention donné au tableau
			tabGrille = new char [intLargeurX][intLongueurY];
			
			//lecture de la grille
			for(int q=0;q<intLongueurY;q++){
				strLigne = brFichier.readLine();
				st = new StringTokenizer(strLigne, " ");
				
				for(int w=0;w<intLargeurX;w++){
					tabGrille[w][q] = st.nextToken().charAt(0);
				}	
			}
			
			//lecture mots
			while ((strLigne = brFichier.readLine()) != null) {
				if(strLigne.trim().compareTo("") > 0){
					
					Mot objMot = new Mot(strLigne);
					arrrMots.add(objMot);
				}		
			}
			
		} catch (Exception e) {
			System.out.println(e.toString());
			// e.printStackTrace();
		}	
		
		// affichage grille pleine
		
		for(int q=0;q<intLongueurY;q++){
			
			for(int w=0;w<intLargeurX;w++){
				System.out.print(tabGrille[w][q] + " ");
			}
			System.out.println();
		}
		
		//Chaque mot
		for(int f=0;f<arrrMots.size();f++){
			//parcours la grille
			for(int j=0;j<intLongueurY;j++){
				for(int t=0;t<intLargeurX;t++){
					
					//Chaque direction
					for(Deplacement dep : Deplacement.values()){
						boolean booMotTrouver = true;
						int intXTempo = t;
						int intYTempo = j;
						try {
							//Possible piste
							for(int c=0;(c<arrrMots.get(f).getStrChaine().length()) && booMotTrouver;c++){
								if(Character.toLowerCase(tabGrille[intXTempo][intYTempo]) != Character.toLowerCase(arrrMots.get(f).getStrChaine().charAt(c))){
									booMotTrouver = false;
									//System.out.println(tabGrille[intYTempo][intXTempo] + " " +arrrMots.get(f).getStrChaine().charAt(c) + " " + arrrMots.get(f).getStrChaine());
									
								}
								else {
									intXTempo += dep.getSens().x;
									intYTempo += dep.getSens().y;
								}
							}
						} catch (Exception u) {
							// TODO: handle exception
							booMotTrouver = false;
						}
						
						if(booMotTrouver){							
							arrrMots.get(f).setObjPoint(t, j);
							arrrMots.get(f).setDire(dep);
						}
					}
				}
			}
		}
		
		//Bare mot
		for(Mot objMot: arrrMots){
			int intXDepart = objMot.getObjPoint().x;
			int intYDepart = objMot.getObjPoint().y;
			for(int b=0;b<objMot.getStrChaine().length();b++){
				tabGrille[intXDepart][intYDepart] = '-';
				
				intXDepart += objMot.getDire().getSens().x;
				intYDepart += objMot.getDire().getSens().y;
			}
		}
		
		//Affichage Grille barré
		System.out.println();
		for(int q=0;q<intLongueurY;q++){
			
			for(int w=0;w<intLargeurX;w++){
				System.out.print(tabGrille[w][q] + " ");
			}
			System.out.println();
		}		
		
		//Affichage Information mots
		System.out.println();
		for(int m=0;m<arrrMots.size();m++){
			System.out.println(arrrMots.get(m).toString());
		}
		
		//mot mystere
		
		StringBuilder sB = new StringBuilder();
		
		for(int q=0;q<intLongueurY;q++){
			
			for(int w=0;w<intLargeurX;w++){
				if(tabGrille[w][q] != '-')
					sB.append(tabGrille[w][q]);
			}
		}
		
		System.out.println("\nMot Mystère : " + sB.toString());	
	}	
}
