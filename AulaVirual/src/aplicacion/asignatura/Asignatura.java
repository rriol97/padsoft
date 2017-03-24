package aplicacion.asignatura;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import aplicacion.asignatura.elemento.Elemento;
import aplicacion.*;

public class Asignatura {

	private final String nombre;
	private List<Solicitud> solicitudes = new ArrayList<Solicitud>();
	private List<Alumno> matriculados = new ArrayList<Alumno>();
	private List<Alumno> expulsados = new ArrayList<Alumno>();
	private List<Elemento> elementos = new ArrayList<Elemento>();

	public Asignatura(String nombre) {
		this.nombre = nombre;
	}

	public String getNombre() {
		return nombre;
	}

	public List<Solicitud> getSolicitudes() {
		return Collections.unmodifiableList(solicitudes);
	}
	
	public boolean anadirSolicitud(Solicitud solicitud){
		return this.solicitudes.add(solicitud);
	}
	
	public boolean aceptarSolicitud(Solicitud solicitud){
		if (this.solicitudes.contains(solicitud)){
			this.matriculados.add(solicitud.getAlumno());
			this.solicitudes.remove(solicitud);
			return true;
		}
		
		return false;
	}
	
	public void denegarSolicitud(Solicitud solicitud){
	}
	
	public List<Alumno> getMatriculados() {
		return Collections.unmodifiableList(matriculados);
	}
	
	public void expulsarAlumno(Alumno alumno){
		this.matriculados.remove(alumno);
		this.expulsados.add(alumno);
	}
	
	public void readmitirAlumno(Alumno alumno){
		this.expulsados.remove(alumno);
		this.matriculados.add(alumno);
	}
	
	public List<Alumno> getExpulsados() {
		return Collections.unmodifiableList(expulsados);
	}
	
	public List<Elemento> getElementos() {
		return Collections.unmodifiableList(elementos);
	}
	
	public boolean anadirElemento(Elemento elemento){
		return this.elementos.add(elemento);
	}
	
	public boolean eliminarElemento(Elemento elemento){
		return this.elementos.remove(elemento);
	}
	

}
