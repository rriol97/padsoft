package JUnit;

import static org.junit.Assert.*;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.junit.Before;
import org.junit.Test;

import aplicacion.clases.elemento.test.Opcion;
import aplicacion.clases.elemento.test.OpcionUnica;
import aplicacion.clases.elemento.test.PreguntaOpcion;
import aplicacion.clases.resolucion.Respuesta;

public class RespuestaTest {

	private PreguntaOpcion preg;
	private Opcion opc;
	private Respuesta resp;
	
	@Before
	public void setUp() throws FileNotFoundException, ClassNotFoundException, IOException {
		preg = new OpcionUnica("Pregunta 1", 10.0, 0.0,1);
		opc = new Opcion("Opcion 1", true);
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
