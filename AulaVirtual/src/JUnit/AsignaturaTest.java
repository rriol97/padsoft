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
import aplicacion.clases.elemento.test.Opcion;
import aplicacion.clases.elemento.test.OpcionUnica;
import aplicacion.clases.elemento.test.PreguntaOpcion;
import aplicacion.clases.resolucion.Resolucion;
import aplicacion.clases.resolucion.Respuesta;
import es.uam.eps.padsof.emailconnection.FailedInternetConnectionException;
import es.uam.eps.padsof.emailconnection.InvalidEmailAddressException;

public class AsignaturaTest {

	private Asignatura asig;
	private Alumno alum;
	private Solicitud sol;
	
	@Before
	public void setUp() throws FileNotFoundException, ClassNotFoundException, IOException, InvalidEmailAddressException, FailedInternetConnectionException {
		asig = new Asignatura("Asignatura 1");
		alum = new Alumno("nia", "contrasena", "correo.electronico@email.com", "Alumno", "Alumnez");
		sol = new Solicitud("Solicito cursar esta asignatura.", alum, asig);
	}
	
	@Test
	public void testAnadirSolicitud1() {
		sol = new Solicitud("Hola", alum, asig);
		assertTrue(asig.anadirSolicitud(sol));
	}
	
	@Test
	public void testAnadirSolicitud2() throws InvalidEmailAddressException, FailedInternetConnectionException {
		sol = new Solicitud("Hola", alum, asig);
		asig.anadirSolicitud(sol);
		assertFalse(asig.anadirSolicitud(sol));
	}
	
	@Test
	public void testAceptarSolicitud1() throws InvalidEmailAddressException, FailedInternetConnectionException {
		sol = new Solicitud("Hola", alum, asig);
		alum.enviarSolicitud(sol);
		assertTrue(asig.aceptarSolicitud(sol));
	}
	
	@Test
	public void testAceptarSolicitud2() throws InvalidEmailAddressException, FailedInternetConnectionException {
		sol = new Solicitud("Hola", alum, asig);
		assertFalse(asig.aceptarSolicitud(sol));
	}
	
	@Test
	public void testExpulsarAlumno1() throws InvalidEmailAddressException, FailedInternetConnectionException {
		sol = new Solicitud("Hola", alum, asig);
		asig.anadirSolicitud(sol);
		asig.aceptarSolicitud(sol);
		assertTrue(asig.expulsarAlumno(alum));
	}
	
	@Test
	public void testExpulsarAlumno2() throws InvalidEmailAddressException, FailedInternetConnectionException {
		assertFalse(asig.expulsarAlumno(alum));
	}
	
	@Test
	public void testReadmitirAlumno1() throws InvalidEmailAddressException, FailedInternetConnectionException {
		sol = new Solicitud("Hola", alum, asig);
		asig.anadirSolicitud(sol);
		asig.aceptarSolicitud(sol);
		asig.expulsarAlumno(alum);
		assertTrue(asig.readmitirAlumno(alum));
	}
	
	@Test
	public void testReadmitirAlumno2() throws InvalidEmailAddressException, FailedInternetConnectionException {
		assertFalse(asig.readmitirAlumno(alum));
	}
	
	@Test
	public void testAnadirElemento1() throws InvalidEmailAddressException, FailedInternetConnectionException {
		Elemento elem = new Apuntes("Apuntes", true, "Estos son unos apuntes.", asig);
		assertTrue(asig.anadirElemento(elem));
	}
	
	@Test
	public void testAnadirElemento2() throws InvalidEmailAddressException, FailedInternetConnectionException {
		Elemento elem = new Apuntes("Apuntes", true, "Estos son unos apuntes.", asig);
		asig.anadirElemento(elem);
		assertFalse(asig.anadirElemento(elem));
	}
	
	@Test
	public void testEliminarElemento1() throws InvalidEmailAddressException, FailedInternetConnectionException {
		Elemento elem = new Apuntes("Apuntes", true, "Estos son unos apuntes.", asig);
		asig.anadirElemento(elem);
		assertTrue(asig.eliminarElemento(elem));
	}
	
	@Test
	public void testEliminarElemento2() throws InvalidEmailAddressException, FailedInternetConnectionException {
		Elemento elem = new Apuntes("Apuntes", true, "Estos son unos apuntes.", asig);
		assertFalse(asig.eliminarElemento(elem));
	}
	
	@Test
	public void testEliminarElemento3() throws InvalidEmailAddressException, FailedInternetConnectionException {
		alum.enviarSolicitud(sol);
		asig.aceptarSolicitud(sol);
		Elemento tema = new Tema("Tema 1", true, asig);
		Elemento test = new aplicacion.clases.elemento.test.Test("Test 1", true, asig, "Descripcion del test.", LocalDate.now(), LocalDate.now().plusDays(5), false, 100.0, 2.0);
		((Tema)tema).anadirElemento(test);
		new Resolucion((aplicacion.clases.elemento.test.Test) test, alum);
		assertFalse(asig.eliminarElemento(tema));
	}
	
	@Test
	public void testCalcularNotaAsig1() throws InvalidEmailAddressException, FailedInternetConnectionException {
		alum.enviarSolicitud(sol);
		asig.aceptarSolicitud(sol);
		aplicacion.clases.elemento.test.Test test = new aplicacion.clases.elemento.test.Test("Test 1", true, asig, "Descripcion del test.", LocalDate.now(), LocalDate.now().plusDays(5), false, 100.0, 2.0);
		PreguntaOpcion preg = new OpcionUnica("Pregunta 1", 10.0, 0.0,1);
		Opcion opc = new Opcion("Opcion 1", true);
		preg.anadirOpcion(opc);
		test.anadirPregunta(preg);
		Resolucion res = new Resolucion(test, alum);
		Respuesta resp = new Respuesta(preg);
		resp.anadirOpcion(opc);
		res.anadirRespuesta(resp);
		res.calcularNota();
		assertTrue(asig.calcularNotaAsig(alum) == 10.0);
	}
	
	@Test
	public void testCalcularNotaAsig2() throws InvalidEmailAddressException, FailedInternetConnectionException {
		assertTrue(asig.calcularNotaAsig(alum) == 0.0);
	}
}
