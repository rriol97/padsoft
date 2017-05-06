package aplicacion.GUI.acciones.profesor.test;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import aplicacion.GUI.general.Frame;
import aplicacion.GUI.paneles.profesor.test.PanelOpcMult;
import aplicacion.GUI.paneles.profesor.test.PanelOpcUnic;
import aplicacion.GUI.paneles.profesor.test.PanelOpciones;
import aplicacion.clases.elemento.test.OpcionMultiple;
import aplicacion.clases.elemento.test.OpcionUnica;
import aplicacion.clases.elemento.test.Test;

public class ActionEditarOpcMult implements ActionListener {
	private PanelOpcMult q;
	private Test t;
	private OpcionMultiple p;
	
	public ActionEditarOpcMult (PanelOpcMult q,Test t, OpcionMultiple p){
		this.p = p;
		this.q = q;
		this.t = t;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		PanelOpciones opc = new PanelOpciones(p,t);
		opc.setContent(q.getSel().getTexto());
		opc.setCorrecta(q.getSel().isCorrecta());
		Frame.getInstance().cambiarPanel(opc,1);
	}

}
