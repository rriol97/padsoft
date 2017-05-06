package aplicacion.GUI.acciones.alumno;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import aplicacion.GUI.frame.Frame;
import aplicacion.GUI.paneles.alumno.PanelSolAlum;
import aplicacion.clases.Aplicacion;

public class ActionSolAsig implements ActionListener{

	@Override
	public void actionPerformed(ActionEvent e) {
		Frame.getInstance().cambiarPanel(new PanelSolAlum(Aplicacion.getInstance()), 1);
	}
}
