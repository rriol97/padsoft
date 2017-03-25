package aplicacion.asignatura;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import aplicacion.asignatura.elemento.Elemento;
import aplicacion.asignatura.elemento.resolucion.Resolucion;
import aplicacion.*;

public class Asignatura implements java.io.Serializable {
	private static final long serialVersionUID = 1L;
	
	private final String nombre;
	private List<Solicitud> solicitudes = new ArrayList<Solicitud>();
	private List<Alumno> matriculados = new ArrayList<Alumno>();
	private List<Alumno> expulsados = new ArrayList<Alumno>();
	private List<Elemento> elementos = new ArrayList<Elemento>();

	public Asignatura(String nombre) {
		this.nombre = nombre;
	}

	public String getNombre() {
		return nombre;
	}

	public List<Solicitud> getSolicitudes() {
		return Collections.unmodifiableList(solicitudes);
	}
	
	public boolean anadirSolicitud(Solicitud solicitud){
		if (Aplicacion.getInstance().getTipoUsu().equals(TipoUsuario.ALUMNO) == false) {
			return false;
		}
		if (this.solicitudes.contains(solicitud)){
			return false;
		}
		return this.solicitudes.add(solicitud);
	}
	
	public boolean aceptarSolicitud(Solicitud solicitud){
		if (Aplicacion.getInstance().getTipoUsu().equals(TipoUsuario.PROFESOR) == false) {
			return false;
		}
		this.solicitudes.remove(solicitud);
		return this.matriculados.add(solicitud.getAlumno());
	}
	
	public void denegarSolicitud(Solicitud solicitud){
		if (Aplicacion.getInstance().getTipoUsu().equals(TipoUsuario.PROFESOR) == false) {
			return;
		}
		this.solicitudes.remove(solicitud);
	}
	
	public List<Alumno> getMatriculados() {
		return Collections.unmodifiableList(matriculados);
	}
	
	public boolean expulsarAlumno(Alumno alumno){
		if (Aplicacion.getInstance().getTipoUsu().equals(TipoUsuario.PROFESOR) == false) {
			return false;
		}
		alumno.eliminarAsignatura(this);
		this.matriculados.remove(alumno);
		return this.expulsados.add(alumno);
	}
	
	public boolean readmitirAlumno(Alumno alumno){
		if (Aplicacion.getInstance().getTipoUsu().equals(TipoUsuario.PROFESOR) == false) {
			return false;
		}
		alumno.anadirAsignatura(this);
		this.expulsados.remove(alumno);
		return this.matriculados.add(alumno);
	}
	
	public List<Alumno> getExpulsados() {
		return Collections.unmodifiableList(expulsados);
	}
	
	public List<Elemento> getElementos() {
		return Collections.unmodifiableList(elementos);
	}
	
	public boolean anadirElemento(Elemento elemento){
		if (Aplicacion.getInstance().getTipoUsu().equals(TipoUsuario.PROFESOR) == false) {
			return false;
		}
		return this.elementos.add(elemento);
	}
	
	public boolean eliminarElemento(Elemento elemento){
		if (Aplicacion.getInstance().getTipoUsu().equals(TipoUsuario.PROFESOR) == false) {
			return false;
		}
		return this.elementos.remove(elemento);
	}
	
	public double calcularNotaAsig(Alumno alumno){
		double nota = 0.0;
		if (this.matriculados.contains(alumno)){
			for (Resolucion res:alumno.getResoluciones()){
				if (res.getTest().getAsignatura().equals(this)){
					res.calcularNota();
					nota = nota + res.getNota() * res.getTest().getPeso();
				}
			}
		}
		
		return nota;
	}

}
