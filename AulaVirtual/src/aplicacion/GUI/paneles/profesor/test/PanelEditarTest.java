package aplicacion.GUI.paneles.profesor.test;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.SpringLayout;

import aplicacion.GUI.SpringUtilities;
import aplicacion.GUI.acciones.ActionVolverAsig;
import aplicacion.clases.elemento.test.Test;

public class PanelEditarTest extends JPanel {
	private static final long serialVersionUID = 1L;
	
	private JComboBox <String> visible;
	
	public PanelEditarTest (Test test, Object padre) {
		this.setLayout(new SpringLayout());
		
		String[] listaVisible = {"Visible", "No visible"};
		this.visible = new JComboBox <String> (listaVisible);
		this.add(this.visible);
		
		JPanel panel_botones = new JPanel();
		panel_botones.setLayout(new BoxLayout(panel_botones, 0));
		
		JButton boton_volver = new JButton("Volver");
		boton_volver.addActionListener(new ActionVolverAsig(test.getAsignatura()));
		panel_botones.add(boton_volver);
		//TODO implementar cuando terminemos la creacion de tests
		JButton boton_eliminar = new JButton("Eliminar");
		/*boton_eliminar.addActionListener(new ActionEliminarTest(test, padre));*/
		panel_botones.add(boton_eliminar);
		
		JButton boton_finalizar = new JButton("Finalizar");
		/*boton_finalizar.addActionListener(new ActionEditarTest(this, test));*/
		panel_botones.add(boton_finalizar);
		
		this.add(panel_botones);
		
		SpringUtilities.makeCompactGrid(this, 2, 1, 5, 5, 5, 5);
	}
}
