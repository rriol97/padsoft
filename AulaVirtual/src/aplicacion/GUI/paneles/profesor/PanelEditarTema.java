package aplicacion.GUI.paneles.profesor;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.SpringLayout;

import aplicacion.GUI.SpringUtilities;
import aplicacion.GUI.acciones.ActionVolverAsig;
import aplicacion.GUI.acciones.profesor.ActionEditarTema;
import aplicacion.GUI.acciones.profesor.ActionEliminarTema;
import aplicacion.clases.elemento.Tema;

public class PanelEditarTema extends JPanel {
	private static final long serialVersionUID = 1L;
	
	private JComboBox<String> visible;
	
	public PanelEditarTema (Tema tema, Object padre) {
		this.setLayout(new SpringLayout());
		
		String[] listaVisible = {"Visible", "No visible"};
		this.visible = new JComboBox <String> (listaVisible);
		this.add(this.visible);
		
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
		
		SpringUtilities.makeCompactGrid(this, 2, 1, 5, 5, 5, 5);
	}

	public JComboBox<String> getVisible() {
		return visible;
	}
}
