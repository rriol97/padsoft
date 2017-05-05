package aplicacion.GUI.acciones.profesor;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import aplicacion.GUI.general.Frame;
import aplicacion.GUI.paneles.profesor.PanelCrearAsig;

public class ActionCrearAsig implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent e) {
		PanelCrearAsig nuevo = new PanelCrearAsig();
		Frame.getInstance().cambiarPanel(nuevo, 1);
		Frame.getInstance().repaint();
		nuevo.setVisible(true);
	}

}
