import java.util.Scanner;


public class test {

	public static void main(String[] args) {
	Scanner scan = new Scanner(System.in);
   System.out.println("Entrez votre nom et prénom: ");

   String  strVotreNomPrenom = scan.nextLine();
   
  System.out.println( " vous avez tapé : "  +strVotreNomPrenom);
  
  System.out.println("Entrez encore votre nom et prénom: ");
  String  strEncoreVotreNom = scan.next();
   
  System.out.println( "votre nom est: " +strEncoreVotreNom);
  String  strVotrePreNom = scan.next();
  System.out.println( "votre prénom est: " +strVotrePreNom);
   
  System.out.println("entrez l'addition que vous voulez effectuer: "); 
  
   int nombre1 = scan.nextInt();
   String operateur = scan.next();
   int nombre2 = scan.nextInt();
   System.out.println( nombre1 + " "+ operateur+ " " + nombre2 );
}
}