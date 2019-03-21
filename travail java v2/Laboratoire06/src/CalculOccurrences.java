import java.util.Scanner;

public class CalculOccurrences {
	public static void main(String[] args) {
		int frequence[] = new int[26];
		Scanner scan = new Scanner(System.in);
		// lecture d'une cha�ne de caract�res
		System.out.print("Entrer un seul mot(des lettres seulement , SVP): ");
		String chaine = scan.nextLine();
		// convertion de la cha�ne en majuscule
		chaine = chaine.toUpperCase();

		for (int i = 0; i < chaine.length(); i++) {
			try {
				// calcul de la fr�quence de chaque lettre dans la chaine
				frequence[chaine.charAt(i) - 'A']++;
			} catch (Exception e) {
				// TODO: handle exception
				System.out.println("Pas une lettre " + "'"+(chaine.charAt(i)) + "'"+ " "+e.toString());
			}
		}
		// affichage des fr�quences
		System.out.println();
		for (int i = 0; i < frequence.length; i++)
			if (frequence[i] != 0)
				System.out.println((char) (i + 'A') + ": " + frequence[i]);
	}
}