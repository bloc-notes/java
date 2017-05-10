import java.awt.BorderLayout;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.jws.HandlerChain;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Exercice2 extends JFrame {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Exercice2 exe = new Exercice2();
	}

	private PanneauSurMesure ps;
	private JLabel barreEtat;
	private String strDetail = "";
	int intCompteurGauche = 0;
	int intCompteurDroit = 0;

	public Exercice2() {
		ps = new PanneauSurMesure();
		barreEtat = new JLabel();
		setLayout(new BorderLayout());

		add(ps, BorderLayout.CENTER);
		add(barreEtat, BorderLayout.SOUTH);
		
		ps.setSize(400, 400);
		
		strDetail = String.format("Coordonnées: ");
		strDetail += " | Clic gauche: " + intCompteurGauche;
		strDetail += " | Clic droit: " + intCompteurDroit;

		addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				
				if (e.getButton() == MouseEvent.BUTTON1) {
					ps.dessiner(1,e.getX(),e.getY());
					intCompteurGauche++;
					
				} 
				
				if (e.getButton() == MouseEvent.BUTTON3) {
					ps.dessiner(2,e.getX(),e.getY());
					intCompteurDroit++;
				}
				
				strDetail = String.format("Coordonnées: %d, %d", e.getX(), e.getY());
				strDetail += " | Clic gauche: " + intCompteurGauche;
				strDetail += " | Clic droit: " + intCompteurDroit;
				
				barreEtat.setText(strDetail);
				//ps.dessiner(1);
			}
		});
		
		barreEtat.setText(strDetail);
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
		private int cooX;
		private int cooY;

		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			if (forme == CERCLE) {
				g.fillOval(cooX-30, cooY-50, 60, 60);
			} else if (forme == CARRE) {
				g.fillRect(cooX-30, cooY-50, 60, 60);
			}
		}

		public void dessiner(int intForme,int X,int Y) {
			forme = intForme;
			cooX = X;
			cooY = Y;
			System.out.println(cooX + " " + cooY + " " + forme);
			repaint();
		}
	}
}
