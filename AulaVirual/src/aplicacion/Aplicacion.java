package aplicacion; 

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Aplicacion {
	private Alumno alumnoActual;
	private List<Alumno> alumnos = new ArrayList<Alumno>();
	
	public Alumno getUsuarioActual() {
		return alumnoActual;
	}
	
	public void setUsuarioActual(Alumno alumnoActual) {
		this.alumnoActual = alumnoActual;
	}
	
	public List<Alumno> getUsuarios() {
		return Collections.unmodifiableList(alumnos);
	}
	
	
	
}
