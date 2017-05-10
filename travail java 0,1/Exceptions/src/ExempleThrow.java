
class ExempleThrow {
    static void uneMethode() {
        int a = 0;
        try {
            if (a == 0) {
                throw new ArithmeticException("Division par 0"); 
            } else {
                System.out.println(5 / a);
            }
        } catch(ArithmeticException e) {
            System.out.println("Erreur arithmétique : " + e);
            e.printStackTrace();
        } 

    }
    
    public static void main(String args[]) {
    	ExempleThrow.uneMethode();
    }
}