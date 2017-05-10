
public class Point {
	public int x;
	public int y;
	
	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	double distance(int x, int y){
		return Math.sqrt(Math.pow((x - this.x), 2) + Math.pow((y - this.y), 2));
	}
	
	double distance(Point p){
		return Math.sqrt(Math.pow((p.x - this.x), 2) + Math.pow((p.y - this.y), 2));
	}
}
