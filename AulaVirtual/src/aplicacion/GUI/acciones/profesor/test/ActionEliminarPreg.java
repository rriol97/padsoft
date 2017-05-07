package aplicacion.GUI.acciones.profesor.test;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import aplicacion.GUI.controlador.Controlador;
import aplicacion.GUI.paneles.profesor.test.PanelAbstractoAnadirPreg;
import aplicacion.clases.elemento.test.Pregunta;
import aplicacion.clases.elemento.test.Test;

public class ActionEliminarPreg implements ActionListener {
	PanelAbstractoAnadirPreg vista;
	Test t;
	
	public ActionEliminarPreg (PanelAbstractoAnadirPreg vista, Test t) {
		this.vista = vista;
		this.t = t;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		Pregunta sel = this.vista.getSeleccionada();
		if (sel == null) {
			JOptionPane.showMessageDialog(vista, "Elige una pregunta");
		}
		Controlador.getInstance().eliminarPreg(this.t, sel);
	}
}
