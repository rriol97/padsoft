package aplicacion; 

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import aplicacion.asignatura.Asignatura;


public class Aplicacion {
	private static Aplicacion INSTANCE;
	
	private String niaProfesor;
	private String contrasenaProfesor;
	private TipoUsuario tipoUsu;
	private Alumno alumnoActual;
	private List <Alumno> alumnos = new ArrayList<Alumno>();
	private List <Asignatura> asignaturas = new ArrayList<Asignatura>();

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
	
	public boolean anadirAsignatura(Asignatura asig) {
		if (Aplicacion.getInstance().getTipoUsu().equals(TipoUsuario.PROFESOR) == false) {
			return false;
		}
		return this.asignaturas.add(asig);
	}
	
	public boolean eliminarAsignatura(Asignatura asig){
		if (Aplicacion.getInstance().getTipoUsu().equals(TipoUsuario.PROFESOR) == false) {
			return false;
		}
		return this.asignaturas.remove(asig);
	}
	
	public boolean anadirAlumno(Alumno alum) {
		if (Aplicacion.getInstance().getTipoUsu().equals(TipoUsuario.PROFESOR) == false) {
			return false;
		}
		return this.alumnos.add(alum);
	}
	
	public boolean eliminarAlumno(Alumno alum){
		if (Aplicacion.getInstance().getTipoUsu().equals(TipoUsuario.PROFESOR) == false) {
			return false;
		}
		return this.alumnos.remove(alum);
	}
	
	public boolean logIn (String nia, String contrasena) throws FileNotFoundException, ClassNotFoundException, IOException{
		if (Aplicacion.getInstance().getTipoUsu().equals(TipoUsuario.NO_INI) == false) {
			return false;
		}
		this.load();
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
	
	public void logOut() throws FileNotFoundException, IOException{
		this.tipoUsu = TipoUsuario.NO_INI;
		this.save();
	}
	
	public boolean leerAlumnosDeFichero(String archivo) throws IOException{
		if (Aplicacion.getInstance().getTipoUsu().equals(TipoUsuario.NO_INI) == false) {
			return false;
		}
		
		String cadena;
        FileReader f = new FileReader(archivo);
        BufferedReader b = new BufferedReader(f);
        while((cadena = b.readLine())!=null) {
            String[] buf = cadena.split(";");
            Alumno alumno = new Alumno (buf[3],buf[4],buf[2],buf[0],buf[1]);
            if(this.alumnos.add(alumno)==false) {
            	b.close();
            	return false;
            }
        }
        b.close();
        return true;
	}
	
	private void save() throws FileNotFoundException, IOException {
		ObjectOutputStream salida = new ObjectOutputStream (new FileOutputStream("apk.data"));
		salida.writeObject(this.niaProfesor);
		salida.writeObject(this.contrasenaProfesor);
		salida.writeObject(this.tipoUsu);
		salida.writeObject(this.alumnoActual);
		salida.writeObject(this.alumnos);
		salida.writeObject(this.asignaturas);
		salida.close();
	}
	
	private void load() throws FileNotFoundException, IOException, ClassNotFoundException {
		ObjectInputStream entrada = new ObjectInputStream (new FileInputStream("apk.data"));
      	this.niaProfesor = (String)entrada.readObject();
      	this.contrasenaProfesor = (String)entrada.readObject();
      	this.tipoUsu = (TipoUsuario)entrada.readObject();
      	this.alumnoActual = (Alumno)entrada.readObject();
      	this.alumnos = (List <Alumno>)entrada.readObject();
      	this.asignaturas = (List <Asignatura>)entrada.readObject();
  		entrada.close();
	}
}
