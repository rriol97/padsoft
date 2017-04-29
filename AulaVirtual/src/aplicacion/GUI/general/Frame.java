package aplicacion.GUI.general;

import java.awt.BorderLayout;
import java.awt.Toolkit;

import javax.swing.*;

public class Frame extends JFrame {
	private static final long serialVersionUID = 1L;
	public static final double WIDTH = Toolkit.getDefaultToolkit().getScreenSize().getWidth();
	public static final double HEIGHT = Toolkit.getDefaultToolkit().getScreenSize().getHeight();
	private static Frame instance = new Frame();
	private JPanel der;
	private JPanel izq;
	
	private Frame (){
		super("Aula Virtual");
		this.setLayout(new BorderLayout());
		this.der = null;
		this.izq = null;
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setExtendedState(MAXIMIZED_BOTH);
	}
	public static Frame getIntance(){
		return instance;
	}
	
	public void cambiarPanel (JPanel nuevo, int panel) {
		if (nuevo == null) {
			return;
		}
		
		if (panel == 0) {
			if (this.izq != null) {
				this.izq.setVisible(false);
			}
			nuevo.setVisible(true);
			this.add(nuevo,BorderLayout.WEST);
			this.izq = nuevo;
			this.repaint();
		} else if (panel == 1) {
			if (this.der != null) {
				this.der.setVisible(false);
			}
			nuevo.setVisible(true);
			this.add(nuevo,BorderLayout.CENTER);
			this.der = nuevo;
			this.repaint();
		}
	}
}
