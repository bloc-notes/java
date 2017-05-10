import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.SwingConstants;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class PanneauOvale2 extends JFrame {
	private PanneauOvale po;
	private JSlider JSDiametre;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PanneauOvale2 po2 = new PanneauOvale2();
		
	}

	public PanneauOvale2() {
		setTitle("Utilisation d'un JSlider");
		//setLayout(new BorderLayout());
		
		po = new PanneauOvale();
		po.setDiametre(10);
		
		JSDiametre = new JSlider(SwingConstants.HORIZONTAL,0,200,10);
		JSDiametre.setMajorTickSpacing(10);
		JSDiametre.setPaintTicks(true);
		
		JSDiametre.addChangeListener(new ChangeListener() {
			
			@Override
			public void stateChanged(ChangeEvent arg0) {
				// TODO Auto-generated method stub
				System.out.println(JSDiametre.getValue());
				po.setDiametre(JSDiametre.getValue());
				po.repaint();
				
			}
		});
		
		add(po,BorderLayout.CENTER);
		add(JSDiametre,BorderLayout.SOUTH);
		
		setSize(250, 300);
		setLocationRelativeTo(null);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}

}
