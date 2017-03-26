package aplicacion.asignatura.elemento.test;

import aplicacion.Aplicacion;
import aplicacion.TipoUsuario;

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
public class Opcion implements java.io.Serializable {
	private static final long serialVersionUID = 1L;
	
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
		if (Aplicacion.getInstance().getTipoUsu().equals(TipoUsuario.PROFESOR)) {
			this.texto = texto;
		}
	}

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
