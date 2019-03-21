package laboratoire3;

public class TestLabo3
	{
	
		public static void main(String[] args)
			{
				// TODO Auto-generated method stub
				
				ListeStations objListeStation = new ListeStations("labo3.txt");
				/*
				objListeStation.TriAltitudeDecroissant();
				objListeStation.afficherstation(104);
				*/
				/*
				objListeStation.TriProvince();
				objListeStation.afficherstation(104);
				*/
				objListeStation.TriProvinceAltitudeCroissant();
				objListeStation.afficherstation(104);
			}
	}