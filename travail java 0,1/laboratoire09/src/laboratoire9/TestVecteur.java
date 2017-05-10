package laboratoire9;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Iterator;
import java.util.StringTokenizer;
import java.util.Vector;

public class TestVecteur {
	Vector<Client> vClient = new Vector<>();

	public TestVecteur(String strFichier) {
		BufferedReader brFichier = null;
		try {
			brFichier = new BufferedReader(new FileReader(strFichier));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		String strLigne;
		StringTokenizer st;
		Client objClient = null;
		try {
			while ((strLigne = brFichier.readLine()) != null) {
				st = new StringTokenizer(strLigne, ",");
				Adresse objAdr;
				objClient = new Client(st.nextToken().trim(), st.nextToken().trim(),
						Integer.parseInt(st.nextToken().trim()),
						objAdr = new Adresse(st.nextToken().trim(), st.nextToken().trim(), st.nextToken().trim()));
				vClient.add(objClient);
			}
		} catch (Exception e) {

		}
	}

	public void afficherClients() {
		for (int x = 0; x < vClient.size(); x++) {
			System.out.println(vClient.get(x) + "\n");
		}
	}

	public void afficherClientsAvecIterateur() {
		for (Iterator<Client> it = vClient.iterator(); it.hasNext();) {
			System.out.println(it.next() + "\n");
		}
	}

	public Client TrouverClient(String nom) {
		Client objRep = null;
		for (Client objRechercher : vClient) {
			if (objRechercher.getStrNom().equals(nom)) {
				objRep = objRechercher;
			}
		}

		return objRep;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TestVecteur objTestVecteur = new TestVecteur("labo9.txt");

		objTestVecteur.afficherClients();
		objTestVecteur.afficherClientsAvecIterateur();
		System.out.println(objTestVecteur.TrouverClient("Client2"));
	}

}