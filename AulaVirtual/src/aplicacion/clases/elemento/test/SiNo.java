package aplicacion.clases.elemento.test;

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
	
	public boolean anadirOpcion(Opcion opcion){
		if (opcion == null || this.opciones.contains(opcion)){
			return false;
		}
		if (this.opciones.size() > 0){
			if (this.opciones.size() > 1) {
				return false;
			} else {
				for(Opcion o: this.opciones) {
					if ((o.isCorrecta() == true && opcion.isCorrecta() == true) || (o.isCorrecta() == false && opcion.isCorrecta() == false)) {
						return false;
					}
				}
			}
		}
		return opciones.add(opcion);
	}
}
