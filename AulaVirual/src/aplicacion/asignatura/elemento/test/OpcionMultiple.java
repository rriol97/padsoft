package aplicacion.asignatura.elemento.test;

public class OpcionMultiple extends PreguntaOpcion implements java.io.Serializable {
	private static final long serialVersionUID = 1L;

	public OpcionMultiple (String enunciado, double valor, double penalizacion, boolean aleatoria){
		super(enunciado,valor,penalizacion,aleatoria);
	}
}