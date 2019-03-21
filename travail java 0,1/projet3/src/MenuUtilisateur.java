import java.io.File;
import java.io.IOException;
import java.nio.file.DirectoryNotEmptyException;
import java.nio.file.DirectoryStream;
import java.nio.file.FileSystem;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;
import java.util.Iterator;
import java.util.Scanner;

public class MenuUtilisateur {
	String strClef;
	ListeUtilisateur objListeUtilisateur;
	boolean booQuitter=false;
	
	public MenuUtilisateur(String strClef, ListeUtilisateur objListeUtilisateur) {
		this.strClef = strClef;
		this.objListeUtilisateur = objListeUtilisateur;
	}
	
	public void DemareMenu(){
		while (booQuitter==false){
			System.out.println(	"\n1- Lister tout vos fichiers\n"+ "2- Lister les fichiers d'un répertoire donné\n"+ 
					"3- Ajouter un fichier ou un répertoire\n"+ "4- Supprimer un fichier existant\n"+"5- Écrire dans un fichier existant\n"+ 
					"6- Renommer un fichier\n"+"7- Changer d'utilisateur\n"+"8- Quitter\n");
								 
			
			Scanner sc = new Scanner(System.in);	
			System.out.println("Entrer votre choix");
			String strRep = sc.nextLine();
			
			MenuAdministrateur objMenuAdm = new MenuAdministrateur(strClef, objListeUtilisateur);
			switch(strRep)
			{
			case "1": objMenuAdm.AfficherListeFichier();
				break;
			case "2": AfficheListeFichierSpecifique();
				break;
			case "3": AjouteDossierFichier();
				break;
			case "4":SupprimerFichier();
				break;
			case "5": 
				break;
			case "6": 
				break;
			case "7": objMenuAdm.ChangerUtilisateur();
				break;
			case "8": objMenuAdm.QuitterEtSauvegarder();
				break;
			
			default:System.out.println("#############################################################################");
					System.out.println("                              Réponse invalide				             ");
					System.out.println("#############################################################################");
					;break;
			}
		}
	}
	
	private void AfficheListeFichierSpecifique(){
		String strChemin;
		System.out.println("\n#############################################################################");
		System.out.println("                     Lister le contenu d'un répertoire");
		System.out.println("#############################################################################");
		
		Scanner sc = new Scanner(System.in);	

		System.out.println("\nDonner le chemin relatif du répertoire:                    Ex: tp2/partie1/ ");

		strChemin = sc.nextLine();
		FileSystem systemeDeFchiers = FileSystems.getDefault();
		Path chemin = systemeDeFchiers.getPath("C:\\PhilippeDoyonProjet3\\"+strClef+(strChemin != ""?"\\" + strChemin:strChemin));
		if(Files.isDirectory(chemin))
		{
			try {
				DirectoryStream <Path> enfants = Files.newDirectoryStream(chemin); 
				for(Path enfant:enfants)
					if(!(Files.isDirectory(enfant)))
					{
				System.out.println(enfant);
					}
				}catch (IOException e) {
				 e.printStackTrace();
				}
			System.out.println("\n#############################################################################");
			System.out.println("                             Opération Éffectuer");
			System.out.println("#############################################################################");
		}
		else
		{
			System.out.println("\n#############################################################################");
			System.out.println("                               Chemin invalide");
			System.out.println("#############################################################################");
		}
	}
	
