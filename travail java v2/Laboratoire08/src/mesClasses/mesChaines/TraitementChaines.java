package mesClasses.mesChaines;

public class TraitementChaines {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String strInverse = new String("MerCi");
		
		System.out.println(inverserCasse(strInverse));
	}
	
	public static String inverserCasse(String strChaine){
		StringBuilder sB = new StringBuilder();
		
		for(char chrLettre: strChaine.toCharArray()){
			sB.append(Character.isUpperCase(chrLettre) ? Character.toLowerCase(chrLettre):Character.toUpperCase(chrLettre));
		}
		
		return sB.toString();
	}

}
