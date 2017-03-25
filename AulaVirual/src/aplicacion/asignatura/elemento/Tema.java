package aplicacion.asignatura.elemento;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import aplicacion.Aplicacion;
import aplicacion.TipoUsuario;
import aplicacion.asignatura.Asignatura;

public class Tema extends Elemento implements java.io.Serializable {
	private static final long serialVersionUID = 1L;
	
	private List<Elemento> elementos = new ArrayList<Elemento>();

	public Tema(String nombre, boolean visible, Asignatura asignatura) {
		super(nombre, visible,asignatura);
	}
	
	public List<Elemento> getElementos() {
		return Collections.unmodifiableList(elementos);
	}
	
	public boolean anadirElemento(Elemento elemento){
		if (Aplicacion.getInstance().getTipoUsu().equals(TipoUsuario.PROFESOR) == false) {
			return false;
		}
		return this.elementos.add(elemento);
	}
	
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
