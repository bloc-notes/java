//Philippe Doyon
public class Point {
	int intx;
	int inty;
	
	public Point(int intx, int y) {
		this.intx = intx;
		this.inty = y;
	}
	
	public double distance(int x2, int y2){
		return(Math.sqrt((Math.pow((x2 - intx), 2)) + (Math.pow((y2-inty), 2))));
	}
	
	public double distance(Point p){
		return(Math.sqrt((Math.pow((p.intx - intx), 2)) + (Math.pow((p.inty-inty), 2))));
	}
}