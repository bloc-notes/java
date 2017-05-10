
public class TestPoint {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Point p1 = new Point(10, 3);
		Point p2 = new Point(24, -16);
		Point p3 = new Point(25, 32);
				
		System.out.println(p1.distance(p2) + "\n" + p1.distance(p3) + "\n" + p1.distance(10, 20) + "\n" + p2.distance(p3)
				+ "\n" + p2.distance(10, 20) + "\n" + p3.distance(10, 20));
	}
}