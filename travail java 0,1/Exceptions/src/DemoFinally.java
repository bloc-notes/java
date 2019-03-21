
class DemoFinally {
    static void methode1() {
        try {
            System.out.println("Dans la méthode 1.");
            throw new RuntimeException("Démonstration méthode 1");
        } finally {
            System.out.println("Le finally de la méthode 1 est exécuté.");
        }
    }

    static void methode2() {
    	
        try {
            System.out.println("Dans la méthode 2.");
            return;
        } finally {
            System.out.println("Le finally de la méthode 2 est exécuté.");
        }
    }
  
    public static void main(String args[]) {
        try {
            methode1();
        } catch (Exception e) {
        	
        } finally {
            System.out.println("Le finally de la méthode main est exécuté.");
            methode2();
          
        }
    }
}
