package aplicacion.asignatura.elemento.test;

import aplicacion.Aplicacion;
import aplicacion.TipoUsuario;
import aplicacion.asignatura.Asignatura;
import aplicacion.asignatura.elemento.Elemento;
import aplicacion.asignatura.elemento.resolucion.Resolucion;


import java.util.List;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;

public class Test extends Elemento implements java.io.Serializable {
	private static final long serialVersionUID = 1L;
	
	private List<Pregunta> preguntas = new ArrayList<Pregunta>();
	private List<Resolucion> resoluciones = new ArrayList<Resolucion>();
	private String texto;
	private  LocalDate fechaIni;
	private LocalDate fechaFin;
	private boolean aleatorio;
	private double peso;
	private double valorDefecto;
	
	public Test(String nombre, boolean visible, Asignatura asignatura,String texto, int numPreguntas, LocalDate fechaIni, LocalDate fechaFin, boolean aleatorio, double peso, double valorDefecto) {
		super(nombre, visible, asignatura);
		this.texto = texto;
		this.fechaIni = fechaIni;
		this.fechaFin = fechaFin;
		this.aleatorio = aleatorio;
		this.peso = peso;
		this.valorDefecto = valorDefecto;
	}
	
	public List<Pregunta> getPreguntas() {
		return Collections.unmodifiableList(preguntas);
	}
	
	public List<Resolucion>getResoluciones(){
		return Collections.unmodifiableList(resoluciones);
	}
	public String getTexto() {
		return texto;
	}
	
	public boolean anadirPregunta(Pregunta pregunta){
		if (Aplicacion.getInstance().getTipoUsu().equals(TipoUsuario.PROFESOR) == false) {
			return false;
		}
		return this.preguntas.add(pregunta);
	}
	
	public boolean eliminarPregunta(Pregunta pregunta){
		if (Aplicacion.getInstance().getTipoUsu().equals(TipoUsuario.PROFESOR) == false) {
			return false;
		}
		return this.preguntas.remove(pregunta);
	}
	
	public boolean anadirResolucion(Resolucion resolucion){
		return this.resoluciones.add(resolucion);
	}
	
	public void eliminaResolucon(Pregunta pregunta){
		this.resoluciones.remove(pregunta);
	}

	public boolean setTexto(String texto) {
		if (Aplicacion.getInstance().getTipoUsu().equals(TipoUsuario.PROFESOR) == false) {
			return false;
		}
		if (isFechaValida()){
			this.texto = texto;
			return true;
		}
		return false;
	}

	public LocalDate getFechaIni() {
		return fechaIni;
	}

	public LocalDate getFechaFin() {
		return fechaFin;
	}

	private boolean isFechaValida(){
		if (LocalDate.now().isBefore(this.fechaIni)){
			return true;
		}
		return false;
	}
	
	public boolean setFechaIni(LocalDate fechaIni) {
		if (Aplicacion.getInstance().getTipoUsu().equals(TipoUsuario.PROFESOR) == false) {
			return false;
		}
		if (isFechaValida()){
			if (LocalDate.now().isBefore(fechaIni)){
				this.fechaIni= fechaIni;
				return true;
			}
		}
		return false;
	}
	
	public boolean setFechaFin(LocalDate fechaFin) {
		if (Aplicacion.getInstance().getTipoUsu().equals(TipoUsuario.PROFESOR) == false) {
			return false;
		}
		if (isFechaValida()){
			this.fechaFin = fechaFin;
			return true;
		}
		return false;
	}

	public boolean isAleatorio() {
		return aleatorio;
	}

	public boolean setAleatorio(boolean aleatorio){
		if (Aplicacion.getInstance().getTipoUsu().equals(TipoUsuario.PROFESOR) == false) {
			return false;
		}
		if (isFechaValida()){
			this.aleatorio = aleatorio;
			return true;
		}
		
		return false;
	}

	public double getPeso() {
		return peso;
	}

	public boolean setPeso(double peso) {
		if (Aplicacion.getInstance().getTipoUsu().equals(TipoUsuario.PROFESOR) == false) {
			return false;
		}
		if (isFechaValida()){
			this.peso = peso;
			return true;
		}
		return false;
	}

	public double getValorDefecto() {
		return valorDefecto;
	}

	public boolean setValorDefecto(double valorDefecto) {
		if (Aplicacion.getInstance().getTipoUsu().equals(TipoUsuario.PROFESOR) == false) {
			return false;
		}
		if (isFechaValida()){
			this.valorDefecto = valorDefecto;
			return true;
		}
		return false;
	}
	
	public void corregir(){
		for (Resolucion res:this.resoluciones){
			res.calcularNota();
		}
	}

	@Override
	public String toString() {
		String res = "";
		res = res +super.getNombre()+this.peso+"\n"+"Fecha inicio:"+this.fechaIni.toString()+"Fecha fin:"+this.fechaFin.toString()+"\n"+this.texto+"\n";
		for (Pregunta p:this.preguntas){
			res = res +p+"\n";
		}
		return res;
	}
	
	
	

}
