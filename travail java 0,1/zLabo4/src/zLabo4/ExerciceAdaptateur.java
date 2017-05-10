package zLabo4;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class ExerciceAdaptateur extends JFrame{
	private int intCompteurCercle;
	private int intCompteurCarre;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ExerciceAdaptateur adp = new ExerciceAdaptateur();
	}
	
	public ExerciceAdaptateur() {
		// TODO Auto-generated constructor stub
		super("Classe Adaptateur");
		setSize(400,400);
		setLocationRelativeTo(null);
		
		final PanneauSurMesure psm = new PanneauSurMesure();
		
		final JLabel barreEtat = new JLabel("Nombre clic gauche: " + intCompteurCercle + "     Nombre clic droit: " + intCompteurCarre);
		
		addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				if(e.getButton() == MouseEvent.BUTTON1){
					psm.dessiner(1, e.getX()-32, e.getY()-60);
					intCompteurCercle++;
				}
				else if(e.getButton() == MouseEvent.BUTTON3){
					psm.dessiner(2, e.getX()-32, e.getY()-60);
					intCompteurCarre++;
				}
				barreEtat.setText("Nombre clic gauche: " + intCompteurCercle + "     Nombre clic droit: " + intCompteurCarre);
			}
		});
			
		barreEtat.setHorizontalAlignment(SwingConstants.CENTER);
		add(barreEtat,BorderLayout.SOUTH);
		
		add(psm);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		setVisible(true);
	}
	
	private class PanneauSurMesure extends JPanel{
		public final int CERCLE = 1;
		public final int CARRE = 2;
		private int forme;
		private int cordX;
		private int cordY;
		
		public void paintComponent(Graphics g){
			super.paintComponent(g);
						
			if(forme == CERCLE){
				g.setColor(Color.green);
				g.fillOval(cordX, cordY, 60, 60);
				
			}
			else if(forme == CARRE) {
				g.setColor(Color.BLUE);
				g.fillRect(cordX, cordY, 60, 60);	
			}
		}
		
		public void dessiner(int s, int x, int y){
			forme = s;
			cordX = x;
			cordY = y;
			repaint();
		}
	}
}