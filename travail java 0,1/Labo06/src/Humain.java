
public class Humain extends Animal implements AnimalQuiNage
	{
		private String strLangueParlee;
		
		public Humain(String strNom, String strLangueParlee)
			{	
				super(strNom);
				this.strLangueParlee = strLangueParlee;
			}
		
		public void parler(String strTexte)
		{
			System.out.println("L'humain " + super.getStrNom() + "dir " + strTexte + "en " + strLangueParlee);
		}
		
		public void nager()
		{
			System.out.println("L'humain nage, plus ou moins gracieusement.");
		}
	}
