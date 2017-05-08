 package aplicacion.GUI.controlador;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.LocalDate;

import javax.swing.JOptionPane;

import aplicacion.clases.elemento.test.*;
import aplicacion.clases.resolucion.Resolucion;
import aplicacion.clases.resolucion.Respuesta;
import aplicacion.GUI.frame.Frame;
import aplicacion.GUI.login.FrameLogin;
import aplicacion.GUI.paneles.alumno.PanelAsigAlum;
import aplicacion.GUI.paneles.alumno.PanelTestAlum;
import aplicacion.GUI.paneles.alumno.componentes.PanelPreg;
import aplicacion.GUI.paneles.profesor.PanelAsigProf;
import aplicacion.GUI.paneles.profesor.PanelAsignaturas;
import aplicacion.GUI.paneles.profesor.test.PanelAnadirPregunta;
import aplicacion.GUI.paneles.profesor.test.PanelCrearOpcMult;
import aplicacion.GUI.paneles.profesor.test.PanelCrearOpcUnic;
import aplicacion.GUI.paneles.profesor.test.PanelVisualizarTest;
import aplicacion.clases.Aplicacion;
import aplicacion.clases.Asignatura;
import aplicacion.clases.Solicitud;
import aplicacion.clases.elemento.Apuntes;
import aplicacion.clases.elemento.Elemento;
import aplicacion.clases.elemento.Tema;
import es.uam.eps.padsof.emailconnection.FailedInternetConnectionException;
import es.uam.eps.padsof.emailconnection.InvalidEmailAddressException;

