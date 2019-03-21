//Philippe Doyon
public class CalculSomme {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int tabInt[] = {10,-18,21,12,13,17,31,17,23,14};
		int intNbRangPair = 0;
		int intNbPair = 0;
		
		for (int i=0; i < tabInt.length; i++){
			if(i % 2 == 0){
				intNbRangPair += tabInt[i];
			}
			
			if(tabInt[i] % 2 == 0){
				intNbPair += tabInt[i];
			}
		}		
		System.out.println("Somme des éléments de rang pair: " + intNbRangPair + "\rSomme des éléments pairs: " + intNbPair);
	}
}