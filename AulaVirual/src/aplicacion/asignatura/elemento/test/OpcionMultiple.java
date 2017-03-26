package aplicacion.asignatura.elemento.test;

/**
 * OpcionMultiple. Clase que hereda de PreguntaOpcion. Permite que haya varias opciones correctas.
 * 
 * @author Adrian Fernandez
 * @author Ricardo Riol
 *
 */
public class OpcionMultiple extends PreguntaOpcion implements java.io.Serializable {
	private static final long serialVersionUID = 1L;
	
	/**
	 * Constructor de OpcionMultiple.
	 * 
	 * @param enunciado enunciado de la pregunta
	 * @param valor valor de la pregunta
	 * @param penalizacion oenalzacion de la pregunta si es fallada
	 * @param aleatoria pregunta aleatoria o no.
	 */
	public OpcionMultiple (String enunciado, double valor, double penalizacion, boolean aleatoria){
		super(enunciado,valor,penalizacion,aleatoria);
	}
}