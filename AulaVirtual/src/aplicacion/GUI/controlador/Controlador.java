 package aplicacion.GUI.controlador;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.LocalDate;

import aplicacion.clases.elemento.test.*;
import aplicacion.GUI.general.Frame;
import aplicacion.GUI.login.FrameLogin;
import aplicacion.clases.Aplicacion;
import aplicacion.clases.Asignatura;
import aplicacion.clases.Solicitud;
import aplicacion.clases.elemento.Apuntes;
import aplicacion.clases.elemento.Tema;
import es.uam.eps.padsof.emailconnection.FailedInternetConnectionException;
import es.uam.eps.padsof.emailconnection.InvalidEmailAddressException;

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
		FrameLogin.getInstance().setVisible(true);
	}

	public void solicitarAsig(Asignatura a, String texto) {
		Solicitud s = new Solicitud(texto, Aplicacion.getInstance().getAlumnoActual(), a);
		Aplicacion.getInstance().getAlumnoActual().enviarSolicitud(s);
	}

	public boolean crearAsig(String texto) {
		Asignatura a = new Asignatura(texto);
		return Aplicacion.getInstance().anadirAsignatura(a);
	}

	public void denergarSol(Asignatura asignatura, Solicitud sol) throws InvalidEmailAddressException, FailedInternetConnectionException {
		asignatura.denegarSolicitud(sol);
	}

	public void aceptarSol(Asignatura asignatura, Solicitud sol) throws InvalidEmailAddressException, FailedInternetConnectionException {
		asignatura.aceptarSolicitud(sol);
	}

	public void crearApuntes(String titulo, boolean selec, String contenido, Asignatura asig, Tema tema) throws InvalidEmailAddressException, FailedInternetConnectionException {
		tema.anadirElemento(new Apuntes(titulo,selec,contenido,asig));
	}

	public void crearTema(String nombre, boolean b, Asignatura asig, Tema tema) throws InvalidEmailAddressException, FailedInternetConnectionException {
		if (tema == null) {
			asig.anadirElemento(new Tema(nombre,b,asig));
		} else {
			tema.anadirElemento(new Tema(nombre,b,asig));
		}
	}

	public Test nuevoTest(String nombre, boolean selec, Asignatura asig, LocalDate fechaIni, LocalDate fechaFin, boolean orden,
						Double peso, Double vpd, Tema tema) throws InvalidEmailAddressException, FailedInternetConnectionException {
		
		Test t = new Test (nombre,selec,asig,"",fechaIni,fechaFin,orden,peso,vpd);
		tema.anadirElemento(t);
		return t;
	}

	public void eliminarTest(Test t,Tema w) throws InvalidEmailAddressException, FailedInternetConnectionException {
		w.eliminarElemento(t);
	}
}
