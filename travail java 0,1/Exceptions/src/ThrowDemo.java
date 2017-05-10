
class ThrowDemo {
    static void methodeDemo() {
        try {
            throw new NullPointerException("demo");
        } catch(NullPointerException e) {
            System.out.println("exception attrapée dans la méthode methodeDemo");
            throw e;  // on relance l’exception après avoir traité la situation 			  //exceptionnelle
        }
    }

    public static void main(String args[]) {
        try {
            methodeDemo();
        } catch(NullPointerException e) {
            System.out.println("exception attrapée de nouveau dans main");
        }
    }
}
