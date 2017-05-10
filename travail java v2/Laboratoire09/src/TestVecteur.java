import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.StringTokenizer;
import java.util.Vector;

public class TestVecteur {
	Vector<Client> vClients;
	
	public TestVecteur(String strFichierTexte) {
		BufferedReader brFichier = null;
		try {
			brFichier = new BufferedReader(new FileReader(strFichierTexte));
		} catch (FileNotFoundException e) {

			e.printStackTrace();
		}
		String strLigne;
		StringTokenizer st;
		Client client;
		try {

			while ((strLigne = brFichier.readLine()) != null) {
				// System.out.println(strLigne);
				st = new StringTokenizer(strLigne, ",");
				while (st.hasMoreTokens()) {
					// remplir le tableau
					client = new Client(st.nextToken(), st.nextToken(), Integer.parseInt(st.nextToken().trim()), 
							new Adresse(st.nextToken(), st.nextToken(), st.nextToken()));
					vClients.addElement(client);
				}
			}
		} catch (Exception e) {
			System.out.println(e.toString());
			// e.printStackTrace();
		}
	}
	
	
	
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
