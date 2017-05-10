package mesclasses.meschaines;


public class TraitementChaines
	{
		public static void main(String[] args)
			{
				// TODO Auto-generated method stub
				System.out.println(inverserCasse("RoNaLdO"));
			}
		
		public static String inverserCasse(String strChaineCarac){
			
			StringBuilder sb = new StringBuilder(strChaineCarac);
			
			for (int i = 0; i < strChaineCarac.length(); i++)
				{
					
					
					char ch = sb.charAt(i);
					
					strChaineCarac.charAt(i);
					
					if (Character.isLowerCase(ch))
						{
							sb.setCharAt(i, Character.toUpperCase(ch));
						}
					else if (Character.isUpperCase(ch)) {
						sb.setCharAt(i, Character.toLowerCase(ch));
					}
				}
			
			return sb.toString();
		}
		
	}
