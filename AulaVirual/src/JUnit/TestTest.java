package JUnit;

import static org.junit.Assert.*;

import java.time.LocalDate;

import org.junit.Before;
import org.junit.Test;

import aplicacion.Alumno;
import aplicacion.asignatura.Asignatura;
import aplicacion.asignatura.elemento.resolucion.Resolucion;
import aplicacion.asignatura.elemento.test.*;

public class TestTest {

	private Asignatura asig;
	private LocalDate fi;
	private LocalDate ff;
	private aplicacion.asignatura.elemento.test.Test test;
	private PreguntaOpcion preg;
	private Opcion opc;
	
	@Before
	public void setUp() {
		asig = new Asignatura("Asignatura 1");
		fi = LocalDate.now();
		ff = LocalDate.now().plusDays(5);
		test = new aplicacion.asignatura.elemento.test.Test("Test 1", true, asig, "Descripcion del test.", fi, ff, false, 100.0, 2.0);
		preg = new OpcionUnica("Pregunta 1", 10.0, 0.0,1);
		opc = new Opcion(1, "Opcion 1", true);
		preg.anadirOpcion(opc);
	}
	
	@Test
	public void testAnadirPregunta1() {
		assertTrue(test.anadirPregunta(preg));
	}
	
	@Test
	public void testAnadirPregunta2() {
		test.anadirPregunta(preg);
		assertFalse(test.anadirPregunta(preg));
	}
	
	@Test
	public void testEliminarPregunta1() {
		test.anadirPregunta(preg);
		assertTrue(test.eliminarPregunta(preg));
	}
	
	@Test
	public void testEliminarPregunta2() {
		assertFalse(test.eliminarPregunta(preg));
	}
	
	@Test
	public void testAnadirResolucion() {
		Alumno alum = new Alumno("nia", "contrasena", "correo.electronico@email.com", "Alumno", "Alumnez");
		Resolucion res = new Resolucion(test, alum);
		test.anadirResolucion(res);
		assertFalse(test.anadirResolucion(res));
	}
	
	@Test
	public void testEliminarResolucion() {
		Alumno alum = new Alumno("nia", "contrasena", "correo.electronico@email.com", "Alumno", "Alumnez");
		Resolucion res = new Resolucion(test, alum);
		assertTrue(test.eliminarResolucion(res));
	}
}
