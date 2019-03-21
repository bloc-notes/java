import java.util.Stack;

public class TestPile {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Stack<Object> maPile = new Stack<Object>();
		
		System.out.println("push -> " + maPile.push(true));
		
		System.out.println("Stack: " + maPile + "\n");
		
		System.out.println("push -> " + maPile.push('$'));
		
		System.out.println("Stack: " + maPile + "\n");
		
		System.out.println("push -> " + maPile.push(34567));
		
		System.out.println("Stack: " + maPile + "\n");
		
		System.out.println("push -> " + maPile.push("merci"));
		
		System.out.println("Stack: " + maPile + "\n");
		
		while (!maPile.empty()) {
			System.out.print("pop -> ");
			Object a = (Object) maPile.pop();
		    System.out.println(a);
		    System.out.println("Stack: " + maPile + "\n");
			
		}
		if (maPile.empty()) {
			System.out.println("Stack Vide");
		}
	      
		/*maPile.pop();
		maPile.pop();
		maPile.pop();
		maPile.pop();*/
		
		//System.out.println("Stack: " + maPile);

	}

}
