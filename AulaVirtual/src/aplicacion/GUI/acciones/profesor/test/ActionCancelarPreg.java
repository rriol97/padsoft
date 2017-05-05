package aplicacion.GUI.acciones.profesor.test;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import aplicacion.GUI.general.Frame;
import aplicacion.GUI.paneles.profesor.test.PanelAnadirPregunta;
import aplicacion.clases.elemento.test.Test;

public class ActionCancelarPreg implements ActionListener {
	
	private Test t;
	
	public ActionCancelarPreg(Test t){
		this.t = t;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Frame.getInstance().cambiarPanel(new PanelAnadirPregunta(t), 1);
	}
}