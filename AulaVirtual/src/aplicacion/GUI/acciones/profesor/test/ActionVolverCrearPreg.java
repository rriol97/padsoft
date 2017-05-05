package aplicacion.GUI.acciones.profesor.test;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import aplicacion.GUI.general.Frame;
import aplicacion.GUI.paneles.profesor.test.PanelCrearPreg;
import aplicacion.clases.elemento.test.Test;

public class ActionVolverCrearPreg implements ActionListener {
	private Test t;
	
	public ActionVolverCrearPreg (Test t) {
		this.t = t;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		Frame.getIntance().cambiarPanel(new PanelCrearPreg(t), 1);
	}
}
