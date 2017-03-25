package aplicacion.asignatura.elemento.test;

public class OpcionUnica extends PreguntaOpcion implements java.io.Serializable {
	private static final long serialVersionUID = 1L;

	public OpcionUnica(String enunciado, double valor, double penalizacion, boolean aleatoria){
		super(enunciado,valor,penalizacion,aleatoria);
	}
}
