package aplicacion.GUI.acciones.profesor;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import aplicacion.GUI.general.Frame;
import aplicacion.GUI.paneles.profesor.PanelAsigProf;
import aplicacion.GUI.paneles.profesor.PanelExpulsar;
import aplicacion.clases.Alumno;

public class ActionExpulsar implements ActionListener {
	private PanelExpulsar vista;
	
	public ActionExpulsar (PanelExpulsar vista) {
		this.vista = vista;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		for (Alumno alum: this.vista.getSeleccionados()) {
			try {
				this.vista.getAsignatura().expulsarAlumno(alum);
				Frame.getInstance().cambiarPanel(new PanelAsigProf(this.vista.getAsignatura()), 1);
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}
	}
}
