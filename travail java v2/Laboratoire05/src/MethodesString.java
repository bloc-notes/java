
public class MethodesString {
	public static void afficherInverse(String chaine){
		StringBuffer sb = new StringBuffer(chaine);
		
		System.out.println(sb.reverse());
	}
	
	public static int compte(char ch, String chaine){
		int intNbOccurence = 0;
		char[] tabChar = chaine.toLowerCase().toCharArray();
		
		
		for(char element:tabChar){
			if(Character.toLowerCase(ch) == element){
				intNbOccurence++;
			}
		}
		
		return intNbOccurence;
	}
}
