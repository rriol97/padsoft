package JUnit;

import static org.junit.Assert.*;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.junit.Before;
import org.junit.Test;
import aplicacion.asignatura.Asignatura;
import aplicacion.asignatura.elemento.Elemento;
import aplicacion.asignatura.elemento.Tema;

public class ElementoTest {

	private Elemento elemento;
	private Asignatura asig;
	
	@Before
	public void setUp() throws FileNotFoundException, ClassNotFoundException, IOException{
		elemento = new Tema ("El clima", true, asig);
		asig = new Asignatura("CCSS");
	}
	
	@Test
	public void testIsVisible() {
		assertTrue(elemento.getVisible());
	}
	
	@Test
	public void testSetVisible(){
		elemento.setVisible(false);
		assertFalse(elemento.getVisible());
	}
}
