package aplicacion;

import aplicacion.asignatura.elemento.test.Test;

import java.util.ArrayList;
import java.util.List;

import aplicacion.asignatura.Asignatura;
import aplicacion.asignatura.elemento.resolucion.*;

public class Alumno {
	private final String nia;
	private final String contrasena;
	private final String correo;
	private String nombre;
	private String apellidos;
	private String dni;
	private List<Resolucion>resoluciones = new ArrayList<Resolucion>();
	
	public Alumno(String nia, String contrasena, String correo, String nombre, String apellidos, String dni) {
		this.nia = nia;
		this.contrasena = contrasena;
		this.correo = correo;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.dni = dni;
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

	public String getDni() {
		return dni;
	}

	public boolean anadirResolucion(Test test) {
		Resolucion res = new Resolucion(test);
		return this.resoluciones.add(res);
	}
	
	public void enviarSolicitud(Asignatura asignatura, String texto){
		Solicitud solicitud = new Solicitud(texto,this,asignatura);
		asignatura.anadirSolicitud(solicitud);
	}
	
	
	
	
	
	
	

}
