import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.StringTokenizer;


public class ListeUtilisateur {
	int intNbUtilisateur;
	String strStatut;
	
	HashMap<String, Utilisateur> mapListeUtilisateur = new HashMap<String, Utilisateur>();
	HashMap<String, ArrayList<String>> mapListeFichier = new HashMap<String, ArrayList<String>>();
	HashMap<String, String> mapStatutUtilisateur = new HashMap<String, String>();
	
	public ListeUtilisateur(){
		BufferedReader brFichier = null;
		try {
			brFichier = new BufferedReader(new FileReader("Utilisateurds.txt"));
		} 
		catch (FileNotFoundException e) {	
			e.printStackTrace();
			System.out.println("Erreur, un fichier système (Utilisateurds.txt) est absent");
		}
		String strLigne;
		StringTokenizer st;
		Utilisateur objUtilisateur;
		
		ListeFichierUtilisateur();
		
		try {		
			while ((strLigne = brFichier.readLine())!= null){
				st = new StringTokenizer(strLigne, ",");
				while (st.hasMoreTokens()) {
					String strNom = st.nextToken();
					String strPrenom = st.nextToken();
					String strStatut = st.nextToken();
					
					String strClef = Clef(strPrenom,strNom);
					
					if(st.countTokens() == 0){
						objUtilisateur = new Utilisateur(strNom, strPrenom);
					}
					else{
						objUtilisateur =new Utilisateur(strNom, strPrenom,st.nextToken(),mapListeFichier.get(strClef));
					}
					
					mapListeUtilisateur.put(strClef, objUtilisateur);
					mapStatutUtilisateur.put(strClef, strStatut);
					
					intNbUtilisateur++;
				}	    
			}   
		} 
		catch (Exception e) {

		}
	}
	
	//Construit les clefs pour le hashmap
	public String Clef(String strPrenom, String strNom){
		String strClef = "";
		int intNomComposer = 0;
		
		//cherche si le prénom est composé
		for(int x =0;x<strPrenom.length();x++){
			if(strPrenom.charAt(x) == '-'){
				intNomComposer++;
			}
		}
		
		if(intNomComposer != 0){
			StringTokenizer stNomComposer = new StringTokenizer(strPrenom,"-");
			
			for(int z=0;z<=intNomComposer;z++){
				strClef += stNomComposer.nextToken().charAt(0);
			}
		}
		else{
			strClef += strPrenom.charAt(0);
		}
		
		strClef += '.' + strNom;
		
		return strClef;
	}
	
	//Lecture fichier Fichiers.txt
	public void ListeFichierUtilisateur(){
		BufferedReader brFichier = null;
		try {
			brFichier = new BufferedReader(new FileReader("Fichiers.txt"));
		} 
		catch (FileNotFoundException e) {	
			e.printStackTrace();
			System.out.println("Erreur, un fichier système (Fichiers.txt) est absent");
		}
		
		String strLigne;
		StringTokenizer st;
		try {		
			while ((strLigne = brFichier.readLine())!= null){
				st = new StringTokenizer(strLigne, ",");
				String strClef = st.nextToken();
				mapListeFichier.put(strClef, ConstruitChemin(strLigne));
			} 
		}
		catch (Exception e) {

		}
	}
	
	//Construit liste fichier
	public ArrayList<String> ConstruitChemin(String strLigne){
		ArrayList<String> alFichierUtilisateur = new ArrayList<String>();
		alFichierUtilisateur.add(strLigne);
		
		
		String[] tabFichierDossier = strLigne.split(",");
		
		Path cheminRacine = Paths.get("D:\\PhilippeDoyonProjet3", tabFichierDossier[0]);
		for(int q=2;q<=tabFichierDossier.length;q=q+2){
			if(tabFichierDossier[q].equals("")){
				
				alFichierUtilisateur.add(cheminRacine.toString() + '\\' + tabFichierDossier[q-1]);
			}
			else{
				alFichierUtilisateur.add(cheminRacine.toString() + '\\' + tabFichierDossier[q] + '\\' + tabFichierDossier[q-1]);
			}
		}
		return alFichierUtilisateur;
	}

	public String getStrStatut() {
		return strStatut;
	}
}






















