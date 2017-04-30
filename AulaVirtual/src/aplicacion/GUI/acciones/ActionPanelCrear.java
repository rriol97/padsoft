package aplicacion.GUI.acciones;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import aplicacion.GUI.Alumno.Frame;
import aplicacion.GUI.Profesor.PanelCrearAsig;

public class ActionPanelCrear implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent e) {
		PanelCrearAsig nuevo = new PanelCrearAsig();
		String texto = nuevo.getNombreAsig();
		Frame.getIntance().cambiarPanel(nuevo, 1);
		Frame.getIntance().repaint();
		nuevo.setVisible(true);
	}

}
