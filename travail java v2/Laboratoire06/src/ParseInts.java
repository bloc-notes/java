import java.util.Scanner;
import java.util.StringTokenizer;

public class ParseInts {
	public static void main(String[] args) {
		String ligne;
		int val, somme = 0;
		Scanner scan = new Scanner(System.in);
		System.out.println("Entre une ligne de texte");
		ligne = scan.nextLine();
		StringTokenizer stLigne = new StringTokenizer(ligne);
		while (stLigne.hasMoreTokens()) {
			try {
				val = Integer.parseInt(stLigne.nextToken().trim());
				somme += val;
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
		System.out.println("La somme des entiers de cette ligne est: " + somme);
	}
}