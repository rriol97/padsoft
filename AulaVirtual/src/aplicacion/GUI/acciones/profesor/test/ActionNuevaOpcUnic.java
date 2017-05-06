package aplicacion.GUI.acciones.profesor.test;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import aplicacion.GUI.frame.Frame;
import aplicacion.GUI.paneles.profesor.test.PanelOpciones;
import aplicacion.clases.elemento.test.OpcionUnica;
import aplicacion.clases.elemento.test.Test;

public class ActionNuevaOpcUnic implements ActionListener {
	private OpcionUnica p;
	private Test t;
	
	public ActionNuevaOpcUnic (OpcionUnica p, Test t){
		this.p = p;
		this.t= t;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		Frame.getInstance().cambiarPanel(new PanelOpciones(p, t), 1);
	}

}
