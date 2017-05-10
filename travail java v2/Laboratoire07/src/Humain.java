
public class Humain extends Mammifere implements AnimalQuiNage{
	public Humain(String strNom, String strLangueParlee) {
		super(strNom, 2);
		
		this.strLangueParlee = strLangueParlee;
	}

	private String strLangueParlee;
	
	public void parler(String strTexte){
		System.out.println("L'humain " + this.getStrNom() + " dit " + strTexte + " en " + strLangueParlee);
	}
	
	public void nager(){
		System.out.println("L'humain nage, plus ou moins gracieusement");
	}
}
