package JUnit;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import aplicacion.asignatura.elemento.resolucion.Respuesta;
import aplicacion.asignatura.elemento.test.Opcion;
import aplicacion.asignatura.elemento.test.OpcionUnica;
import aplicacion.asignatura.elemento.test.PreguntaOpcion;

public class RespuestaTest {

	private PreguntaOpcion preg;
	private Opcion opc;
	private Respuesta resp;
	
	@Before
	public void setUp() {
		preg = new OpcionUnica("Pregunta 1", 10.0, 0.0);
		opc = new Opcion(1, "Opcion 1", true);
		preg.anadirOpcion(opc);
		resp = new Respuesta(preg);
	}
	
	@Test
	public void testAnadirOpcion1() {
		assertTrue(resp.anadirOpcion(opc));
	}
	
	@Test
	public void testAnadirOpcion2() {
		resp.anadirOpcion(opc);
		assertFalse(resp.anadirOpcion(opc));
	}
	
	@Test
	public void testEliminarOpcion1() {
		resp.anadirOpcion(opc);
		assertTrue(resp.eliminarOpcion(opc));
	}
	
	@Test
	public void testEliminarOpcion2() {
		assertFalse(resp.eliminarOpcion(opc));
	}
}
