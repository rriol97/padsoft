 package aplicacion.clases.elemento.test;


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
	
	protected List<Opcion> opciones = new ArrayList<Opcion>();
	private boolean aleatoria;
	
	/**
	 * Constructor de PreguntaOpcion.
	 * 
	 * @param enunciado enunciado de la pregunta
	 * @param valor valor de la pregunta
	 * @param penalizacion penalizacion de la pregunta en caso de fallo
	 */
	public PreguntaOpcion(String enunciado, double valor, double penalizacion){
		super(enunciado, valor, penalizacion);
		this.aleatoria = false;
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
	public abstract boolean anadirOpcion(Opcion opcion);
	
	/**
	 * Metodo que permite eliminar una opcion de la lista de opciones de la pregunta.
	 * 
	 * @param opcion opcion a eliminar
	 * @return boolean true si se elimina correctamente, false en caso contrario
	 */
	public boolean eliminarOpcion(Opcion opcion){
		return opciones.remove(opcion);
	}
	
	/**
	 * Metodo que devuelve la lista de opciones correctas de una pregunta con opciones.
	 * @return Lista de opciones correctas.
	 */
	public List<Opcion> getCorrectas() {
		List<Opcion> correctas = new ArrayList<Opcion>();
		for (Opcion o: getOpciones()) {
			if (o.isCorrecta()) {
				correctas.add(o);
			}
		}
		return Collections.unmodifiableList(correctas);
	}

	public boolean isAleatoria() {
		return aleatoria;
	}

	public void setAleatoria(boolean aleatoria) {
		this.aleatoria = aleatoria;
	}
	
	/**
	 * Metodo para mostrar la lista de opciones de una pregunta desordenada.
	 * 
	 * @return Lista de preguntas desordenadas.
	 */
	public List<Opcion> desordenar() {
		int i = 0;
		List <Opcion> op = new ArrayList<Opcion>(this.opciones.size());
		while (i < this.opciones.size()) {
			int random = (int)(Math.random() * this.opciones.size());
			Opcion rand = this.opciones.get(random);
			if (op.contains(rand) == false) {
				op.add(rand);
				i++;
			}
		}
		return op;
	}
	
	@Override
	public String toString() {
		String res = "";
		res = res+ super.toString();
		return res;
	}
}
