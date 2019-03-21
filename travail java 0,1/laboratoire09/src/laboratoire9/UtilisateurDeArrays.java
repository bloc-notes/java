package laboratoire9;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

import javax.security.sasl.AuthorizeCallback;

public class UtilisateurDeArrays {
	
	private int[] tabIntValeurs= {1,2,3,4,5,6};
	private double[] tabDoubleValeurs = {2.5,1.6,5.2,4.5,3.8};
	private int[] rempliDint;
	private int[] copieTabIntValeurs;
	private int[] autreCopieTabIntValeurs;
	
	public UtilisateurDeArrays() {	
		rempliDint = new int[10];
		copieTabIntValeurs = new int[tabIntValeurs.length];
		Arrays.fill(rempliDint, 8);
		Arrays.sort(tabDoubleValeurs);
		System.arraycopy(tabIntValeurs,0, copieTabIntValeurs, 0, tabIntValeurs.length);
		autreCopieTabIntValeurs = Arrays.copyOf(tabIntValeurs, tabIntValeurs.length);	
	}
	
	public void afficherTableaux(){
		System.out.println("tabDoubleValeurs: " + Arrays.toString(tabDoubleValeurs));
		System.out.println("tabIntValeurs: " + Arrays.toString(tabIntValeurs));
		System.out.println("rempliDint: " + Arrays.toString(rempliDint));
		System.out.println("copieTabIntValeurs avec System.arrayCopy: " + Arrays.toString(copieTabIntValeurs));
		System.out.println("autreCopieTabIntValeurs avec Arrays.copyOf(): " + Arrays.toString(autreCopieTabIntValeurs));
	}
	
	public int recherche(int valeur){
		return(Arrays.binarySearch(tabIntValeurs, valeur));
	}
	
	public void comparerTableaux(){
		System.out.println(Arrays.equals(tabIntValeurs, copieTabIntValeurs) ? "tabIntValeurs == copieTabIntValeurs" : "tabIntValeurs != copieTabIntValeurs");
		
		System.out.println(Arrays.equals(tabIntValeurs, rempliDint) ? "tabIntValeurs == rempliDint" : "tabIntValeurs != rempliDint" );
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		UtilisateurDeArrays objArr = new UtilisateurDeArrays();	
		objArr.afficherTableaux();
		objArr.comparerTableaux();
		int position = objArr.recherche(4);
		System.out.println((position>=0)?" 4 est trouvé à la position " + position : " 4 n'existe pas le tableau tabIntValeurs ");
		position = objArr.recherche(14);
		System.out.println((position>=0)?" 14 est trouvé à la position" + position : " 14 n'existe pas dans le tableau tabIntvaleurs" );
	}

}
