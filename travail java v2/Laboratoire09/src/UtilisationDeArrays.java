import java.util.Arrays;

public class UtilisationDeArrays {
	

	private int[] tabIntValeurs= {1,2,3,4,5,6};
	private double[] tabDoubleValeurs = {2.5,1.6,5.2,4.5,3.8};
	private int[] rempliDint;
	private int[] copieTabIntValeurs;
	private int[] autreCopieTabIntValeurs;
	
	public UtilisationDeArrays() {
		
		rempliDint = new int[10];
		copieTabIntValeurs= new int[tabIntValeurs.length];
		Arrays.fill(rempliDint, 8);
		Arrays.sort(tabDoubleValeurs);
		System.arraycopy(tabIntValeurs, 0, copieTabIntValeurs, 0, tabIntValeurs.length);
		autreCopieTabIntValeurs = Arrays.copyOf(tabIntValeurs, tabIntValeurs.length);
		
		//La diff�rence entre System.arraycopy et Arrays.copyOf outre le fait qu'ils proviennent 
		//de classe diff�rente, System.arraycopy permet une meilleur maniabilit� des donn�es.
	}
	
	public void afficherTableau(){
		String strDV = "tabDoubleValeurs:";
		
		for(int intX=0;intX<tabDoubleValeurs.length;intX++){
			strDV += " " + tabDoubleValeurs[intX];
		}
		
		String strIV = "\ntabIntValeurs:";
		
		for(int intX=0;intX<tabIntValeurs.length;intX++){
			strIV += " " + tabIntValeurs[intX];
		}
		
		String strRD = "\nrempliDint:";
		
		for(int intX=0;intX<rempliDint.length;intX++){
			strRD += " " + rempliDint[intX];
		}
		
		String strCTIV = "\ncopieTabintValeurs avec System.arrayCopy():";
		
		for(int intX=0;intX<copieTabIntValeurs.length;intX++){
			strCTIV += " " + copieTabIntValeurs[intX];
		}
		
		String strACTIV = "\nautreCopieTabIntValeurs avec Arrays.copyOf():";
		
		for(int intX=0;intX<autreCopieTabIntValeurs.length;intX++){
			strACTIV += " " + autreCopieTabIntValeurs[intX];
		}
		
		System.out.println(strDV + strIV + strRD + strCTIV + strACTIV);
	}
	
	public void afficherTableauAvecToString(){
		System.out.println(Arrays.toString(tabDoubleValeurs));
		System.out.println(Arrays.toString(tabIntValeurs));
		System.out.println(Arrays.toString(rempliDint));
		System.out.println(Arrays.toString(copieTabIntValeurs));
		System.out.println(Arrays.toString(autreCopieTabIntValeurs));
	}
	
	public int rechercher(int valeur){
		return Arrays.binarySearch(tabIntValeurs, valeur);
	}
	
	public void comparerTableau(){
		System.out.println(Arrays.equals(tabIntValeurs, copieTabIntValeurs)?"tabIntValeurs==copieTabIntValeurs":"tabIntValeurs!=copieTabIntValeurs");
		System.out.println(Arrays.equals(tabIntValeurs, rempliDint)?"tabIntValeurs==rempliDint":"tabIntValeurs!=rempliDint");
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		UtilisationDeArrays app = new UtilisationDeArrays();
		app.afficherTableauAvecToString();
		app.comparerTableau();
		int position= app.rechercher(4);
		System.out.println((position>=0)?"4 est trouv� � la position " + position :"4 n'existe pas dans le tableau tabIntValeurs" );
		position= app.rechercher(14);
		System.out.println( (position>=0)?"14 est trouv� � la position " + position :"14 n'existe pas dans le tableau tabIntValeurs"); 
	}

}
