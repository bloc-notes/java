package premierProgramme;

import java.util.Scanner;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Merci pour votre attention");
		System.out.println("Syso");
		System.out.println("Fin du tableau :");
		int intFinTableau = new Scanner(System.in).nextInt();
		
		int Tabint[] = new int[intFinTableau - 1];
		
		for (int i= 0; i < intFinTableau; i++){
			Tabint[i] = i + 2;
		}
		
		int intEntier = 2;
		while(Math.pow(intEntier, 2) > intFinTableau){
			for(int j=0; j < intFinTableau;j++){
				if (Tabint[j] % intEntier == 0 )
					Tabint[j] = -1;
			}
			while(Tabint[intEntier -1] < intEntier){
				intEntier++;
			}		
		}
		
		String strNombrePremier = "";
		for(int k = 0; k < intFinTableau;k++){
			if (Tabint[k] != -1)
				strNombrePremier += Tabint[k] + " ";
		}
		
		System.out.println("Les nombres premiers de " + intFinTableau + " sont:\r" + strNombrePremier);
	}	
}
