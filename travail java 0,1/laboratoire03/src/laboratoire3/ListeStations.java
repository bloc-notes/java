package laboratoire3;
import java.io.*;
import java.util.*;

public class ListeStations {
private Station[] tabStation= new Station[200];
BufferedReader brFichier;
int intNbStations = 0;

	public ListeStations(String nomFichier){
	
		try {
			brFichier = new BufferedReader(new FileReader(nomFichier));
		} 
		catch (FileNotFoundException e) {	
			e.printStackTrace();
		}
		String strLigne;
		StringTokenizer st;
		Station station;
		try {		
			while ((strLigne = brFichier.readLine())!= null){
				st = new StringTokenizer(strLigne, ",");
				while (st.hasMoreTokens()) {	   
					station = new Station(st.nextToken(), st.nextToken(),Short.parseShort(st.nextToken().trim()));
				
					tabStation[intNbStations]= station;
					intNbStations++;
				}	    
			}   
		} 
		catch (Exception e) {

		}
	}
	public Station[] TriAltitudeDecroissant(){
				Station[] tabStationTrier;
				int intNbElementsTries= 0;
				int intPlaceInsertion;
				boolean blnPlaceTrouve ;
				
				tabStationTrier = new Station[intNbStations];
				
				for ( int i =0; i<intNbStations; i++ ){
					intPlaceInsertion= 0;
					blnPlaceTrouve = false;
					while ( intPlaceInsertion < intNbElementsTries && !blnPlaceTrouve) {
						
						if ( tabStation[i].getShAltitude() > tabStationTrier[intPlaceInsertion].getShAltitude())
							blnPlaceTrouve= true ;
							else
								intPlaceInsertion++;			
					}
									  
					for( int j = intNbElementsTries-1; j>= intPlaceInsertion; j--){
						tabStationTrier[j+1]= tabStationTrier[j];
						
					}
					tabStationTrier [intPlaceInsertion]= tabStation[i];
							
					intNbElementsTries++;	
				}			
				
				tabStation = tabStationTrier;
				return tabStation;
	}
	
	public Station[] TriProvince(){		
		Station objTemporaire;
	    int  intIndiceDebut;
	    int  intIndicePetit=0 ;
	    int  intRecherche;
	    String strpetit;     
	    
	    for ( intIndiceDebut = 0; intIndiceDebut< intNbStations; intIndiceDebut++) {
	    	strpetit = "ZZ";
	    	for (intRecherche = intIndiceDebut;intRecherche<intNbStations;intRecherche++)  {
	    		if (tabStation[intRecherche].getStrProvince().compareTo(strpetit)<0){
	    			strpetit = tabStation[intRecherche].getStrProvince() ;
	    			intIndicePetit = intRecherche ;
	            }
	       }
	    	objTemporaire = tabStation[intIndiceDebut];
		    tabStation[intIndiceDebut] = tabStation[intIndicePetit];
		    tabStation[intIndicePetit] = objTemporaire;
	    }
		
		return tabStation;		
	}
	public Station[] TriProvinceAltitudeCroissant(){
		
		Station objTempo;
		
		boolean booTerminer = false;
		int intFinTableau = intNbStations - 1;
		while (booTerminer == false){
			booTerminer = true;
			
			for(int r =0; r<intFinTableau;r++){
				Station objTraiter = tabStation[r];
				Station objSuivant = tabStation[r+1];
				Station objPrecedent = tabStation[r-1];
				if(objTraiter.getStrProvince().compareTo(objSuivant.getStrProvince())>0){
					objTempo = tabStation[r+1];
					tabStation[r+1] = tabStation[r];
					tabStation[r] = objTempo;
					
					booTerminer = false;
				}
				objTraiter = tabStation[r];
				//Fini moisa le gros
				if ((r != 0) && (objTraiter.getStrProvince().compareTo(objPrecedent.getStrProvince()) == 1) && ()){
					
				}
				/*if(objTraiter.getStrProvince().compareTo(objPrecedent.getStrProvince()) == 1){
					
				}
				*/
			}
			intFinTableau--;
		}
		
		return tabStation;
	}
	public void afficherstation(int intNbLignes){	
		for(int d=0; d<intNbLignes;d++){
			tabStation[d].afficherInfoStation();
		}
	}
}