package aplicacion.asignatura;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import aplicacion.asignatura.elemento.Elemento;
import aplicacion.asignatura.elemento.Tema;
import aplicacion.asignatura.elemento.resolucion.Resolucion;
import aplicacion.asignatura.elemento.test.Test;
import es.uam.eps.padsof.emailconnection.EmailSystem;
import es.uam.eps.padsof.emailconnection.FailedInternetConnectionException;
import es.uam.eps.padsof.emailconnection.InvalidEmailAddressException;
import aplicacion.*;

/**
 * Asignatura. Clase que contiene los datos de una asignatura. Como son su nombre y elementos, la lista de solicitudes de ingreso, la lista de alumnos matriculados y la de alumnos expulsados.
 * 
 * @author Adrian Fernandez
 * @author Ricardo Riol
 * 
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
	 * @param nombre nombre de la asignatura
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
	 * 
	 * @param solicitud solicitud en anadir
	 * @return boolean true si se anade correctamente, false en caso contrario
	 */
	public boolean anadirSolicitud(Solicitud solicitud){
		if (solicitud == null || this.solicitudes.contains(solicitud)){
			return false;
		}
		return this.solicitudes.add(solicitud);
	}
	
	/**
	 * Metodo para admitir a un alumno que haya solicitado ingrsar en una asignatura.
	 * 
	 * @param solicitud solicitud a aceptar
	 * @return boolean true si se acepta correctamente, false en caso contrario
	 * @throws InvalidEmailAddressException exception
	 * @throws FailedInternetConnectionException exception
	 */
	public boolean aceptarSolicitud(Solicitud solicitud) throws InvalidEmailAddressException, FailedInternetConnectionException{
		if(EmailSystem.isValidEmailAddr(solicitud.getAlumno().getCorreo())){
			EmailSystem.send(solicitud.getAlumno().getCorreo(),"Adimision", "Se ha inscrito correctamente en la asignatura "+this.getNombre());
		}
		if (solicitud == null || this.solicitudes.contains(solicitud)){
			this.solicitudes.remove(solicitud);
			return this.matriculados.add(solicitud.getAlumno());
		}
		return false;
	}
	
	/**
	 * Metodo para denegar la solicitud de ingreso de un alumno a una asignatura.
	 * 
	 * @param solicitud solicitud a denegar
	 * @throws InvalidEmailAddressException exception
	 * @throws FailedInternetConnectionException exception
	 */
	public void denegarSolicitud(Solicitud solicitud) throws InvalidEmailAddressException, FailedInternetConnectionException{
		if(EmailSystem.isValidEmailAddr(solicitud.getAlumno().getCorreo())){
			EmailSystem.send(solicitud.getAlumno().getCorreo(),this.getNombre(), "Por ciertos motivos no puedes inscribirte a la asignatura de "+this.getNombre());
		}	
		this.solicitudes.remove(solicitud);
	}
	
	public List<Alumno> getMatriculados() {
		return Collections.unmodifiableList(matriculados);
	}
	
	/**
	 * Metodo para expulsar a un alumno matriculado en una asignatura.
	 * 
	 * @param alumno alumno a expulsar
	 * @return boolean true si se expulsa correctamente, false en caso contrario
	 * @throws InvalidEmailAddressException exception
	 * @throws FailedInternetConnectionException exception
	 */
	public boolean expulsarAlumno(Alumno alumno) throws InvalidEmailAddressException, FailedInternetConnectionException{
		if (this.matriculados.contains(alumno) == false) {
			return false;
		}
		
		if(EmailSystem.isValidEmailAddr(alumno.getCorreo())){
			EmailSystem.send(alumno.getCorreo(),this.getNombre(), "Ha sido expulsado de la asignatura de "+this.getNombre());
		}
		
		alumno.eliminarAsignatura(this);
		this.matriculados.remove(alumno);
		return this.expulsados.add(alumno);
	}
	
	/**
	 * Metodo para readmitir a un alumno expulsado en una asignatura.
	 * 
	 * @param alumno alumno a readmitir
	 * @return true si se readmite correctamente, false en caso contrario
	 * @throws InvalidEmailAddressException exception
	 * @throws FailedInternetConnectionException exception
	 */
	public boolean readmitirAlumno(Alumno alumno) throws InvalidEmailAddressException, FailedInternetConnectionException{	
		if (this.expulsados.contains(alumno) == false) {
			return false;
		}
		
		if(EmailSystem.isValidEmailAddr(alumno.getCorreo())){
			EmailSystem.send(alumno.getCorreo(),this.getNombre(), "Ha sido readmitido en la asignatura de " +this.getNombre());
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
	 * @param elemento elemento a anadir
	 * @return boolean true si se anade correctamente, false en caso contrario
	 * @throws InvalidEmailAddressException exception
	 * @throws FailedInternetConnectionException exception
	 */
	public boolean anadirElemento(Elemento elemento) throws InvalidEmailAddressException, FailedInternetConnectionException{
		if (elemento == null || this.elementos.contains(elemento)){
			return false;
		}
		for (Alumno alum:this.getMatriculados()){
			if (EmailSystem.isValidEmailAddr(alum.getCorreo())){
				EmailSystem.send(alum.getCorreo(),this.getNombre(), "Se ha actualizado la pagina de la asignatura "+this.getNombre());
			}
		}
		return this.elementos.add(elemento);
	}
	
	/**
	 * Metodo que permite eliminar un elemento de la lista de elementos de una asignatura.
	 * 
	 * @param elemento elemento a eliminar
	 * @return boolean true si se eliminar correctamente, false en caso contrario
	 * @throws InvalidEmailAddressException exception
	 * @throws FailedInternetConnectionException exception
	 */
	public boolean eliminarElemento(Elemento elemento) throws InvalidEmailAddressException, FailedInternetConnectionException{
		for (Alumno alum:this.getMatriculados()){
			if (EmailSystem.isValidEmailAddr(alum.getCorreo())){
				EmailSystem.send(alum.getCorreo(),this.getNombre(), "Se ha actualizado la pagina de la asignatura "+this.getNombre());
			}
		}
		if (elemento instanceof Test){
			if(((Test) elemento).getResoluciones().size() > 0){
				return false;
			}
		} else if (elemento instanceof Tema){
			if (((Tema)elemento).isEliminable()==false){
				return false;
			}
		}
		return this.elementos.remove(elemento);
	}
	
	/**
	 * Metodo para calcular la nota total de un alumno en una asignatura.
	 * 
	 * @param alumno alumno del cual se quiere calcular su nota
	 * @return double la nota del la asignatura
	 * @throws InvalidEmailAddressException exception
	 * @throws FailedInternetConnectionException exception
	 */
	public double calcularNotaAsig(Alumno alumno) throws InvalidEmailAddressException, FailedInternetConnectionException{
		double nota = 0.0;
		if (this.matriculados.contains(alumno)){
			for (Resolucion res:alumno.getResoluciones()){
				if (res.getTest().getAsignatura().equals(this)){
					res.calcularNota();
					nota = nota + (res.getNota() * res.getTest().getPeso() / 100.0);
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
