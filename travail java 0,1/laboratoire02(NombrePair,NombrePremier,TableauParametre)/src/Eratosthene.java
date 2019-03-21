import java.util.Scanner;
//Philippe Doyon
public class Eratosthene {

	public static void main(String[] args) {
		// TODO Auto-generated method stub		
		System.out.println("Fin du tableau :");
		int intFinTableau = new Scanner(System.in).nextInt();
		
		int Tabint[] = new int[intFinTableau -1];
		
		for (int i= 0; i <= intFinTableau -2; i++){
			Tabint[i] = i + 2;
		}
		
		int intEntier = 2;
		
		while(Math.pow(intEntier, 2) < intFinTableau){
			for(int j=0; j < intFinTableau -1;j++){
				if(Tabint[j] == intEntier || Tabint[j] < intEntier){
					//rien
				}					
				else if (Tabint[j] % intEntier == 0 ){
					Tabint[j] = -1;
				}				
			}
			
			int intIndex =0;
			do {
				intIndex++;
			} while(Tabint[intIndex -1] <= intEntier);
			intEntier = Tabint[intIndex - 1];
		}
		
		String strNombrePremier = "";
		for(int k = 0; k < intFinTableau -1;k++){
			if (Tabint[k] != -1)
				strNombrePremier += Tabint[k] + " ";
		}
		
		System.out.println("Les nombres premiers de " + intFinTableau + " sont : " + strNombrePremier);
	}
}