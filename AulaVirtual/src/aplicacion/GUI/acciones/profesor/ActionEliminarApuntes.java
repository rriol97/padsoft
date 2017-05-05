package aplicacion.GUI.acciones.profesor;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import aplicacion.GUI.controlador.Controlador;
import aplicacion.clases.elemento.Apuntes;

public class ActionEliminarApuntes implements ActionListener {
	private Apuntes apuntes; 
	private Object padre;
	
	public ActionEliminarApuntes (Apuntes apuntes, Object padre) {
		this.apuntes = apuntes;
		this.padre = padre;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		Controlador.getInstance().eliminarElemento(this.apuntes, this.padre);
	}
}
