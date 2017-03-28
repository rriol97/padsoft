package JUnit;

import static org.junit.Assert.*;


import org.junit.Test;


import aplicacion.asignatura.elemento.test.OpcionUnica;

public class OpcionUnicaTest {

	@Test
	public void TestOpcionUnica() {
		OpcionUnica opc = new OpcionUnica("Cuantas caras tiene un dado?", 1.0, 0.5);
		assertNotNull(opc);
	}
}

