//Philippe Doyon
import java.util.Scanner;
public class CalculOccurences {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int intfrequence[] = new int[26];
		Scanner scScan = new Scanner(System.in);
		
		System.out.print("Entrer un seul mot(des lettres seulement , svp): ");
		String strChaine = scScan.nextLine();
		
		strChaine = strChaine.toUpperCase();
		
			for(int i = 0; i <strChaine.length();i++){
				try{
					intfrequence[strChaine.charAt(i)-'A']++;
				}catch(ArrayIndexOutOfBoundsException e){
					System.out.println("Pas une lettre " + strChaine.charAt(i) +" " +  e.toString() );
				}
			}
		
			System.out.println();
			for(int i = 0; i< intfrequence.length;i++){
				if(intfrequence[i] != 0){
					System.out.println((char) (i+'A') + ": " +  intfrequence[i]);
				}
			}
		
	}
}