	private void AjouteDossierFichier(){
		String strChemin;
		String strRep;
		String strType;
		String strNom;
		
		System.out.println("\n#############################################################################");
		System.out.println("                    Ajouter un fichier ou un répertoire");
		System.out.println("#############################################################################");
		
		Scanner sc = new Scanner(System.in);	
		System.out.println("\nDonner le chemin relatif du répertoire: \n");
		strChemin = sc.nextLine();
		
		FileSystem systemeDeFchiers = FileSystems.getDefault();
		Path chemin = systemeDeFchiers.getPath("C:\\PhilippeDoyonProjet3\\"+strClef+(strChemin != ""?"\\" + strChemin:strChemin));
		if(Files.isDirectory(chemin))
		{
			System.out.println("\nCréer un répertoire(1) ou un fichier(2): \n");
			strRep = sc.nextLine();
			
			if(strRep.equals("1"))
			{
				System.out.println("\nNommer votre répertoire: \n");
				strNom = sc.nextLine();
				
				if(strNom.equals(""))
				{
					System.out.println("\n#############################################################################");
					System.out.println("                              Réponse invalide");
					System.out.println("#############################################################################");
				}
				else
				{
					System.out.println(chemin.toString());
					boolean booF = new File("C:\\PhilippeDoyonProjet3\\"+strClef+(strChemin != ""?"\\" + strChemin:strChemin)+"\\"+strNom).mkdir();
					if(booF)
					{
					System.out.println("\n#############################################################################");
					System.out.println("                             Opération Éffectuer");
					System.out.println("#############################################################################");
					///---->
					objListeUtilisateur.mapListeUtilisateur.get(strClef).alFichierUtilisateur.set(0,
							objListeUtilisateur.mapListeUtilisateur.get(strClef).alFichierUtilisateur.get(0) + "," + strNom + "," + 
							(strChemin != ""?strChemin:","));
					}
					else
					{
						System.out.println("\n#############################################################################");
						System.out.println("                         Répertoire déja existant");
						System.out.println("#############################################################################");
					}
				}
			}
			else if(strRep.equals("2"))
			{
				System.out.println("\nNommer votre fichier: \n");
				strNom = sc.nextLine();
				
				if(strNom.equals(""))
				{
					System.out.println("#############################################################################");
					System.out.println("                            Réponse invalide");
					System.out.println("#############################################################################");
				}
				else
				{
					try {
						
						objListeUtilisateur.mapListeUtilisateur.get(strClef).alFichierUtilisateur.set(0,
								objListeUtilisateur.mapListeUtilisateur.get(strClef).alFichierUtilisateur.get(0) + "," + strNom + "," + 
								(strChemin != ""?strChemin:","));
						
						objListeUtilisateur.mapListeUtilisateur.get(strClef).alFichierUtilisateur.add("C:\\PhilippeDoyonProjet3\\"+strClef+
								(strChemin != ""?"\\" + strChemin:strChemin)+ "\\"+strNom);
						
						chemin = systemeDeFchiers.getPath("C:\\PhilippeDoyonProjet3\\"+strClef+(strChemin != ""?"\\" + strChemin:strChemin)+ "\\"+
								strNom);
						Files.createFile(chemin);

						System.out.println("\n#############################################################################");
						System.out.println("                             Opération Éffectuer");
						System.out.println("#############################################################################");

					} catch (IOException e) {
						System.out.println("\n#############################################################################");
						System.out.println("                         Répertoire déja existant");
						System.out.println("#############################################################################");
					}
				}
			}
			else
			{
				System.out.println("\n#############################################################################");
				System.out.println("                             Réponse invalide");
				System.out.println("#############################################################################");
			}
		}
		else
		{
			System.out.println("\n#############################################################################");
			System.out.println("                                Chemin invalide");
			System.out.println("#############################################################################");
		}
	}
	
	private void SupprimerFichier(){
		boolean booFi = false ;
		String strChemin;
		String strRep;
		System.out.println("\n#############################################################################");
		System.out.println("                           Supprimer un fichier");
		System.out.println("#############################################################################");
		
		Scanner sc = new Scanner(System.in);	
		System.out.println("\nDonner le chemin relatif du fichier                             Ex: tp2/f2 ");
		strChemin = sc.nextLine();
		FileSystem systemeDeFchiers = FileSystems.getDefault();
		Path chemin = systemeDeFchiers.getPath("C:\\PhilippeDoyonProjet3\\"+strClef+"\\"+strChemin);
		//String strKeyList = "C:\\PhilippeDoyonProjet3\\"+strClef+(strChemin != ""?"\\" + strChemin:strChemin);
		try {
			if(strChemin.equals("")){
				System.out.println("\n#############################################################################");
				System.out.println("                              Chemin invalide");
				System.out.println("#############################################################################");
				throw new NoSuchFileException("strChemin=vide");
			}
			Files.delete(chemin);
				
			System.out.println("\n#############################################################################");
			System.out.println("                             Opération Éffectuer");
			System.out.println("#############################################################################");
		} catch (NoSuchFileException x) {
			System.out.println("#############################################################################");
			System.out.println("                               Chemin invalide");
			System.out.println("#############################################################################");
		} catch (DirectoryNotEmptyException x){
			sc = new Scanner(System.in);	
			System.out.println("\nDétruire tout ce qui est dans le répertoire?             Oui(1) Non(2)\n");
			strRep = sc.nextLine();
			
			if(strRep.equals("1"))
			{
				File Fichier = new File("C:\\PhilippeDoyonProjet3\\"+strClef+"\\"+strChemin);
				Connexion.deleteAll(Fichier);
				
				for(int v=1;v<=objListeUtilisateur.mapListeUtilisateur.get(strClef).alFichierUtilisateur.size();v++){
					if(Fichier.toString().equals(objListeUtilisateur.mapListeUtilisateur.get(strClef).alFichierUtilisateur.get(v))){
						objListeUtilisateur.mapListeUtilisateur.get(strClef).alFichierUtilisateur.remove(v);
					}
				}
				/*
				String[] tabListeFichier = objListeUtilisateur.mapListeUtilisateur.get(strClef).alFichierUtilisateur.get(0).split(",");
				for(int n=1;n<=tabListeFichier.length;n++){
					if(tabListeFichier[n].equals())
				}
				*/
				
				System.out.println("#############################################################################");
				System.out.println("                             Opération Éffectuer");
				System.out.println("#############################################################################");
			}
			else if(strRep.equals("2"))
			{
				System.out.println("\n#############################################################################");
				System.out.println("                                  Annuler");
				System.out.println("#############################################################################");
			}
			else
			{
				System.out.println("\n#############################################################################");
				System.out.println("                          Réponse invalide");
				System.out.println("#############################################################################");
			}
		}
		 catch (IOException x) {
			System.out.println("\n#############################################################################");
			System.out.println("                             Problème de permission");
			System.out.println("#############################################################################");
		}
	}
}
















