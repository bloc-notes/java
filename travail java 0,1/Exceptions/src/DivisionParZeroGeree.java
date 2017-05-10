public class DivisionParZeroGeree {
	static void afficher(){
		try {
			System.out.println(10/0);
		}catch (ArithmeticException e){
			System.out.println(" Capture de la division par  zero");
		}
	}
	public static void main(String[] args) {
		DivisionParZeroGeree.afficher();
	
	}
}
