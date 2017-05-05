package aplicacion.GUI.paneles.profesor;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SpringLayout;

import aplicacion.GUI.SpringUtilities;
import aplicacion.GUI.acciones.ActionVolverAsig;
import aplicacion.GUI.acciones.profesor.ActionEditarApuntes;
import aplicacion.GUI.acciones.profesor.ActionEliminarApuntes;
import aplicacion.clases.elemento.Apuntes;

public class PanelEditarApuntes extends JPanel {
	private static final long serialVersionUID = 1L;
	
	private JComboBox<String> visible;
	private JTextField texto;
	
	public PanelEditarApuntes (Apuntes apuntes, Object padre) {
		this.setLayout(new SpringLayout());
		
		JPanel panel_edicion = new JPanel();
		panel_edicion.setLayout(new SpringLayout());
		
		this.texto = new JTextField();
		this.texto.setText(apuntes.getTexto());
		panel_edicion.add(this.texto);
		
		String[] listaVisible = {"Visible", "No visible"};
		this.visible = new JComboBox <String> (listaVisible);
		panel_edicion.add(this.visible);
		
		SpringUtilities.makeCompactGrid(panel_edicion, 2, 1, 0, 0, 5, 5);
		
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
		
		SpringUtilities.makeCompactGrid(this, 2, 1, 5, 5, 5, 5);
	}

	public JTextField getTexto() {
		return texto;
	}

	public JComboBox<String> getVisible() {
		return visible;
	}
}
