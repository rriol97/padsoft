package aplicacion.GUI.login;

import javax.swing.*;

public class FrameLogin extends JFrame {
	private static final long serialVersionUID = 1L;

	public FrameLogin(){
		super("Login");
		JPanel panel = new PanelLogin();
		this.getContentPane().add(panel);
		this.setSize (280, 135);
		this.setResizable(false);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
