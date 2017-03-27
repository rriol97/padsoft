package aplicacion.asignatura.elemento.test;

import aplicacion.Aplicacion;
import aplicacion.TipoUsuario;

/**
 * RespuestaLibre. Clase que hereda de Pregunta. Contiene la solucion a la pregunta en forma de String.
 * 
 * @author Adrian Fernandez
 * @author Ricardo Riol
 *
 */
public class RespuestaLibre extends Pregunta implements java.io.Serializable {
	private static final long serialVersionUID = 1L;
	
	private String solucion;
	
	/**
	 * Constructor de RespuestaLibre.
	 * 
	 * @param enunciado eenunciado de la pregunta
	 * @param valor valor de la pregunta
	 * @param penalizacion penalizacion de la pregunta si se falla
	 * @param solucion solucion de la pregunta
	 */
	public RespuestaLibre(String enunciado, double valor, double penalizacion, String solucion){
		super(enunciado,valor,penalizacion);
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
