package aplicacion.clases;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import aplicacion.clases.elemento.test.Test;
import aplicacion.clases.resolucion.*;

/**
 * Alumno. Clase que contiene todo lo relacionado con los alumnos, como sus datos personales, sus asignaturas y las resoluciones de test realizadas.
 * 
 * @author Adrian Fernandez
 * @author Ricardo Riol
 * 
 *
 */
public class Alumno implements java.io.Serializable {
	private static final long serialVersionUID = 1L;
	
	private final String nia;
	private final String contrasena;
	private final String correo;
	private String nombre;
	private String apellidos;
	private List<Resolucion>resoluciones = new ArrayList<Resolucion>();
	private List<Asignatura>asignaturas = new ArrayList<Asignatura>();
	
	/**
	 * Constructor de Alumno.
	 * 
	 * @param nia nia del alumno
	 * @param contrasena contrasena del alumno
	 * @param correo correo del alumno
	 * @param nombre nombre del alumno
	 * @param apellidos apellios del alumno
	 */
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
	
	public List<Asignatura> getAsignaturas() {
		return Collections.unmodifiableList(this.asignaturas);
	}
	
	/**
	 * Metodo que permite anadir una asignatura a la lista de asignaturas de un alumno.
	 * 
	 * @param asig asigantura a a�adir
	 * @return boolean true si se anade correctamente, false en caso contrario
	 */
	public boolean anadirAsignatura(Asignatura asig) {
		if (asig == null || this.asignaturas.contains(asig)){
			return false;
		}
		return this.asignaturas.add(asig);
	}
	
	/**
	 * Metodo que permite eliminar una asignatura de la lista de asignaturas de un alumno.
	 * 
	 * @param asig asignatura a eliminar
	 * @return boolean true si se elimina correctamente, false en caso contrario
	 */
	public boolean eliminarAsignatura(Asignatura asig){
		return this.asignaturas.remove(asig);
	}
	
	/**
	 * Metodo que permite anadir una resolucion a la lista de resoluciones de un alumno.
	 * 
	 * @param res resolucion a anadir
	 * @return boolean true si se anade correctamente, false en caso contrario
	 */
	public boolean anadirResolucion(Resolucion res) {
		if (res == null || this.resoluciones.contains(res)){
			return false;
		}
		return this.resoluciones.add(res);
	}
	
	/**
	 * Metodo que permite eliminar una resolucion de la lista de resoluciones de un alumno.
	 * 
	 * @param res resolucion a eliminar
	 * @return boolean true si se elimina correctamente, false en caso contrario
	 */
	public boolean eliminarResolucion(Resolucion res){
		return this.resoluciones.remove(res);
	}
	
	/**
	 * Metodo para enviar una solicitud de ingreso a una asignatura.
	 * 
	 * @param sol solicitud a enviar
	 * @return boolean true si se envia correctamente, false en caso contrario
	 */
	public boolean enviarSolicitud(Solicitud sol){
		if (this.asignaturas.contains(sol.getAsignatura())){
			return false;
		}
		System.out.println("Su solicitud se ha enviado correctamenete");
		return sol.getAsignatura().anadirSolicitud(sol);
	}
	
	/**
	 * Metodo para encontar la resolucion de un test realizado por un alumno. 
	 * 
	 * @param test test hecho por el alumno
	 * @return Resolucion La resolucion si se encuantra.
	 */
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
