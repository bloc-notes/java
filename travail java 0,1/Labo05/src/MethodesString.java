
public class MethodesString
	{
		
		public static void afficherInverse(String strChaine)
		{
			String strInverser = "";
			
			int length = strChaine.length();
			
			for (int i = length - 1; i >= 0; i--)
				{
		    	  strInverser = strInverser + strChaine.charAt(i);
				}
			//strChaine = strInverser;
			
			System.out.println("String d'origine:\n" + strChaine + "\n\nString inverser:\n" + strInverser);
			
		}
		
		public static int compte(char ch,String strChaine)
			{
				int intCompteur = 0;
				int length = strChaine.length();
				
				for (int i = 0; i < length; i++)
					{
						char chrChar = strChaine.charAt(i);
						String strChar = Character.toString(chrChar);
						//String string2 = String.valueOf(ch);

						//strChar.indexOf(ch);
						
						if (strChar.indexOf(ch) != -1)
							{
								intCompteur++;
							}
					}
				//strChaine.compareToIgnoreCase(strChaine.indexOf(ch));
				return intCompteur;
			}
	}
