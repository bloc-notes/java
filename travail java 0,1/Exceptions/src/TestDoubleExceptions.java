
class TestDoubleExceptions {
    int tableau[];

    void uneMethode(int i) {
        try {
            tableau[i] = 2;
            System.out.println(5 / 0);  		       
        } catch (ArithmeticException e) {
            System.out.println("Division par z�ro");
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("D�passement de bornes du tableau.");
        }
    }

    public static void main(String args[]) {
        TestDoubleExceptions t = new TestDoubleExceptions();
        t.tableau = new int[10];
        t.uneMethode(15);
    }
}