/**
 * Clas controlador. Se encarga de manejar los los objetos de la aplicacion.
 * @author Adrian Fernandez
 * @author Ricardo Riol
 *
 */
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

	/**
	 * Metodo para salir de la aplicacion.
	 * @throws FileNotFoundException excepcion
	 * @throws IOException excepcion
	 */
	public void salirAplicacion() throws FileNotFoundException, IOException{
		Aplicacion.getInstance().logOut();
		FrameLogin.getInstance().setVisible(true);
	}

	/**
	 * Metodo para solicitar una asignatura.
	 * @param a Asignatura solicitada
	 * @param texto Mensaje de la solicitud
	 */
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
	
	/**
	 * Metodo pata crear una asignatura.
	 * @param texto Nombre de la asignatura.
	 */
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
	
	/**
	 * Metodo para denagar una solicitud.
	 * @param asignatura Asignatura solicitada
	 * @param sol Solicitud enviada
	 * @throws InvalidEmailAddressException excepcion
	 * @throws FailedInternetConnectionException excepcion
	 */
	public void denergarSol(Asignatura asignatura, Solicitud sol) throws InvalidEmailAddressException, FailedInternetConnectionException {
		asignatura.denegarSolicitud(sol);
	}

	/**
	 * Metodo para aceptar una solicitud.
	 * @param asignatura Asignatura solicitada
	 * @param sol Solicitud enviada
	 * @throws InvalidEmailAddressException excepcion
	 * @throws FailedInternetConnectionException excepcion
	 */
	public void aceptarSol(Asignatura asignatura, Solicitud sol) throws InvalidEmailAddressException, FailedInternetConnectionException {
		asignatura.aceptarSolicitud(sol);
	}

	/**
	 * Metodo para crear apuntes.
	 * @param titulo Titulo de los apuntes.
	 * @param selec Visiblidad
	 * @param contenido Texto contenido.
	 * @param asig Asignatura que los contiene.
	 * @param tema Tema que los contiene.
	 * @throws InvalidEmailAddressException excepcion
	 * @throws FailedInternetConnectionException excepcion
	 */
	public void crearApuntes(String titulo, boolean selec, String contenido, Asignatura asig, Tema tema) throws InvalidEmailAddressException, FailedInternetConnectionException {
		tema.anadirElemento(new Apuntes(titulo,selec,contenido,asig));
	}

	/**
	 * Metodo para crear un tema.
	 * @param nombre Nombre del tema
	 * @param b Visibilidad
	 * @param asig Asignatura a la que pertenece
	 * @param tema Tema padre que lo contiene, null si esta contenido en la asignatura
	 * @throws InvalidEmailAddressException excepcion
	 * @throws FailedInternetConnectionException excepcion
	 */
	public void crearTema(String nombre, boolean b, Asignatura asig, Tema tema) throws InvalidEmailAddressException, FailedInternetConnectionException {
		if (tema == null) {
			asig.anadirElemento(new Tema(nombre,b,asig));
		} else {
			tema.anadirElemento(new Tema(nombre,b,asig));
		}
	}

	/**
	 * Metodo para crear un nuevo test.
	 * @param nombre Nombre del test
	 * @param selec Visibilidad
	 * @param asig Asignatura a la que pertenece
	 * @param fechaIni Fecha de inicio
	 * @param fechaFin Fecha de fin
	 * @param orden Indicador del orden de las preguntas
	 * @param peso Peso del test con respecto a la asignatura
	 * @param vpd valor por defecto de las preguntas
	 * @param tema Tema que lo contiene
	 * @return Test creado
	 * @throws InvalidEmailAddressException excepcion
	 * @throws FailedInternetConnectionException excepcion
	 */
	public Test nuevoTest(String nombre, boolean selec, Asignatura asig, LocalDate fechaIni, LocalDate fechaFin, boolean orden,
						Double peso, Double vpd, Tema tema) throws InvalidEmailAddressException, FailedInternetConnectionException {
		
		Test t = new Test (nombre,selec,asig,"",fechaIni,fechaFin,orden,peso,vpd);
		tema.anadirElemento(t);
		return t;
	}

	/**
	 * Metodo para eliminar un test.
	 * @param t Test a eliminar
	 * @param w Tema contenedor
	 * @throws InvalidEmailAddressException excepcion
	 * @throws FailedInternetConnectionException excepcion
	 */
	public void eliminarTest(Test t,Tema w) throws InvalidEmailAddressException, FailedInternetConnectionException {
		w.eliminarElemento(t);
	}
	
	/**
	 * Metodo para crear una pregunta de tipo si/no
	 * @param t Test contenedor
	 * @param enunciado enunciado de la pregunta
	 * @param valor Valor dentro del test
	 * @param penalizacion Penalizacion por contestar mal
	 * @param respuesta Respuesta
	 * @param opc1 Opcion 1
	 * @param opc2 Opcion 2
	 */
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

	/**
	 * Metodo para crear una pregunta de tipo respuesta libre.
	 * @param t Test contenedor
	 * @param enunciado Enunciado de la pregunta
	 * @param valor Valor dentro del test
	 * @param penalizacion Penalizacion por contestar mal
	 * @param sol Solucion
	 */
	public void crearPregCorta(Test t,String enunciado, Double valor, Double penalizacion, String sol) {
		RespuestaLibre p = new RespuestaLibre(enunciado,valor,penalizacion,sol);
		t.anadirPregunta(p);
		
	}

	/**
	 * Metodo para crear una pregunta de tipo opcion unica.
	 * @param t Test contenedor
	 * @param enunciado Enunciado de la pregunta
	 * @param valor Valor dentro del test
	 * @param penalizacion Penalizacion por contestar mal
	 * @param aleatoria Indicador del orden de las opciones
	 */
	public void crearPregOpcUnic(Test t,String enunciado, Double valor, Double penalizacion, boolean aleatoria) {
		OpcionUnica p = new OpcionUnica(enunciado,valor,penalizacion);
		p.setAleatoria(aleatoria);
		Frame.getInstance().cambiarPanel(new PanelCrearOpcUnic(p, t), 1);
	}
	
	/**
	 * Metodo para crear una pregunta de tipo opcion multiple.
	 * @param t Test contenedor
	 * @param enunciado Enunciado de la pregunta
	 * @param valor Valor dentro del test
	 * @param penalizacion Penalizacion por contestar mal
	 * @param aleatoria Indicador del orden de las opciones
	 */
	public void crearPregOpcMult(Test t, String enunciado, Double valor, Double penalizacion, boolean aleatoria) {
		OpcionMultiple p = new OpcionMultiple(enunciado,valor,penalizacion);
		p.setAleatoria(aleatoria);
		Frame.getInstance().cambiarPanel(new PanelCrearOpcMult(p,t), 1);
	}
	
	/**
	 * Metodo para editar una pregunta de tipo respuesta libre.
	 * @param t Test contenedor
	 * @param enunciado Enunciado de la pregunta
	 * @param valor Valor dentro del test
	 * @param penalizacion Penalizacion por contestar mal
	 * @param sol Solucion
	 */
	public void editarPregCorta(Test t,String enunciado, Double valor, Double penalizacion, String sol) {
		RespuestaLibre p = new RespuestaLibre(enunciado,valor,penalizacion,sol);
		t.anadirPregunta(p);
		
	}
	
	/**
	 * Metodo para editar una pregunta de tipo si/no
	 * @param preg Pregunta a editar
	 * @param enunciado enunciado de la pregunta
	 * @param valor Valor dentro del test
	 * @param penalizacion Penalizacion por contestar mal
	 * @param respuesta Respuesta
	 */
	public void editarPregSiNo(SiNo preg, String enunciado, Double valor, Double penalizacion, String respuesta) {
		preg.setEnunciado(enunciado);
		preg.setValor(valor);
		preg.setPenalizacion(penalizacion);
		for (Opcion o:preg.getCorrectas()){
			o.setTexto(respuesta);
		}
		
	}

	/**
	 * Metodo para editar una pregunta de tipo respuesta libre.
	 * @param preg Pregunta a editar
	 * @param enunciado Enunciado de la pregunta
	 * @param valor Valor dentro del test
	 * @param penalizacion Penalizacion por contestar mal
	 * @param respuesta Solucion de la pregunta
	 */
	public void editarPreguntaCorta(RespuestaLibre preg, String enunciado, Double valor, Double penalizacion,
			String respuesta) {
		
		preg.setEnunciado(enunciado);
		preg.setValor(valor);
		preg.setPenalizacion(penalizacion);
		preg.setSolucion(respuesta);
		
	}
	
	/**
	 * Metodo para editar una pregunta de tipo opcion unica.
	 * @param t Test contenedor
	 * @param ou Pregunta a editar
	 * @param enunciado Nuevo enunciado
	 * @param valor Nuevo valor
	 * @param penalizacion Nueva penalizacion
	 */
	public void editarPregOpcUnic(Test t, OpcionUnica ou, String enunciado, Double valor, Double penalizacion) {
		ou.setEnunciado(enunciado);
		ou.setValor(valor);
		ou.setPenalizacion(penalizacion);
		Frame.getInstance().cambiarPanel(new PanelCrearOpcUnic(ou, t), 1);
	}
	
	/**
	 * Metodo para editar una pregunta de tipo opcion multiple.
	 * @param t Test contenedor
	 * @param om Pregunta a editar
	 * @param enunciado Nuevo enunciado
	 * @param valor Nuevo valor
	 * @param penalizacion Nueva penalizacion
	 */
	public void editarPregOpcMult(Test t, OpcionMultiple om, String enunciado, Double valor, Double penalizacion) {
		om.setEnunciado(enunciado);
		om.setValor(valor);
		om.setPenalizacion(penalizacion);
		Frame.getInstance().cambiarPanel(new PanelCrearOpcMult(om, t), 1);
	}
	
	/**
	 * Metodo para anadir una opcion a una pregunta de opciones.
	 * @param t Test contenedor.
	 * @param p Pregunta a la cual anadir la opcion
	 * @param enunciado Texto de la opcion
	 * @param correcta Indica si la opcion es correcta
	 */
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

	/**
	 * Metodo para eliminar una asignatura.
	 * @param asig Asignatura a eliminar.
	 */
	public void eliminarAsignatura(Asignatura asig) {
		Aplicacion.getInstance().eliminarAsignatura(asig);
		Frame.getInstance().borrarDer();
		Frame.getInstance().cambiarPanel(new PanelAsignaturas(Aplicacion.getInstance()), 0);
	}
	
	/**
	 * Metodo para eliminar un elemento de una asignatura o de un tema.
	 * @param ele Elemento a eliminar.
	 * @param padre Padre del elemento.
	 */
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
	
	/**
	 * Metodo para realizar un test.
	 * @param vista Panel que contiene toda la informacion de la resolucion del alumno
	 * @param test Test realizado
	 */
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
	
	/**
	 * Metodo para eliminar una pregunta de un test.
	 * @param t Test contenedor
	 * @param p Pregunta a eliminar
	 */
	public void eliminarPreg(Test t, Pregunta p) {
		t.eliminarPregunta(p);
		Frame.getInstance().cambiarPanel(new PanelAnadirPregunta(t), 1);
	}

	/**
	 * Metodo para eliminar una opcion de una pregunta
	 * @param u Pregunta contenedora
	 * @param sel Opcion a eliminar
	 * @param t Test contenedor
	 */
	public void eliminarOpc(PreguntaOpcion u, Opcion sel,Test t) {
		u.eliminarOpcion(sel);
		if (u instanceof OpcionUnica){
			Frame.getInstance().cambiarPanel(new PanelCrearOpcUnic((OpcionUnica)u, t), 1);
		} else{
			Frame.getInstance().cambiarPanel(new PanelCrearOpcMult((OpcionMultiple)u,t), 1);
		}
	}

	public void modificarTest(Test t, String nombre, boolean selec, boolean orden, LocalDate fechaIni,
			LocalDate fechaFin, Double vpd, Double peso)  {
		try {
			t.setVisible(selec);
		} catch (InvalidEmailAddressException | FailedInternetConnectionException e) {
			e.printStackTrace();
		}
		t.setAleatorio(orden);
		t.setFechaIni(fechaIni);
		t.setFechaFin(fechaFin);
		t.setValorDefecto(vpd);
		t.setPeso(peso);
	}

	public void editarFechaFinTest(Test t,LocalDate fechaFin) {
		t.setFechaFin(fechaFin);
		Frame.getInstance().cambiarPanel(new PanelVisualizarTest(t,t.getAsignatura()), 1);
	}
}