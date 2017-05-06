 package aplicacion.GUI.controlador;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.LocalDate;

import javax.swing.JOptionPane;

import aplicacion.clases.elemento.test.*;
import aplicacion.clases.resolucion.Resolucion;
import aplicacion.clases.resolucion.Respuesta;
import aplicacion.GUI.general.Frame;
import aplicacion.GUI.login.FrameLogin;
import aplicacion.GUI.paneles.alumno.PanelAsigAlum;
import aplicacion.GUI.paneles.alumno.PanelTestAlum;
import aplicacion.GUI.paneles.alumno.componentes.PanelPreg;
import aplicacion.GUI.paneles.profesor.PanelAsigProf;
import aplicacion.GUI.paneles.profesor.PanelAsignaturas;
import aplicacion.GUI.paneles.profesor.test.PanelAnadirPregunta;
import aplicacion.GUI.paneles.profesor.test.PanelCrearOpcMult;
import aplicacion.GUI.paneles.profesor.test.PanelCrearOpcUnic;
import aplicacion.clases.Aplicacion;
import aplicacion.clases.Asignatura;
import aplicacion.clases.Solicitud;
import aplicacion.clases.elemento.Apuntes;
import aplicacion.clases.elemento.Elemento;
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
		if (a == null){
			JOptionPane.showMessageDialog(vista, "Debe seleccionar una asignatura");
		} else if (texto.equals("")){
			JOptionPane.showMessageDialog(vista, "Debe añadir un mensaje");
		} else {
			Solicitud s = new Solicitud(texto, Aplicacion.getInstance().getAlumnoActual(), a);
			if (Aplicacion.getInstance().getAlumnoActual().enviarSolicitud(s) == false) {
				JOptionPane.showMessageDialog(vista, "Ya has solicitado esta asignatura");
			} else {
				JOptionPane.showMessageDialog(vista, "Se ha enviado la solicitud correctamente");
				Frame.getInstance().borrarDer();
			}
		}
	}

	public void crearAsig(String texto) {
		Asignatura a = new Asignatura(texto);
		if (Aplicacion.getInstance().anadirAsignatura(a) == false) {
			JOptionPane.showMessageDialog(vista, "Error al crear la asignatura");
		} else {
			Frame.getInstance().cambiarPanel(new PanelAsignaturas(Aplicacion.getInstance()), 0);
			JOptionPane.showMessageDialog(vista, "Asignatura creada");
			Frame.getInstance().borrarDer();
		}
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
		Frame.getInstance().cambiarPanel(new PanelCrearOpcUnic(p, t), 1);
	}
	
	public void crearPregOpcMult(Test t, String enunciado, Double valor, Double penalizacion) {
		OpcionMultiple p = new OpcionMultiple(enunciado,valor,penalizacion);
		Frame.getInstance().cambiarPanel(new PanelCrearOpcMult(p,t), 1);
	}
	
	public void editarPregCorta(Test t,String enunciado, Double valor, Double penalizacion, String sol) {
		RespuestaLibre p = new RespuestaLibre(enunciado,valor,penalizacion,sol);
		t.anadirPregunta(p);
		
	}

	public void editarPregOpcUnic(Test t, OpcionUnica ou, String enunciado, Double valor, Double penalizacion) {
		ou.setEnunciado(enunciado);
		ou.setValor(valor);
		ou.setPenalizacion(penalizacion);
		Frame.getInstance().cambiarPanel(new PanelCrearOpcUnic(ou, t), 1);
	}
	
	public void editarPregOpcMult(Test t, OpcionMultiple om, String enunciado, Double valor, Double penalizacion) {
		om.setEnunciado(enunciado);
		om.setValor(valor);
		om.setPenalizacion(penalizacion);
		Frame.getInstance().cambiarPanel(new PanelCrearOpcMult(om, t), 1);
	}
	
	public void anadirOpcion(Test t, PreguntaOpcion p, String enunciado, boolean correcta) {
		if (p instanceof OpcionUnica){
			if (p.anadirOpcion(new Opcion(enunciado, correcta))) {
				Frame.getInstance().cambiarPanel(new PanelCrearOpcUnic((OpcionUnica)p, t), 1);
			} else {
				JOptionPane.showMessageDialog(vista, "Error, ya existe una opcion correcta");
			}
		}else{
			p.anadirOpcion(new Opcion(enunciado,correcta));
			Frame.getInstance().cambiarPanel(new PanelCrearOpcMult((OpcionMultiple)p,t), 1);
		}
	}

	public void eliminarAsignatura(Asignatura asig) {
		Aplicacion.getInstance().eliminarAsignatura(asig);
		Frame.getInstance().borrarDer();
		Frame.getInstance().cambiarPanel(new PanelAsignaturas(Aplicacion.getInstance()), 0);
	}
	
	public void eliminarElemento(Elemento ele, Object padre) {
		if (padre instanceof Asignatura) {
			Asignatura asig = (Asignatura) padre;
			try {
				if (asig.eliminarElemento(ele) == false) {
					JOptionPane.showMessageDialog(vista, "Elemento no eliminable");
				} else {
					Frame.getInstance().cambiarPanel(new PanelAsigProf(ele.getAsignatura()), 1);
				}
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		} else if (padre instanceof Tema) {
			Tema t = (Tema) padre;
			if (t.eliminarElemento(ele) == false) {
				JOptionPane.showMessageDialog(vista, "Elemento no eliminable");
			} else {
				Frame.getInstance().cambiarPanel(new PanelAsigProf(ele.getAsignatura()), 1);
			}
		}
	}
	
	public void realizarTest(PanelTestAlum vista, Test test) {
		Resolucion res = new Resolucion(test, Aplicacion.getInstance().getAlumnoActual());
		for (Pregunta p: test.getPreguntas()) {
			for (PanelPreg panel: vista.getPaneles()) {
				if (p.equals(panel.getPregunta())) {
					Respuesta resp = new Respuesta(p);
					if (p instanceof RespuestaLibre) {
						resp.setRespuesta(panel.getRespuesta().getText());
					} else {
						for (Opcion opc: panel.getSeleccionadas()) {
							resp.anadirOpcion(opc);
						}
					}
					res.anadirRespuesta(resp);
					break;
				}
			}
		}
		Aplicacion.getInstance().getAlumnoActual().anadirResolucion(res);
		Frame.getInstance().cambiarPanel(new PanelAsigAlum(test.getAsignatura()), 1);
	}
	
	public void eliminarPreg(Test t, Pregunta p) {
		t.eliminarPregunta(p);
		Frame.getInstance().cambiarPanel(new PanelAnadirPregunta(t), 1);
	}

	public void eliminarOpc(PreguntaOpcion u, Opcion sel,Test t) {
		u.eliminarOpcion(sel);
		if (u instanceof OpcionUnica){
			Frame.getInstance().cambiarPanel(new PanelCrearOpcUnic((OpcionUnica)u, t), 1);
		} else{
			Frame.getInstance().cambiarPanel(new PanelCrearOpcMult((OpcionMultiple)u,t), 1);
		}
	}

	public void editarPregSiNo(SiNo preg, String enunciado, Double valor, Double penalizacion, String respuesta) {
		preg.setEnunciado(enunciado);
		preg.setValor(valor);
		preg.setPenalizacion(penalizacion);
		for (Opcion o:preg.getCorrectas()){
			o.setTexto(respuesta);
		}
		
	}

	public void editarPreguntaCorta(RespuestaLibre preg, String enunciado, Double valor, Double penalizacion,
			String respuesta) {
		
		preg.setEnunciado(enunciado);
		preg.setValor(valor);
		preg.setPenalizacion(penalizacion);
		preg.setSolucion(respuesta);
		
	}
}