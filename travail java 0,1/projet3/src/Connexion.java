import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Iterator;
import java.util.Scanner;

public class Connexion {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		ListeUtilisateur objListeUtilisateur = new ListeUtilisateur();
		Demarrage(objListeUtilisateur);
		
		Initialisation(objListeUtilisateur);
	}
	
	public static void Demarrage(ListeUtilisateur objListeUtilisateur) throws IOException{
		//Détruit et recrée le dossier racine système
		Path cheminS = Paths.get("C:\\PhilippeDoyonProjet3");
		File objRacine = cheminS.toFile();
		
		deleteAll(objRacine);				
		
		Files.createDirectory(cheminS);
		
		//Crée (dossiers et fichiers des utilisateurs) et (liste utilisateur et fichier)
		
		Iterator<String> it = objListeUtilisateur.mapListeUtilisateur.keySet().iterator();
		
		while(it.hasNext()){
			String strClef = it.next();
			Path cheminUtilisateurR = Paths.get(cheminS.toString(),"\\" , strClef);
			Files.createDirectories(cheminUtilisateurR);			
			
			if(objListeUtilisateur.mapListeFichier.containsKey(strClef)){
				for(int b=1;b<objListeUtilisateur.mapListeFichier.get(strClef).size();b++){
					String[] tabChemin = objListeUtilisateur.mapListeFichier.get(strClef).get(b).split("\\\\");
					
					if(tabChemin.length == 4){
						Path cheminFichier = Paths.get(objListeUtilisateur.mapListeFichier.get(strClef).get(b));
						Files.createFile(cheminFichier);
					}
					else{
						for(int q=4;q<=tabChemin.length;q++){
							if(q == tabChemin.length){
								Path cheminFichier = Paths.get(objListeUtilisateur.mapListeFichier.get(strClef).get(b));
								Files.createFile(cheminFichier);
							}
							else{
								int intLongueur = 3;
								String strChemin = "";
								while(intLongueur!=q){
									strChemin+= '\\' + tabChemin[intLongueur];
									intLongueur++;
								}
								Path cheminMilieu = Paths.get(cheminUtilisateurR.toString(), strChemin);
								Files.createDirectories(cheminMilieu);
							}
						}
					}
				}	
			}
		}		
	}
	
	//
	@SuppressWarnings("resource")
	public static void Initialisation(ListeUtilisateur objListeUtilisateur){
		System.out.println("#############################################################################");
		System.out.println("                                Connexion");
		System.out.println("#############################################################################");
		
		String strClef = "";
		boolean boolDone = false;
		while(boolDone == false)
		{
			Scanner sc = new Scanner(System.in);	
			System.out.println("\nUtilisateur: \n");
			strClef = sc.nextLine();
			
			if(objListeUtilisateur.mapListeUtilisateur.containsKey(strClef))
			{
				if(objListeUtilisateur.mapListeUtilisateur.get(strClef).getStrMotDePasse()==null)
				{
				
					boolean boolMotDePasse = true;
					System.out.println("\n#############################################################################");
					System.out.println("                             Nouveau mot de passe");
					System.out.println("#############################################################################");
					Scanner scNouveauMDP = new Scanner(System.in);	
					System.out.println("\nNouveau mot de passe: \n");
					String strMDPNouveau = scNouveauMDP.nextLine();
					
					if(strMDPNouveau.equals(""))
					{
						System.out.println("\n#############################################################################");
						System.out.println("                           Mot de passe invalide!");
						System.out.println("#############################################################################");
						boolMotDePasse = false;
					}
					if(boolMotDePasse == true)
					{
						System.out.println("\nRetaper le nouveau mot de passe: \n");

						String strMDPN = scNouveauMDP.nextLine();	
					
						if (strMDPNouveau.equals(strMDPN))
						{
							System.out.println("\n#############################################################################");
							System.out.println("                      Nouveau mot de passe enresgistré...");
							System.out.println("#############################################################################");
							objListeUtilisateur.mapListeUtilisateur.get(strClef).setStrMotDePasse(strMDPNouveau);
							
							System.out.println("\nMot de Passe: \n");

							strMDPNouveau = scNouveauMDP.nextLine();	
							
						
							if(objListeUtilisateur.mapListeUtilisateur.get(strClef).getStrMotDePasse().equals(strMDPNouveau.trim()))
							{
								boolDone = true;
							}
							else
							{
								System.out.println("\n#############################################################################");
								System.out.println("                           Mot de passe invalide!");
								System.out.println("#############################################################################");
							}
						}
						else
						{
							System.out.println("\n#############################################################################");
							System.out.println("                           Mot de passe differents!");
							System.out.println("#############################################################################");
						}
					}
				}
				else
				{
					Scanner ss = new Scanner(System.in);	
					System.out.println("\nMot de Passe: \n");
					String scNouveauMDP = ss.nextLine();	
				
					if(objListeUtilisateur.mapListeUtilisateur.get(strClef).getStrMotDePasse().equals(scNouveauMDP.trim()))
					{
						boolDone = true;
					}
					else
					{
						System.out.println("\n#############################################################################");
						System.out.println("                           Mot de passe invalide!");
						System.out.println("#############################################################################");
					}
				}
			}
			else
			{
				System.out.println("\n#############################################################################");
				System.out.println("                           Utilisateur invalide!");
				System.out.println("#############################################################################");
			}
	
		}
		
		//Gestion Statut
		if(objListeUtilisateur.mapStatutUtilisateur.get(strClef).compareToIgnoreCase("utilisateur") == 0)
		{
			System.out.println("\n#############################################################################");
			System.out.println("                      Connexion en tant qu'Utilisateur");
			System.out.println("#############################################################################");
			
			MenuUtilisateur objMenuUti = new MenuUtilisateur(strClef, objListeUtilisateur);
			objMenuUti.DemareMenu();
		}
		else if(objListeUtilisateur.mapStatutUtilisateur.get(strClef).compareToIgnoreCase("administrateur") == 0)
		{
			System.out.println("\n#############################################################################");
			System.out.println("                     Connexion en tant qu'Administrateur");
			System.out.println("#############################################################################");
			
			MenuAdministrateur objMenuAdm = new MenuAdministrateur(strClef, objListeUtilisateur);
			objMenuAdm.DemareMenu();
		}
		else
		{
			System.out.println("\n#############################################################################");
			System.out.println("                            Status invalide!");
			System.out.println("#############################################################################");
		}
	}
	
	public static void deleteAll(File dir) {
		
        if (dir.isDirectory()) {
            File[] objEnfant = dir.listFiles();
            for (int i=0; i<objEnfant.length; i++) {
            	deleteAll(objEnfant[i]);
            }
        }
        dir.delete();
    }
}