package aplicacion.GUI.acciones;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import aplicacion.GUI.controlador.Controlador;
import aplicacion.GUI.general.Frame;


public class ActionSalir implements ActionListener{

	@Override
	public void actionPerformed(ActionEvent e) {
		try {
			Controlador.getInstance().salirAplicacion();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		Frame.getInstance().setVisible(false);
	}
}
