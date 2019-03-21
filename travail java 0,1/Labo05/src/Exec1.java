
public class Exec1
	{

		public static void main(String[] args)
			{
				// TODO Auto-generated method stub
				
				String str1 = "Ronaldo";
				String str2 = "Ronaldo";
				String str3 = new String("1");
				String str4 = new String("1");
				
				if (str3 == str4) // sera toujours false, car str3 et str4 sont des references à deux objets differents.
					{
						System.out.println("string identiques");
					}
				else
					System.out.println("string non-identiques");
				
				/********************************************************
				 * str1 == str2 est true, car str1 et str2 font référence à l’objet String anonymes
				 * "Ronaldo" et Java considère les objets String anonymes dont les contenus sont 
				 * identiques comme un seul objet String anonyme.
				 ********************************************************/
				if (str1 == str2) 
					{
						System.out.println("string identiques");
					}
				else
					System.out.println("string non-identiques");
				
				/********************************************************
				 * String str1 = "Ronaldo"; = référence à l’objet String anonymes.
				 * String str3 = new String("1"); ==  references l'objets
				 ********************************************************/
						
			}

	}
