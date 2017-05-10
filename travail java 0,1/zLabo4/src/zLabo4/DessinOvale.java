package zLabo4;

import java.awt.Graphics;
import javax.swing.JPanel;
	
public class DessinOvale extends JPanel{
	private int diametre;
		
	public void paintComponent(Graphics g){
		super.paintComponent(g);
			
		g.fillOval(25, 25, diametre, diametre);	
	}
		
	public void setDiametre(int d){
		if(d >=0) diametre =d;
		else diametre = 10;
	}
}