package aplicacion.GUI.acciones.profesor;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import aplicacion.GUI.frame.Frame;
import aplicacion.GUI.paneles.profesor.PanelAsigProf;
import aplicacion.GUI.paneles.profesor.PanelCrearEle;

public class ActionCrearEle implements ActionListener {
	private PanelAsigProf vista;
	
	public ActionCrearEle (PanelAsigProf vista) {
		this.vista = vista;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		Frame.getInstance().cambiarPanel(new PanelCrearEle(vista.getAsignatura()), 1);
	}
}
