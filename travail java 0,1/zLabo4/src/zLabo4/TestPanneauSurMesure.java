package zLabo4;

import java.awt.*;
import javax.swing.*;

public class TestPanneauSurMesure extends JFrame{

	public static void main(String[] args) {
		// TODO Auto-generated method stub	
		TestPanneauSurMesure q = new TestPanneauSurMesure();
	}
	
	public TestPanneauSurMesure(){
		super("TestForme");
		setSize(400,400);
		setLocationRelativeTo(null);
		
		PanneauSurMesure psm = new PanneauSurMesure();
		
		psm.dessiner(2);
		
		add(psm);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);	
	}
	
	private class PanneauSurMesure extends JPanel{
		public final int CERCLE = 1;
		public final int CARRE = 2;
		private int forme;
		
		public void paintComponent(Graphics g){
			super.paintComponent(g);
						
			if(forme == CERCLE) g.fillOval(50, 10, 60, 60);
			else if(forme == CARRE) g.fillRect(50, 10, 60, 60);
		}
		
		public void dessiner(int s){
			forme = s;
			repaint();
		}
	}
}