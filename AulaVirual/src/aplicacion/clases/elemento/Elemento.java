package aplicacion.clases.elemento;

import aplicacion.clases.Alumno;
import aplicacion.clases.Asignatura;
import es.uam.eps.padsof.emailconnection.EmailSystem;
import es.uam.eps.padsof.emailconnection.FailedInternetConnectionException;
import es.uam.eps.padsof.emailconnection.InvalidEmailAddressException;

/**
 * Elemento. Clase abstracta de la cual heredan Test, Apuntes y Tema. Contiene el numbre, un indicador de visibilidad y una referencia a la asignatura a la que pertenece.
 * 
 * @author Adrian Fernandez
 * @author Ricardo Riol
 */
public abstract class Elemento implements java.io.Serializable {
	private static final long serialVersionUID = 1L;
	
	private final String nombre;
	private boolean visible;
	private  final Asignatura asignatura;
	
	/**
	 * Constructor de Elemento.
	 * 
	 * @param nombre nombre del elemento
	 * @param visible visibilidad
	 * @param asignatura asignatura del elemento
	 */
	public Elemento(String nombre, boolean visible, Asignatura asignatura) {
		this.nombre = nombre;
		this.visible = visible;
		this.asignatura = asignatura;
	}

	public String getNombre() {
		return nombre;
	}

	public boolean isVisible() {
		return visible;
	}
	public void setVisible(boolean visible) throws InvalidEmailAddressException, FailedInternetConnectionException {
		for (Alumno alum :this.getAsignatura().getMatriculados()){
			EmailSystem.send(alum.getCorreo(), "Se ha actualizado la asignatura"+this.getAsignatura().getNombre(), "");
		}
		this.visible = visible;
	}
	
	public Asignatura getAsignatura(){
		return this.asignatura;
	}
	
	public abstract boolean isEliminable();
	
	@Override
	public String toString() {
		return  nombre;
	}
}
