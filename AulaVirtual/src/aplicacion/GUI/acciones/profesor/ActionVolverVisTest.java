package aplicacion.GUI.acciones.profesor;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import aplicacion.GUI.frame.Frame;
import aplicacion.GUI.paneles.profesor.test.PanelVisualizarTest;
import aplicacion.clases.elemento.test.Test;

public class ActionVolverVisTest implements ActionListener {
	private Test t;
	
	public ActionVolverVisTest(Test t){
		this.t = t;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		Frame.getInstance().cambiarPanel(new PanelVisualizarTest(t,t.getAsignatura()), 1);
	}

}
