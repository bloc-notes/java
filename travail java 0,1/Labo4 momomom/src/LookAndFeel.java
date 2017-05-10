import javax.swing.UIManager;

public class LookAndFeel {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		UIManager.LookAndFeelInfo aspects[] = UIManager.getInstalledLookAndFeels();
		try {
			System.out.println(aspects[0].getName());
			System.out.println(aspects.length);
			for (int i = 0; i < aspects.length; i++) {
				System.out.println(aspects[i].getClassName());
				
			}
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("LookAndFeel Invalide-");
		}

	}

}
