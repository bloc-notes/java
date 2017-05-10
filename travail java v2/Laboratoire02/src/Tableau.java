
public class Tableau {
	private int[] intTab;
	
	public Tableau(int[] intTab) {
		super();
		this.intTab = intTab;
	}
	
	public void listerTableau(){
		for(int q=0;q<intTab.length -1;q++){
			System.out.println("indice:"+q+"\tvaleur: " + intTab[q]);
		}
	}
	
	public boolean trouverElement(int intValeur){
		boolean booTrouver = false;
		for (int i : intTab) {
			if(intValeur == i){booTrouver = true;};
		}
		return booTrouver;
	}
	
	public int trouverPlusGrandElement(){
		int intPlusGrand = Integer.MIN_VALUE;
		for (int i : intTab) {
			intPlusGrand = i>intPlusGrand ? i:intPlusGrand;
		}
		return intPlusGrand;
	}
	
	public void modifierElement(int intPosition,int intValeur){
		intTab[intPosition] = intValeur;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int intTableau[] ={10,-18,21,12,13,17,31,17,23,14};
		
		Tableau objTab = new Tableau(intTableau);
		
		System.out.println("17 est dans tableau ? : " + objTab.trouverElement(17));
		
		System.out.println("Élément le plus grand : " + objTab.trouverPlusGrandElement());
		
		objTab.listerTableau();
		
		System.out.println("Remplace 3 ème élément par 42");
		objTab.modifierElement(2, 42);
		
		objTab.listerTableau();
	}

}
