package aplicacion.GUI.PInicio;

import javax.swing.*;

public class FramePInicio extends JFrame {
	private static final long serialVersionUID = 1L;

	public FramePInicio(){
		super("Inicio profesor");
		JPanel panel = new PanelPInicio();
		this.getContentPane().add(panel);
		this.setSize (500, 500);
		this.setResizable(false);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
