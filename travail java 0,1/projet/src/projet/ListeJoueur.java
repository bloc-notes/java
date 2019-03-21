package projet;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.StringTokenizer;

public class ListeJoueur {
	private  Joueur lstJoueur[] = new Joueur[200];   //pour stocker les joueurs
	private  int nbreElements;    
	
	public ListeJoueur(String strNomFichier, ListeEquipe lstEquipe){
		BufferedReader brFichier = null;
		try {
			brFichier = new BufferedReader(new FileReader(strNomFichier));
		} 
		catch (FileNotFoundException e) {	
			e.printStackTrace();
		}
		String strLigne;
		StringTokenizer st;
		Joueur objJoueur;
		try {		
			while ((strLigne = brFichier.readLine())!= null){
			
				st = new StringTokenizer(strLigne, ",");
				while (st.hasMoreTokens()) {	
					
					objJoueur = new Joueur(Integer.parseInt(st.nextToken()), st.nextToken(), st.nextToken(), PositionJoueur.valueOf(st.nextToken().trim()
							.toUpperCase()),Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), lstEquipe.trouver(st.nextToken().trim()));
					
					lstJoueur[nbreElements] = objJoueur;
					nbreElements++;
					
					for (int a = 0; a< lstEquipe.getLstEquipe().length;a++){
						//454646
						if(objJoueur.getEquipe() == lstEquipe.getLstEquipe()[a])
						lstEquipe.getLstEquipe()[a].ajouterJoueur(objJoueur);
					}
				}	    
			}
			joueurDecroisant();
		} 
		catch (Exception e) {

		}
	}
	
	public Joueur trouver(int intNumChandail){
		for(int t=0;t<nbreElements;t++){
	    	 if(intNumChandail == (lstJoueur[t].getIntNumChandail())){
	    		 return lstJoueur[t];
	    	 }	    			 
	     }
	    
		return null;
	}
	
	private void joueurDecroisant(){
		Joueur objTemporaire;
	    int  intIndiceDebut;
	    int intpetit;
	    int  intIndicePetit=0;
	    int  intRecherche;
	    
	    for ( intIndiceDebut = 0; intIndiceDebut< nbreElements -1; intIndiceDebut++){	       
	       
	    	intpetit = Integer.MIN_VALUE;
	       for (intRecherche = intIndiceDebut;intRecherche<nbreElements;intRecherche++){
	    	   if (lstJoueur[intRecherche].getIntPoids() > intpetit){
	    		   intpetit = lstJoueur[intRecherche].getIntPoids();
	    		   intIndicePetit = intRecherche;}	    
	       }
	       
	    objTemporaire = lstJoueur[intIndiceDebut];
	    lstJoueur[intIndiceDebut] = lstJoueur[intIndicePetit];
	    lstJoueur[intIndicePetit] = objTemporaire;
	    }
	}

	public int getNbreElements() {
		return nbreElements;
	}

	public Joueur[] getLstJoueur() {
		return lstJoueur;
	}

	public void setLstJoueur(Joueur[] lstJoueur) {
		this.lstJoueur = lstJoueur;
	}
}
