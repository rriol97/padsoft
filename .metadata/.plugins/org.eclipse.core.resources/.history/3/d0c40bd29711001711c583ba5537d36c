package aplicacion.asignatura.elemento.resolucion;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import aplicacion.asignatura.elemento.test.Opcion;
import aplicacion.asignatura.elemento.test.Pregunta;

public class Respuesta {
	private EstadoRespuesta estado;
	private String respuesta;
	private List <Opcion> opcionesSeleccionadas = new ArrayList <Opcion> ();
	private final Pregunta pregunta;
	
	public Respuesta(Pregunta p) {
		this.estado = EstadoRespuesta.NSNC;
		this.respuesta = "";
		this.pregunta = p;
	}

	public List<Opcion> getOpcionesSeleccionadas() {
		return Collections.unmodifiableList(opcionesSeleccionadas);
	}
	
	public boolean anadirOpcion(Opcion opcion){
		return this.opcionesSeleccionadas.add(opcion);
	}
	
	public boolean eliminarRespuesta(Respuesta respuesta){
		return this.opcionesSeleccionadas.remove(respuesta);
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


	
}
