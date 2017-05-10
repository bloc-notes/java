import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class TestPanneauSurMesure extends JFrame{

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TestPanneauSurMesure exe = new TestPanneauSurMesure();
	}
	
	public TestPanneauSurMesure(){
		JPanel panel = new JPanel();
		
		PanneauSurMesure ps = new PanneauSurMesure();
		
		ps.dessiner(1);
		
		add(ps);
		
		setSize(400, 400);
		setLocationRelativeTo(null);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}
	
	private class PanneauSurMesure extends JPanel {
		public final int CERCLE = 1;
		public final int CARRE = 2;
		private int forme;
		
		public void paintComponent (Graphics g){
			super.paintComponent(g);
			if(forme == CERCLE){
				g.fillOval (200,200,60,60);
			}else if (forme == CARRE){
				g.fillRect(50,10,60,60);
			}
		}
		
		public void dessiner (int s){
			forme = s;
			repaint();
		}
	}
}
