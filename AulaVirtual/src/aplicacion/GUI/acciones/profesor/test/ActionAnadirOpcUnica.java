package aplicacion.GUI.acciones.profesor.test;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import aplicacion.GUI.general.Frame;
import aplicacion.GUI.paneles.profesor.test.PanelCrearPreg;
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
		Frame.getIntance().cambiarPanel(new PanelCrearPreg(t), 1);
	}
}
