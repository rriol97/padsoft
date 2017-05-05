package aplicacion.GUI.acciones.profesor;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import aplicacion.GUI.general.Frame;
import aplicacion.GUI.paneles.profesor.PanelAsigProf;
import aplicacion.GUI.paneles.profesor.PanelReadmitir;

public class ActionSeleccionReadmitir implements ActionListener {
	private PanelAsigProf vista;
	
	public ActionSeleccionReadmitir (PanelAsigProf vista) {
		this.vista = vista;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		Frame.getIntance().cambiarPanel(new PanelReadmitir(vista.getAsignatura()), 1);
	}
}
