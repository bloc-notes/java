package laboratoire3;

public class FusionTableau {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [] tabIntPremier = {3,4,5,7,10,11};
		int [] tabIntDeuxieme = {11,12,13,16,18,20,21,23,25,28};
		int [] tabIntFusion = new int[tabIntPremier.length + tabIntDeuxieme.length];
		
		int intIndexPremier =0;
		int intIndexDeuxieme = 0;
		
		for (int s = 0; s < tabIntFusion.length; s++ ){	
			if (intIndexPremier == tabIntPremier.length){
				tabIntFusion[s] = tabIntDeuxieme[intIndexDeuxieme];
				intIndexDeuxieme++;
			}
			else if (intIndexDeuxieme == tabIntDeuxieme.length){
				tabIntFusion[s]=tabIntPremier[intIndexPremier];
				intIndexPremier++;
			}
			else if(tabIntPremier[intIndexPremier]>tabIntDeuxieme[intIndexDeuxieme]){
				tabIntFusion[s] = tabIntDeuxieme[intIndexDeuxieme];
				intIndexDeuxieme++;
			}						
			else if((tabIntDeuxieme[intIndexDeuxieme]>tabIntPremier[intIndexPremier]) ||
					(tabIntDeuxieme[intIndexDeuxieme] == tabIntPremier[intIndexPremier])){
				tabIntFusion[s]=tabIntPremier[intIndexPremier];
				intIndexPremier++;
			}		
		}
		
		for(int d=0; d<tabIntFusion.length;d++){
			System.out.println(tabIntFusion[d]);
		}
	}

}
