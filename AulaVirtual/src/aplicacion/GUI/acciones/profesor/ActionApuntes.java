package aplicacion.GUI.acciones.profesor;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import aplicacion.GUI.general.Frame;
import aplicacion.GUI.profesor.PanelCrearApuntes;
import aplicacion.clases.Asignatura;

public class ActionApuntes implements ActionListener {
	
	private Asignatura asig;

	public ActionApuntes(Asignatura asig){
		this.asig = asig;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Frame.getIntance().cambiarPanel(new PanelCrearApuntes(this.asig), 1);
	}

}
