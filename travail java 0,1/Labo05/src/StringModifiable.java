
public class StringModifiable
	{

		public static void main(String[] args)
			{
				// TODO Auto-generated method stub
				StringBuilder sbTest = new StringBuilder("zxy");
				
				trierParInsertion(sbTest);
				
				System.out.println(sbTest);
			}
		
		public static void trierParInsertion(StringBuilder s)
		{
			
			for(int i = 0; i < s.length()-1; i++)
			{
				for(int j = i+1; j > 0; j--)
				{
					if(s.charAt(j) < s.charAt(j-1))
					{
						char temp = s.charAt(j-1);
						s.setCharAt(j-1, s.charAt(j));
						s.setCharAt(j, temp);
					}
				}
			}
			
			
			/*// déclaration 
			char[] chrTabNombres = new char[s.length()];
			char[] chrTabTrie = null;
			int intNbElementsTries= 0;
			int intPlaceInsertion;
			boolean blnPlaceTrouve ;
			chrTabTrie = new char[chrTabNombres.length];
			
			for (int i = 0; i < s.length(); i++)
				{
					chrTabNombres[i] = s.charAt(i);
				}
			
			// pour chaque élément du tableau reçu en argument
			
			for ( int i =0; i<chrTabNombres.length; i++ )
			{
				// rechercher la position dans le tableau trié
				intPlaceInsertion= 0;
				blnPlaceTrouve = false;
				while ( intPlaceInsertion < intNbElementsTries && !blnPlaceTrouve) {
					
					// vérifier si c'est l'endroit pour insérer sinon avancer
					if ( chrTabNombres[i]< chrTabTrie[intPlaceInsertion])
						blnPlaceTrouve= true ;
						else 
							intPlaceInsertion++;			
				}
				
			  
				// décaler en commençant par la fin
				for( int j = intNbElementsTries-1; j>= intPlaceInsertion; j--){
					chrTabTrie[j+1]= chrTabTrie[j];
				}
				
				
				// ajouter la valeur au bon endroit
				chrTabTrie [intPlaceInsertion]= chrTabNombres[i];
				
				// augmenter le nombre d'éléments de 1
						
				intNbElementsTries++;	
				
			}	
			for (int i =0; i<chrTabTrie.length;i++)
				{
					System.out.println(chrTabTrie[i]);
				}*/
		}
	}
