package aplicacion.asignatura.elemento.test;

/**
 * OpcionUnica. Clase que hereda de PreguntaOpcion. Solo permite que haya una opcion correcta.
 * 
 * @author Adrian Fernandez
 * @author Ricardo Riol
 */
public class OpcionUnica extends PreguntaOpcion implements java.io.Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * Constructor de OpcionUnica.
	 * 
	 * @param enunciado enunciado de la pregunta
	 * @param valor valor de la pregunta
	 * @param penalizacion oenalzacion de la pregunta si es fallada
	 */
	public OpcionUnica(String enunciado, double valor, double penalizacion){
		super(enunciado,valor,penalizacion);
	}
}
