import java.util.Scanner;
import java.util.StringTokenizer;

public class Telephone {

	public static void main(String[] args) throws TelephoneInvalideException {
		// TODO Auto-generated method stub
		String strNoTelephone = "";
		boolean booSortie = false;
		
		do {
			Scanner scan = new Scanner(System.in);
			System.out.println("Entre un numéro de téléphone (xxx)xxx-xxxx : ");
			
			strNoTelephone = scan.nextLine();
			
			try {
				StringTokenizer stNoTelephone = new StringTokenizer(strNoTelephone, "()-");
				
				String strIndicatif = stNoTelephone.nextToken();
				String strNumero1 = stNoTelephone.nextToken();
				String strNumero2 = stNoTelephone.nextToken();
				
				String strNumeroAssemble = new String(strNumero1 + strNumero2);
				
				int intIndicatif = Integer.parseInt(strIndicatif);
				int intNumeroAutre = Integer.parseInt(strNumeroAssemble);
				
				System.out.println(intIndicatif + " " + intNumeroAutre);
				booSortie = true;
			} catch (Exception e) {
				// TODO: handle exception
				try{
					throw new TelephoneInvalideException();
				}
				catch (Exception f) {
					// TODO: handle exception
					System.out.println(f);
				}
			}
		} while (booSortie == false);
		
	}

}
