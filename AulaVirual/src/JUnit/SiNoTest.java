package JUnit;

import static org.junit.Assert.*;


import org.junit.Test;


import aplicacion.asignatura.elemento.test.SiNo;


public class SiNoTest {

	@Test
	public void TestOpcionSiNo() {
		SiNo opc = new SiNo("¿Cuántas caras tiene un dado?", 1.0, 0.5);
		assertNotNull(opc);
	}

}
