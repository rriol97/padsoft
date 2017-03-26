 package aplicacion.asignatura.elemento.test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import aplicacion.Aplicacion;
import aplicacion.TipoUsuario;
import aplicacion.asignatura.elemento.resolucion.*;

/**
 * Pregunta. Clase abstracta contenida en test. Sus atributos son un enunciado, el valor sobre el test, la penalizacion que se sufre si se falla y el numero de respuestas, fallos y erroros de los alumnos.
 * Tambien contiene una lista con las respuestas de todos los alumnos. 
 * 
 * @author Adrian Fernandez
 * @author Ricardo Riol
 */
public abstract class Pregunta implements java.io.Serializable {
	private static final long serialVersionUID = 1L;
	
	private String enunciado;
	private double valor;
	private double penalizacion;
	private boolean aleatoria;
	private int numRespuestas;
	private int numAciertos;
	private int numFallos;
	private List <Respuesta> respuestas = new ArrayList <Respuesta>();
	
	/**
	 * Constructor de Pregunta.
	 * 
	 * @param enunciado enunciado de la pregunta
	 * @param valor valor de la pregunta
	 * @param penalizacion oenalzacion de la pregunta si es fallada
	 * @param aleatoria pregunta aleatoria o no.
	 */
	public Pregunta(String enunciado, double valor, double penalizacion, boolean aleatoria) {
		this.enunciado = enunciado;
		this.valor = valor;
		this.penalizacion = penalizacion;
		this.aleatoria = aleatoria;
		this.numRespuestas = 0;
		this.numAciertos = 0;
		this.numFallos = 0;
	}
	
	public String getEnunciado() {
		return enunciado;
	}

	public void setEnunciado(String enunciado) {
		if (Aplicacion.getInstance().getTipoUsu().equals(TipoUsuario.PROFESOR)) {
			this.enunciado = enunciado;
		}
		
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		if (Aplicacion.getInstance().getTipoUsu().equals(TipoUsuario.PROFESOR)) {
			this.valor = valor;
		}
		
	}

	public boolean isAleatoria() {
		return aleatoria;
	}

	public void setAleatoria(boolean aleatoria) {
		if (Aplicacion.getInstance().getTipoUsu().equals(TipoUsuario.PROFESOR)) {
			this.aleatoria = aleatoria;
		}
		
	}

	public int getNumRespuesta() {
		return this.respuestas.size();
	}

	public void setNumRespuesta(int numRespuesta) {
		if (Aplicacion.getInstance().getTipoUsu().equals(TipoUsuario.PROFESOR)) {
			this.numRespuestas = numRespuesta;
		}
		
	}
	
	/**
	 * Metodo para calcular el porcentaje de aciertos en una pregunta.
	 * 
	 * @return double pocentaje de aciertos
	 */
	public double getPorcentajeciertos() {
		if (Aplicacion.getInstance().getTipoUsu().equals(TipoUsuario.PROFESOR) == false) {
			return 0.0;
		}
		return (double)(this.numAciertos)/(double)(this.numRespuestas) * 100.0;
	}
	
	/**
	 * Metodo para calcular el porcentaje de fallos en una pregunta.
	 * 
	 * @return double el porcentaje de fallos
	 */
	public double getPorcentajeFallos() {
		if (Aplicacion.getInstance().getTipoUsu().equals(TipoUsuario.PROFESOR) == false) {
			return 0.0;
		}
		return (double)(this.numFallos)/(double)(this.numRespuestas) * 100.0;
	}
	
	/**
	 * Metodo para calcular el porcentaje de respuestas en blanco en una pregunta.
	 * 
	 * @return double porcentaje de nsnc
	 */
	public double getPorcentajeNsnc(){
		if (Aplicacion.getInstance().getTipoUsu().equals(TipoUsuario.PROFESOR) == false) {
			return 0.0;
		}
		return (double)(this.numRespuestas - this.numAciertos - this.numFallos)/(double)this.numRespuestas * 100.0;
	}
	public double getPenalizacion() {
		return penalizacion;
	}

	public void setPenalizacion(double penalizacion) {
		if (Aplicacion.getInstance().getTipoUsu().equals(TipoUsuario.PROFESOR) == false) {
			this.penalizacion = penalizacion;
		}
	}
	
	/**
	 * Metodo que permite anadir una respuesta a la lista de respuestas de la pregunta.
	 * Solo es accesible por profesores.
	 * 
	 * @param respuesta respuesta a anadir
	 * @return boolean true si se anade correctamente, false en caso contrario
	 */
	public boolean anadirRespuesta(Respuesta respuesta){
		if (Aplicacion.getInstance().getTipoUsu().equals(TipoUsuario.PROFESOR) == false) {
			return false;
		}
		return this.respuestas.add(respuesta);
	}
	
	/**
	 * Metodo que permite eliminar una respuesta de la lista de respuestas de la pregunta.
	 * Solo es accesible por profesores.
	 * 
	 * @param respuesta respuesta a eliminar
	 * @return boolean true si se elimina correctamente, false en caso contrario
	 */
	public boolean eliminarRespuesta(Respuesta respuesta){
		if (Aplicacion.getInstance().getTipoUsu().equals(TipoUsuario.PROFESOR) == false) {
			return false;
		}
		return this.respuestas.remove(respuesta);
	}
	
	public List<Respuesta> getRespuestas() {
		return Collections.unmodifiableList(respuestas);
	}

	/**
	 * Metodo para obtener los numero de respuestas, aciertos y fallos, que se guardan en los atributos numRespuestas, numAciertos y numFallos respectivamente.
	 */
	public void calcularRespuestas() {
		if (Aplicacion.getInstance().getTipoUsu().equals(TipoUsuario.PROFESOR) == false) {
			return;
		}
		EstadoRespuesta aux;
		for (Respuesta r: respuestas) {
			aux = r.getEstado();
			if (aux.equals("ACIERTO")) {
				this.numAciertos++;
			} else if (aux.equals("ERROR")) {
				this.numFallos++;
			}
			this.numRespuestas++;
		}
		
		return;
	}
	
	/**
	 * Metodo para responder una pregunta dependiendo del tipo de pregunta que sea.
	 * 
	 * @param res resolucion de la pregunta
	 * @param opc opcion contestada
	 * @param tes solucion
	 */
	public void responderPregunta(Resolucion res, Opcion opc, String tes){
		Respuesta respuesta = new Respuesta(this);
		if (this instanceof OpcionUnica || this instanceof OpcionMultiple || this instanceof SiNo){
			respuesta.anadirOpcion(opc);
	  	} else {
	  		respuesta.setRespuesta(tes);
	  	}
	  	res.anadirRespuesta(respuesta);
	}

	@Override
	public String toString() {
		return "\n\t\tEnunciado:" + enunciado + "   (" + valor + " p)\n";
	}	
	
	
}
