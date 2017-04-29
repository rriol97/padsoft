package aplicacion.GUI.acciones;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import aplicacion.GUI.general.Frame;
import aplicacion.GUI.general.PanelSolAsig;
import aplicacion.clases.Aplicacion;

public class ActionSolAsig implements ActionListener{

	@Override
	public void actionPerformed(ActionEvent e) {
		PanelSolAsig ventana = new PanelSolAsig(Aplicacion.getInstance());
		Frame.getIntance().cambiarPanel(ventana, 1);
		ventana.setVisible(true);
	}

}
