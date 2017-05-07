package aplicacion.GUI.acciones.profesor.test;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import aplicacion.GUI.frame.Frame;
import aplicacion.GUI.paneles.profesor.PanelAsigProf;
import aplicacion.clases.elemento.test.Test;

public class ActionVolverAsigDeModTest implements ActionListener {
	private Test t;
	
	public ActionVolverAsigDeModTest (Test t){
		this.t = t;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		Frame.getInstance().cambiarPanel(new PanelAsigProf(this.t.getAsignatura()), 1);
	}

}
