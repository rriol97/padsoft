package aplicacion.GUI.acciones.profesor;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import aplicacion.GUI.controlador.Controlador;
import aplicacion.clases.Asignatura;

public class ActionEliminarAsig implements ActionListener {

	private Asignatura asig;
	
	public ActionEliminarAsig (Asignatura asig){
		this.asig = asig;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		Controlador.getInstance().eliminarAsignatura(asig);
	}

}
