
public class MesChaines {
	static boolean estPalindrome(String phrase){
		StringBuffer sbPalindrome;
		boolean booPalindrome = false;
		
		sbPalindrome = new StringBuffer(phrase);
		sbPalindrome.reverse();
		
		if(sbPalindrome.toString().equals(phrase)){
			booPalindrome = true;
		}
		
		return booPalindrome;
	}
}
