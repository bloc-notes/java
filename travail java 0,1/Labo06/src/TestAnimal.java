
public class TestAnimal
	{

		public static void main(String[] args)
			{
				// TODO Auto-generated method stub
				//Animal objAnimal1 = new Humain("Ronaldo","Alien");

				//System.out.println(objAnimal1);
				AnimalQuiNage a1 = new Poisson("Joey", 23);
				AnimalQuiNage h1 = new Humain("Ronaldo","Portuguese");
				//sAnimalQuiNage m1 = new Mammifere("Joey", 23);
				//Animal a3 = new Mammifere("Joey", 23);
				
				a1.nager();
				h1.nager();
				
				Animal m1 = new Mammifere("Joey", 23);
				Animal a2 = new Poisson("Joey", 23);
				Animal h2 = new Humain("Ronaldo","Portuguese");
				
				Piscine p = new Piscine();

				if(m1 instanceof AnimalQuiNage)
				{
					p.lancerDansPiscine((AnimalQuiNage)m1);
				}
				else
					System.out.println(m1.getStrNom() + " sait pas nager");
				
				if(a2 instanceof AnimalQuiNage)
				{
					p.lancerDansPiscine((AnimalQuiNage)a2);
				}
				
				if(h2 instanceof AnimalQuiNage)
				{
					p.lancerDansPiscine((AnimalQuiNage)h2);
				}
			}

	}
