package aplicacion.GUI.acciones.profesor.test;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import aplicacion.GUI.controlador.Controlador;
import aplicacion.GUI.paneles.profesor.test.PanelOpciones;
import aplicacion.clases.elemento.test.PreguntaOpcion;
import aplicacion.clases.elemento.test.Test;

public class ActionAceptarOpc implements ActionListener {
	private PanelOpciones p;
	private PreguntaOpcion opc;
	private Test t;
	
	public ActionAceptarOpc(PanelOpciones p, PreguntaOpcion opc, Test t){
		this.p = p;
		this.opc  = opc;
		this.t = t;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		Controlador.getInstance().anadirOpcion(t, opc, p.getContent(), p.isCorrecta());
	}

}
