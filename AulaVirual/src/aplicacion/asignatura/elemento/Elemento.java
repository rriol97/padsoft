package aplicacion.asignatura.elemento;

import aplicacion.asignatura.Asignatura;

/**
 * Elemento. Clase abstracta de la cual heredan Test, Apuntes y Tema. Contiene el numbre, un indicador de visibilidad y una referencia a la asignatura a la que pertenece.
 * 
 * @author Adrian Fernandez
 * @author Ricardo Riol
 * 
 *
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

	public boolean getVisible(){
		return this.visible;
	}
	public void setVisible(boolean visible) {
		this.visible = visible;
	}
	
	public Asignatura getAsignatura(){
		return this.asignatura;
	}

	@Override
	public String toString() {
		return  nombre;
	}
	
	
	
	

}
