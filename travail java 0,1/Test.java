
public class Test {


	public static void main(String[] args) {
		
		
		
		int[]  tableau = {12, 3, 10, -1, 15, -1, 13,17,-3,0,-5};
		
		tableau = Tri.triInsertion(tableau);
		
		//Tri.triSelection(tableau);
		//Tri.triBulle(tableau);
		for (int i =0; i<tableau.length;i++)
		System.out.println("i = "+ i + "   tableau["+i+"]: " + tableau[i]);
		//System.out.println(" indice trouvé: "  + Tri.trouverElement(tableau, -1));
		//System.out.println(" indice trouvé: "  + Tri.trouverElement(tableau, 20));

	}

}
