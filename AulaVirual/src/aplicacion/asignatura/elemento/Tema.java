package aplicacion.asignatura.elemento;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Tema extends Elemento {

	private List<Elemento> elementos = new ArrayList<Elemento>();

	public Tema(String nombre, boolean visible) {
		super(nombre, visible);
	}
	
	public List<Elemento> getElementos() {
		return Collections.unmodifiableList(elementos);
	}
	
	public boolean anadirElemento(Elemento elemento){
		return this.elementos.add(elemento);
	}
	
	public boolean eliminarElemento(Elemento elemento){
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
