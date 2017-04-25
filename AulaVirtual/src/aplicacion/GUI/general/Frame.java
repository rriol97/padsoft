package aplicacion.GUI.general;

import javax.swing.*;

public class Frame extends JFrame {
	private static final long serialVersionUID = 1L;

	public Frame(){
		super("Aula Virtual");
		this.setSize (500, 500);
		this.setResizable(false);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public void cambiarPanel (JPanel panel) {
		this.getContentPane().add(panel);
	}
}
