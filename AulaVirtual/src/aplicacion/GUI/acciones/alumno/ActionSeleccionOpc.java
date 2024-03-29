package aplicacion.GUI.acciones.alumno;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JRadioButton;

import aplicacion.GUI.paneles.alumno.componentes.PanelPreg;
import aplicacion.clases.elemento.test.Opcion;

public class ActionSeleccionOpc implements ItemListener {
	private PanelPreg vista;
	private JRadioButton boton;
	private Opcion opcion;
	
	public ActionSeleccionOpc (PanelPreg vista, JRadioButton boton, Opcion opcion) {
		this.vista = vista;
		this.boton = boton;
		this.opcion = opcion;
	}

	@Override
	public void itemStateChanged(ItemEvent e) {
		if (this.boton.isSelected()) {
			this.vista.getSeleccionadas().add(this.opcion);
		} else {
			this.vista.getSeleccionadas().remove(this.opcion);
		}
	}
}
