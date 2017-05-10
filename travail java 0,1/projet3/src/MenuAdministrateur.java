import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Iterator;
import java.util.Scanner;
import java.util.regex.Pattern;

public class MenuAdministrateur {
	String strClef;
	ListeUtilisateur objListeUtilisateur;
	boolean booQuitter=false;
	
	public MenuAdministrateur(String strClef, ListeUtilisateur objListeUtilisateur) {
		this.strClef = strClef;
		this.objListeUtilisateur = objListeUtilisateur;
	}
	
	@SuppressWarnings("resource")
	public void DemareMenu(){
		while (booQuitter==false){
			System.out.println(	"\n**Tout modification du syst�me sera appliqu� au prochain d�marrage**\n\n1- Ajouter un nouvel utilisateur\n" + 
					"2- Supprimer un utilisateur\n" + "3- Lister les fichiers d'un utilisateur\n" + 
					"4- R�initialiser le mot de passe d'un utilisateur\n" + "5- Changer d'utilisateur\n" + "6- Quitter\n");
								 
			Scanner scChoix = new Scanner(System.in);	
			System.out.println("Entrer votre choix");
			String strRep = scChoix.nextLine();
			switch(strRep)
			{
				case "1": 
					AjouterUtilisateur();
					break;
				case "2":
					SupprimerUtilisateur();
					break;
				case "3": 
					AfficherListeFichier();
					break;
				case "4": 
					ReinitialiserMDP();
					break;
				case "5":
					ChangerUtilisateur();
					break;
				case "6":
					QuitterEtSauvegarder();
					break;
				
				default:System.out.println("\n#############################################################################");
						System.out.println("                              R�ponse invalide");
						System.out.println("#############################################################################");
						break;
			}
		}
	}
	
	//Ajoute utilisateur
	@SuppressWarnings("resource")
	private void AjouterUtilisateur(){
		System.out.println("\n#############################################################################");
		System.out.println("                         Cr�ation d'un utilisateur");
		System.out.println("#############################################################################");
		
		String strNom = "";
		Scanner sc = new Scanner(System.in);	
		System.out.println("\nDonner le nom de famille de l'utilisateur: \n");
		strNom = sc.nextLine();
		
		if((strNom.trim().equals(""))||Pattern.matches("[a-zA-Z]+", strNom) != true )
		{
			System.out.println("\n#############################################################################");
			System.out.println("                       Nom de famille invalide");
			System.out.println("#############################################################################");
		}
		else
		{
			String strPrenom = "";	
			System.out.println("\nDonner le pr�nom de l'utilisateur: \n");
			strPrenom = sc.nextLine();	
			
			if((strPrenom.trim().equals(""))||Pattern.matches("[a-zA-Z-]+", strPrenom) != true )
			{
				System.out.println("\n#############################################################################");
				System.out.println("                            Pr�nom invalide");
				System.out.println("#############################################################################");
			}
			else
			{
				System.out.println("\nDonner le statut de l'utilisateur: \n");
				String strStatut = sc.nextLine();
				
				if((strStatut.trim().compareToIgnoreCase("administrateur") == 0)||((strStatut.trim().compareToIgnoreCase("utilisateur") == 0)))
				{
					String strNouvelleClef = objListeUtilisateur.Clef(strPrenom, strNom);
					if(!objListeUtilisateur.mapListeUtilisateur.containsKey(strNouvelleClef))
					{
					System.out.println("\n#############################################################################");
					System.out.println("Cr�ation de l'utilisateur: \n"+ strNouvelleClef +"\n" + strPrenom + "\n"
							+ strNom + "\n" + strStatut);
					System.out.println("#############################################################################");
					
					Utilisateur objUtilisateur = new Utilisateur(strNom, strPrenom);
					objListeUtilisateur.mapListeUtilisateur.put(strNouvelleClef, objUtilisateur);
					objListeUtilisateur.mapStatutUtilisateur.put(strNouvelleClef, strStatut);
					}
					else
					{
						System.out.println("\n#############################################################################");
						System.out.println("                    Code d'utilisateur d�ja existant");
						System.out.println("#############################################################################");
					}
				}
				else
				{
					System.out.println("\n#############################################################################");
					System.out.println("                             Statut invalide");
					System.out.println("#############################################################################");
				}
			}
		}
	}
	
	//Supprime utilisateur
	@SuppressWarnings("resource")
	private void SupprimerUtilisateur(){
		String strClefSupprimer;
		System.out.println("\n#############################################################################");
		System.out.println("                          Supprimer un utilisateur");
		System.out.println("#############################################################################");
		
		Scanner sc = new Scanner(System.in);	
		System.out.println("\nDonner le clef de l'utilisateur: \n");
		strClefSupprimer = sc.nextLine();	
		
		if(!objListeUtilisateur.mapListeUtilisateur.containsKey(strClefSupprimer))
		{
			System.out.println("\n#############################################################################");
			System.out.println("                            Utilisateur invalide");
			System.out.println("#############################################################################");
		}
		else
		{
			System.out.println("\n�tes-vous s�r de vouloir supprimer : " + strClefSupprimer+"\n**Tout son r�pertoire sera supprim�**");
			String strConfirmation = sc.nextLine();
			
			if(strConfirmation.compareToIgnoreCase("oui") == 0){
				objListeUtilisateur.mapListeUtilisateur.remove(strClefSupprimer);
				if(objListeUtilisateur.mapListeFichier.containsKey(strClefSupprimer)){
					objListeUtilisateur.mapListeFichier.remove(strClefSupprimer);
				}
				objListeUtilisateur.mapStatutUtilisateur.replace(strClefSupprimer, "supprimer");

				System.out.println("\n#############################################################################");
				System.out.println("                          Utilisateur Supprimer");
				System.out.println("#############################################################################");
			}
			else{
				System.out.println("\n#############################################################################");
				System.out.println("                        Utilisateur pas Supprimer");
				System.out.println("#############################################################################");
			}
		}
	}
	
