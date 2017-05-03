package aplicacion.clases.elemento;

import aplicacion.clases.Asignatura;

/**
 * Apuntes. Clase que hereda de Elemento. Consiste en un String con el texto de los apuntes.
 * 
 * @author Adrian Fernandez
 * @author Ricardo Riol
 * 
 *
 */
public class Apuntes extends Elemento implements java.io.Serializable {
	private static final long serialVersionUID = 1L;
	
	private String texto;
	
	/**
	 * Constructor de Apuntes.
	 * 
	 * @param nombre nombre de los pauntes
	 * @param visible visibilidad
	 * @param texto apuntes
	 * @param asignatura asigantura en la cual se van a colgar
	 */
	public Apuntes(String nombre, boolean visible, String texto, Asignatura asignatura) {
		super(nombre, visible, asignatura);
		this.texto = texto;
	}

	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}

	public boolean isEliminable() {
		return true;
	}
	
	@Override
	public String toString() {
		return super.toString();
	}
	
	
}
