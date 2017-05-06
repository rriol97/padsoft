package aplicacion.GUI.acciones.profesor.test;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import aplicacion.GUI.general.Frame;
import aplicacion.GUI.paneles.profesor.test.PanelOpcUnic;
import aplicacion.GUI.paneles.profesor.test.PanelOpciones;
import aplicacion.clases.elemento.test.OpcionUnica;
import aplicacion.clases.elemento.test.Test;

public class ActionEditarOpcUnic implements ActionListener {
	
	private PanelOpcUnic q;
	private Test t;
	private OpcionUnica p;
	
	public ActionEditarOpcUnic (PanelOpcUnic q,Test t, OpcionUnica p){
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
