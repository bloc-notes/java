package projet;

public class Joueur {
	private int intNumChandail;
	private String strNom;
	private String strPrenom;
	private PositionJoueur position;
	private int intAge;
	private int intPoids;
	private Equipe equipe;
	
	/*Constructeur: Initialise les variables d�instance � la valeur des arguments
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
		return "\nNum�ro de chandail: " + intNumChandail + "\nPr�nom et nom: " + strPrenom + " " + strNom + "\nPosition: " + position
				+ "\nPoids: " + intPoids + "\n�ge: " + intAge + "\n�quipe: " + equipe.getStrNom();
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
