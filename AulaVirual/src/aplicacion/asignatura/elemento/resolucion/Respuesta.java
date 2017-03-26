package aplicacion.asignatura.elemento.resolucion;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import aplicacion.Aplicacion;
import aplicacion.TipoUsuario;
import aplicacion.asignatura.elemento.test.Opcion;
import aplicacion.asignatura.elemento.test.OpcionMultiple;
import aplicacion.asignatura.elemento.test.Pregunta;
import aplicacion.asignatura.elemento.test.PreguntaOpcion;
import aplicacion.asignatura.elemento.test.SiNo;

/**
 * Respuesta. Clase creada cuando un alumno responde una pregunta.
 * 
 * @author Adrian Fernandez
 * @author Ricardo Riol
 */
public class Respuesta implements java.io.Serializable {
	private static final long serialVersionUID = 1L;
	
	private EstadoRespuesta estado;
	private String respuesta;
	private List <Opcion> opcionesSeleccionadas = new ArrayList <Opcion> ();
	private final Pregunta pregunta;
	
	/**
	 * Constructor de Respuesta.
	 * 
	 * @param p pregunta a responder
	 */
	public Respuesta(Pregunta p) {
		this.estado = EstadoRespuesta.NSNC;
		this.respuesta = "";
		this.pregunta = p;
	}

	public List<Opcion> getOpcionesSeleccionadas() {
		return Collections.unmodifiableList(opcionesSeleccionadas);
	}
	
	/**
	 * Metodo que permite anadir una opcion a la lista de opciones de la respuesta.
	 * Solo es accesible por alumnos.
	 * 
	 * @param opcion opcion a anadir
	 * @return boolean true si se anade correctamente, false en caso contrario
	 */
	public boolean anadirOpcion(Opcion opcion){
		if (Aplicacion.getInstance().getTipoUsu().equals(TipoUsuario.ALUMNO) == false) {
			return false;
		}
		return this.opcionesSeleccionadas.add(opcion);
	}
	
	/**
	 * Metodo que permite eliminar una opcion de la lista de opciones de la respuesta.
	 * Solo es accesible por alumnos.
	 * 
	 * @param respuesta respuesta a eliminar
	 * @return boolean true si se eimina correctamente, false en caso contrario
	 */
	public boolean eliminarRespuesta(Respuesta respuesta){
		if (Aplicacion.getInstance().getTipoUsu().equals(TipoUsuario.ALUMNO) == false) {
			return false;
		}
		return this.opcionesSeleccionadas.remove(respuesta);
	}
	
	public String getRespuesta() {
		return respuesta;
	}

	public void setRespuesta(String respuesta) {
		if (Aplicacion.getInstance().getTipoUsu().equals(TipoUsuario.ALUMNO)) {
			this.respuesta = respuesta;
		}
	}

	public void setEstado(EstadoRespuesta estado) {
		this.estado = estado;
	}

	public EstadoRespuesta getEstado() {
		return estado;
	}

	public Pregunta getPregunta() {
		return pregunta;
	}

	@Override
	public String toString() {
		String res = "";
		if (this.getPregunta() instanceof PreguntaOpcion || this.getPregunta() instanceof OpcionMultiple || this.getPregunta() instanceof SiNo){
			for (Opcion opc :this.getOpcionesSeleccionadas()){
				res = res + opc;
			}
		} else {
			res = res + this.respuesta;
		}
		
		return res;
	}

	

	
}
