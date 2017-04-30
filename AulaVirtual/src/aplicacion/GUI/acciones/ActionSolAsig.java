package aplicacion.GUI.acciones;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import aplicacion.GUI.Alumno.Frame;
import aplicacion.GUI.Alumno.PanelSolAsig;
import aplicacion.clases.Aplicacion;

public class ActionSolAsig implements ActionListener{

	@Override
	public void actionPerformed(ActionEvent e) {
		PanelSolAsig ventana = new PanelSolAsig(Aplicacion.getInstance());
		Frame.getIntance().cambiarPanel(ventana, 1);
		Frame.getIntance().repaint();
		ventana.setVisible(true);
	}

}
