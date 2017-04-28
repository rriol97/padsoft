package aplicacion.clases; 

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

/**
 * Aplicacion. Clase que contiene todos los datos del programa.
 * Es un singleton, es decir, es accesible desde cualquier clase.
 * 
 * @author Adrian Fernandez
 * @author Ricardo Riol
 * 
 *
 */
public class Aplicacion {
	private static Aplicacion instance;
	
	private String niaProfesor;
	private String contrasenaProfesor;
	private TipoUsuario tipoUsu;
	private Alumno alumnoActual;
	private List <Alumno> alumnos = new ArrayList<Alumno>();
	private List <Asignatura> asignaturas = new ArrayList<Asignatura>();

	/**
	 * Constructor de Aplicacion. Es privado porque Aplicacion es un singleton.
	 */
	private Aplicacion (){
		this.tipoUsu = TipoUsuario.NO_INI;
	}
	
	/**
	 * Metodo para obtener la instancia unica de la clase Aplicacion.
	 * 
	 * @return Aplicacion la instancia de la aplcacion
	 */
	public static Aplicacion getInstance() {
		if (instance == null) {
			instance = new Aplicacion();
		}
		return instance;
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
	
	/**
	 * Metodo que permite anadir una asignatura a la lista de asignaturas de la aplicacion.
	 * 
	 * @param asig asignatura a anadir
	 * @return boolean true si se anade correctamente, false en caso contrario
	 */
	public boolean anadirAsignatura(Asignatura asig) {
		if (asig == null || this.asignaturas.contains(asig)){
			return false;
		}
		return this.asignaturas.add(asig);
	}
	
	/**
	 * Metodo que permite eliminar una asignatura de la lista de asignaturas de la aplicacion.
	 * 
	 * @param asig asignatura a eliminar
	 * @return boolean true si se elimina correctamente, false en caso contrario
	 */
	public boolean eliminarAsignatura(Asignatura asig){
		return this.asignaturas.remove(asig);
	}
	
	/**
	 * Metodo que permite anadir un alumno a la lista de alumnos de la aplicacion.
	 *  
	 * @param alum a anadir
	 * @return boolean true si se anade correctamente, false en caso contrario
	 */
	public boolean anadirAlumno(Alumno alum) {
		if (alum == null || this.alumnos.contains(alum)){
			return false;
		}
		return this.alumnos.add(alum);
	}
	
	/**
	 * Metodo que permite eliminar un alumno de la lista de alumnos de la aplicacion.
	 * 
	 * @param alum alumno a eliminar
	 * @return boolean true si se elimina correctamente, false en caso contrario
	 */
	public boolean eliminarAlumno(Alumno alum){
		return this.alumnos.remove(alum);
	}
	
	/**
	 * Metodo para iniciar sesion.
	 * Detecta si se ha iniciado sesion como profesor o alumno y actualiza el valor de tipoUsu.
	 * Si es alumno tambien se actualiza alumnoActual para que indique el alumno que ha iniciado sesion.
	 * 
	 * @param nia nia del alumno
	 * @param contrasena contrasena del alumno
	 * @return boolean true si se inicia correctamente, false en caso contrario
	 * @throws FileNotFoundException excepcion
	 * @throws ClassNotFoundException excepcion
	 * @throws IOException excepcion
	 */
	public boolean logIn (String nia, String contrasena) throws FileNotFoundException, ClassNotFoundException, IOException{
		if (Aplicacion.getInstance().getTipoUsu().equals(TipoUsuario.NO_INI) == false) {
			return false;
		}
		
		leerAlumnosDeFichero("alumnos.txt");
		leerProfesorDeFichero ("profesor.txt");
		
		if (this.niaProfesor.equals(nia) && this.contrasenaProfesor.equals(contrasena)){
			this.tipoUsu = TipoUsuario.PROFESOR;
			return true;
		} else{
			for (Alumno alu: this.alumnos){
				if (alu.getNia().equals(nia) && alu.getContrasena().equals(contrasena)){
					this.alumnoActual = alu;
					this.tipoUsu = TipoUsuario.ALUMNO;
					return true;
				}
			}
		}
		
		return false;
	}
	
	/**
	 * Metodo para cerrar sesion.
	 * Actualiza tipoUsu a no iniciado.
	 * 
	 * @throws FileNotFoundException excepcion
	 * @throws IOException excepcion
	 */
	public void logOut() throws FileNotFoundException, IOException{
		System.out.println("La sesion se ha cerrado correctamenete");
		this.tipoUsu = TipoUsuario.NO_INI;
	}
	
	/**
	 * Metodo para cargar los datos de alumnos proporcionados en moodle.
	 * 
	 * @param archivo archivo desde donde se lee
	 * @return boolean true si se lee correctamente, false en caso contrario
	 * @throws IOException excepcion
	 */
	public boolean leerAlumnosDeFichero(String archivo) throws IOException{
		String cadena;
        FileReader f = new FileReader(archivo);
        BufferedReader b = new BufferedReader(f);
        b.readLine();
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
	
	/**
	 * Metodo para cargar los datos del profesor.
	 * 
	 * @param archivo archivo desde donde se lee
	 * @return boolean true si se lee correctamente, false en caso contrario
	 * @throws IOException excepcion
	 */
	public boolean leerProfesorDeFichero(String archivo) throws IOException{
		String cadena;
        FileReader f = new FileReader(archivo);
        BufferedReader b = new BufferedReader(f);
        cadena = b.readLine();
        String[] buf = cadena.split(";");
        this.niaProfesor = buf[0];
        this.contrasenaProfesor = buf[1];
        b.close();
        return true;
	}
	
	/**
	 * Metodo para guardar toda la informacion en un fichero "apk.data".
	 * 
	 * @throws FileNotFoundException excepcion
	 * @throws IOException excepcion
	 */
	public void save() throws FileNotFoundException, IOException {
		ObjectOutputStream salida = new ObjectOutputStream (new FileOutputStream("apk.data"));
		salida.writeObject(this.niaProfesor);
		salida.writeObject(this.contrasenaProfesor);
		salida.writeObject(this.tipoUsu);
		salida.writeObject(this.alumnoActual);
		salida.writeObject(this.alumnos);
		salida.writeObject(this.asignaturas);
		salida.close();
	}
	
	/**
	 * Metodo para cargar toda la informacion de un fichero "apk.data".
	 * 
	 * @throws FileNotFoundException excepcion
	 * @throws IOException excepcion
	 * @throws ClassNotFoundException excepcion
	 */
	@SuppressWarnings("unchecked")
	public void load() throws FileNotFoundException, IOException, ClassNotFoundException {
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
