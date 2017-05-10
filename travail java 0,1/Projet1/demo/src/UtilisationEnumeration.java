

public class UtilisationEnumeration {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub		ValeurCartes val1= ValeurCartes.AS;
		NomDivision  nomDivision1 = NomDivision.ATLANTIQUE;
		NomDivision  nomDivision2 = NomDivision.MÉTROPOLITAINE;
	
		System.out.println (" nomDivision1 = " + nomDivision1 + " nomDivision2 = "+ nomDivision2);
				
		// on peut l'utiliser dans un switch case..
		
		switch(nomDivision1){
		case  ATLANTIQUE: System.out.println("Atlantique");
		break;
		case MÉTROPOLITAINE: System.out.println("Métropolitaine");
		break;	
		}
		
		// énumération des éléments dans l'ordre de définition. 
		for(NomDivision nomDiv : NomDivision.values()){
			System.out.println(" ordre: " +nomDiv.ordinal() + " "+  nomDiv);

		}
		
		NomDivision[] tabNomDivision = NomDivision.values();
		
		for (NomDivision nomDiv:tabNomDivision){
			System.out.println(nomDiv);
		}
	}

}
