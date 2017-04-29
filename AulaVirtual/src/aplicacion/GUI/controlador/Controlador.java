package aplicacion.GUI.controlador;

import aplicacion.GUI.general.Frame;

public class Controlador {
	private Frame vista;
	
	public Controlador (Frame vista){
		this.setVista(vista);
	}

	public Frame getVista() {
		return vista;
	}

	public void setVista(Frame vista) {
		this.vista = vista;
	}
}
