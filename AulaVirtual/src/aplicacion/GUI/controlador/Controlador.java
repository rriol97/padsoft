 package aplicacion.GUI.controlador;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.LocalDate;

import javax.swing.JOptionPane;

import aplicacion.clases.elemento.test.*;
import aplicacion.GUI.general.Frame;
import aplicacion.GUI.login.FrameLogin;
import aplicacion.GUI.paneles.profesor.PanelAsignaturas;
import aplicacion.GUI.paneles.profesor.test.PanelOpcMult;
import aplicacion.GUI.paneles.profesor.test.PanelOpcUnic;
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

	public void crearPregSiNo(Test t, String enunciado, Double valor, Double penalizacion, String respuesta, String opc1, String opc2) {
		SiNo p = new SiNo(enunciado,valor,penalizacion);
		if (respuesta.equals(opc1)){
			Opcion opcion1 = new Opcion(opc1,true);
			Opcion opcion2 = new Opcion(opc2,false);
			p.anadirOpcion(opcion1);
			p.anadirOpcion(opcion2);
		} else{
			Opcion opcion2 = new Opcion(opc2,true);
			Opcion opcion1 = new Opcion(opc1,false);
			p.anadirOpcion(opcion1);
			p.anadirOpcion(opcion2);
		}
		
		t.anadirPregunta(p);
	}

	public void crearPregCorta(Test t,String enunciado, Double valor, Double penalizacion, String sol) {
		RespuestaLibre p = new RespuestaLibre(enunciado,valor,penalizacion,sol);
		t.anadirPregunta(p);
		
	}

	public void crearPregOpcUnic(Test t,String enunciado, Double valor, Double penalizacion) {
		OpcionUnica p = new OpcionUnica(enunciado,valor,penalizacion);
		Frame.getInstance().cambiarPanel(new PanelOpcUnic(p, t), 1);
	}
	
	public void anadirOpcionUnica(Test t, PreguntaOpcion p, String enunciado, boolean correcta) {
		if (p instanceof OpcionUnica){
			if (p.anadirOpcion(new Opcion(enunciado, correcta))) {
				Frame.getInstance().cambiarPanel(new PanelOpcUnic((OpcionUnica)p, t), 1);
			} else {
				JOptionPane.showMessageDialog(vista, "Error, ya existe una opcion correcta");
			}
		}else{
			p.anadirOpcion(new Opcion(enunciado,correcta));
			Frame.getInstance().cambiarPanel(new PanelOpcMult((OpcionMultiple)p,t), 1);
		}
	}

	public void crearPregOpcMult(Test t, String enunciado, Double valor, Double penalizacion) {
		OpcionMultiple p = new OpcionMultiple(enunciado,valor,penalizacion);
		Frame.getInstance().cambiarPanel(new PanelOpcMult(p,t), 1);
		
	}

	public void eliminarAsignatura(Asignatura asig) {
		Aplicacion.getInstance().eliminarAsignatura(asig);
		Frame.getInstance().borrarDer();
		Frame.getInstance().cambiarPanel(new PanelAsignaturas(Aplicacion.getInstance()), 0);
		
	}
}