package aplicacion.GUI.controlador;

import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import aplicacion.GUI.general.Frame;
import aplicacion.GUI.general.PanelAInicio;
import aplicacion.GUI.login.PanelLogin;
import aplicacion.clases.Aplicacion;

public class ActionLogIn implements ActionListener {
	
	private PanelLogin vista;
	
	public ActionLogIn (PanelLogin vista){
		this.vista = vista;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		String usu = vista.getUsuario();
		String psw = vista.getPassword();
		
		if (usu.equals("")){
			JOptionPane.showMessageDialog(vista, "Debe introducir su nobre de usuario y contraseña para iniciar sesión");
		}
		
		if (psw.equals("")){
			JOptionPane.showMessageDialog(vista, "Debe introducir su nombre de usuario y contraseña para iniciar sesión");
		}
		
		try {
			if (Aplicacion.getInstance().logIn(usu, psw) == false){
				JOptionPane.showMessageDialog(vista, "Error, usuario y contraseñas incorrectos");
			}
			else{
				Frame f = new Frame();
				f.setVisible(true);
				this.vista.setVisible(false);
			}
		} catch (HeadlessException | ClassNotFoundException | IOException e1) {
			e1.printStackTrace();
		}

		}
				
	}
	

