package aplicacion.GUI.acciones;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import aplicacion.GUI.Alumno.PanelSolicitud;
import aplicacion.GUI.general.Frame;
import aplicacion.clases.Aplicacion;

public class ActionSolAsig implements ActionListener{

	@Override
	public void actionPerformed(ActionEvent e) {
		PanelSolicitud ventana = new PanelSolicitud(Aplicacion.getInstance());
		Frame.getIntance().cambiarPanel(ventana, 1);
		Frame.getIntance().repaint();
		ventana.setVisible(true);
	}
}
