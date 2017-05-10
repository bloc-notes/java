package laboratoire3;

public class TriBulle {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [] tabInt = {12,4,10,23,25,20,16,7,3,5,21,18,13,11,11,28};
		int intTempo = 0;
		
		boolean booTerminer = false;
		int intFinTableau = tabInt.length - 1;
		while (booTerminer == false){
			booTerminer = true;
			
			for(int r =0; r<intFinTableau;r++){
				int intTraiter = tabInt[r];
				int intSuivant = tabInt[r+1];
				
				if(intTraiter > intSuivant){
					intTempo = tabInt[r+1];
					tabInt[r+1] = tabInt[r];
					tabInt[r] = intTempo;
					
					booTerminer = false;
				}
			}
			intFinTableau--;
		}
		
		for(int d=0; d<tabInt.length;d++){
			System.out.println(tabInt[d]);
		}	
	}
}
