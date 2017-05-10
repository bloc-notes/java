
public class Employe
	{
		private  String strPrenom;
		private  String strNom;
		private static int intNombre = 0;
		
		public Employe(String strPrenom,String strNom)
			{
				this.strPrenom = strPrenom;
				this.strNom = strNom;
				this.intNombre = intNombre + 1;
				
				System.out.println("\nAppel du constructeur\n" + "Nom de famille: " + strNom + "\nPrénom: " + strPrenom + "\nNombre: " + intNombre);
				
			}

		public String getStrPrenom()
			{
				return strPrenom;
			}

		public String getStrNom()
			{
				return strNom;
			}

		public static int getIntNombre()
			{
				return intNombre;
			}
		
		protected void finalize()
			{
				intNombre--;
				
				System.out.println("\nAppel de la methode finalize\n" + "Nom de famille: " + strNom + "\nPrénom: " + strPrenom + "\nNombre: " + intNombre);
			}
		
	}
