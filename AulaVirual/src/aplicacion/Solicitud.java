package aplicacion;

import java.time.LocalDate;

import aplicacion.asignatura.Asignatura;

/**
 * Solicitud. Esta clse se genera cuando un alumno solicita ingresar en una asignatura y se destruye cuando se acepta o rechaza. Contiene un mensaje, la fecha de creacion, una referencia al alumno que la realizo y otra referenca a la asignatura.
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
	 * @param texto texto de la solicitud
	 * @param alumno alumno que solicita
	 * @param asignatura asignatura a solicitar
	 */
	public Solicitud(String texto,Alumno alumno,Asignatura asignatura) {
		this.texto = texto;
		this.fecha = LocalDate.now();
		this.alumno = alumno;
		this.asigantura = asignatura;
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
		return  this.alumno+" solicita inscribirse en la asignatura "+this.asigantura.getNombre()+"\n  "+" "+this.texto;
	}
	
}
