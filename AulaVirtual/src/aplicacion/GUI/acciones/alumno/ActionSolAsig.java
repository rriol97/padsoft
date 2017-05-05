package aplicacion.GUI.acciones.alumno;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import aplicacion.GUI.general.Frame;
import aplicacion.GUI.paneles.alumno.PanelSolAlum;
import aplicacion.clases.Aplicacion;

public class ActionSolAsig implements ActionListener{

	@Override
	public void actionPerformed(ActionEvent e) {
		PanelSolAlum ventana = new PanelSolAlum(Aplicacion.getInstance());
		Frame.getIntance().cambiarPanel(ventana, 1);
		Frame.getIntance().repaint();
		ventana.setVisible(true);
	}
}
