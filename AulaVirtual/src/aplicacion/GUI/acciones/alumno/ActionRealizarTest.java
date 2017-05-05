package aplicacion.GUI.acciones.alumno;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import aplicacion.GUI.controlador.Controlador;
import aplicacion.GUI.paneles.alumno.PanelTestAlum;
import aplicacion.clases.elemento.test.Test;

public class ActionRealizarTest implements ActionListener {
	private PanelTestAlum vista;
	private Test test;
	
	public ActionRealizarTest (PanelTestAlum vista, Test test) {
		this.vista = vista;
		this.test = test;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		Controlador.getInstance().realizarTest(this.vista, this.test);
	}
}
