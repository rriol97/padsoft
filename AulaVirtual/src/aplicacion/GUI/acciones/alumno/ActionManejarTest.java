package aplicacion.GUI.acciones.alumno;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import aplicacion.GUI.alumno.PanelResAlum;
import aplicacion.GUI.alumno.PanelTestAlum;
import aplicacion.GUI.general.Frame;
import aplicacion.clases.Aplicacion;
import aplicacion.clases.elemento.test.Test;

public class ActionManejarTest implements ActionListener {
	private Test test;
	
	public ActionManejarTest (Test test) {
		this.test = test;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (this.test.isFechaValida()) {
			Frame.getIntance().cambiarPanel(new PanelTestAlum(this.test), 1);
		} else {
			if (this.test.isTerminado()) {
				try {
					Frame.getIntance().cambiarPanel(new PanelResAlum(Aplicacion.getInstance().getAlumnoActual().encontrarResolucion(this.test)), 1);
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		}
	}
}
