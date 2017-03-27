package aplicacion.asignatura.elemento.test;

import aplicacion.Aplicacion;
import aplicacion.TipoUsuario;

/**
 * Opcion. Clase utilizada para implementar preguntas con opciones. Contiene un numero de opcion, un texto y un indicador sobre si correcta.
 * 
 * @author Adrian Fernandez
 * @author Ricardo Riol
 */
public class Opcion implements java.io.Serializable {
	private static final long serialVersionUID = 1L;
	
	private final int num;
	private String texto;
	private boolean correcta;
	
	
	/**
	 * Constructor Opcion
	 * 
	 * @param num numero de opcion
	 * @param texto texto de la opcion
	 * @param correcta opcion correcta o no
	 */
	public Opcion(int num, String texto,boolean correcta){
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
		if (Aplicacion.getInstance().getTipoUsu().equals(TipoUsuario.PROFESOR)) {
			this.texto = texto;
		}
	}
	
	/**
	 * Metodo que sirve para saber si la opcion es correcta
	 * @return booelan true si es correcta, false en caso contrario
	 */
	public boolean isCorrecta() {
		return correcta;
	}

	public void setCorrecta(boolean correcta) {
		if (Aplicacion.getInstance().getTipoUsu().equals(TipoUsuario.PROFESOR)) {
			this.correcta = correcta;
		}
		
	}

	@Override
	public String toString() {
		return "\n\t\t\t"+num +") " + texto;
	}
	
	
}
