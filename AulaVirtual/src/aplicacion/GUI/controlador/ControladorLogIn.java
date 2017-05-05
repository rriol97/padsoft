package aplicacion.GUI.controlador;

import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JOptionPane;

import aplicacion.GUI.general.Frame;
import aplicacion.GUI.login.FrameLogin;
import aplicacion.GUI.login.PanelLogin;
import aplicacion.clases.Aplicacion;

public class ControladorLogIn implements ActionListener {
	
	private PanelLogin vista;
	
	public ControladorLogIn (PanelLogin vista){
		this.vista = vista;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		String usu = vista.getUsuario();
		String psw = vista.getPassword();
		
		if (usu.equals("") || psw.equals("")){
			JOptionPane.showMessageDialog(vista, "Debe introducir su nombre de usuario y contrasena para iniciar sesion");
		}
		
		try {
			if (Aplicacion.getInstance().logIn(usu, psw) == false){
				JOptionPane.showMessageDialog(vista, "Error, usuario y/o contrasena incorrectos");
			}
			else{
				FrameLogin.getInstance().borrarLogin();
				Frame.getInstance().iniPaneles();
				Frame.getInstance().setVisible(true);
			}
		} catch (HeadlessException | ClassNotFoundException | IOException e1) {
			e1.printStackTrace();
		}

	}
			
}
	

