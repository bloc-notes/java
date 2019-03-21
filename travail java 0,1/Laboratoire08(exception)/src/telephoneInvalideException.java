
public class telephoneInvalideException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2039357874683579866L;
	
	
	public String toString() {
		return "Mauvais format, le format doit etre des chiffres organiser comme se suit: (###)###-####";
	}
}