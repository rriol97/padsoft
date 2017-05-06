package aplicacion.GUI.acciones.profesor.test;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import aplicacion.GUI.frame.Frame;
import aplicacion.GUI.paneles.profesor.test.PanelAnadirPregunta;
import aplicacion.clases.elemento.test.Test;

public class ActionVolverCrearPreg implements ActionListener {
	private Test t;
	
	public ActionVolverCrearPreg (Test t) {
		this.t = t;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		Frame.getInstance().cambiarPanel(new PanelAnadirPregunta(t), 1);
	}
}
