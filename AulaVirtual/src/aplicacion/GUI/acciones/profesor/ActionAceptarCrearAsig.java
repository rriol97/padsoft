package aplicacion.GUI.acciones.profesor;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import aplicacion.GUI.controlador.Controlador;
import aplicacion.GUI.general.Frame;
import aplicacion.GUI.paneles.profesor.PanelAsignaturas;
import aplicacion.GUI.paneles.profesor.PanelCrearAsig;
import aplicacion.clases.Aplicacion;

public class ActionAceptarCrearAsig implements ActionListener {
	private PanelCrearAsig vista;
	
	public ActionAceptarCrearAsig(PanelCrearAsig p){
		this.vista = p;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String nombre = this.vista.getNombreAsig();
		if (nombre.equals("")){
			JOptionPane.showMessageDialog(this.vista, "Introduzca el nombre de la asignatura");
		}
		else if (Controlador.getInstance().crearAsig(nombre)== false){
			JOptionPane.showMessageDialog(this.vista, "Error al crear la asignatura");
		}
		else{
			Frame.getIntance().cambiarPanel(new PanelAsignaturas(Aplicacion.getInstance()), 0);
			JOptionPane.showMessageDialog(this.vista, "Asignatura creada");
			Frame.getIntance().borrarDer();
			this.vista.setVisible(false);
		}
	}

}
