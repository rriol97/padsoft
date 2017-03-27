package JUnit;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import aplicacion.asignatura.Asignatura;
import aplicacion.asignatura.elemento.Apuntes;
import aplicacion.asignatura.elemento.Elemento;
import aplicacion.asignatura.elemento.Tema;

public class TemaTest {
	
	private Tema tema;
	private Asignatura asig;
	
	@Before
	public void setUp(){
		asig = new Asignatura("Conocimiento del Medio");
		tema = new Tema("La naturaleza", true, asig);
	}
	
	@Test
	public void testAnadirElemento1() {
		Elemento apuntes = new Apuntes("La naturaleza en su estado puro", false, "(texto)",asig);
		assertTrue(tema.anadirElemento(apuntes));
		
	}
	
	@Test
	public void testAnadirElemento2() {
		assertFalse(tema.anadirElemento(null));
		
	}

	@Test
	public void testEliminarElemento1() {
		Elemento apuntes = new Apuntes("La naturaleza en su estado puro", false, "(texto)",asig);
		tema.anadirElemento(apuntes);
		assertTrue(tema.eliminarElemento(apuntes));
		
	}
	
	@Test
	public void testEliminarElemento2() {
	
		assertFalse(tema.eliminarElemento(null));
		
	}
}
