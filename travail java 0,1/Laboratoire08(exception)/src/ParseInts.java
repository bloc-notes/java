import java.util.Scanner;
import java.util.StringTokenizer;

//Philippe Doyon
public class ParseInts {

	public static void main(String[] args) {
		// TODO Auto-generated method stub		
		String strligne;
		int intVal, intSomme=0;
		Scanner scScan = new Scanner(System.in);
		System.out.println("Entre une ligne de texte");
		strligne = scScan.nextLine();

		StringTokenizer stLigne = new StringTokenizer(strligne);

		while(stLigne.hasMoreTokens()){
			try{
				intVal = Integer.parseInt(stLigne.nextToken().trim());
				intSomme += intVal;
			}catch(NumberFormatException e){
				
			}
		}

		System.out.println("La somme des entiers de cette ligne est: " +  intSomme);
	}
}
