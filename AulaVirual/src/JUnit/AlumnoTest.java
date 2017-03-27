package JUnit;

import static org.junit.Assert.*;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.LocalDate;

import org.junit.Before;
import org.junit.Test;

import aplicacion.Alumno;
import aplicacion.Aplicacion;
import aplicacion.asignatura.Asignatura;
import aplicacion.asignatura.elemento.resolucion.Resolucion;

public class AlumnoTest {

	private Alumno alum;
	private Asignatura asig;
	private LocalDate fi;
	private LocalDate ff;
	private aplicacion.asignatura.elemento.test.Test test;
	private Resolucion res;	
	
	@Before
	public void setUp() throws FileNotFoundException, ClassNotFoundException, IOException {
		alum = new Alumno("nia", "contrasena", "correo.electronico@email.com", "Alumno", "Alumnez");
		Aplicacion.getInstance().anadirAlumno(alum);
		Aplicacion.getInstance().logIn("nia", "contrasena");
		asig = new Asignatura("Asignatura 1");
		fi = LocalDate.now();
		ff = LocalDate.now().plusDays(5);
		test = new aplicacion.asignatura.elemento.test.Test("Test 1", true, asig, "Descripcion del test.", fi, ff, false, 100.0, 2.0);
		res = new Resolucion(test, alum);
	}
	
	@Test
	public void testAnadirAsignatura1() {
		assertTrue(alum.anadirAsignatura(asig));
	}
	
	@Test
	public void testAnadirAsignatura2() {
		alum.anadirAsignatura(asig);
		assertFalse(alum.anadirAsignatura(asig));
	}
	
	@Test
	public void testEliminarAsignatura1() {
		alum.anadirAsignatura(asig);
		assertTrue(alum.eliminarAsignatura(asig));
	}
	
	@Test
	public void testEliminarAsignatura2() {
		assertFalse(alum.eliminarAsignatura(asig));
	}
	
	@Test
	public void testAnadirResolucion1() throws FileNotFoundException, ClassNotFoundException, IOException {
		alum.eliminarResolucion(res);
		assertTrue(alum.anadirResolucion(res));
	}
	
	@Test
	public void testAnadirResolucion2() {
		assertFalse(alum.anadirResolucion(res));
	}
	
	@Test
	public void testEliminarResolucion1() {
		assertTrue(alum.eliminarResolucion(res));
	}
	
	@Test
	public void testEliminarResolucion2() {
		alum.eliminarResolucion(res);
		assertFalse(alum.eliminarResolucion(res));
	}
	
	@Test
	public void testEncontrarResolucion1() {
		assertNotNull(alum.encontrarResolucion(test));
	}
	
	@Test
	public void testEncontrarResolucion2() {
		alum.eliminarResolucion(res);
		assertNull(alum.encontrarResolucion(test));
	}
}
