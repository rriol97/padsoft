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
	
}
