class TestDoubleExceptions2 {
    int tableau[];

    void uneMethode(int i) {
        try {
        	 System.out.println(5 / 0); 
              tableau[i] = 2;
            		       
        } catch (ArithmeticException e) {
            System.out.println("Division par zéro");
        }
    }

    public static void main(String args[]) {
        TestDoubleExceptions2 t = new TestDoubleExceptions2();
        t.tableau = new int[10];    
        try {    
            t.uneMethode(15);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Dépassement de bornes du tableau.");
        }
    }
}
