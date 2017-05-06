package aplicacion.clases.resolucion;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import aplicacion.clases.elemento.test.Opcion;
import aplicacion.clases.elemento.test.OpcionMultiple;
import aplicacion.clases.elemento.test.Pregunta;
import aplicacion.clases.elemento.test.PreguntaOpcion;
import aplicacion.clases.elemento.test.SiNo;

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
		p.anadirRespuesta(this);
	}

	public List<Opcion> getOpcionesSeleccionadas() {
		return Collections.unmodifiableList(opcionesSeleccionadas);
	}
	
	/**
	 * Metodo que permite anadir una opcion a la lista de opciones de la respuesta.
	 * 
	 * @param opcion opcion a anadir
	 * @return boolean true si se anade correctamente, false en caso contrario
	 */
	public boolean anadirOpcion(Opcion opcion){
		if (opcion == null || this.opcionesSeleccionadas.contains(opcion)){
			return false;
		}
		return this.opcionesSeleccionadas.add(opcion);
	}
	
	/**
	 * Metodo que permite eliminar una opcion de la lista de opciones de la respuesta.
	 * 
	 * @param opcion opcion a eliminar
	 * @return boolean true si se elimina correctamente, false en caso contrario
	 */
	public boolean eliminarOpcion(Opcion opcion){
		return this.opcionesSeleccionadas.remove(opcion);
	}
	
	public String getRespuesta() {
		return respuesta;
	}

	public void setRespuesta(String respuesta) {
		this.respuesta = respuesta;
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
