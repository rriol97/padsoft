package aplicacion.asignatura.elemento.resolucion;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import aplicacion.Aplicacion;
import aplicacion.TipoUsuario;
import aplicacion.asignatura.elemento.test.Opcion;
import aplicacion.asignatura.elemento.test.Pregunta;
import aplicacion.asignatura.elemento.test.RespuestaLibre;
import aplicacion.asignatura.elemento.test.Test;

public class Resolucion implements java.io.Serializable {
	private static final long serialVersionUID = 1L;
	
	private double nota;
	private final LocalDate fecha;
	private List <Respuesta> respuestas = new ArrayList <Respuesta>();
	private Test test;
	
	public Resolucion(Test test) {
		this.test = test;
		this.fecha = LocalDate.now();
		this.nota = -1.0;
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
	
	public boolean anadirRespuesta(Respuesta respuesta){
		if (Aplicacion.getInstance().getTipoUsu().equals(TipoUsuario.ALUMNO) == false) {
			return false;
		}
		 return this.respuestas.add(respuesta);
	}
	
	public boolean eliminarRespuesta(Respuesta respuesta){
		if (Aplicacion.getInstance().getTipoUsu().equals(TipoUsuario.ALUMNO) == false) {
			return false;
		}
		return this.respuestas.remove(respuesta);
	}

	public List<Respuesta> getRespuestas() {
		return Collections.unmodifiableList(respuestas);
	}

	private void estadoRespuestas() {
		for (Respuesta res:this.respuestas){
			int flag = 0;
			Pregunta p = res.getPregunta();
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
	
	public void calcularNota(){
		double nota = 0.0;
		
		estadoRespuestas();
		for (Respuesta res:this.respuestas){
			if (res.getEstado().equals(EstadoRespuesta.ACIERTO)){
				nota = nota + res.getPregunta().getValor();
			} else if (res.getEstado().equals(EstadoRespuesta.ERROR)) {
				nota = nota - res.getPregunta().getPenalizacion();
			}
		}
		
		this.setNota(nota);
	}

	@Override
	public String toString() {
		String res="";
		int contador = 1;
		res = res +"\tResolucion: "+this.getTest().getNombre()+" nota:"+nota+" "+fecha;
		res = res +"\n\t"+this.getTest()+"\n"+"\t\tOpciones seleccionadas: \n";
		for (Respuesta p :this.getRespuestas()){
			res = res +"\n\n\t\t"+contador+"-"+ p;
		}
		
		return res;
	}
	
	
}
