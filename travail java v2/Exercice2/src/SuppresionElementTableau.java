
public class SuppresionElementTableau {
	static int intTab[] = {2,3,4,5,6,7,10,16,36,38,42};
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int intElementSupprimer = 5;
		
		System.out.println("Le 5eme élément a été enlever : " +intTab[intElementSupprimer]);
		
		for(int s=intElementSupprimer;s<intTab.length-1;s++){
			intTab[s] = intTab[s+1];
		}
		
		for(int d = 0; d<intTab.length -2;d++){
			System.out.println(intTab[d]);
		}
	}

}
