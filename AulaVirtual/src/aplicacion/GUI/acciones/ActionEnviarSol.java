package aplicacion.GUI.acciones;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import aplicacion.GUI.Alumno.Frame;
import aplicacion.GUI.Alumno.PanelSolAsig;
import aplicacion.GUI.controlador.Controlador;
import aplicacion.clases.Asignatura;

public class ActionEnviarSol implements ActionListener{
	
	private PanelSolAsig panel;
	
	public ActionEnviarSol(PanelSolAsig p){
		this.panel = p;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String coment = this.panel.getComentario();
		Asignatura sel = this.panel.getSeleccionada();
		if (sel== null){
			JOptionPane.showMessageDialog(this.panel, "Debe seleccionar una asignatura");
		}
		else{
			Controlador.getInstance().solicitarAsig(sel,coment);
			JOptionPane.showMessageDialog(this.panel, "Se ha enviado la solicitud correctamente");
			Frame.getIntance().cambiarPanel();
			this.panel.setVisible(false);
		}
	}

}
