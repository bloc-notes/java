
class DemoFinally {
    static void methode1() {
        try {
            System.out.println("Dans la m�thode 1.");
            throw new RuntimeException("D�monstration m�thode 1");
        } finally {
            System.out.println("Le finally de la m�thode 1 est ex�cut�.");
        }
    }

    static void methode2() {
    	
        try {
            System.out.println("Dans la m�thode 2.");
            return;
        } finally {
            System.out.println("Le finally de la m�thode 2 est ex�cut�.");
        }
    }
  
    public static void main(String args[]) {
        try {
            methode1();
        } catch (Exception e) {
        	
        } finally {
            System.out.println("Le finally de la m�thode main est ex�cut�.");
            methode2();
          
        }
    }
}
