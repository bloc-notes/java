
public class Cercle {
	protected double dblCentreX;
	protected double dblCentreY;
	protected double dblRayon;
	
	public static void main(String[] args) {
		Cercle cer1 = new Cercle(8, 12, 4);
		Cercle cer2 = new Cercle(20, 20, 10);
		
		System.out.println(cer1);
		System.out.println(cer2);
	}
	
	public Cercle(double dblCentreX, double dblCentreY, double dblRayon) {
		this.dblCentreX = dblCentreX;
		this.dblCentreY = dblCentreY;
		this.dblRayon = dblRayon;
	}
	
	public double getPerimetre(){
		return 2*Math.PI*dblRayon;
	}
	
	public double getSurface(){
		return Math.PI*Math.pow(dblRayon, 2);
	}

	@Override
	public String toString() {
		return "Cercle [dblCentreX=" + dblCentreX + ", dblCentreY=" + dblCentreY + ", getPerimetre()=" + getPerimetre()
				+ ", getSurface()=" + getSurface() + "]";
	}
}
