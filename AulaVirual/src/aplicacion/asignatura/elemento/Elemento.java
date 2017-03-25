package aplicacion.asignatura.elemento;

import aplicacion.asignatura.Asignatura;

public abstract class Elemento {
	
	private final String nombre;
	private boolean visible;
	private  final Asignatura asignatura;
	
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
