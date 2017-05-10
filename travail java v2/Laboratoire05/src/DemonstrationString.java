
public class DemonstrationString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		String str1 = "allo";
		String str2 = "allo2";
		String str3 = "allo";
		
		if(str1 == str2){
			System.out.println("Fonctionne");
		}
		else{
			System.out.println("Fonctionne pas");
		}
		
		if(str1 == str3){
			System.out.println("Fonctionne");
		}
		else{
			System.out.println("Fonctionne pas");
		}
		
		String strTest1 = new String("allo");
		String strTest2 = new String("allo");
		
		if(strTest1 == strTest2){
			System.out.println("Fonctionne");
		}
		else{
			System.out.println("Fonctionne pas");
		}
		
		//Le premier exemple fonctionne pas, car c'est deux objet différent.
		
		//Le deuxième exemple fonctionne, car lorsque déclarer sans new String les deux variable pointent vers le même objet. La raison 
		//est qu'ils ont la même valeur.
		
		//Dans le troisième exemple, les deux objets sont déclarés avec new String. Donc, les objets sont différents. Vu que le == compare 
		//les objet et non le contenue, cela ne fonctionne pas.
		
	}

}
