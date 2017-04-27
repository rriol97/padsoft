package aplicacion.GUI.general;

import java.awt.Toolkit;

import javax.swing.*;


public class Frame extends JFrame {
	private static final long serialVersionUID = 1L;
	public static double WIDTH = Toolkit.getDefaultToolkit().getScreenSize().getWidth();
	public static double HEIGHT = Toolkit.getDefaultToolkit().getScreenSize().getHeight();
	public Frame(){
		super("Aula Virtual");
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setExtendedState(MAXIMIZED_BOTH);
	}
	
	public void cambiarPanel (JPanel panel) {
		this.getContentPane().add(panel);
	}
}
