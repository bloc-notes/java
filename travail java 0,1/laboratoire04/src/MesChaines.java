
public class MesChaines {

	public static Boolean estPalindrome(String strPhrase){
		
		StringBuffer inverser = new StringBuffer(strPhrase);
		String strMotInverse = inverser.reverse().toString();
		
		Boolean blnReponse = false;
		
		if(strPhrase.toUpperCase().equals(strMotInverse.toUpperCase()))
			blnReponse = true;
		
		return(blnReponse);
	}
}