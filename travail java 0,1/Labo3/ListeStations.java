
import java.io.*;
import java.util.*;

public class ListeStations {
private Station[] tabStation= new Station[200];
BufferedReader brFichier;
int intNbStations = 0;

// initialiser le tableau à partir des éléments du fichier
// dans le constructeur

public ListeStations(String nomFichier){

try {
	brFichier = new BufferedReader(new FileReader(nomFichier));
} catch (FileNotFoundException e) {
	
	e.printStackTrace();
}
String strLigne;
StringTokenizer st;
Station station;
try {
	
	
	while ((strLigne = brFichier.readLine())!= null){
		//System.out.println(strLigne);
	    st = new StringTokenizer(strLigne, ",");
	    while (st.hasMoreTokens()) {
	   
	    	// remplir le tableau
	     station = new Station(st.nextToken(), st.nextToken(),Short.parseShort(st.nextToken().trim()));
	     tabStation[intNbStations]= station;
	     intNbStations++;
	}
	    
	}   
} catch (Exception e) {
  System.out.println(e.toString());
	//e.printStackTrace();
}
} 

}
