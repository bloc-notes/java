
class DemoThrows {
    static void uneMethode() throws IllegalAccessException {
        System.out.println("dans la méthode");
        throw new IllegalAccessException("demo");
    }
 
    public static void main(String args[]) {
        try {
            uneMethode();
        } catch (IllegalAccessException e) {
            System.out.println("attrapée : " + e);
        }
    }
}
