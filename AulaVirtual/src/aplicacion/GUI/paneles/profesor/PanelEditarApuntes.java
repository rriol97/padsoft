package aplicacion.GUI.paneles.profesor;

import java.awt.Dimension;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.SpringLayout;

import aplicacion.GUI.acciones.ActionVolverAsig;
import aplicacion.GUI.acciones.profesor.ActionEditarApuntes;
import aplicacion.GUI.acciones.profesor.ActionEliminarApuntes;
import aplicacion.GUI.general.Frame;
import aplicacion.clases.elemento.Apuntes;

public class PanelEditarApuntes extends JPanel {
	private static final long serialVersionUID = 1L;
	
	private JComboBox<String> visible;
	private JTextField texto;
	
	public PanelEditarApuntes (Apuntes apuntes, Object padre) {
		SpringLayout l = new SpringLayout();
		this.setLayout(l);
		
		this.texto = new JTextField();
		this.texto.setText(apuntes.getTexto());
		JScrollPane scroll_texto = new JScrollPane(this.texto);
		scroll_texto.setPreferredSize(new Dimension(250, 80));
		this.add(scroll_texto);
		
		String[] listaVisible = {"Visible", "No visible"};
		this.visible = new JComboBox <String> (listaVisible);
		this.add(this.visible);
		
		JPanel panel_botones = new JPanel();
		panel_botones.setLayout(new BoxLayout(panel_botones, 0));
		
		JButton boton_volver = new JButton("Volver");
		boton_volver.addActionListener(new ActionVolverAsig(apuntes.getAsignatura()));
		panel_botones.add(boton_volver);
		
		JButton boton_eliminar = new JButton("Eliminar");
		boton_eliminar.addActionListener(new ActionEliminarApuntes(apuntes, padre));
		panel_botones.add(boton_eliminar);
		
		JButton boton_finalizar = new JButton("Finalizar");
		boton_finalizar.addActionListener(new ActionEditarApuntes(this, apuntes));
		panel_botones.add(boton_finalizar);
		
		this.add(panel_botones);
		
		l.putConstraint(SpringLayout.NORTH, scroll_texto, (int)(Frame.HEIGHT/4), SpringLayout.NORTH, this);
		l.putConstraint(SpringLayout.WEST, scroll_texto, (int)(Frame.WIDTH/6), SpringLayout.WEST, this);
		
		l.putConstraint(SpringLayout.NORTH, visible, (int)(Frame.HEIGHT/4), SpringLayout.NORTH, this);
		l.putConstraint(SpringLayout.WEST, visible, 20, SpringLayout.EAST, scroll_texto);
		
		l.putConstraint(SpringLayout.NORTH, panel_botones, 20, SpringLayout.SOUTH, scroll_texto);
		l.putConstraint(SpringLayout.WEST, panel_botones, (int)(Frame.WIDTH/6), SpringLayout.WEST, this);
	}

	public JTextField getTexto() {
		return texto;
	}

	public JComboBox<String> getVisible() {
		return visible;
	}
}
