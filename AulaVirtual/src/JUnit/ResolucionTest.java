package JUnit;

import static org.junit.Assert.*;

import java.time.LocalDate;

import org.junit.Before;
import org.junit.Test;

import aplicacion.clases.Alumno;
import aplicacion.clases.Asignatura;
import aplicacion.clases.elemento.test.Opcion;
import aplicacion.clases.elemento.test.OpcionUnica;
import aplicacion.clases.elemento.test.PreguntaOpcion;
import aplicacion.clases.resolucion.Resolucion;
import aplicacion.clases.resolucion.Respuesta;
import es.uam.eps.padsof.emailconnection.FailedInternetConnectionException;
import es.uam.eps.padsof.emailconnection.InvalidEmailAddressException;

public class ResolucionTest {

	private Asignatura asig;
	private aplicacion.clases.elemento.test.Test test;
	private PreguntaOpcion preg;
	private Opcion opc;
	private Resolucion res;
	private Respuesta resp;
	private Alumno alum;
	
	@Before
	public void setUp() {
		alum = new Alumno("nia", "contrasena", "correo.electronico@email.com", "Alumno", "Alumnez");
		asig = new Asignatura("Asignatura 1");
		test = new aplicacion.clases.elemento.test.Test("Test 1", true, asig, "Descripcion del test.", LocalDate.now(), LocalDate.now().plusDays(5), false, 100.0, 2.0);
		preg = new OpcionUnica("Pregunta 1", 10.0, 0.0);
		opc = new Opcion("Opcion 1", true);
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
