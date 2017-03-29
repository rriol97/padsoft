package aplicacion.asignatura.elemento.test;

/**
 * SiNo. Clase que hereda de PreguntaOpcion. Solo dos opciones, de las cuales solo una es correcta.
 * 
 * @author Adrian Fernandez
 * @author Ricardo Riol
 *
 */
public class SiNo extends PreguntaOpcion implements java.io.Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * Constructor de SiNo.
	 * 
	 * @param enunciado enunciado de la pregunta
	 * @param valor valor de la pregunta
	 * @param penalizacion oenalzacion de la pregunta si es fallada
	 */
	public SiNo(String enunciado, double valor, double penalizacion, int numCorrectas){
		super(enunciado,valor,penalizacion,numCorrectas);
	}
}
