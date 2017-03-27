package JUnit;

import static org.junit.Assert.*;


import org.junit.Test;


import aplicacion.asignatura.elemento.test.OpcionMultiple;


public class OpcionMultipleTest {

	@Test
	public void TestOpcionMultiple() {
		OpcionMultiple opc = new OpcionMultiple("Cuantas caras tiene un dado?", 1.0, 0.5);
		assertNotNull(opc);
	}

}
