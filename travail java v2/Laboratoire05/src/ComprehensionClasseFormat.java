import java.util.Formatter;

public class ComprehensionClasseFormat {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char[] tabChar = "salut".toCharArray();
		double dblSalaire = 145.2568;
		
		System.out.printf("Valeur:  %,.2f \n", dblSalaire);
		
		String strMessage = "Bonjours utilisateur no: ";
		int intNoUtilisateur = 142;
		
		String strResultat = String.format("%1$s %2$04d", strMessage,intNoUtilisateur);
		
		System.out.println(strResultat + "\n");
		
		Formatter f = new Formatter();
		f.format("%1$s   %2$03d", strMessage,intNoUtilisateur);
		f.format(String.format("%1$s   %2$03d", strMessage,intNoUtilisateur));
		
		//Les métodes utilise la classe formatter pour formater le contenue.
		
		//("%-30s",strFormat) = Padleft (30 espace avant la chaine), sans (-) fait padright
		
	}

}
