package aplicacion.GUI.acciones.alumno;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import aplicacion.GUI.controlador.Controlador;
import aplicacion.GUI.paneles.alumno.PanelSolAlum;
import aplicacion.clases.Asignatura;

public class ActionEnviarSol implements ActionListener{
	
	private PanelSolAlum panel;
	
	public ActionEnviarSol(PanelSolAlum p){
		this.panel = p;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String coment = this.panel.getComentario();
		Asignatura sel = this.panel.getSeleccionada();
		Controlador.getInstance().solicitarAsig(sel,coment);
	}
}
