package aplicacion.GUI.acciones.alumno;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JCheckBox;

import aplicacion.GUI.componentes.PanelPreg;
import aplicacion.clases.elemento.test.Opcion;

public class ActionSeleccionOpcM implements ActionListener {
	private PanelPreg vista;
	private JCheckBox boton;
	private Opcion opcion;
	
	public ActionSeleccionOpcM (PanelPreg vista, JCheckBox boton, Opcion opcion) {
		this.vista = vista;
		this.boton = boton;
		this.opcion = opcion;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if (this.boton.isSelected()) {
			this.vista.getSeleccionadas().add(this.opcion);
		} else {
			this.vista.getSeleccionadas().remove(this.opcion);
		}
	}
}