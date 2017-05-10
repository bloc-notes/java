
public class StringModifiable {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		StringBuilder sb = new StringBuilder("BDCAHEFGH");
		
		trierParInsertion(sb);
		
		System.out.println(sb);
	}
	
	public static void trierParInsertion(StringBuilder s){
		for(int j =1;j < s.length();j++){
			char chrInserer = s.charAt(j);
			
			int i = j-1;
			for(; i>=0 && s.charAt(i)> chrInserer;i--){
				s.setCharAt(i + 1, s.charAt(i));
			}
			
			s.setCharAt(i + 1, chrInserer);
		}
	}

}
