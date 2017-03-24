package aplicacion.asignatura.elemento;

public abstract class Elemento {
	
	private String nombre;
	private boolean visible;
	
	public Elemento(String nombre, boolean visible) {
		super();
		this.nombre = nombre;
		this.visible = visible;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public boolean isVisible() {
		return visible;
	}

	public void setVisible(boolean visible) {
		this.visible = visible;
	}
	
	
	

}
