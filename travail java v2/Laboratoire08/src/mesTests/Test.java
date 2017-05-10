package mesTests;

import mesClasses.mesChaines.TraitementChaines;
import mesUtilitaires.Temps;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//meschaine
		String strInverse = new String("MerCi");
		
		System.out.println(TraitementChaines.inverserCasse(strInverse));
		
		//temps
		Temps t = new Temps();
		String strResultat = "\nLe temps universel initial vaut: " + t.formatUniversel() + "\nLe temps standars initial vaut: " + t.toString() +
				"\nAppel implicite à toString(): " + t;

		t.setTemps(15, 37, 06);
		
		strResultat += "\n\nLe temps universel après setTemps() vaut: " + t.formatUniversel() + "\nLe temps stadard après setTemps() vaut: " + t.toString();
		
		t.setTemps(99, 99, 99);
		
		strResultat +="\n\nAprès utilisation de valeur incorrectes:\nTemps universel: " + t.formatUniversel() + "\nTemps standard: " + t.toString();
		
		System.out.println(strResultat);
	}

}
