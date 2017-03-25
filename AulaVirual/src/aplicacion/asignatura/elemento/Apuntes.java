package aplicacion.asignatura.elemento;


import aplicacion.asignatura.Asignatura;

public class Apuntes extends Elemento {
	
	private String texto;

	public Apuntes(String nombre, boolean visible, String texto, Asignatura asignatura) {
		super(nombre, visible, asignatura);
		this.texto = texto;
	}

	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}

	@Override
	public String toString() {
		return super.toString()+"\n"+texto;
	}
	
	
}
