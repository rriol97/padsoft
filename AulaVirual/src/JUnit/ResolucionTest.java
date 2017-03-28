package JUnit;

import static org.junit.Assert.*;

import java.time.LocalDate;

import org.junit.Before;
import org.junit.Test;

import aplicacion.Alumno;
import aplicacion.asignatura.Asignatura;
import aplicacion.asignatura.elemento.resolucion.Resolucion;
import aplicacion.asignatura.elemento.resolucion.Respuesta;
import aplicacion.asignatura.elemento.test.Opcion;
import aplicacion.asignatura.elemento.test.OpcionUnica;
import aplicacion.asignatura.elemento.test.PreguntaOpcion;
import es.uam.eps.padsof.emailconnection.FailedInternetConnectionException;
import es.uam.eps.padsof.emailconnection.InvalidEmailAddressException;

public class ResolucionTest {

	private Asignatura asig;
	private aplicacion.asignatura.elemento.test.Test test;
	private PreguntaOpcion preg;
	private Opcion opc;
	private Resolucion res;
	private Respuesta resp;
	private Alumno alum;
	
	@Before
	public void setUp() {
		alum = new Alumno("nia", "contrasena", "correo.electronico@email.com", "Alumno", "Alumnez");
		asig = new Asignatura("Asignatura 1");
		test = new aplicacion.asignatura.elemento.test.Test("Test 1", true, asig, "Descripcion del test.", LocalDate.now(), LocalDate.now().plusDays(5), false, 100.0, 2.0);
		preg = new OpcionUnica("Pregunta 1", 10.0, 0.0);
		opc = new Opcion(1, "Opcion 1", true);
		preg.anadirOpcion(opc);
		test.anadirPregunta(preg);
		res = new Resolucion(test, alum);
		resp = new Respuesta(preg);
		resp.anadirOpcion(opc);
		

	}
	
	@Test
	public void testAnadirRespuesta1() {
		assertTrue(res.anadirRespuesta(resp));
	}
	
	@Test
	public void testAnadirRespuesta2() {
		res.anadirRespuesta(resp);
		assertFalse(res.anadirRespuesta(resp));
	}
	
	@Test
	public void testEliminarRespuesta1() {
		res.anadirRespuesta(resp);
		assertTrue(res.eliminarRespuesta(resp));
	}
	
	@Test
	public void testEliminarRespuesta2() {
		assertFalse(res.eliminarRespuesta(resp));
	}
	
	@Test
	public void testCalcularNota1() throws InvalidEmailAddressException, FailedInternetConnectionException {
		res.anadirRespuesta(resp);
		res.calcularNota();
		assertTrue(res.getNota() == 10.0);
	}
	
	@Test
	public void testCalcularNota2() throws InvalidEmailAddressException, FailedInternetConnectionException {
		res.calcularNota();
		assertTrue(res.getNota() == 0.0);
	}
}
