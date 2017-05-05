package aplicacion.GUI.acciones.alumno;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import aplicacion.GUI.general.Frame;
import aplicacion.GUI.paneles.alumno.PanelNotasAsig;
import aplicacion.clases.Aplicacion;
import aplicacion.clases.Asignatura;

public class ActionConsultarNotas implements ActionListener {
	private Asignatura asig;
	
	public ActionConsultarNotas(Asignatura asig) {
		this.asig = asig;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Frame.getIntance().cambiarPanel(new PanelNotasAsig(Aplicacion.getInstance().getAlumnoActual(), asig), 1);
	}
}
