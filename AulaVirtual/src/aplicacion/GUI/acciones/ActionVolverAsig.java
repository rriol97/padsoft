package aplicacion.GUI.acciones;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import aplicacion.GUI.frame.Frame;
import aplicacion.GUI.paneles.alumno.PanelAsigAlum;
import aplicacion.GUI.paneles.profesor.PanelAsigProf;
import aplicacion.clases.Aplicacion;
import aplicacion.clases.Asignatura;
import aplicacion.clases.TipoUsuario;

public class ActionVolverAsig implements ActionListener{
	
	private Asignatura asig;
	
	public ActionVolverAsig(Asignatura asig){
		this.asig = asig;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (Aplicacion.getInstance().getTipoUsu() == TipoUsuario.ALUMNO) {
			Frame.getInstance().cambiarPanel(new PanelAsigAlum(this.asig),1);
		} else if (Aplicacion.getInstance().getTipoUsu() == TipoUsuario.PROFESOR) {
			Frame.getInstance().cambiarPanel(new PanelAsigProf(this.asig),1);
		}
	}
}
