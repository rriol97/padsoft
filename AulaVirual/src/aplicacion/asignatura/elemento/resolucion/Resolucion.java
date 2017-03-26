package aplicacion.asignatura.elemento.resolucion;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import aplicacion.Alumno;
import aplicacion.Aplicacion;
import aplicacion.TipoUsuario;
import aplicacion.asignatura.elemento.test.Opcion;
import aplicacion.asignatura.elemento.test.Pregunta;
import aplicacion.asignatura.elemento.test.RespuestaLibre;
import aplicacion.asignatura.elemento.test.Test;
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
	
	/**
	 * Constructor de Resolucion.
	 * 
	 * @param test test de la resolucion
	 */
	public Resolucion(Test test) {
		this.test = test;
		this.fecha = LocalDate.now();
		this.nota = -1.0;
		test.anadirResolucion(this);
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
	
	/**
	 * Metodo que permite anadir una respuesta a la lista de respuestas de la resolucion.
	 * Solo es accesible por alumnos.
	 * 
	 * @param respuesta respuesta a anadir
	 * @return boolean true si se anade correctamente, false en caso contrario
	 */
	public boolean anadirRespuesta(Respuesta respuesta){
		if (Aplicacion.getInstance().getTipoUsu().equals(TipoUsuario.ALUMNO) == false) {
			return false;
		}
		 return this.respuestas.add(respuesta);
	}
	
	/**
	 * Metodo que permite eliminar una respuesta de la lista de respuestas de la resolucion.
	 * Solo es accesible por alumnos.
	 * 
	 * @param respuesta a eliminar
	 * @return boolean true si se eliminar correctamente, false en caso contrario
	 */
	public boolean eliminarRespuesta(Respuesta respuesta){
		if (Aplicacion.getInstance().getTipoUsu().equals(TipoUsuario.ALUMNO) == false) {
			return false;
		}
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
			p.calcularRespuestas();
			if (p instanceof RespuestaLibre){
				if (((RespuestaLibre) p).getSolucion().equals(res.getRespuesta())){
					res.setEstado(EstadoRespuesta.ACIERTO);
				} else {
					res.setEstado(EstadoRespuesta.ERROR);
				}
			} else {
				if (res.getOpcionesSeleccionadas().size()== 0){
					res.setEstado(EstadoRespuesta.NSNC);
				} else{
					for (Opcion opc:res.getOpcionesSeleccionadas()){
						if (opc.isCorrecta() == false){
							flag = 1;
							break;
						}	
					}
					
					if (flag == 1){
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
	 * @throws InvalidEmailAddressException exception
	 * @throws FailedInternetConnectionException exception
	 */
	public void calcularNota() throws InvalidEmailAddressException, FailedInternetConnectionException{
		double nota = 0.0;
		if (this.getFecha().isBefore(this.getTest().getFechaFin())){
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
		
		for (Alumno alum:this.getTest().getAsignatura().getMatriculados()){
			if (EmailSystem.isValidEmailAddr(alum.getCorreo())){
				EmailSystem.send(alum.getCorreo(),"Notas", "Ya estan disponisbles en Aula Virtual las calificaciones y soluciones del test"+this.getTest().getNombre());
			}
		}
		
		this.setNota(nota);
	}

	@Override
	public String toString() {
		String res="";
		if (this.getFecha().isBefore(this.getTest().getFechaFin())){
			return " Todavia no puede visaulizar el examen, espere a la fecha de fin para hacerlo.\n";
		}
		int contador = 1;
		res = res +"\tResolucion: "+this.getTest().getNombre()+" nota:"+nota+" "+fecha;
		res = res +"\n\t"+this.getTest()+"\n"+"\t\tOpciones seleccionadas: \n";
		for (Respuesta p :this.getRespuestas()){
			res = res +"\n\n\t\t"+contador+"-"+ p;
		}
		
		return res;
	}
	
	
}
