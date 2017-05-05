package aplicacion.GUI.acciones.profesor.test;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import aplicacion.GUI.controlador.Controlador;
import aplicacion.GUI.paneles.profesor.test.PanelOpciones;
import aplicacion.clases.elemento.test.OpcionUnica;
import aplicacion.clases.elemento.test.Test;

public class ActionAceptarOpcUnica implements ActionListener {
	private PanelOpciones p;
	private OpcionUnica opc;
	private Test t;
	
	public ActionAceptarOpcUnica(PanelOpciones p, OpcionUnica opc, Test t){
		this.p = p;
		this.opc  = opc;
		this.t = t;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		Controlador.getInstance().anadirOpcionUnica(t, opc, p.getContent(), p.isCorrecta());
	}

}
