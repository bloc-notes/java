package projet1;

public class Inscription {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListeEtudiants objListeEtu = new ListeEtudiants("etudiants.txt");
		
		
		//System.out.println(objListeEtu.trouver(540) != null?objListeEtu.trouver(412).toString():"Null");
		
		ListeCours objListeCours = new ListeCours("cours.txt");
		
		MenuPrincipal objMenu = new MenuPrincipal();
		
		objMenu.demarrerMenuPrincipal(objListeCours, objListeEtu);
		
		
	}
}
