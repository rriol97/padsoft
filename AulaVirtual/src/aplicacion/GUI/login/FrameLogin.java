package aplicacion.GUI.login;

import javax.swing.*;

import aplicacion.GUI.general.Frame;

public class FrameLogin extends JFrame {
	private static final long serialVersionUID = 1L;

	private static FrameLogin instance = new FrameLogin();
	
	private FrameLogin(){
		super("Login");
		JPanel panel = new PanelLogin();
		this.getContentPane().add(panel);
		this.setSize (280, 135);
		this.setResizable(false);
		this.setVisible(true);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public static FrameLogin getInstance(){
		return instance;
	}
	
	public void borrarLogin(){
		this.dispose();
	}
}
