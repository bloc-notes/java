
public class Poisson extends Animal implements AnimalQuiNage
	{
		private int intTemperatureSang;
		
		public Poisson(String strNom, int intTemperatureSang)
			{	
				super(strNom);
				this.intTemperatureSang = intTemperatureSang;
			}
		
		public void nager()
		{
			System.out.println("Le Poisson " + super.getStrNom() + " nage gracieusement");
		}
	}
