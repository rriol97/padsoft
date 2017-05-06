package aplicacion.GUI.acciones.profesor.test;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import aplicacion.GUI.general.Frame;
import aplicacion.GUI.paneles.profesor.test.PanelOpcMult;
import aplicacion.GUI.paneles.profesor.test.PanelOpcUnic;
import aplicacion.clases.elemento.test.OpcionMultiple;
import aplicacion.clases.elemento.test.OpcionUnica;
import aplicacion.clases.elemento.test.PreguntaOpcion;
import aplicacion.clases.elemento.test.Test;

public class ActionCancelarEditarOpc implements ActionListener {
	private PreguntaOpcion p;
	private Test t;
	
	public ActionCancelarEditarOpc (PreguntaOpcion p, Test t) {
		this.p = p;
		this.t = t;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if (p instanceof OpcionUnica) {
			OpcionUnica ou = (OpcionUnica) p;
			Frame.getInstance().cambiarPanel(new PanelOpcUnic(ou, t), 1);
		} else if (p instanceof OpcionMultiple) {
			OpcionMultiple om = (OpcionMultiple) p;
			Frame.getInstance().cambiarPanel(new PanelOpcMult(om, t), 1);
		}
	}
}
