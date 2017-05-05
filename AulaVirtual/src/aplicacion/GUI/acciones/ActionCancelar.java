package aplicacion.GUI.acciones;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import aplicacion.GUI.general.Frame;

public class ActionCancelar implements ActionListener{

	@Override
	public void actionPerformed(ActionEvent e) {
		Frame.getInstance().borrarDer();
	}
}
