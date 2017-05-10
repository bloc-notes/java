package mestests;
import  mesutilitaires.*;
import  mesclasses.*;
import mesclasses.meschaines.TraitementChaines;

public class Test
	{

		public static void main(String[] args)
			{
				// TODO Auto-generated method stub
				Temps t = new Temps();
				t.setTemps(8, 0, 0);
				
				System.out.println("Appel TraitementChaines Inverser: " + TraitementChaines.inverserCasse("RoNaLdO") + "\nTemps Standard:" + t.toString() + "\nTemps Universel: " + t.formatUniversel());
			}

	}
