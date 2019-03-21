package laboratoire11;

public class ListeVideException extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = -4630351204372204478L;
	
	String strNom;
	
	ListeVideException(String strNom) {
		this.strNom = strNom;
	}

	@Override
	public String toString() {
		return "La liste  " + strNom + " est vide";
	}
}