 package aplicacion.asignatura.elemento.test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import aplicacion.asignatura.elemento.resolucion.*;

public abstract class Pregunta {
	private String enunciado;
	private double valor;
	private double penalizacion;
	private boolean aleatoria;
	private int numRespuesta;
	private int numAciertos;
	private int numFallos;
	private List <Respuesta> respuestas = new ArrayList <Respuesta>();
	
	
	public Pregunta(String enunciado, double valor, double penalizacion, boolean aleatoria, int numRespuesta, int numAciertos, int numFallos) {
		this.enunciado = enunciado;
		this.valor = valor;
		this.aleatoria = aleatoria;
		this.numRespuesta = numRespuesta;
		this.numAciertos = numAciertos;
		this.numFallos = numFallos;
		this.penalizacion = penalizacion;
	}
	
	public String getEnunciado() {
		return enunciado;
	}

	public void setEnunciado(String enunciado) {
		this.enunciado = enunciado;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	public boolean isAleatoria() {
		return aleatoria;
	}

	public void setAleatoria(boolean aleatoria) {
		this.aleatoria = aleatoria;
	}

	public int getNumRespuesta() {
		return numRespuesta;
	}

	public void setNumRespuesta(int numRespuesta) {
		this.numRespuesta = numRespuesta;
	}

	public double getPorcentajeciertos() {
		return (double)(this.numAciertos)/(double)(this.numRespuesta) * 100.0;
	}

	public double getPorcentajeFallos() {
		return (double)(this.numFallos)/(double)(this.numRespuesta) * 100.0;
	}
	
	public double getPorcentajeNsnc(){
		return (double)(this.numRespuesta - this.numAciertos - this.numFallos)/(double)this.numRespuesta * 100.0;
	}
	public double getPenalizacion() {
		return penalizacion;
	}

	public void setPenalizacion(double penalizacion) {
		this.penalizacion = penalizacion;
	}
	
	public boolean anadirRespuesta(Respuesta respuesta){
		return this.respuestas.add(respuesta);
	}
	
	public boolean eliminarRespuesta(Respuesta respuesta){
		return this.respuestas.remove(respuesta);
	}
	
	public List<Respuesta> getRespuestas() {
		return Collections.unmodifiableList(respuestas);
	}

	public void calcularRespuestas() {
		EstadoRespuesta aux;
		for (Respuesta r: respuestas) {
			aux = r.getEstado();
			if (aux.equals("ACIERTO")) {
				this.numAciertos++;
			} else if (aux.equals("ERROR")) {
				this.numFallos++;
			}
			this.numRespuesta++;
		}
		
		return;
	}

	@Override
	public String toString() {
		return "Enunciado:" + enunciado + "(" + valor + ")";
	}	
	
	
}
