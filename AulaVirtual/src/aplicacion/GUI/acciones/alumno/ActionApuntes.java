package aplicacion.GUI.acciones.alumno;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import aplicacion.GUI.alumno.PanelApunAlum;
import aplicacion.GUI.general.Frame;
import aplicacion.clases.elemento.Apuntes;

public class ActionApuntes implements ActionListener {
	private Apuntes apuntes;
	
	public ActionApuntes (Apuntes apuntes) {
		this.apuntes = apuntes;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		Frame.getIntance().cambiarPanel(new PanelApunAlum(this.apuntes), 1);
	}
}
