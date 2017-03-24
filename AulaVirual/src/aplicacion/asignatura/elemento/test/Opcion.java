package aplicacion.asignatura.elemento.test;

/**
 * 
 * Imlementacion de la clase Opcion.
 * 
 * @author Ricardo Riol Gonzalez y Adrian Fernandez Amador
 * 
 * @file Opcion.java
 * @date 07/03/2017
 *
 */
public class Opcion {

	private final int num;
	private String texto;
	private boolean correcta;
	
	
	/**
	 * Constructor de la clase Opcion
	 * 
	 * @param num
	 * @param texto
	 * @param correcta
	 * @param seleccionada
	 */
	public Opcion(int num, String texto,boolean correcta,boolean seleccionada){
		this.num = num;
		this.texto = texto;
		this.correcta = correcta;
		
	}

	public int getNum() {
		return num;
	}

	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}

	public boolean isCorrecta() {
		return correcta;
	}

	public void setCorrecta(boolean correcta) {
		this.correcta = correcta;
	}

	@Override
	public String toString() {
		return num +") " + texto;
	}
	
	
}
