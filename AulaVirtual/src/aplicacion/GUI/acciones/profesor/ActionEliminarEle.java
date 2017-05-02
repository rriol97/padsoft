package aplicacion.GUI.acciones.profesor;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import aplicacion.GUI.general.Frame;
import aplicacion.GUI.profesor.PanelAsigProf;
import aplicacion.GUI.profesor.PanelEliminarEle;

public class ActionEliminarEle implements ActionListener {
	private PanelAsigProf vista;
	
	public ActionEliminarEle (PanelAsigProf vista) {
		this.vista = vista;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		Frame.getIntance().cambiarPanel(new PanelEliminarEle(vista.getAsignatura()), 1);
	}
}