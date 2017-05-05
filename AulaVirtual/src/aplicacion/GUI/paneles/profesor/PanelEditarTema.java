package aplicacion.GUI.paneles.profesor;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.SpringLayout;

import aplicacion.GUI.SpringUtilities;
import aplicacion.GUI.acciones.ActionVolverAsig;
import aplicacion.GUI.acciones.profesor.ActionEditarTema;
import aplicacion.GUI.acciones.profesor.ActionEliminarTema;
import aplicacion.GUI.general.Frame;
import aplicacion.clases.elemento.Tema;

public class PanelEditarTema extends JPanel {
	private static final long serialVersionUID = 1L;
	
	private JComboBox<String> visible;
	
	public PanelEditarTema (Tema tema, Object padre) {
		this.setLayout(new BoxLayout(this,1));
		
		JPanel aux = new JPanel();
		SpringLayout y = new SpringLayout();
		aux.setLayout(y);
		String[] listaVisible = {"Visible", "No visible"};
		this.visible = new JComboBox <String> (listaVisible);
		//this.visible.setPreferredSize(new Dimension((int)Frame.WIDTH/4,(int)Frame.HEIGHT/10));
		aux.add(visible);
		//y.putConstraint(SpringLayout.SOUTH, visible, (int)Frame.WIDTH/4, SpringLayout.SOUTH, aux);
		this.add(aux);
		
		JPanel panel_botones = new JPanel();
		panel_botones.setLayout(new BoxLayout(panel_botones, 0));
		
		JButton boton_volver = new JButton("Volver");
		boton_volver.addActionListener(new ActionVolverAsig(tema.getAsignatura()));
		panel_botones.add(boton_volver);
		
		JButton boton_eliminar = new JButton("Eliminar");
		boton_eliminar.addActionListener(new ActionEliminarTema(tema, padre));
		panel_botones.add(boton_eliminar);
		
		JButton boton_finalizar = new JButton("Finalizar");
		boton_finalizar.addActionListener(new ActionEditarTema(this, tema));
		panel_botones.add(boton_finalizar);
		
		this.add(panel_botones);
		
		//SpringUtilities.makeCompactGrid(this, 2, 1, 5, 5, 5, 5);
	}

	public JComboBox<String> getVisible() {
		return visible;
	}
}
