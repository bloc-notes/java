import java.lang.String;
import java.io.PrintStream;

public class Format
	{

		public static void main(String[] args)
			{
				// TODO Auto-generated method stub
				/********************************************************************
				 * On peut construire une cha�ne format et l'assigner � une variable en utilisant la m�thode de format statique dans la classe String.
				   L'utilisation d'un Format string et les arguments sont identique a ceux dans la m�thode printf. La m�thode format
				   renvoie une r�f�rence � une cha�ne.
				 *********************************************************************/
				String strTest = String.format("%-12z.5f%.20f", 12.23429837482,9.10212023134);
				
				System.out.println(strTest);
				
				 String strTest2 = "Hello World";

			     // declaration de l'objet printstream 
			     PrintStream ps = new PrintStream(System.out);

			     // affichageprint string
			     ps.print("\nVoici un example\n");
			     ps.print(strTest2);

			     // Se debarasser de l'objet
			     ps.flush();
				
			}

	}
