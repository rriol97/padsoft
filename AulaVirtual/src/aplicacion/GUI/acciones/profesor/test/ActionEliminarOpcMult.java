package aplicacion.GUI.acciones.profesor.test;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import aplicacion.GUI.controlador.Controlador;
import aplicacion.GUI.paneles.profesor.test.PanelOpcMult;
import aplicacion.clases.elemento.test.OpcionMultiple;
import aplicacion.clases.elemento.test.Test;

public class ActionEliminarOpcMult implements ActionListener {

	private PanelOpcMult p;
	private Test t;
	private OpcionMultiple u;
	
	public ActionEliminarOpcMult(PanelOpcMult p, Test t, OpcionMultiple u){
		this.p = p;
		this.t = t;
		this.u = u;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		Controlador.getInstance().eliminarOpc(this.u,this.p.getSel(),t);
	}
}
