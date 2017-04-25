package JUnit;

import static org.junit.Assert.*;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.LocalDate;

import org.junit.Before;
import org.junit.Test;

import aplicacion.clases.Alumno;
import aplicacion.clases.Asignatura;
import aplicacion.clases.Solicitud;
import aplicacion.clases.elemento.Apuntes;
import aplicacion.clases.elemento.Elemento;
import aplicacion.clases.elemento.Tema;
import aplicacion.clases.resolucion.Resolucion;
import es.uam.eps.padsof.emailconnection.FailedInternetConnectionException;
import es.uam.eps.padsof.emailconnection.InvalidEmailAddressException;

public class TemaTest {
	
	private Tema tema;
	private Asignatura asig;
	private Elemento apuntes;
	
	@Before
	public void setUp() throws FileNotFoundException, ClassNotFoundException, IOException{
		asig = new Asignatura("Conocimiento del Medio");
		tema = new Tema("La naturaleza", true, asig);
		apuntes = new Apuntes("La naturaleza en su estado puro", false, "(texto)",asig);
	}
	
	@Test
	public void testAnadirElemento1() throws InvalidEmailAddressException, FailedInternetConnectionException{
		assertTrue(tema.anadirElemento(apuntes));
		
	}
	
	@Test
	public void testAnadirElemento2() throws FileNotFoundException, ClassNotFoundException, IOException, InvalidEmailAddressException, FailedInternetConnectionException {
		tema.anadirElemento(apuntes);
		assertFalse(tema.anadirElemento(apuntes));
	}
	
	@Test
	public void testAnadirElemento3() throws FileNotFoundException, ClassNotFoundException, IOException, InvalidEmailAddressException, FailedInternetConnectionException {
		Alumno alum = new Alumno("nia", "contrasena", "correo.electronico@email.com", "Alumno", "Alumnez");
		Solicitud sol = new Solicitud("Solicito cursar esta asignatura.", alum, asig);
		alum.enviarSolicitud(sol);
		asig.aceptarSolicitud(sol);
		Elemento tema = new Tema("Tema 1", true, asig);
		Elemento test = new aplicacion.clases.elemento.test.Test("Test 1", true, asig, "Descripcion del test.", LocalDate.now(), LocalDate.now().plusDays(5), false, 100.0, 2.0);
		((Tema)tema).anadirElemento(test);
		new Resolucion((aplicacion.clases.elemento.test.Test) test, alum);
		assertFalse(asig.eliminarElemento(tema));
	}

	@Test
	public void testEliminarElemento1() throws FileNotFoundException, ClassNotFoundException, IOException, InvalidEmailAddressException, FailedInternetConnectionException {
		tema.anadirElemento(apuntes);
		assertTrue(tema.eliminarElemento(apuntes));
		
	}
	
	@Test
	public void testEliminarElemento2() throws FileNotFoundException, ClassNotFoundException, IOException {
		assertFalse(tema.eliminarElemento(apuntes));
		
	}
}
