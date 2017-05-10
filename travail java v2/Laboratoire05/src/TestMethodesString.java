import javax.swing.plaf.metal.MetalTreeUI;

public class TestMethodesString extends MethodesString{

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		afficherInverse("Philippe");
		
		System.out.println(compte('P', "Philippe"));
		
		//Mettre static permet de pouvoir appeler une méthode sans objet.
	}

}
