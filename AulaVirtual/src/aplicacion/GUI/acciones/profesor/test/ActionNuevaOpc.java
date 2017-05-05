package aplicacion.GUI.acciones.profesor.test;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import aplicacion.GUI.general.Frame;
import aplicacion.GUI.paneles.profesor.test.PanelOpciones;
import aplicacion.clases.elemento.test.OpcionUnica;
import aplicacion.clases.elemento.test.Test;

public class ActionNuevaOpc implements ActionListener {
	private OpcionUnica p;
	private Test t;
	
	public ActionNuevaOpc (OpcionUnica p, Test t){
		this.p = p;
		this.t= t;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		Frame.getIntance().cambiarPanel(new PanelOpciones(p, t), 1);
	}

}
