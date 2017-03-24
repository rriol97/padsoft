package aplicacion.asignatura.elemento;

public class Apuntes extends Elemento {
	
	private String texto;

	public Apuntes(String nombre, boolean visible, String texto) {
		super(nombre, visible);
		this.texto = texto;
	}

	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}
	
	
}
