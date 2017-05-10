import java.util.Scanner;

public class Palindrome {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		StringBuffer sbPalindrome;
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Mot palindrome: ");
		String strPalindrome = sc.nextLine();	
		
		sbPalindrome = new StringBuffer(strPalindrome);
		sbPalindrome.reverse();
		
		if(sbPalindrome.toString().equals(strPalindrome)){
			System.out.println("C'est un palindrome");
		}
		else{
			System.out.println("C'est pas un palindrome");
		}
	}
}
