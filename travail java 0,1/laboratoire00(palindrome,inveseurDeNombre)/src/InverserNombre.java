//Philippe Doyon
import java.util.Scanner;
public class InverserNombre {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scDonner = new Scanner(System.in);
		System.out.println("Veuiller inscrire un nombre integer a inverser : ");
		int intNombre = scDonner.nextInt();
		
		String strNombreInverser = "";
		int intModulo = 0;
		int intCopieNombre = intNombre;
		
		while(intCopieNombre != 0){
			intModulo = intCopieNombre % 10;
			strNombreInverser += intModulo;
			intCopieNombre = intCopieNombre / 10;
		}
		
		System.out.println(intNombre + " est devenue " + strNombreInverser);
		scDonner.close();
	}
}
