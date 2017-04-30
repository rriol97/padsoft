package aplicacion.GUI.acciones;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import aplicacion.GUI.Profesor.PanelCrearAsig;
import aplicacion.GUI.general.Frame;

public class ActionCrearAsig implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent e) {
		PanelCrearAsig nuevo = new PanelCrearAsig();
		Frame.getIntance().cambiarPanel(nuevo, 1);
		Frame.getIntance().repaint();
		nuevo.setVisible(true);
	}

}
