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
	private final int numOpcionesCorrectas;
	
	/**
	 * Constructor de PreguntaOpcion.
	 * 
	 * @param enunciado enunciado de la pregunta
	 * @param valor valor de la pregunta
	 * @param penalizacion penalizacion de la pregunta en caso de fallo
	 */
	public PreguntaOpcion(String enunciado, double valor, double penalizacion,int numOpcionesCorrectas){
		super(enunciado, valor, penalizacion);
		this.numOpcionesCorrectas = numOpcionesCorrectas;
	}
	
	public List<Opcion> getOpciones() {
		return Collections.unmodifiableList(opciones);
	}
	
	public int getNumOpcionesCorrectas() {
		return numOpcionesCorrectas;
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

	@Override
	public String toString() {
		String res = "";
		res = res+ super.toString();
		for (Opcion opc:opciones){
			res = res +"  "+ opc.toString() + "\n";
		}
		return res;
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
	 * @return List<Opcion> Lista de preguntas desordenadas.
	 */
	public List<Opcion> desordenar() {
		int i;
		List <Opcion> op = new ArrayList<Opcion>(this.opciones.size());
		for (i = 0; i < this.opciones.size(); i++) {
			int random = (int)(Math.random() * this.opciones.size());
			if (op.add(this.opciones.get(random)) == false) {
				return null;
			}
		}
		return op;
	}
}
