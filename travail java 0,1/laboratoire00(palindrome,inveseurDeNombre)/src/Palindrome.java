//Philippe Doyon
import java.util.Scanner;
public class Palindrome {

	public static void main(String[] args) {
		// TODO Auto-generated method stub		
		 Scanner scDonner = new Scanner(System.in);
		
		System.out.println("Veuiller inscrire votre palindrome : ");
		String  strMot = scDonner.next();
		
		StringBuffer inverser = new StringBuffer(strMot);
		String strMotInverse = inverser.reverse().toString();
		
		if(strMot.equals(strMotInverse))
			System.out.println(strMot + " est un palindrome.");
		else
			System.out.println(strMot + " n'est pas un palindrome");
		scDonner.close();
	}
}
