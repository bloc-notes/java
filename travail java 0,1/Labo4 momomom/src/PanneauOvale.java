import java.awt.Graphics;

import javax.swing.JPanel;

public class PanneauOvale extends JPanel{

	private int intDiametre;

	public void paintComponent(Graphics g){
		super.paintComponent(g);
		g.fillOval(20, 20, intDiametre, intDiametre);
		System.out.println(intDiametre);
	}
	
	public void setDiametre(int d){
		if (d >= 0) {
			intDiametre = d;
		}
		else {
			intDiametre = 10;
		}
		
	}
}
