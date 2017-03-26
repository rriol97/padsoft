package aplicacion.asignatura.elemento;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import aplicacion.Aplicacion;
import aplicacion.TipoUsuario;
import aplicacion.asignatura.Asignatura;

/**
 * Tema. Clase que hereda de Elemento. Contiene una lista de sub-elementos.
 * 
 * @author Adrian Fernandez
 * @author Ricardo Riol
 * 
 *
 */
public class Tema extends Elemento implements java.io.Serializable {
	private static final long serialVersionUID = 1L;
	
	private List<Elemento> elementos = new ArrayList<Elemento>();
	
	/**
	 * Constructor de Tema.
	 * 
	 * @param nombre nombre del tema
	 * @param visible visibilidad
	 * @param asignatura asignatura del tema
	 */
	public Tema(String nombre, boolean visible, Asignatura asignatura) {
		super(nombre, visible,asignatura);
	}
	
	public List<Elemento> getElementos() {
		return Collections.unmodifiableList(elementos);
	}
	
	/**
	 * Metodo que permite anadir un elemento a la lista de elementos de un tema.
	 * Solo es accesible por profesores.
	 * 
	 * @param elemento elemento a anadir
	 * @return boolean true si se anade correctamente, false en caso contrario
	 */
	public boolean anadirElemento(Elemento elemento){
		if (Aplicacion.getInstance().getTipoUsu().equals(TipoUsuario.PROFESOR) == false) {
			return false;
		}
		return this.elementos.add(elemento);
	}
	
	/**
	 * Metodo que permite eliminar un elemento de la lista de elementos de un tema.
	 * Solo es accesible por profesores.
	 * 
	 * @param elemento elemento a eliminar
	 * @return boolean true si se elimina correctamente, false en caso contrario
	 */
	public boolean eliminarElemento(Elemento elemento){
		if (Aplicacion.getInstance().getTipoUsu().equals(TipoUsuario.PROFESOR) == false) {
			return false;
		}
		return this.elementos.remove(elemento);
	}

	@Override
	public String toString() {
		String res = "";
		res = res + super.toString();
		for (Elemento ele:this.elementos){
			res = res + "\n \t"+ele.toString(); 
		}
		
		return res;
	}
	
}
