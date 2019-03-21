
public class GestionDesDeuxExceptions {
	  int tableau[];

	    void uneMethode(int i) {
	        try {
	            tableau[i] = 2;
	           }catch (ArrayIndexOutOfBoundsException e) {
		            System.out.println("D�passement de bornes du tableau.");
		        }
	        
	         try {
	            System.out.println(5 / 0);  
	            } catch (ArithmeticException e) {
	            System.out.println("Division par z�ro");
	        }
	    }

	    public static void main(String args[]) {
	    	GestionDesDeuxExceptions t = new GestionDesDeuxExceptions();
	        t.tableau = new int[10];
	        t.uneMethode(15);
	    }
	}


