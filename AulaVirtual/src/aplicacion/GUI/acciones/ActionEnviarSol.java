package aplicacion.GUI.acciones;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import aplicacion.GUI.Alumno.PanelSolicitud;
import aplicacion.GUI.controlador.Controlador;
import aplicacion.GUI.general.Frame;
import aplicacion.clases.Aplicacion;
import aplicacion.clases.Asignatura;

public class ActionEnviarSol implements ActionListener{
	
	private PanelSolicitud panel;
	
	public ActionEnviarSol(PanelSolicitud p){
		this.panel = p;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String coment = this.panel.getComentario();
		Asignatura sel = this.panel.getSeleccionada(Aplicacion.getInstance());
		if (sel== null){
			JOptionPane.showMessageDialog(this.panel, "Debe seleccionar una asignatura");
		} else {
			Controlador.getInstance().solicitarAsig(sel,coment);
			JOptionPane.showMessageDialog(this.panel, "Se ha enviado la solicitud correctamente");
			Frame.getIntance().borrarDer();
			this.panel.setVisible(false);
		}
	}
}
