package projet1;

public enum EnumProgramme {INFORMATQUE("Informatique"), ELECTRONIQUE("Electronique"), COMPTABILITE("Comptabilit�"), SOINSINFIRMIERS("Soins Infirmiers"),
	EDUCATIONENFANCE("Education � l'enfance"), SCIENCESNATURE("Sciences Natures"),
	SCIENCESHUMAINES("Sciences Humaines"), ARTSETLETTRES("Arts et Lettres");
	
	String strNomProgramme;
	
	private EnumProgramme(String strNomProgramme) {
		this.strNomProgramme = strNomProgramme;
	}

	public String getStrNomProgramme() {
		return strNomProgramme;
	}
}
