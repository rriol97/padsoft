package aplicacion.GUI.acciones.profesor.test;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import aplicacion.GUI.general.Frame;
import aplicacion.GUI.paneles.profesor.test.PanelOpcMult;
import aplicacion.GUI.paneles.profesor.test.PanelOpcUnic;
import aplicacion.GUI.paneles.profesor.test.PanelOpciones;
import aplicacion.clases.elemento.test.OpcionMultiple;
import aplicacion.clases.elemento.test.OpcionUnica;
import aplicacion.clases.elemento.test.PreguntaOpcion;
import aplicacion.clases.elemento.test.Test;


public class ActionCancelarOpc implements ActionListener {
	private PreguntaOpcion opc;
	private Test t;
	
	public ActionCancelarOpc(PreguntaOpcion opc,Test t){
		this.opc = opc;
		this.t = t;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (opc instanceof OpcionUnica){
			Frame.getInstance().cambiarPanel(new PanelOpcUnic((OpcionUnica)opc,t), 1);
		} else{
			Frame.getInstance().cambiarPanel(new PanelOpcMult((OpcionMultiple)opc,t), 1);
		}
	}

}
