package aplicacion.GUI.acciones.profesor.test;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import aplicacion.GUI.frame.Frame;
import aplicacion.GUI.paneles.profesor.test.PanelOpciones;
import aplicacion.clases.elemento.test.OpcionMultiple;
import aplicacion.clases.elemento.test.Test;

public class ActionNuevaOpcMult implements ActionListener {
	private OpcionMultiple p;
	private Test t;
	
	public ActionNuevaOpcMult (OpcionMultiple p, Test t){
		this.p = p;
		this.t = t;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		Frame.getInstance().cambiarPanel(new PanelOpciones(p, t), 1);
	}
}
