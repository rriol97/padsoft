package aplicacion.clases.resolucion;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import aplicacion.clases.Alumno;
import aplicacion.clases.Aplicacion;
import aplicacion.clases.TipoUsuario;
import aplicacion.clases.elemento.test.Opcion;
import aplicacion.clases.elemento.test.Pregunta;
import aplicacion.clases.elemento.test.PreguntaOpcion;
import aplicacion.clases.elemento.test.RespuestaLibre;
import aplicacion.clases.elemento.test.Test;
import es.uam.eps.padsof.emailconnection.EmailSystem;
import es.uam.eps.padsof.emailconnection.FailedInternetConnectionException;
import es.uam.eps.padsof.emailconnection.InvalidEmailAddressException;

/**
 * Resolucion. Clase que contiene todas las respuestas de un alumno en un test.
 * 
 * @author Adrian Fernandez
 * @author Ricardo Riol
 */
public class Resolucion implements java.io.Serializable {
	private static final long serialVersionUID = 1L;
	
	private double nota;
	private final LocalDate fecha;
	private List <Respuesta> respuestas = new ArrayList <Respuesta>();
	private Test test;
	private Alumno alumno;
	
	/**
	 * Constructor de Resolucion.
	 * 
	 * @param test test de la resolucion
	 * @param alumno alumno que realiza la resolucion
	 */
	public Resolucion(Test test, Alumno alumno) {
		this.test = test;
		this.alumno = alumno;
		this.fecha = LocalDate.now();
		this.nota = 0.0;
		this.test.anadirResolucion(this);
		this.alumno.anadirResolucion(this);
	}

	public double getNota() {
		return nota;
	}
	
	public void setNota(double nota){
		this.nota = nota;
	}
	
	public LocalDate getFecha() {
		return fecha;
	}
	
	public Test getTest() {
		return test;
	}
	
	public Alumno getAlumno() {
		return alumno;
	}
	
	/**
	 * Metodo que permite anadir una respuesta a la lista de respuestas de la resolucion.
	 * 
	 * @param respuesta respuesta a anadir
	 * @return boolean true si se anade correctamente, false en caso contrario
	 */
	public boolean anadirRespuesta(Respuesta respuesta){
		if (respuesta == null || this.respuestas.contains(respuesta)){
			return false;
		}
		return this.respuestas.add(respuesta);
	}
	
	/**
	 * Metodo que permite eliminar una respuesta de la lista de respuestas de la resolucion.
	 * 
	 * @param respuesta a eliminar
	 * @return boolean true si se eliminar correctamente, false en caso contrario
	 */
	public boolean eliminarRespuesta(Respuesta respuesta){
		return this.respuestas.remove(respuesta);
	}

	public List<Respuesta> getRespuestas() {
		return Collections.unmodifiableList(respuestas);
	}

	/**
	 * Metodo para determinar el estado de las respuestas de una resolcion.
	 */
	private void estadoRespuestas() {
		for (Respuesta res:this.respuestas){
			int flag = 0;
			Pregunta p = res.getPregunta();
			p.anadirRespuesta(res);
			if (p instanceof RespuestaLibre){
				if (((RespuestaLibre) p).getSolucion().equals(res.getRespuesta())){
					res.setEstado(EstadoRespuesta.ACIERTO);
				} else {
					res.setEstado(EstadoRespuesta.ERROR);
				}
			} else {
				if (res.getOpcionesSeleccionadas().size() == 0){
					res.setEstado(EstadoRespuesta.NSNC);
				} else{
					for (Opcion opc:res.getOpcionesSeleccionadas()){
						if (opc != null) {
							if (opc.isCorrecta() == false){
								flag = 1;
								break;
							}
						}
					}
					
					int numOpcCorrectas = 0;
					for (Opcion opc:((PreguntaOpcion)p).getOpciones()){
						if (opc.isCorrecta()){
							numOpcCorrectas++;
						}
					}
					if (flag == 1 || res.getOpcionesSeleccionadas().size()!= numOpcCorrectas){
						res.setEstado(EstadoRespuesta.ERROR);
					} else {
						res.setEstado(EstadoRespuesta.ACIERTO);
					}
				}
			}
			
		}
	}
	
	/**
	 * Metodo para calcular la note de una resolucion.
	 * 
	 * @throws InvalidEmailAddressException exception
	 * @throws FailedInternetConnectionException exception
	 */
	public void calcularNota() throws InvalidEmailAddressException, FailedInternetConnectionException{
		double nota = 0.0;

		if (this.getFecha().isAfter(this.getTest().getFechaFin())){
			return;
		}
		
		estadoRespuestas();
		for (Respuesta res:this.respuestas){
			if (res.getEstado().equals(EstadoRespuesta.ACIERTO)){
				nota = nota + res.getPregunta().getValor();
			} else if (res.getEstado().equals(EstadoRespuesta.ERROR)) {
				nota = nota - res.getPregunta().getPenalizacion();
			}
		}
		
		if (EmailSystem.isValidEmailAddr(this.alumno.getCorreo())){
			EmailSystem.send(this.alumno.getCorreo(),"Notas", "Ya estan disponisbles en Aula Virtual las calificaciones y soluciones del test"+this.getTest().getNombre());
		}
		
		this.setNota(nota);
	}

	@Override
	public String toString() {
		String res="";
		if (Aplicacion.getInstance().getTipoUsu().equals(TipoUsuario.ALUMNO) == true){
			if (this.getFecha().isBefore(this.getTest().getFechaFin())){
				return " Todavia no puede visualizar el examen, espere a la fecha de fin para hacerlo.\n";
			}
		}
		int contador = 1;
		res = res +"\tResolucion: "+this.getTest().getNombre()+" nota:"+nota+" "+fecha;
		res = res +"\n\t"+this.getTest()+"\n"+"   Opciones seleccionadas: \n";
		for (Respuesta p :this.getRespuestas()){
			res = res +"\n  "+contador+"-"+ p+"       "+"Porcentaje de Aciertos:"+p.getPregunta().getPorcentajeAciertos()+"% Porcentaje de fallos:"+p.getPregunta().getPorcentajeFallos()+"% Pocentaje NSNC:"+p.getPregunta().getPorcentajeNsnc()+"%";
		}
		
		return res;
	}
	
	
}
