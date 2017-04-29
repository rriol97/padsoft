package aplicacion.GUI.controlador;

import java.io.FileNotFoundException;
import java.io.IOException;

import aplicacion.GUI.general.Frame;
import aplicacion.GUI.login.FrameLogin;
import aplicacion.clases.Aplicacion;
import aplicacion.clases.Asignatura;
import aplicacion.clases.Solicitud;

public class Controlador {
	private static Frame vista;
	private static Controlador instance = new Controlador(vista);
	
	private Controlador (Frame vista){
		this.setVista(vista);
	}
	
	public static Controlador getInstance(){
		return instance;
	}

	public Frame getVista() {
		return vista;
	}

	public void setVista(Frame vista) {
		Controlador.vista = vista;
	}

	public void salirAplicacion() throws FileNotFoundException, IOException{
		Aplicacion.getInstance().logOut();
		FrameLogin.getInstance().setVisible(true);;
	}

	public void solicitarAsig(Asignatura a, String c) {
		Solicitud d = new Solicitud(c,Aplicacion.getInstance().getAlumnoActual(),a);
		Aplicacion.getInstance().getAlumnoActual().enviarSolicitud(d);
	}
}
