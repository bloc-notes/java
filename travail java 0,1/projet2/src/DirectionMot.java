
public enum DirectionMot {
	NORD(-1,0),
	NORD_EST(-1,1),
	EST(0,1),
	SUD_EST(1,1),
	SUD(1,0),
	SUD_OUEST(1,-1),
	OUEST(0,-1),
	NORD_OUEST(-1,-1);
	
	private int intLigne;
	private int intColonne;
	
	private DirectionMot(int intLigne, int intColonne) {
		this.intLigne = intLigne;
		this.intColonne = intColonne;
	}
	
	public int getIntLigne() {
		return intLigne;
	}
	public int getIntColonne() {
		return intColonne;
	}	
}