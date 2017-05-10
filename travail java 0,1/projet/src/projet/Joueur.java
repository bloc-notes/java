package projet;

public class Joueur {
	private int intNumChandail;
	private String strNom;
	private String strPrenom;
	private PositionJoueur position;
	private int intAge;
	private int intPoids;
	private Equipe equipe;
	
	/*Constructeur: Initialise les variables d’instance à la valeur des arguments
	 * 
	 */
	public Joueur(int intNumChandail, String strNom, String strPrenom, PositionJoueur position, int intAge, int intPoids, Equipe equipe){
		this.intNumChandail = intNumChandail;
		this.strNom = strNom;
		this.strPrenom = strPrenom;
		this.position = position;
		this.intAge = intAge;
		this.intPoids = intPoids;
		this.equipe = equipe;
	}
	//
	public String toString() {
		return "\nNuméro de chandail: " + intNumChandail + "\nPrénom et nom: " + strPrenom + " " + strNom + "\nPosition: " + position
				+ "\nPoids: " + intPoids + "\nÂge: " + intAge + "\nÉquipe: " + equipe.getStrNom();
	}
	public int getIntNumChandail() {
		return intNumChandail;
	}
	public int getIntPoids() {
		return intPoids;
	}
	public Equipe getEquipe() {
		return equipe;
	}
	public PositionJoueur getPosition() {
		return position;
	}
	public void setEquipe(Equipe equipe) {
		this.equipe = equipe;
	}
}
