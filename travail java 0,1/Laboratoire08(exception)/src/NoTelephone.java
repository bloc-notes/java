import java.util.Scanner;
import java.util.StringTokenizer;

public class NoTelephone {

	public static void main(String[] args) throws telephoneInvalideException {
		// TODO Auto-generated method stub
		Scanner scScan = new Scanner(System.in);
		String strCodeRegional = "";
		String strNumero = "";

		boolean booValide = false;
		while (booValide == false) {
			System.out.print("Entrer un numéro de téléphone: ");
			String strChaine = scScan.nextLine();

			StringTokenizer stLigne = new StringTokenizer(strChaine, "() -");

			try {
				if (strChaine.length() == 13) {
					if ((strChaine.charAt(0) == '(') && (strChaine.charAt(4) == ')') && (strChaine.charAt(8) == '-')) {

						strCodeRegional = stLigne.nextToken();
						strNumero = stLigne.nextToken();
						strNumero += stLigne.nextToken();
						booValide = true;
						try {
							int intPoubelle = Integer.parseInt(strCodeRegional);
							intPoubelle = Integer.parseInt(strNumero);
						} catch (java.lang.NumberFormatException g) {
							try {
								booValide = false;
								throw new telephoneInvalideException();
							} catch (telephoneInvalideException f) {
								System.out.println(f);
							}
						}

					} else
						throw new telephoneInvalideException();
				} else
					throw new telephoneInvalideException();
			} catch (telephoneInvalideException e) {
				System.out.println(e);
			}

		}
		System.out.println("code régional : " + Integer.parseInt(strCodeRegional) + "\nnuméro: " + Integer.parseInt(strNumero));

	}
}