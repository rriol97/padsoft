package JUnit;

import static org.junit.Assert.*;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.junit.Before;
import org.junit.Test;

import aplicacion.clases.Asignatura;
import aplicacion.clases.elemento.Elemento;
import aplicacion.clases.elemento.Tema;
import es.uam.eps.padsof.emailconnection.FailedInternetConnectionException;
import es.uam.eps.padsof.emailconnection.InvalidEmailAddressException;

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
		assertTrue(elemento.isVisible());
	}
	
	@Test
	public void testSetVisible() throws InvalidEmailAddressException, FailedInternetConnectionException{
		elemento.setVisible(false);
		assertFalse(elemento.isVisible());
	}
}
