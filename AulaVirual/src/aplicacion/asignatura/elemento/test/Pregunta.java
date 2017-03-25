 package aplicacion.asignatura.elemento.test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import aplicacion.Aplicacion;
import aplicacion.TipoUsuario;
import aplicacion.asignatura.elemento.resolucion.*;

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
		return numRespuestas;
	}

	public void setNumRespuesta(int numRespuesta) {
		if (Aplicacion.getInstance().getTipoUsu().equals(TipoUsuario.PROFESOR)) {
			this.numRespuestas = numRespuesta;
		}
		
	}

	public double getPorcentajeciertos() {
		if (Aplicacion.getInstance().getTipoUsu().equals(TipoUsuario.PROFESOR) == false) {
			return 0.0;
		}
		return (double)(this.numAciertos)/(double)(this.numRespuestas) * 100.0;
	}

	public double getPorcentajeFallos() {
		if (Aplicacion.getInstance().getTipoUsu().equals(TipoUsuario.PROFESOR) == false) {
			return 0.0;
		}
		return (double)(this.numFallos)/(double)(this.numRespuestas) * 100.0;
	}
	
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
	
	public boolean anadirRespuesta(Respuesta respuesta){
		if (Aplicacion.getInstance().getTipoUsu().equals(TipoUsuario.PROFESOR) == false) {
			return false;
		}
		return this.respuestas.add(respuesta);
	}
	
	public boolean eliminarRespuesta(Respuesta respuesta){
		if (Aplicacion.getInstance().getTipoUsu().equals(TipoUsuario.PROFESOR) == false) {
			return false;
		}
		return this.respuestas.remove(respuesta);
	}
	
	public List<Respuesta> getRespuestas() {
		return Collections.unmodifiableList(respuestas);
	}

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

	@Override
	public String toString() {
		return "Enunciado:" + enunciado + "(" + valor + ")";
	}	
	
	
}
