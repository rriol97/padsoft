 package aplicacion.asignatura.elemento.test;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * PreguntaOpcion. Clase abstracta de hereda de Pregunta. Contiene una lista de opciones.
 * 
 * @author Adrian Fernandez
 * @author Ricardo Riol
 */
public abstract class PreguntaOpcion extends Pregunta implements java.io.Serializable {
	private static final long serialVersionUID = 1L;
	
	private List<Opcion> opciones = new ArrayList<Opcion>();
	
	/**
	 * Constructor de PreguntaOpcion.
	 * 
	 * @param enunciado enunciado de la pregunta
	 * @param valor valor de la pregunta
	 * @param penalizacion penalizacion de la pregunta en caso de fallo
	 */
	public PreguntaOpcion(String enunciado, double valor, double penalizacion){
		super(enunciado, valor, penalizacion);
	}
	
	public List<Opcion> getOpciones() {
		return Collections.unmodifiableList(opciones);
	}
	
	/**
	 * Metodo que permite anadir una opcion a la lista de opciones de la pregunta.
	 * 
	 * @param opcion opcion a anadir
	 * @return boolean true si se anade correctamente, false en caso contrario
	 */
	public boolean anadirOpcion(Opcion opcion){
		if (opcion == null || this.opciones.contains(opcion)){
			return false;
		}
		if (this.opciones.size() > 0){
			if (this instanceof OpcionUnica) {
				if (opcion.isCorrecta()){
					for (Opcion o: this.opciones) {
						if (o.isCorrecta()) {
							return false;
						}
					}
				}
				return opciones.add(opcion);
			} else if (this instanceof SiNo) {
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
		}
		return opciones.add(opcion);
	}
	
	/**
	 * Metodo que permite eliminar una opcion de la lista de opciones de la pregunta.
	 * 
	 * @param opcion opcion a eliminar
	 * @return boolean true si se elimina correctamente, false en caso contrario
	 */
	public boolean eliminarOpcion(Opcion opcion){
		return opciones.remove(opcion);
	}

	@Override
	public String toString() {
		String res = "";
		res = res+ super.toString();
		for (Opcion opc:opciones){
			res = res +"  "+ opc.toString() + "\n";
		}
		return res;
	}
	
}
