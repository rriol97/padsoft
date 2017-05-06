package aplicacion.GUI.acciones.profesor;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import aplicacion.GUI.frame.Frame;
import aplicacion.GUI.paneles.alumno.PanelNotasAsig;
import aplicacion.GUI.paneles.profesor.PanelAsigProf;
import aplicacion.clases.Alumno;
import aplicacion.clases.Asignatura;

public class ActionConsultarNotasProf implements ActionListener {
	PanelAsigProf vista;
	Asignatura asig;
	
	public ActionConsultarNotasProf(PanelAsigProf vista, Asignatura asig) {
		this.vista = vista;
		this.asig = asig;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Alumno sel = vista.getSel();
		if (sel == null) {
			JOptionPane.showMessageDialog(vista, "Debe seleccionar un alumno");
		} else {
			Frame.getInstance().cambiarPanel(new PanelNotasAsig(sel, asig), 1);
		}
	}
}
