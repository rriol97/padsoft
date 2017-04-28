package aplicacion.GUI.general;

import java.awt.Toolkit;

import javax.swing.*;



public class Frame extends JFrame {
	private static final long serialVersionUID = 1L;
	public static final double WIDTH = Toolkit.getDefaultToolkit().getScreenSize().getWidth();
	public static final double HEIGHT = Toolkit.getDefaultToolkit().getScreenSize().getHeight();
	public Frame(){
		super("Aula Virtual");
		String []asig = {"Hola", "Adios"};
		JTree b = new JTree();
		PanelAInicio a = new PanelAInicio(asig,b);
		a.setVisible(true);
		this.getContentPane().add(a);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setExtendedState(MAXIMIZED_BOTH);
	}
	
	public static void cambiarPanel (JPanel actual, JPanel nuevo) {
		actual.setVisible(false);
		nuevo.setVisible(true);
	}
}
