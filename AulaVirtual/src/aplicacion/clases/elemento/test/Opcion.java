package aplicacion.clases.elemento.test;

/**
 * Opcion. Clase utilizada para implementar preguntas con opciones. Contiene un numero de opcion, un texto y un indicador sobre si correcta.
 * 
 * @author Adrian Fernandez
 * @author Ricardo Riol
 */
public class Opcion implements java.io.Serializable {
	private static final long serialVersionUID = 1L;
	
	private String texto;
	private boolean correcta;
	
	
	/**
	 * Constructor Opcion
	 * 
	 * @param texto texto de la opcion
	 * @param correcta opcion correcta o no
	 */
	public Opcion(String texto,boolean correcta){
		this.texto = texto;
		this.correcta = correcta;
		
	}

	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}
	
	/**
	 * Metodo que sirve para saber si la opcion es correcta
	 * 
	 * @return booelan true si es correcta, false en caso contrario
	 */
	public boolean isCorrecta() {
		return correcta;
	}

	public void setCorrecta(boolean correcta) {
		this.correcta = correcta;	
	}

	@Override
	public String toString() {
		return texto;
	}
	
	
}
