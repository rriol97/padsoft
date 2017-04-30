package aplicacion.GUI.login;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.*;

import aplicacion.GUI.SpringUtilities;
import aplicacion.GUI.controlador.ControladorLogIn;

/**
 * Clase que implementa el panel mostrado al iniciar al iniciar la aplicacion. Pide un usuario y contrasena.
 * @author Adrian Fernandez
 * @author Ricardo Riol
 *
 */
public class PanelLogin extends JPanel{
	private static final long serialVersionUID = 1L;
	private JLabel etiqueta_user;
	private JTextField campo_user;
	private JLabel etiquetaPsw;
	private JPasswordField campoPsw;
	private JButton boton;

	public PanelLogin () {
		this.setLayout(new BorderLayout());
		
		JPanel texto = new JPanel();
		texto.setLayout(new SpringLayout());
		
		etiqueta_user = new JLabel("Usuario: ", JLabel.TRAILING);
		texto.add(etiqueta_user);
		campo_user = new JTextField(10);
		etiqueta_user.setLabelFor(campo_user);
		texto.add(campo_user);
		
		etiquetaPsw = new JLabel("Contrasena: ", JLabel.TRAILING);
		texto.add(etiquetaPsw);
		campoPsw = new JPasswordField(10);
		etiquetaPsw.setLabelFor(campoPsw);
		texto.add(campoPsw);
		
		SpringUtilities.makeCompactGrid(texto, 2, 2, 6, 6, 6, 6);
		this.add(texto, BorderLayout.CENTER);
		
		JPanel botones = new JPanel();
		botones.setLayout(new FlowLayout());
		boton = new JButton ("Login");
		botones.add(boton);
		
		this.add(botones, BorderLayout.SOUTH);
		
		boton.addActionListener(new ControladorLogIn(this));
		
	}
	
	public String getUsuario(){
		return this.campo_user.getText();
	}
	
	public String getPassword(){
		return String.valueOf(this.campoPsw.getPassword());
	}
}
