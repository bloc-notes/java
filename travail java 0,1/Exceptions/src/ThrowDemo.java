
class ThrowDemo {
    static void methodeDemo() {
        try {
            throw new NullPointerException("demo");
        } catch(NullPointerException e) {
            System.out.println("exception attrap�e dans la m�thode methodeDemo");
            throw e;  // on relance l�exception apr�s avoir trait� la situation 			  //exceptionnelle
        }
    }

    public static void main(String args[]) {
        try {
            methodeDemo();
        } catch(NullPointerException e) {
            System.out.println("exception attrap�e de nouveau dans main");
        }
    }
}
