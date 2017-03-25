package aplicacion; 

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import aplicacion.asignatura.Asignatura;


public class Aplicacion {
	private static Aplicacion INSTANCE;
	private Alumno alumnoActual;
	private List<Alumno> alumnos = new ArrayList<Alumno>();
	private List<Asignatura>asignaturas = new ArrayList<Asignatura>();
	private final String niaProfesor;
	private final String contrasenaProfesor;
	private TipoUsuario tipoUsu;
	
	public Aplicacion (){
		this.niaProfesor = "profesor";
		this.contrasenaProfesor = "profesor";
		this.tipoUsu = TipoUsuario.NO_INI;
	}
	
	public static Aplicacion getInstance() {
		if (INSTANCE == null) INSTANCE = new Aplicacion();
		return INSTANCE;
	}
	
	public Alumno getUsuarioActual() {
		return alumnoActual;
	}
	
	public void setUsuarioActual(Alumno alumnoActual) {
		this.alumnoActual = alumnoActual;
	}
	
	public TipoUsuario getTipoUsu() {
		return tipoUsu;
	}
	
	public Alumno getAlumnoActual() {
		return alumnoActual;
	}

	public List<Alumno> getAlumnos() {
		return alumnos;
	}

	public List<Asignatura> getAsignaturas() {
		return asignaturas;
	}

	public List<Alumno> getUsuarios() {
		return Collections.unmodifiableList(alumnos);
	}
	
	public boolean anadirAsignatura(String nombre) {
		Asignatura asig = new Asignatura(nombre);
		return this.asignaturas.add(asig);
	}
	
	public boolean eliminarAsignatura(Asignatura asig){
		return this.asignaturas.remove(asig);
	}
	
	public boolean anadirAlumno(Alumno alum) {
		return this.alumnos.add(alum);
	}
	
	public boolean eliminarAlumno(Alumno alum){
		return this.alumnos.remove(alum);
	}
	
	public boolean logIn (String nia, String contrasena){
		if (this.niaProfesor.equals(nia) && this.contrasenaProfesor.equals(contrasena)){
			this.tipoUsu = TipoUsuario.PROFESOR;
			return true;
		} else{
			for (Alumno alu: this.alumnos){
				if (alu.getNia().equals(nia) && alu.getContrasena().equals(contrasena)){
					this.tipoUsu = TipoUsuario.ALUMNO;
					return true;
				}
			}
		}
		
		return false;
	}
	
	public void logOut(){
		this.tipoUsu = TipoUsuario.NO_INI;
	}
	
	public void leerAlumnosDeFichero(String archivo) throws IOException{
		 String cadena;
	        FileReader f = new FileReader(archivo);
	        BufferedReader b = new BufferedReader(f);
	        while((cadena = b.readLine())!=null) {
	            String[] buf = cadena.split(";");
	            Alumno alumno = new Alumno (buf[3],buf[4],buf[2],buf[0],buf[1]);
	            this.alumnos.add(alumno);
	        }
	        b.close();
	}
	
	
}
