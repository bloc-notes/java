package laboratoire3;

//Philippe Doyon
public class SupprimeElemTableau {
	
	public static void main(String[] args) {			
		int [] tabInt = {12,4,10,23,25,20,16,7,3,5,21,18,13,11,11,28};
		int intElementSupprimer = 8;
		
		for (;intElementSupprimer < tabInt.length - 1;intElementSupprimer++ ){
			tabInt[intElementSupprimer] = tabInt[intElementSupprimer + 1];
		}
		
		int [] tabIntSupprimer = new int[tabInt.length -1];
		
		for (int c =0; c< tabInt.length -1; c++){
			tabIntSupprimer[c] = tabInt[c];
		}
		
		for(int d=0; d<tabIntSupprimer.length;d++){
			System.out.println(tabIntSupprimer[d]);
		}	
	}
	
}