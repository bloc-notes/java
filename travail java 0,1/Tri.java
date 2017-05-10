
public class Tri {
	
	// tri par insertion
	
 public static  int[] triInsertion( int[] intTabNombres){
		
		// d�claration 
		int[] intTabTrie = null;
		int intNbElementsTries= 0;
		int intPlaceInsertion;
		boolean blnPlaceTrouve ;
		intTabTrie = new int[intTabNombres.length];
		
		// pour chaque �l�ment du tableau re�u en argument
		
		for ( int i =0; i<intTabNombres.length; i++ ){
			// rechercher la position dans le tableau tri�
			intPlaceInsertion= 0;
			blnPlaceTrouve = false;
			while ( intPlaceInsertion < intNbElementsTries && !blnPlaceTrouve) {
				
				// v�rifier si c'est l'endroit pour ins�rer sinon avancer
				if ( intTabNombres[i]< intTabTrie[intPlaceInsertion])
					blnPlaceTrouve= true ;
					else
						intPlaceInsertion++;			
			}
			
		  
			// d�caler en commen�ant par la fin
			for( int j = intNbElementsTries-1; j>= intPlaceInsertion; j--){
				intTabTrie[j+1]= intTabTrie[j];
			}
			
			
			// ajouter la valeur au bon endroit
			intTabTrie [intPlaceInsertion]= intTabNombres[i];
			
			// augmenter le nombre d'�l�ments de 1
					
			intNbElementsTries++;		
		}		
		return intTabTrie;	
	}
	
 
 // tri par selection
 
 
public static void triSelection( int[] intTabNombres){

    int intTemporaire ;     // Pour �changer deux �l�ments
    int  intIndiceDebut ;      // Indice � partir duquel on recherche le plus petit
    int intpetit;           // Valeur du plus petit
    int  intIndicePetit=0 ;      // Indice o� on a trouv� le plus petit
    int  intRecherche;           //Indice pour le for de la recherche du plus petit
    
    for ( intIndiceDebut = 0; intIndiceDebut< intTabNombres.length-1; intIndiceDebut++) {
   // Trouver le plus petit pour le d�placer en position iIndiceDebut
       
       intpetit = Integer.MAX_VALUE;            // initialiser recherche du plus petit
       for (intRecherche = intIndiceDebut;intRecherche<intTabNombres.length;intRecherche++)  {   // Balayer la partie non tri�e
        if (intTabNombres[intRecherche] < intpetit){
            intpetit = intTabNombres[intRecherche] ;      // Valeur du plus petit
            intIndicePetit = intRecherche ;}               //Indice du plus petit
    
       }
    //faire l'�change pour mettre le plus petit � l'indice iIndiceDebut
    intTemporaire = intTabNombres[intIndiceDebut];
    intTabNombres[intIndiceDebut] = intTabNombres[intIndicePetit];
    intTabNombres[intIndicePetit] = intTemporaire;
    }
    
}


public static void triBulle( int[] intTabNombres){
	
	boolean blnTabTrie=false;
	while (!blnTabTrie){
		
		blnTabTrie=true;
		for(int i =0;i<intTabNombres.length-1;i++)
			if (intTabNombres[i] >intTabNombres[i+1]){
				int intTemp = intTabNombres[i];
				intTabNombres[i]= intTabNombres[i+1];
				intTabNombres[i+1]= intTemp;
				blnTabTrie= false;	
			}
		
	}
}

//  utiliser la recherche dichotomique

public static int  trouverElement( int[] intTabNombres, int intValeur){
	boolean  blnTrouve ; 
	int intRetour;
	int intBinf = 0;
	int intBsup = intTabNombres.length-1;
    int intNbComparaison = 0;
	int  intMilieu= -1 ;      // indice central (valeur compar�e)
                                  
   int intPasTrouve = -1; 

     // valeur hors limites en cas d'�chec
     blnTrouve = false ;          // pas trouv� jusqu'� preuve du contraire

     while (intBinf <= intBsup && !blnTrouve){
    	 intNbComparaison++;
         intMilieu = (intBinf + intBsup) / 2 ;   // moyenne enti�re
         if (intTabNombres[intMilieu]== intValeur ){
         blnTrouve = true ;   // on a trouve 
         }
         else
        	 if (intTabNombres[intMilieu]>intValeur )
        		 intBsup = intMilieu - 1;
        	 else
        		 intBinf = intMilieu + 1;
         
     } 	 
     if (blnTrouve) intRetour = intMilieu;
     else intRetour = intPasTrouve;
     System.out.println(" nombre comparaisons = " + intNbComparaison);
	return intRetour;
}


public static void main(String[] args) {
	int intTab[] = {-1,4,8,-3,10,-15};
	//intTab = triInsertion(intTab);
	triSelection(intTab);
	for (int i=0; i<intTab.length;i++){
		System.out.print(intTab[i]+ " " );
	}
	System.out.println();
	//System.out.println(trouverElement(intTab, -3));
	//System.out.println(trouverElement(intTab, 100));
}
}





	
}
}
