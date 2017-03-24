package aplicacion.asignatura.elemento;

public abstract class Elemento {
	
	private final String nombre;
	private boolean visible;
	
	public Elemento(String nombre, boolean visible) {
		this.nombre = nombre;
		this.visible = visible;
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

	@Override
	public String toString() {
		return  nombre;
	}
	
	
	
	

}
