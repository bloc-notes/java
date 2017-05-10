package laboratoire3;

public class Station {
	private String strNom;
	private String strProvince;
	private short shAltitude;
	
	public Station(String strNom, String strProvince, short shAltitude){
		this.strNom = strNom;
		this.strProvince= strProvince;
		this.shAltitude = shAltitude;
	}

	public String getStrNom()
		{
			return strNom;
		}

	public String getStrProvince()
		{
			return strProvince;
		}

	public short getShAltitude()
		{
			return shAltitude;
		}
	
	public void afficherInfoStation(){
		System.out.println("Nom : " + strNom + "  Province: " + strProvince + "  Altitude: " + shAltitude);
	}
}
