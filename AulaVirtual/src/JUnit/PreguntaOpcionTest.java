package JUnit;

import static org.junit.Assert.*;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.junit.Before;
import org.junit.Test;

import aplicacion.clases.elemento.test.*;

public class PreguntaOpcionTest {
	
	private PreguntaOpcion popc1;
	private PreguntaOpcion popc2;
	private PreguntaOpcion popc3;
	
	@Before
	public void setUp() throws FileNotFoundException, ClassNotFoundException, IOException{
		popc1 = new OpcionUnica("Cuantos anyos tienes?",1.0,0.5,1);
		popc2 = new OpcionMultiple("Cuantos hermanos tienes?", 1.0,0.5,2);
		popc3 = new SiNo ("�Cu�ntos ordenadores tienes?", 1.0,0.5,1);
	}
	
	@Test
	public void testAnadirOpcion1() {
		
		Opcion opc1 = new Opcion("Los piratas del Caribe",false);
		assertTrue(popc1.anadirOpcion(opc1));
		assertTrue(popc2.anadirOpcion(opc1));
		assertTrue(popc3.anadirOpcion(opc1));
	}
	
	@Test
	public void testAnadirOpcion2() {
		assertFalse(popc1.anadirOpcion(null));
		assertFalse(popc2.anadirOpcion(null));
		assertFalse(popc3.anadirOpcion(null));
	}
	
	@Test
	public void testAnadirOpcion3() {
		Opcion opc1 = new Opcion("Los piratas del Caribe",false);
		assertTrue(popc1.anadirOpcion(opc1));
		assertFalse(popc1.anadirOpcion(opc1));
	}
	
	@Test 
	public void testEliminarOpcion1(){
		Opcion opc1 = new Opcion("Los piratas del Caribe",false);
		popc1.anadirOpcion(opc1);
		assertTrue(popc1.eliminarOpcion(opc1));
	}
	
	@Test 
	public void testEliminarOpcion2(){
		Opcion opc1 = new Opcion("Los piratas del Caribe",false);
		popc1.anadirOpcion(opc1);
		assertTrue(popc1.eliminarOpcion(opc1));
		assertFalse(popc1.eliminarOpcion(opc1));
	}
	
	@Test 
	public void testEliminarOpcion3(){
		assertFalse(popc1.eliminarOpcion(null));
	}
}
