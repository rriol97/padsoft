package aplicacion.asignatura.elemento.test;

import aplicacion.Aplicacion;
import aplicacion.TipoUsuario;

public class RespuestaLibre extends Pregunta implements java.io.Serializable {
	private static final long serialVersionUID = 1L;
	
	private String solucion;
	
	public RespuestaLibre(String enunciado, double valor, double penalizacion, boolean aleatoria, String solucion){
		super(enunciado,valor,penalizacion,aleatoria);
		this.solucion = solucion;
	}

	public String getSolucion() {
		return solucion;
	}

	public void setSolucion(String solucion) {
		if (Aplicacion.getInstance().getTipoUsu().equals(TipoUsuario.PROFESOR)) {
			this.solucion = solucion;
		}
	}

	@Override
	public String toString() { 
		String res = "";
		res = res+ super.toString();
		res = res+"\n"+"Respuesta Libre:";
		return res;
	}
	
}
