package laboratoire11;

import java.util.LinkedList;

public class TestListe {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Liste objListe = new Liste("Google");
		
		objListe.insererEnTete(null);
		objListe.parcourirAvecIterateur();
		
		objListe.insererEnTete("$");
		objListe.parcourirAvecIterateur();
		
		objListe.insererEnQueue("merci");
		objListe.parcourirAvecIterateur();
		
		objListe.insererEnQueue("12345");
		objListe.parcourirAvecIterateur();
		/*
		System.out.println(objListe.retirerDeTete());
		objListe.parcourirAvecIterateur();
		
		System.out.println(objListe.retirerDeTete());
		objListe.parcourirAvecIterateur();
		
		System.out.println(objListe.retirerDeQueue());
		objListe.parcourirAvecIterateur();
		
		System.out.println(objListe.retirerDeQueue());
		objListe.parcourirAvecIterateur();
		
		System.out.println(objListe.retirerDeQueue());
		objListe.parcourirAvecIterateur();
		*/
		Liste objListe2 = new Liste("Yahoo");
		objListe2.insererEnTete("Java");
		objListe2.insererEnTete("langage");
		objListe2.insererEnTete("cours 2P6");
		
		objListe2.concatener(objListe);
		objListe2.parcourirAvecIterateur();
		objListe.parcourirAvecIterateur();
	}
}
