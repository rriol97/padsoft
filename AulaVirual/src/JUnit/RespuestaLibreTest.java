package JUnit;

import static org.junit.Assert.*;


import org.junit.Test;


import aplicacion.asignatura.elemento.test.RespuestaLibre;


public class RespuestaLibreTest {

	@Test
	public void TestRespuestaLibre() {
		RespuestaLibre opc = new RespuestaLibre("¿Cuántas caras tiene un dado?", 1.0, 0.5,"seis");
		assertNotNull(opc);
	}

}
