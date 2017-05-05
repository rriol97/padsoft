package aplicacion.GUI.acciones.alumno;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import aplicacion.GUI.controlador.Controlador;
import aplicacion.GUI.general.Frame;
import aplicacion.GUI.paneles.alumno.PanelSolAlum;
import aplicacion.clases.Aplicacion;
import aplicacion.clases.Asignatura;

public class ActionEnviarSol implements ActionListener{
	
	private PanelSolAlum panel;
	
	public ActionEnviarSol(PanelSolAlum p){
		this.panel = p;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String coment = this.panel.getComentario();
		Asignatura sel = this.panel.getSeleccionada(Aplicacion.getInstance());
		if (sel== null){
			JOptionPane.showMessageDialog(this.panel, "Debe seleccionar una asignatura");
		} else if (coment.equals("")){
			JOptionPane.showMessageDialog(this.panel, "Debe añadir un mensaje");
		} else {
			Controlador.getInstance().solicitarAsig(sel,coment);
			JOptionPane.showMessageDialog(this.panel, "Se ha enviado la solicitud correctamente");
			Frame.getInstance().borrarDer();
			this.panel.setVisible(false);
		}
	}
}
