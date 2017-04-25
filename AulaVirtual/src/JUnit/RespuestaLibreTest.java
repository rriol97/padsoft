package JUnit;

import static org.junit.Assert.*;


import org.junit.Test;

import aplicacion.clases.elemento.test.Pregunta;
import aplicacion.clases.elemento.test.RespuestaLibre;



public class RespuestaLibreTest {

	@Test
	public void TestRespuestaLibre() {
		Pregunta p = new RespuestaLibre("Hemos estudiado la paradoja de Rusell?",1.0,0.5,"si");
		assertNotNull(p);
	}

}
