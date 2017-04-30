package aplicacion.GUI.acciones;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import aplicacion.GUI.Alumno.Frame;
import aplicacion.GUI.controlador.Controlador;


public class ActionSalir implements ActionListener{

	@Override
	public void actionPerformed(ActionEvent e) {
		
		try {
			Controlador.getInstance().salirAplicacion();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		
		Frame.getIntance().setVisible(false);
		
	}

}
