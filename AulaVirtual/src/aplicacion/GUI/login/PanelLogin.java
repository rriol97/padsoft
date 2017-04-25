package aplicacion.GUI.login;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.*;

import aplicacion.GUI.SpringUtilities;

public class PanelLogin extends JPanel {
	private static final long serialVersionUID = 1L;

	public PanelLogin () {
		this.setLayout(new BorderLayout());
		
		JPanel texto = new JPanel();
		texto.setLayout(new SpringLayout());
		
		JLabel etiqueta_user = new JLabel("Usuario: ", JLabel.TRAILING);
		texto.add(etiqueta_user);
		JTextField campo_user = new JTextField(10);
		etiqueta_user.setLabelFor(campo_user);
		texto.add(campo_user);
		
		JLabel etiqueta_psw = new JLabel("Contraseña: ", JLabel.TRAILING);
		texto.add(etiqueta_psw);
		JPasswordField campo_psw = new JPasswordField(10);
		etiqueta_psw.setLabelFor(campo_psw);
		texto.add(campo_psw);
		
		SpringUtilities.makeCompactGrid(texto, 2, 2, 6, 6, 6, 6);
		this.add(texto, BorderLayout.CENTER);
		
		JPanel botones = new JPanel();
		botones.setLayout(new FlowLayout());
		JButton boton = new JButton ("Login");
		botones.add(boton);
		
		this.add(botones, BorderLayout.SOUTH);
	}
}
