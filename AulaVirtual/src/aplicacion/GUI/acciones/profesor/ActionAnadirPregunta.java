package aplicacion.GUI.acciones.profesor;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import aplicacion.GUI.general.Frame;
import aplicacion.GUI.profesor.PanelEnunciadoComun;
import aplicacion.clases.elemento.test.Test;

public class ActionAnadirPregunta implements ActionListener {
	private Test test;
	
	public ActionAnadirPregunta(Test t){
		this.test = t;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		Frame.getIntance().cambiarPanel(new PanelEnunciadoComun(test), 1);
	}
	
}
