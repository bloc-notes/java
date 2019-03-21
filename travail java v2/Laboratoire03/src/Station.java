
public class Station {
	
	private String strNom;
	private String strProvince;
	private Short shAltitude;
	
	public Station(String strNom, String strProvince, Short shAltitude) {
		super();
		this.strNom = strNom;
		this.strProvince = strProvince;
		this.shAltitude = shAltitude;
	}

	public String getStrNom() {
		return strNom;
	}

	public String getStrProvince() {
		return strProvince;
	}

	public Short getShAltitude() {
		return shAltitude;
	}

	public void  afficherInfoStation() {
		System.out.println("Station [strNom=" + strNom + ", strProvince=" + strProvince + ", shAltitude=" + shAltitude + "]");
	}
}