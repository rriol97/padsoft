package aplicacion.clases.elemento.test;

import aplicacion.clases.Asignatura;
import aplicacion.clases.elemento.Elemento;
import aplicacion.clases.resolucion.Resolucion;
import es.uam.eps.padsof.emailconnection.FailedInternetConnectionException;
import es.uam.eps.padsof.emailconnection.InvalidEmailAddressException;

import java.util.List;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;

/**
 * Test. Clase que hereda de Elemento. Consiste en un texto, su fecha de inicio y fin, un indicador sobre si es aleatorio, el valor del examen en la asignatura y el valor de cada pregunta por defecto.
 * Tambien continene una lista de preguntas y la lista de resoluciones realizadas.
 * 
 * @author Adrian Fernandez
 * @author Ricardo Riol
 *
 */
public class Test extends Elemento implements java.io.Serializable {
	private static final long serialVersionUID = 1L;
	
	private List<Pregunta> preguntas = new ArrayList<Pregunta>();
	private List<Resolucion> resoluciones = new ArrayList<Resolucion>();
	private String texto;
	private LocalDate fechaIni;
	private LocalDate fechaFin;
	private boolean aleatorio;
	private double peso;
	private double valorDefecto;
	
	/**
	 * Constructor de Test.
	 * 
	 * @param nombre nombre de test
	 * @param visible visibilidad
	 * @param asignatura asigantura del test
	 * @param texto texto explicativo
	 * @param fechaIni fecha de inicio del test
	 * @param fechaFin fecha de final del test
	 * @param aleatorio aleatorio o no
	 * @param peso porcentaje del examen
	 * @param valorDefecto valor que tiene una preguna del test por defecto
	 */
	public Test(String nombre, boolean visible, Asignatura asignatura,String texto, LocalDate fechaIni, LocalDate fechaFin, boolean aleatorio, double peso, double valorDefecto) {
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
	
	/**
	 * Metodo que permite anadir una pregunta a la lista de preguntas del test.
	 * 
	 * @param pregunta pregunta a anadir
	 * @return boolean true si se anade correctamente, false en caso contrario
	 */
	public boolean anadirPregunta(Pregunta pregunta){
		if (pregunta == null || this.preguntas.contains(pregunta)){
			return false;
		}
		return this.preguntas.add(pregunta);
	}
	
	/**
	 * Metodo que permite eliminar una pregunta de la lista de preguntas del test.
	 * 
	 * @param pregunta eliminar
	 * @return boolean true si se elimina correctamente, false en caso contrario
	 */
	public boolean eliminarPregunta(Pregunta pregunta){
		return this.preguntas.remove(pregunta);
	}
	
	/**
	 * Metodo que permite anadir una resolucion a la lista de resoluciones del test.
	 * 
	 * @param resolucion resolucion a anadir
	 * @return boolean true si se anade correctamente, false en caso contrario
	 */
	public boolean anadirResolucion(Resolucion resolucion){
		if (resolucion == null || this.resoluciones.contains(resolucion)){
			return false;
		}
		if (this.isFechaValida()==false){
			return false;
		}
		return this.resoluciones.add(resolucion);
	}
	
	/**
	 * Metodo que permite eliminar una resolucion de la lista de resoluciones del test.
	 * 
	 * @param resolucion resolucion a eliminar
	 * @return boolean true si elimina correctamente, false en caso contrario
	 */
	public boolean eliminarResolucion(Resolucion resolucion){
		return this.resoluciones.remove(resolucion);
	}

	public boolean setTexto(String texto) {
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

	/**
	 * Metodo que devuelve true si se puede realizar el test y false en caso contrario.
	 * 
	 * @return boolean true si es correcta correctamente, false en caso contrario
	 */
	public boolean isFechaValida(){
		if (LocalDate.now().isAfter(this.fechaIni) && LocalDate.now().isBefore(this.fechaFin)){
			return true;
		}
		return false;
	}
	
	/**
	 * Metodo que devuelve true si ha pasado la fecha de finalizacion del test y false en caso contrario.
	 * 
	 * @return boolean true si es correcta correctamente, false en caso contrario
	 */
	public boolean isTerminado(){
		if (LocalDate.now().isAfter(this.fechaFin)){
			return true;
		}
		return false;
	}
	
	public boolean setFechaIni(LocalDate fechaIni) {
		if (isFechaValida()){
			if (LocalDate.now().isBefore(fechaIni)){
				this.fechaIni= fechaIni;
				return true;
			}
		}
		return false;
	}
	
	public boolean setFechaFin(LocalDate fechaFin) {
		if (isFechaValida()){
			this.fechaFin = fechaFin;
			return true;
		}
		return false;
	}

	/**
	 * Metodo que devuelve el estado del atributo aleatorio.
	 * 
	 * @return boolean true si es aleatorio correctamente, false en caso contrario
	 */
	public boolean isAleatorio() {
		return aleatorio;
	}

	public boolean setAleatorio(boolean aleatorio){
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
		if (isFechaValida()){
			this.valorDefecto = valorDefecto;
			return true;
		}
		return false;
	}
	
	/**
	 * Metodo que calcula la nota de todas las resoluciones individuales de un test.
	 * 
	 * @throws InvalidEmailAddressException exception
	 * @throws FailedInternetConnectionException exception
	 */
	public void corregir() throws InvalidEmailAddressException, FailedInternetConnectionException{
		if (this.isFechaValida()==false){
			return;
		}
		for (Resolucion res:this.resoluciones){
			res.calcularNota();
		}
	}

	public boolean isEliminable() {
		if (this.getResoluciones().size() > 0){
			return false;
		}
		return true;
	}
	
	/**
	 * Metodo para mostrar la lista de preguntas de un test desordenada.
	 * 
	 * @return List<Pregunta> Lista de preguntas desordenadas.
	 */
	public List<Pregunta> desordenar() {
		int i;
		List <Pregunta> preg = new ArrayList<Pregunta>(this.preguntas.size());
		for (i = 0; i < this.preguntas.size(); i++) {
			int random = (int)(Math.random() * this.preguntas.size());
			if (preg.add(this.preguntas.get(random)) == false) {
				return null;
			}
		}
		return preg;
	}
	
	@Override
	public String toString() {
		String res = "";
		res = res +super.getNombre()+" "+this.peso+"%"+" "+"Fecha inicio:"+this.fechaIni.toString()+"  Fecha fin:"+this.fechaFin.toString()+"\n\t"+this.texto+"\n";
		for (Pregunta p:this.preguntas){
			res = res +p+"\n";
		}
		return res;
	}
	
	
	

}
