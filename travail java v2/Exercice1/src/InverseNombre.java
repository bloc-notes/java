public class InverseNombre {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int intNbInverser = 0;
		int intNombreDepart = 6778725;
		
		while(intNombreDepart > 0){
			intNbInverser += intNombreDepart % 10;
			intNombreDepart = intNombreDepart / 10;
			
			if(intNombreDepart != 0){
				intNbInverser*=10;	
			}
		}	
		System.out.println("Nombre inverser : " + intNbInverser);	
	}
}
