package aplicacion.GUI.acciones.profesor.test;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import aplicacion.GUI.frame.Frame;
import aplicacion.GUI.paneles.profesor.test.PanelAnadirPregunta;
import aplicacion.clases.elemento.test.OpcionUnica;
import aplicacion.clases.elemento.test.Test;

public class ActionAnadirOpcUnica implements ActionListener {
	private Test t;
	private OpcionUnica p;
	
	public ActionAnadirOpcUnica (OpcionUnica p, Test t) {
		this.t = t;
		this.p = p;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		t.anadirPregunta(p);
		Frame.getInstance().cambiarPanel(new PanelAnadirPregunta(t), 1);
	}
}
