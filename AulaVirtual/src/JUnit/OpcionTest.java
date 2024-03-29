package JUnit;

import static org.junit.Assert.*;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.junit.Before;
import org.junit.Test;

import aplicacion.clases.elemento.test.Opcion;

public class OpcionTest {
	
	private Opcion opcion1;
	private Opcion opcion2;
	
	@Before 
	public void setUp() throws FileNotFoundException, ClassNotFoundException, IOException{
		opcion1 = new Opcion("El canto del loco", false);
		opcion2 = new Opcion("Pereza",true);
	}
		
	@Test
	public void testSetTexto() {
		opcion1.setTexto("Leiva");
		opcion2.setTexto ("El canto del loco");
		assertEquals("Leiva", opcion1.getTexto());
		assertEquals("El canto del loco", opcion2.getTexto());
	}
	
	@Test
	public void testIsCorrecta(){
		assertFalse(opcion1.isCorrecta());
		assertTrue(opcion2.isCorrecta());
	}
}
