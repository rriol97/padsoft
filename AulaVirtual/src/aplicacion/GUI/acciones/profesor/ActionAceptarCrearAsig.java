package aplicacion.GUI.acciones.profesor;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import aplicacion.GUI.controlador.Controlador;
import aplicacion.GUI.paneles.profesor.PanelCrearAsig;

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
		Controlador.getInstance().crearAsig(nombre);
	}
}
