package aplicacion.GUI.acciones.profesor.test;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import aplicacion.GUI.general.Frame;
import aplicacion.GUI.paneles.profesor.PanelAsigProf;
import aplicacion.clases.elemento.test.Test;

public class ActionFinTest implements ActionListener {
	private Test test;
	
	public ActionFinTest (Test test) {
		this.test = test;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		Frame.getIntance().cambiarPanel(new PanelAsigProf(test.getAsignatura()), 1);
	}
}
