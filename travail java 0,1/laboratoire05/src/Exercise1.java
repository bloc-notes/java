import java.util.Scanner;

//Philippe Doyon

public class Exercise1 {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// voici un exemple ou deux string ne sont pas comparer correctement
		Scanner scDonner = new Scanner(System.in);
		
		System.out.println("Veuiller inscrire votre palindrome (inscrire laval) : ");
		String  strMot = scDonner.next();
		
		StringBuffer inverser = new StringBuffer(strMot);
		String strMotInverse = inverser.reverse().toString();
		
		if(strMot == strMotInverse)
			System.out.println(strMot + " est un palindrome.");
		else
			System.out.println(strMot + " n'est pas un palindrome");
		scDonner.close();
		
		//Dans cette exemple, le if compare les espaces mémoires et effectivement ils n'ont pas les meme espace mémoire. en remplacant par equal, il va 
		//comparer le contenue.
	}
}