	@SuppressWarnings("resource")
	public void AfficherListeFichier(){
		String strClefTravaille;
		System.out.println("\n#############################################################################");
		System.out.println("                     Lister fichier d'un utilisateur");
		System.out.println("#############################################################################");
		
		Scanner sc = new Scanner(System.in);	
		System.out.println("\nDonner le code de l'utilisateur: \n");
		strClefTravaille = sc.nextLine();
		
		if(!objListeUtilisateur.mapListeFichier.containsKey(strClefTravaille))
		{
			System.out.println("\n#############################################################################");
			System.out.println("                      Utilisateur invalide ou pas de fichier");
			System.out.println("#############################################################################");
			
		}
		else
		{
			for(int o=1;o<objListeUtilisateur.mapListeUtilisateur.get(strClefTravaille).getAlFichierUtilisateur().size();o++){
				System.out.println(objListeUtilisateur.mapListeUtilisateur.get(strClefTravaille).getAlFichierUtilisateur().get(o));
			}
			
			System.out.println("\n#############################################################################");
			System.out.println("                             Op�ration �ffectuer				             ");
			System.out.println("#############################################################################");
		}
	}
	
	@SuppressWarnings("resource")
	private void ReinitialiserMDP(){
		System.out.println("#############################################################################");
		System.out.println("                     R�initialisation d'un mot de passe");
		System.out.println("#############################################################################");
		
		Scanner sc = new Scanner(System.in);	
		System.out.println("\nDonner le code de l'utilisateur: \n");
		String strClefTravaille = sc.nextLine();	
		
		if(!objListeUtilisateur.mapListeUtilisateur.containsKey(strClefTravaille))
		{
			System.out.println("\n#############################################################################");
			System.out.println("                        Utilisateur invalide");
			System.out.println("#############################################################################");
		}
		else
		{
			objListeUtilisateur.mapListeUtilisateur.get(strClefTravaille).setStrMotDePasse(null);;

			System.out.println("#############################################################################");
			System.out.println("                          Mot de passe r�initialis�");
			System.out.println("#############################################################################");
		}
	}
	
	public void ChangerUtilisateur(){
		System.out.println("\n#############################################################################");
		System.out.println("                           Changement d'utilisateur");
		System.out.println("#############################################################################");
		booQuitter = true;
		
		Connexion.Initialisation(objListeUtilisateur);
	}
	
	public void QuitterEtSauvegarder(){
		//r��criture fichier utilisateur
		try{
			BufferedWriter bw = new BufferedWriter(new FileWriter("Utilisateurds.txt",false));
			Iterator<String> it = objListeUtilisateur.mapListeUtilisateur.keySet().iterator();
			
			while(it.hasNext()){
				String strClefTravaille = it.next();
				
				Utilisateur objUtiEcr = objListeUtilisateur.mapListeUtilisateur.get(strClefTravaille);
				
				if(objUtiEcr.strMotDePasse != null){
					bw.write(objUtiEcr.strNom + "," + objUtiEcr.getStrPrenom() + "," + objListeUtilisateur.mapStatutUtilisateur.get(strClefTravaille)
					+ "," + objUtiEcr.strMotDePasse);
				}
				else{
					bw.write(objUtiEcr.strNom + "," + objUtiEcr.getStrPrenom()+","+objListeUtilisateur.mapStatutUtilisateur.get(strClefTravaille));
				}
				bw.newLine();
			}
			bw.close();
		}catch (Exception e){
			System.out.println("Probl�me lors de la sauvegarde!!!!");
		}
		
		//r��criture fichier Fichier.txt
		try{
			BufferedWriter bwFichier = new BufferedWriter(new FileWriter("Fichiers.txt",false));
			Iterator<String> itF = objListeUtilisateur.mapListeFichier.keySet().iterator();
			
			while(itF.hasNext()){
				String strClefTravaille = itF.next();
				bwFichier.write(objListeUtilisateur.mapListeUtilisateur.get(strClefTravaille).alFichierUtilisateur.get(0));
				bwFichier.newLine();
			}
			bwFichier.close();
		}catch(Exception f){
			System.out.println("Probl�me lors de la sauvegarde!!!");
		}
		
		//Supression des Dossier d'utilisateur supprimer
		
		Iterator<String> itS = objListeUtilisateur.mapStatutUtilisateur.keySet().iterator();
		
		while(itS.hasNext()){
			String strClefTravaille = itS.next();
			if(objListeUtilisateur.mapStatutUtilisateur.get(strClefTravaille).equals("supprimer")){
				Path cheminSuppr = Paths.get("C:\\PhilippeDoyonProjet3\\",strClefTravaille);
				File objFichierSuppr = cheminSuppr.toFile();
				Connexion.deleteAll(objFichierSuppr);
			}
		}
		
		//Quitte
		System.out.println("\n#############################################################################");
		System.out.println("                                 Quitte");
		System.out.println("#############################################################################");
		System.exit(0);
	}
}