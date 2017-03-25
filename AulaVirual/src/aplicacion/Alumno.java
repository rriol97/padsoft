package aplicacion;

import aplicacion.asignatura.elemento.test.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import aplicacion.asignatura.Asignatura;
import aplicacion.asignatura.elemento.resolucion.*;

public class Alumno {
	private final String nia;
	private final String contrasena;
	private final String correo;
	private String nombre;
	private String apellidos;
	private List<Resolucion>resoluciones = new ArrayList<Resolucion>();
	private List<Asignatura>asignaturas = new ArrayList<Asignatura>();
	
	public Alumno(String nia, String contrasena, String correo, String nombre, String apellidos) {
		this.nia = nia;
		this.contrasena = contrasena;
		this.correo = correo;
		this.nombre = nombre;
		this.apellidos = apellidos;

	}

	public String getNia() {
		return nia;
	}

	public String getContrasena() {
		return contrasena;
	}

	public String getCorreo() {
		return correo;
	}
	
	public String getNombre() {
		return nombre;
	}

	public String getApellidos() {
		return apellidos;
	}
	
	public List<Resolucion> getResoluciones() {
		return Collections.unmodifiableList(this.resoluciones);
	}
	
	public List<Asignatura> getAsignatura() {
		return Collections.unmodifiableList(this.asignaturas);
	}
	
	public boolean anadirAsignatura(Asignatura asig) {
		return this.asignaturas.add(asig);
	}
	
	public boolean eliminarAsignatura(Asignatura asig){
		return this.asignaturas.remove(asig);
	}

	public boolean anadirResolucion(Test test) {
		Resolucion res = new Resolucion(test);
		return this.resoluciones.add(res);
	}
	
	public boolean eliminarResolucion(Resolucion res){
		return this.resoluciones.remove(res);
	}
	
	public boolean enviarSolicitud(Asignatura asignatura, String texto){
		if (this.asignaturas.contains(asignatura)){
			return false;
		}
		Solicitud solicitud = new Solicitud(texto,this,asignatura);
		return asignatura.anadirSolicitud(solicitud);
	}
	
	public Resolucion encontrarResolucion (Test test){
		for (Resolucion res:this.resoluciones){
			res.getTest().equals(test);
			return res;
		}
		return null;
	}

	@Override
	public String toString() {
		return "Alumno [nia=" + nia + ", correo=" + correo + ", nombre=" + nombre
				+ ", apellidos=" + apellidos +"]";
	}
	
	

	
	
	
	
	
	
	
	

}
