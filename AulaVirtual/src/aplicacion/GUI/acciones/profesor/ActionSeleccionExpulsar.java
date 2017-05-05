package aplicacion.GUI.acciones.profesor;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import aplicacion.GUI.general.Frame;
import aplicacion.GUI.paneles.profesor.PanelAsigProf;
import aplicacion.GUI.paneles.profesor.PanelExpulsar;

public class ActionSeleccionExpulsar implements ActionListener {
	private PanelAsigProf vista;
	
	public ActionSeleccionExpulsar (PanelAsigProf vista) {
		this.vista = vista;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		Frame.getInstance().cambiarPanel(new PanelExpulsar(vista.getAsignatura()), 1);
	}
}
