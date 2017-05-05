package aplicacion.GUI.acciones.profesor.test;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import aplicacion.GUI.paneles.profesor.test.PanelOpciones;


public class ActionCancelarOpcUnica implements ActionListener {
	private PanelOpciones p;
	
	public ActionCancelarOpcUnica(PanelOpciones p){
		this.p = p;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		this.p.setVisible(false);
	}

}
