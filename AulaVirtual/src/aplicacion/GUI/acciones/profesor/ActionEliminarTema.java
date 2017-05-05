package aplicacion.GUI.acciones.profesor;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import aplicacion.GUI.controlador.Controlador;
import aplicacion.clases.elemento.Tema;

public class ActionEliminarTema implements ActionListener {
	private Tema tema;
	private Object padre;
	
	public ActionEliminarTema (Tema tema, Object padre) {
		this.tema = tema;
		this.padre = padre;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		Controlador.getInstance().eliminarElemento(this.tema, this.padre);
	}
}
