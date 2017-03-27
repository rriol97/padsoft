package JUnit;

import static org.junit.Assert.*;

import java.time.LocalDate;

import org.junit.Before;
import org.junit.Test;

import aplicacion.Alumno;
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
	public void setUp() {
		alum = new Alumno("nia", "contrasena", "correo.electronico@email.com", "Alumno", "Alumnez");
		asig = new Asignatura("Asignatura 1");
		fi = LocalDate.now();
		ff = LocalDate.now().plusDays(5);
		test = new aplicacion.asignatura.elemento.test.Test("Test 1", true, asig, "Descripcion del test.", fi, ff, false, 100.0, 2.0);
		res = new Resolucion(test);
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
	public void testAnadirResolucion1() {
		assertTrue(alum.anadirResolucion(res));
	}
	
	@Test
	public void testAnadirResolucion2() {
		alum.anadirResolucion(res);
		assertFalse(alum.anadirResolucion(res));
	}
	
	@Test
	public void testEliminarResolucion1() {
		alum.anadirResolucion(res);
		assertTrue(alum.eliminarResolucion(res));
	}
	
	@Test
	public void testEliminarResolucion2() {
		assertFalse(alum.eliminarResolucion(res));
	}
	
	@Test
	public void testEncontrarResolucion1() {
		alum.anadirResolucion(res);
		assertNotNull(alum.encontrarResolucion(test));
	}
	
	@Test
	public void testEncontrarResolucion2() {
		assertNull(alum.encontrarResolucion(test));
	}
}
