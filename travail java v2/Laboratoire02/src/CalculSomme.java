
public class CalculSomme {
	static int intTav[]= {10,-18,21,12,13,17,31,17,23,14};
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int intSommePair = 0;
		int intSommeRangPair = 0;
		
		for(int q=0;q<intTav.length;q++){
			if((q%2) == 0){
				intSommeRangPair += intTav[q];
			}
			
			if((intTav[q] % 2)==0){
				intSommePair += intTav[q];
			}
		}
		
		System.out.println("Somme éléments de rang pair: " + intSommeRangPair + "\rSomme des éléments pairs: " + intSommePair);
	}	
}