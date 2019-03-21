
class TestDoubleExceptions {
    int tableau[];

    void uneMethode(int i) {
        try {
            tableau[i] = 2;
            System.out.println(5 / 0);  		       
        } catch (ArithmeticException e) {
            System.out.println("Division par zéro");
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Dépassement de bornes du tableau.");
        }
    }

    public static void main(String args[]) {
        TestDoubleExceptions t = new TestDoubleExceptions();
        t.tableau = new int[10];
        t.uneMethode(15);
    }
}
