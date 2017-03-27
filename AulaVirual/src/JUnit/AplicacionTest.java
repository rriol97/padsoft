package JUnit;

import static org.junit.Assert.*;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.junit.Before;
import org.junit.Test;

import aplicacion.Alumno;
import aplicacion.Aplicacion;
import aplicacion.asignatura.Asignatura;

public class AplicacionTest {

	private Aplicacion ap;
	private Alumno alum;
	private Asignatura asig;
	
	@Before
	public void setUp() {
		ap = Aplicacion.getInstance();
		alum = new Alumno("nia", "contrasena", "correo.electronico@email.com", "Alumno", "Alumnez");
		asig = new Asignatura("Asignatura 1");
	}
	
	@Test
	public void testAnadirAsignatura1() {
		assertTrue(ap.anadirAsignatura(asig));
	}
	
	@Test
	public void testAnadirAsignatura2() {
		ap.anadirAsignatura(asig);
		assertFalse(ap.anadirAsignatura(asig));
	}
	
	@Test
	public void testEliminarAsignatura1() {
		ap.anadirAsignatura(asig);
		assertTrue(ap.eliminarAsignatura(asig));
	}
	
	@Test
	public void testEliminarAsignatura2() {
		assertFalse(ap.eliminarAsignatura(asig));
	}
	
	@Test
	public void testAnadirAlumno1() {
		assertTrue(ap.anadirAlumno(alum));
	}
	
	@Test
	public void testAnadirAlumno2() {
		ap.anadirAlumno(alum);
		assertFalse(ap.anadirAlumno(alum));
	}
	
	@Test
	public void testEliminarAlumno1() {
		ap.anadirAlumno(alum);
		assertTrue(ap.eliminarAlumno(alum));
	}
	
	@Test
	public void testEliminarAlumno2() {
		assertFalse(ap.eliminarAlumno(alum));
	}
	
	@Test
	public void testLogIn1() throws FileNotFoundException, ClassNotFoundException, IOException {
		ap.anadirAlumno(alum);
		assertTrue(ap.logIn("nia", "contrasena"));
	}
	
	@Test
	public void testLogIn2() throws FileNotFoundException, ClassNotFoundException, IOException {
		ap.anadirAlumno(alum);
		assertFalse(ap.logIn("nia", "contrasena_incorrecta"));
	}
	
	@Test
	public void testLogIn3() throws FileNotFoundException, ClassNotFoundException, IOException {
		assertFalse(ap.logIn("nia", "contrasena"));
	}
	
	@Test
	public void testLeerAlumnosDeFichero() throws IOException {
		assertTrue(ap.leerAlumnosDeFichero("alumnos.txt"));
	}
}
