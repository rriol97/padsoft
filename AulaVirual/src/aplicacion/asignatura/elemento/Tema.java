package aplicacion.asignatura.elemento;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import aplicacion.Alumno;
import aplicacion.asignatura.Asignatura;
import aplicacion.asignatura.elemento.test.Test;
import es.uam.eps.padsof.emailconnection.EmailSystem;
import es.uam.eps.padsof.emailconnection.FailedInternetConnectionException;
import es.uam.eps.padsof.emailconnection.InvalidEmailAddressException;

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
	 * 
	 * @param elemento elemento a anadir
	 * @return boolean true si se anade correctamente, false en caso contrario
	 * @throws FailedInternetConnectionException 
	 * @throws InvalidEmailAddressException 
	 */
	public boolean anadirElemento(Elemento elemento) throws InvalidEmailAddressException, FailedInternetConnectionException{
		if (elemento == null){
			return false;
		}
		if (elemento.isVisible()){
			for (Alumno alum :this.getAsignatura().getMatriculados()){
				EmailSystem.send(alum.getCorreo(), "Se ha actualizado la asignatura"+this.getAsignatura().getNombre(), "");
			}
		}
		return this.elementos.add(elemento);
	}
	
	/**
	 * Metodo que permite eliminar un elemento de la lista de elementos de un tema.
	 * 
	 * @param elemento elemento a eliminar
	 * @return boolean true si se elimina correctamente, false en caso contrario
	 */
	public boolean eliminarElemento(Elemento elemento){
		if (elemento instanceof Tema){
			if(((Tema)elemento).isEliminable()==false) {
				return false;
			}
		}
		return this.elementos.remove(elemento);
	}
	
	/**
	 * Metodo que comprueba si un elemento es eliminable
	 * @return boolean true si comprueba correcatmente, false en caso contrario
	 */
	public boolean isEliminable() {
		for (Elemento ele:this.elementos){
			if (ele instanceof Apuntes){
				return true;
			} else if (ele instanceof Test){
				if (((Test)ele).getResoluciones().size() > 0){
					return false;
				} else{
					return true;
				}
			} else {
				return ((Tema)ele).isEliminable();
			}
		}
		return true;
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
