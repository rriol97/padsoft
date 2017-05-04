package aplicacion.GUI.acciones.profesor;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import aplicacion.GUI.profesor.PanelOpciones;

public class ActionNuevaOpc implements ActionListener {
	private PanelOpciones opc;
	
	public ActionNuevaOpc (PanelOpciones opc){
		this.opc = opc;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		this.opc.setVisible(true);
	}

}
