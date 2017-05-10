//Philippe Doyon
public class TableauParam {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [] tabInt = {1,2,9,4,6,8};
		String [] tabStringAffichage = TableauParam.listerTableau(tabInt);
		
		for(int d=0; d<tabStringAffichage.length;d++){
			System.out.println(tabStringAffichage[d]);
		}		
		
		boolean booTrouver = TableauParam.trouverElement(tabInt, 2);
		
		System.out.println(booTrouver);
		
		int intPlusG = TableauParam.trouverPlusGrandElement(tabInt);
		
		System.out.println("Le plus grand: " + intPlusG);
		
		tabInt=TableauParam.modifierElement(tabInt, 2, 20);
		
		tabStringAffichage = TableauParam.listerTableau(tabInt);
		
		for(int d=0; d<tabStringAffichage.length;d++){
			System.out.println(tabStringAffichage[d]);
		}		
	}
	
	public static String [] listerTableau(int [] tabInt){
		String [] tabStrAffichage = new String [tabInt.length];
		
		for(int q=0;q< tabInt.length;q++){
			tabStrAffichage[q] = "indice: " + q + " valeur : " + tabInt[q];
		}
		return tabStrAffichage;
	}
	
	public static boolean trouverElement(int [] tabInt, int intRechercher){
		boolean booReponse = false;
		
		for(int w = 0 ; w<tabInt.length;w++){
			if(tabInt[w] == intRechercher){
				booReponse = true;
				break;
			}				
		}	
		return booReponse; 
	}
	public static int trouverPlusGrandElement(int [] tabInt){
		int intPlusG = Integer.MIN_VALUE;
		
		for(int a=0;a<tabInt.length;a++){
			if(intPlusG < tabInt[a])
				intPlusG = tabInt[a];
		}
		
		return intPlusG;
	}
	
	public static int [] modifierElement(int [] tabInt, int intIndex, int intValeurMo){
		tabInt[intIndex] = intValeurMo;
		
		return tabInt;
	}

}
