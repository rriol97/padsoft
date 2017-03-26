package aplicacion.asignatura.elemento;


import aplicacion.Aplicacion;
import aplicacion.TipoUsuario;
import aplicacion.asignatura.Asignatura;

public class Apuntes extends Elemento implements java.io.Serializable {
	private static final long serialVersionUID = 1L;
	
	private String texto;

	public Apuntes(String nombre, boolean visible, String texto, Asignatura asignatura) {
		super(nombre, visible, asignatura);
		this.texto = texto;
	}

	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		if (Aplicacion.getInstance().getTipoUsu().equals(TipoUsuario.PROFESOR)) {
			this.texto = texto;
		}
	}

	@Override
	public String toString() {
		return super.toString()+"\n\t\t"+texto;
	}
	
	
}
