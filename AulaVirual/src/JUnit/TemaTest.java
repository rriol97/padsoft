package JUnit;

import static org.junit.Assert.*;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.junit.Before;
import org.junit.Test;

import aplicacion.Aplicacion;
import aplicacion.asignatura.Asignatura;
import aplicacion.asignatura.elemento.Apuntes;
import aplicacion.asignatura.elemento.Elemento;
import aplicacion.asignatura.elemento.Tema;

public class TemaTest {
	
	private Tema tema;
	private Asignatura asig;
	
	@Before
	public void setUp() throws FileNotFoundException, ClassNotFoundException, IOException{
		Aplicacion.getInstance().logIn("profesor", "profesor");
		asig = new Asignatura("Conocimiento del Medio");
		tema = new Tema("La naturaleza", true, asig);
	}
	
	@Test
	public void testAnadirElemento1(){
		Elemento apuntes = new Apuntes("La naturaleza en su estado puro", false, "(texto)",asig);
		assertTrue(tema.anadirElemento(apuntes));
		
	}
	
	@Test
	public void testAnadirElemento2() throws FileNotFoundException, ClassNotFoundException, IOException {
		Aplicacion.getInstance().logIn("profesor", "profesor");
		assertFalse(tema.anadirElemento(null));
		
	}

	@Test
	public void testEliminarElemento1() throws FileNotFoundException, ClassNotFoundException, IOException {
		Aplicacion.getInstance().logIn("profesor", "profesor");
		Elemento apuntes = new Apuntes("La naturaleza en su estado puro", false, "(texto)",asig);
		tema.anadirElemento(apuntes);
		assertTrue(tema.eliminarElemento(apuntes));
		
	}
	
	@Test
	public void testEliminarElemento2() throws FileNotFoundException, ClassNotFoundException, IOException {
		Aplicacion.getInstance().logIn("profesor", "profesor");
		assertFalse(tema.eliminarElemento(null));
		
	}
}
