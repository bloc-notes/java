
public class Mot {
	private String strMots;
	private DirectionMot direction;
	private int intPositionLigne;
	private int intPositionColonne;
	
	public Mot(String strMots, DirectionMot direction, int intPositionLigne, int intPositionColonne) {
		super();
		this.strMots = strMots;
		this.direction = direction;
		this.intPositionLigne = intPositionLigne;
		this.intPositionColonne = intPositionColonne;
	}

	public String getStrMots() {
		return strMots;
	}

	public DirectionMot getDirection() {
		return direction;
	}

	public int getIntPositionLigne() {
		return intPositionLigne;
	}

	public int getIntPositionColonne() {
		return intPositionColonne;
	}
}