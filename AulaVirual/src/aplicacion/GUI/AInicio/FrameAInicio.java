package aplicacion.GUI.AInicio;

import javax.swing.*;

public class FrameAInicio extends JFrame {
	private static final long serialVersionUID = 1L;

	public FrameAInicio(){
		super("Inicio alumno");
		JPanel panel = new PanelAInicio();
		this.getContentPane().add(panel);
		this.setSize (500, 500);
		this.setResizable(false);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
