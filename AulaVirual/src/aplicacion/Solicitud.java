package aplicacion;

import java.time.LocalDate;

import aplicacion.asignatura.Asignatura;

/**
 * Solicitud. Esta clse se genera cuando un alumno solicita ingresar en una asignatura y se destruye cuando se acepta o rechaza. Contiene un mensaje, la fecha de creación y un indicador del alumno que la realizo.
 * 
 * @author Adrian Fernandez
 * @author Ricardo Riol
 *
 */
public class Solicitud implements java.io.Serializable {
	private static final long serialVersionUID = 1L;
	
	private final String texto;
	private final LocalDate fecha;
	private Alumno alumno;
	private Asignatura asigantura;

	/**
	 * Constructor de Solicitud.
	 * 
	 * @param texto
	 * @param alumno
	 * @param asignatura
	 */
	public Solicitud(String texto,Alumno alumno,Asignatura asignatura) {
		this.texto = texto;
		this.fecha = LocalDate.now();
		this.alumno = alumno;
		this.asigantura = asignatura;
		this.asigantura.anadirSolicitud(this);
	}

	public String getTexto() {
		return texto;
	}

	public LocalDate getFecha() {
		return fecha;
	}
	
	public Alumno getAlumno() {
		
		return this.alumno;
	}
	
	public Asignatura getAsignatura(){
		return this.asigantura;
	}

	@Override
	public String toString() {
		return "\t"+ this.alumno+" solicita inscribirse en la asignatura "+this.asigantura.getNombre()+"\n\t\t "+" "+this.texto;
	}
	
}
