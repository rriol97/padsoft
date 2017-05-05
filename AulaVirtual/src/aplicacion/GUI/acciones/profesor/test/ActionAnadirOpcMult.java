package aplicacion.GUI.acciones.profesor.test;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import aplicacion.GUI.general.Frame;
import aplicacion.GUI.paneles.profesor.test.PanelAnadirPregunta;
import aplicacion.clases.elemento.test.OpcionMultiple;
import aplicacion.clases.elemento.test.Test;

public class ActionAnadirOpcMult implements ActionListener {
	private Test t;
	private OpcionMultiple p;
	
	public ActionAnadirOpcMult (OpcionMultiple p, Test t) {
		this.t = t;
		this.p = p;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		t.anadirPregunta(p);
		Frame.getIntance().cambiarPanel(new PanelAnadirPregunta(t), 1);
	}
}
