
public class TestLabo3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListeStation objListe = new ListeStation("labo3.txt");
		//104 éléments max
		
		
		objListe.triAltitudeDecroissant();
		objListe.afficherStation(104);
		System.out.println("-----------------------------------------------------------------------------------");
		/*
		objListe.triProvinceCroissant();;
		objListe.afficherStation(30);
		System.out.println("-----------------------------------------------------------------------------------");
		
		objListe.triProvinceAltitudeCroissant();
		objListe.afficherStation(30);
		*/
		
		short a =2;
		objListe.rechercheDicotomiqueAltitudeDecroissant(a);
		
	}
}