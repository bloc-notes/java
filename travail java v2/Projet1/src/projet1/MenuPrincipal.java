package projet1;

import java.util.Scanner;

public class MenuPrincipal {
	public void demarrerMenuPrincipal(ListeCours lstCours, ListeEtudiants lstEtudiant){
		boolean booQuitter = false;
		
		while (booQuitter == false) {
			System.out.println("*********************************\nLogiciel pour les inscriptions aux cours\nPar Philippe Doyon"
					+ "\n*********************************\nMenu Principal\n1- Lister les cours encore disponibles\n"
					+ "2- Lister les �tudiants inscrits � un cours donn�\n3- Lister les cours d�un �tudiant\n"
					+ "4- Lister les �tudiants par programme\n5- Modification d�une inscription\n6- Quitter"
					+ "\n*********************************\nEntr� le num�ro de l'action d�sir�e:");
			//Scanner scan = new Scanner(System.in);
			@SuppressWarnings("resource")
			int intChoix = new Scanner(System.in).nextInt();
			
			switch (intChoix) {
			case 1:
				listerCoursDisponibles(lstCours);
				break;
			case 2:
				listerEtudiant(lstCours, lstEtudiant);
				break;
			case 3:
				listerCours(lstCours, lstEtudiant);
				break;
			case 4:
				listerEtudiantsProgramme(lstEtudiant);
				break;
			case 5:
				afficherSousMenu(lstCours, lstEtudiant);
				break;
			case 6:
				booQuitter = quitter();
				break;

			default:
				System.out.println("[Probl�me]Votre choix doit �tre entre 1 et 6!");
				break;
			}
		}
	}
	
	private void listerCoursDisponibles(ListeCours lstCours){
		for (int f = 0; f < lstCours.getIntNbreElements(); f++) {
			if (lstCours.getLstCours()[f].getIntNbreEtudiants() != lstCours.getLstCours()[f].getIntNbreMax()) {
				System.out.println(lstCours.getLstCours()[f].toString());
			}
		}
	}
	
	private void listerEtudiant (ListeCours lstCours, ListeEtudiants lstEtudiant){
		System.out.println("Entr� le num�ro du cours:");
		
		@SuppressWarnings("resource")
		String strSigle = new Scanner(System.in).nextLine();
		
		Cours objcours = lstCours.trouver(strSigle);
		
		if(objcours == null){
			System.out.println("[Probl�me]Le num�ro de cours n'existe pas!");
		}
		else {
			objcours.afficherListeEtudiant();
		}
	}
	
	private void listerCours(ListeCours lstCours, ListeEtudiants lstEtudiant){
		System.out.println("Entr� le num�ro de l'�tudiant:");
		
		@SuppressWarnings("resource")
		int intNumero = new Scanner(System.in).nextInt();
		
		Etudiant objEtudiant = lstEtudiant.trouver(intNumero);
		
		if(objEtudiant == null){
			System.out.println("[Probl�me]Le num�ro d'�tudiant n'existe pas!");
		}
		else {
			objEtudiant.afficherListeCours();
		}
	}
	
	private void listerEtudiantsProgramme (ListeEtudiants lstEtudiants){
		boolean booProgrammeExiste = false;
		
		System.out.println("Entr� le nom du programme:");
		
		@SuppressWarnings("resource")
		String strProgramme = new Scanner(System.in).nextLine();
		
		//V�rifie que le programme existe
		for(EnumProgramme objProgramme: EnumProgramme.values()){
			if (objProgramme.getStrNomProgramme().compareToIgnoreCase(strProgramme) == 0) {
				booProgrammeExiste = true;
			}
		}
		
		if (booProgrammeExiste) {
			for(int d=0;d<lstEtudiants.getIntNbreElements();d++){
				if (lstEtudiants.getLstEtudiants()[d].getProgramme().getStrNomProgramme().
						compareToIgnoreCase(strProgramme) == 0) {
					System.out.println(lstEtudiants.getLstEtudiants()[d].toString());
				}
			}
		}
		else {
			System.out.println("[Probl�me]Le programme n'existe pas!");
		}
	}
	
	private void afficherSousMenu(ListeCours lstCours, ListeEtudiants lstEtudiant){
		System.out.println("*********************************\nModification d�une inscription\n*********************************\n"
				+ "1- Annuler l'inscription d'un �tudiant a un cours\n2- Inscrire un �tudiant a un cours\nEntr� le num�ro de l'action d�sir�e:");
		
		@SuppressWarnings("resource")
		int intChoix = new Scanner(System.in).nextInt();
		
		switch (intChoix) {
		case 1:
			annulerCours(lstCours, lstEtudiant);
			break;
		case 2:
			ajouterCours(lstCours, lstEtudiant);
			break;
		default:
			System.out.println("[Probl�me]Les options sont seulement 1 ou 2!");
			break;
		}
	}
	
	private void annulerCours(ListeCours lstCours, ListeEtudiants lstEtudiant){
		System.out.println("Entr� le num�ro de l'�tudiant");
		
		@SuppressWarnings("resource")
		int intNumero =new Scanner(System.in).nextInt();
		
		System.out.println("Entr� le nom du cours:");
		
		@SuppressWarnings("resource")
		String strCours = new Scanner(System.in).next();
		
		//V�rifie si �tudiant et cours existe
		Etudiant objEtudiant = lstEtudiant.trouver(intNumero);
		Cours objcours = lstCours.trouver(strCours);
		
		//Cours et �tudiant valide
		if (objEtudiant != null && objcours !=null) {
			objEtudiant.supprimerCours(objcours);
		}
		else {
			System.out.println("[Probl�me]L'�tudiant ou le cours est invalide!");
		}
		
	}
	
	private void ajouterCours(ListeCours lstCours, ListeEtudiants lstEtudiant){
		System.out.println("Entr� le num�ro de l'�tudiant");
		
		@SuppressWarnings("resource")
		int intNumero =new Scanner(System.in).nextInt();
		
		System.out.println("Entr� le nom du cours:");
		
		@SuppressWarnings("resource")
		String strCours = new Scanner(System.in).next();
		
		//V�rifie si �tudiant et cours existe
		Etudiant objEtudiant = lstEtudiant.trouver(intNumero);
		Cours objcours = lstCours.trouver(strCours);
		
		//Cours et �tudiant valide
		if (objEtudiant != null && objcours !=null) {
			objEtudiant.ajouterCours(objcours);
		}
		else {
			System.out.println("[Probl�me]L'�tudiant ou le cours est invalide!");
		}	
	}
	
	private boolean quitter(){
		System.out.println("Voulez-vous vraiment quitter?\nOui ou Non");
		
		@SuppressWarnings("resource")
		String strReponse = new Scanner(System.in).next();
		
		if (strReponse.compareToIgnoreCase("oui") == 0) {
			return true;
		}
		else if (strReponse.compareToIgnoreCase("non") == 0){
			return false;	
		}
		else {
			System.out.println("[Probl�me]Vous devez inscrire (oui) ou (non)");
			return false;
		}
	}
}
