package aplicacion.GUI.acciones.profesor;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import aplicacion.GUI.controlador.Controlador;
import aplicacion.GUI.paneles.profesor.test.PanelEditarFechaFin;
import aplicacion.clases.elemento.test.Test;

public class ActionEditarFechaFin implements ActionListener {
	private Test t;
	private PanelEditarFechaFin p;
	public ActionEditarFechaFin(Test t, PanelEditarFechaFin p){
		this.t = t;
		this.p = p;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		Controlador.getInstance().editarFechaFinTest(t, this.p.getFechaFin());
	}

}
