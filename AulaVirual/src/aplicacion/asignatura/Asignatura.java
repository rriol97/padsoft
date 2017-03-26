package aplicacion.asignatura;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import aplicacion.asignatura.elemento.Elemento;
import aplicacion.asignatura.elemento.resolucion.Resolucion;
import aplicacion.*;

/**
 * Asignatura. Clase que contiene los datos de una asignatura. Como son su nombre y elementos, la lista de solicitudes de ingreso, la lista de alumnos matriculados y la de alumnos expulsados.
 * 
 * @author Adrian Fernandez
 * @author Ricardo Riol
 *
 */
public class Asignatura implements java.io.Serializable {
	private static final long serialVersionUID = 1L;
	
	private final String nombre;
	private List<Solicitud> solicitudes = new ArrayList<Solicitud>();
	private List<Alumno> matriculados = new ArrayList<Alumno>();
	private List<Alumno> expulsados = new ArrayList<Alumno>();
	private List<Elemento> elementos = new ArrayList<Elemento>();

	/**
	 * Constructor de Asignatura.
	 * 
	 * @param nombre
	 */
	public Asignatura(String nombre) {
		this.nombre = nombre;
	}

	public String getNombre() {
		return nombre;
	}

	public List<Solicitud> getSolicitudes() {
		return Collections.unmodifiableList(solicitudes);
	}
	
	/**
	 * Metodo que permite anadir una solicitud a la lista de solicitudes de una asignatura.
	 * Solo es accesible por alumnos.
	 * 
	 * @param solicitud
	 * @return boolean
	 */
	public boolean anadirSolicitud(Solicitud solicitud){
		if (Aplicacion.getInstance().getTipoUsu().equals(TipoUsuario.ALUMNO) == false) {
			return false;
		}
		if (this.solicitudes.contains(solicitud)){
			return false;
		}
		return this.solicitudes.add(solicitud);
	}
	
	/**
	 * Metodo para admitir a un alumno que haya solicitado ingrsar en una asignatura.
	 * Solo es accesible por profesores.
	 * 
	 * @param solicitud
	 * @return boolean
	 */
	public boolean aceptarSolicitud(Solicitud solicitud){
		if (Aplicacion.getInstance().getTipoUsu().equals(TipoUsuario.PROFESOR) == false) {
			return false;
		}
		this.solicitudes.remove(solicitud);
		return this.matriculados.add(solicitud.getAlumno());
	}
	
	/**
	 * Metodo para denegar la solicitud de ingreso de un alumno a una asignatura.
	 * Solo es accesible por profesores.
	 * 
	 * @param solicitud
	 */
	public void denegarSolicitud(Solicitud solicitud){
		if (Aplicacion.getInstance().getTipoUsu().equals(TipoUsuario.PROFESOR)) {
			this.solicitudes.remove(solicitud);
		}
	}
	
	public List<Alumno> getMatriculados() {
		return Collections.unmodifiableList(matriculados);
	}
	
	/**
	 * Metodo para expulsar a un alumno matriculado en una asignatura.
	 * Solo es accesible por profesores.
	 * 
	 * @param alumno
	 * @return boolean
	 */
	public boolean expulsarAlumno(Alumno alumno){
		if (Aplicacion.getInstance().getTipoUsu().equals(TipoUsuario.PROFESOR) == false) {
			return false;
		}
		if (this.matriculados.contains(alumno) == false) {
			return false;
		}
		alumno.eliminarAsignatura(this);
		this.matriculados.remove(alumno);
		return this.expulsados.add(alumno);
	}
	
	/**
	 * Metodo para readmitir a un alumno expulsado en una asignatura.
	 * Solo es accesible por profesores.
	 * 
	 * @param alumno
	 * @return
	 */
	public boolean readmitirAlumno(Alumno alumno){
		if (Aplicacion.getInstance().getTipoUsu().equals(TipoUsuario.PROFESOR) == false) {
			return false;
		}
		if (this.expulsados.contains(alumno) == false) {
			return false;
		}
		alumno.anadirAsignatura(this);
		this.expulsados.remove(alumno);
		return this.matriculados.add(alumno);
	}
	
	public List<Alumno> getExpulsados() {
		return Collections.unmodifiableList(expulsados);
	}
	
	public List<Elemento> getElementos() {
		return Collections.unmodifiableList(elementos);
	}
	
	/**
	 * Metodo que permite anadir un elemento a la lista de elementos de una asignatura.
	 * 
	 * @param elemento
	 * @return boolean
	 */
	public boolean anadirElemento(Elemento elemento){
		if (Aplicacion.getInstance().getTipoUsu().equals(TipoUsuario.PROFESOR) == false) {
			return false;
		}
		return this.elementos.add(elemento);
	}
	
	/**
	 * Metodo que permite eliminar un elemento de la lista de elementos de una asignatura.
	 * 
	 * @param elemento
	 * @return boolean
	 */
	public boolean eliminarElemento(Elemento elemento){
		if (Aplicacion.getInstance().getTipoUsu().equals(TipoUsuario.PROFESOR) == false) {
			return false;
		}
		return this.elementos.remove(elemento);
	}
	
	/**
	 * Metodo para calcular la nota total de un alumno en una asignatura.
	 * 
	 * @param alumno
	 * @return double
	 */
	public double calcularNotaAsig(Alumno alumno){
		double nota = 0.0;
		if (this.matriculados.contains(alumno)){
			for (Resolucion res:alumno.getResoluciones()){
				if (res.getTest().getAsignatura().equals(this)){
					res.calcularNota();
					nota = nota + res.getNota() * res.getTest().getPeso();
				}
			}
		}
		
		return nota;
	}

	@Override
	public String toString() {
		return nombre ;
	}
}
