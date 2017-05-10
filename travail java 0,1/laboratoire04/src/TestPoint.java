
public class TestPoint {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Point p1 = new Point(5, 10);
		Point p2 = new Point(10, 50);
		Point p3 = new Point(30, 20);
		
		System.out.println(p1.distance(p2));
		System.out.println(p1.distance(p3));
		System.out.println(p1.distance(10, 20) + "\n");
		
		System.out.println(p2.distance(p3));
		System.out.println(p2.distance(10, 20) + "\n");
		
		System.out.println(p3.distance(10, 20));
	}

}
