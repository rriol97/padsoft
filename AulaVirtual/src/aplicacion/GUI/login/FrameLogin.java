package aplicacion.GUI.login;

import javax.swing.*;

/**
 * Clase que implementa la ventana mostrada al iniciar al iniciar la aplicacion. Pide un usuario y contrasena.
 * @author Adrian Fernandez
 * @author Ricardo Riol
 *
 */
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
	
	/**
	 * Metodo que oculta la ventana de login cuando se accede a la aplicacion.
	 */
	public void borrarLogin(){
		this.setVisible(false);
	}
}
