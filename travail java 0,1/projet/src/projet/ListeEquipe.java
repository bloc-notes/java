package projet;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.StringTokenizer;

public class ListeEquipe {
	private Equipe lstEquipe[] = new Equipe[50];
	private  int nbreElements;
	
	public ListeEquipe ( String strNomFichier){
	
		BufferedReader brFichier = null;
		try {
			brFichier = new BufferedReader(new FileReader(strNomFichier));
		} 
		catch (FileNotFoundException e) {	
			e.printStackTrace();
		}
		String strLigne;
		StringTokenizer st;
		Equipe objEquipe;
		try {		
			while ((strLigne = brFichier.readLine())!= null){
			
				st = new StringTokenizer(strLigne, ",");
				while (st.hasMoreTokens()) {	
					
					objEquipe = new Equipe(st.nextToken(),NomDivision.valueOf(st.nextToken().trim().toUpperCase()),
							Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken().trim()));
								
					inserer(objEquipe);
					nbreElements++;
				}	    
			}   
		} 
		catch (Exception e) {

		}		
	}
	
	private void inserer(Equipe objEquipe){
		int intPlaceInsertion;
		boolean blnPlaceTrouve;
		intPlaceInsertion= 0;
		blnPlaceTrouve = false;
		while ( intPlaceInsertion < nbreElements && !blnPlaceTrouve) {
			if ( objEquipe.getStrNom().compareTo(lstEquipe[intPlaceInsertion].getStrNom()) < 0){
				blnPlaceTrouve= true ;
			}
			else
				intPlaceInsertion++;			
			}							  
		for( int j = nbreElements-1; j>= intPlaceInsertion; j--){
			lstEquipe[j+1]= lstEquipe[j];				
		}
		lstEquipe[intPlaceInsertion]= objEquipe;
	}
	
	public Equipe trouver (String strNom){	     
	     for(int t=0;t<nbreElements;t++){
	    	 if(strNom.toUpperCase().equals(lstEquipe[t].getStrNom().toUpperCase())){
	    		 return lstEquipe[t];
	    	 }	    			 
	     }
	    
		return null;	
	}	

	public Equipe[] getLstEquipe() {
		return lstEquipe;
	}

	public int getNbreElements() {
		return nbreElements;
	}
}
