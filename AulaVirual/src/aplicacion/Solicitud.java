package aplicacion;

import java.time.LocalDate;

import aplicacion.asignatura.Asignatura;

public class Solicitud implements java.io.Serializable {
	private static final long serialVersionUID = 1L;
	
	private final String texto;
	private final LocalDate fecha;
	private Alumno alumno;
	private Asignatura asigantura;

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
