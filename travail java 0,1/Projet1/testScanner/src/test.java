import java.util.Scanner;


public class test {

	public static void main(String[] args) {
	Scanner scan = new Scanner(System.in);
   System.out.println("Entrez votre nom et pr�nom: ");

   String  strVotreNomPrenom = scan.nextLine();
   
  System.out.println( " vous avez tap� : "  +strVotreNomPrenom);
  
  System.out.println("Entrez encore votre nom et pr�nom: ");
  String  strEncoreVotreNom = scan.next();
   
  System.out.println( "votre nom est: " +strEncoreVotreNom);
  String  strVotrePreNom = scan.next();
  System.out.println( "votre pr�nom est: " +strVotrePreNom);
   
  System.out.println("entrez l'addition que vous voulez effectuer: "); 
  
   int nombre1 = scan.nextInt();
   String operateur = scan.next();
   int nombre2 = scan.nextInt();
   System.out.println( nombre1 + " "+ operateur+ " " + nombre2 );
}
}