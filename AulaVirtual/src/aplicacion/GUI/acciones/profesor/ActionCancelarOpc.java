package aplicacion.GUI.acciones.profesor;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import aplicacion.GUI.profesor.PanelOpciones;


public class ActionCancelarOpc implements ActionListener {
	private PanelOpciones p;
	
	public ActionCancelarOpc(PanelOpciones p){
		this.p = p;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		this.p.setVisible(false);
	}

}
