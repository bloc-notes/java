package zLabo4;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JSlider;
import javax.swing.SwingConstants;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class ExerciceJSlide extends JFrame {
	DessinOvale objDessin;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ExerciceJSlide exe = new ExerciceJSlide();
	}
	
	public ExerciceJSlide(){
		super("Utilisation d'un JSlider");
		setSize(250,300);
		setLocationRelativeTo(null);
		
		final JSlider JSDiametre=new JSlider(SwingConstants.HORIZONTAL,0,200,10);
		JSDiametre.setMajorTickSpacing(10);
		JSDiametre.setPaintTicks(true);
		objDessin= new DessinOvale();
		JSDiametre.addChangeListener(new ChangeListener() {
			
			@Override
			public void stateChanged(ChangeEvent e) {
				// TODO Auto-generated method stub
				objDessin.setDiametre(JSDiametre.getValue());
				objDessin.repaint();
			}
		});
		add(objDessin,BorderLayout.CENTER);
		add(JSDiametre,BorderLayout.SOUTH);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		setVisible(true);
	}
}