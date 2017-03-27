package JUnit;

import static org.junit.Assert.*;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.LocalDate;

import org.junit.Before;
import org.junit.Test;

import aplicacion.Alumno;
import aplicacion.Aplicacion;
import aplicacion.Solicitud;
import aplicacion.asignatura.Asignatura;
import aplicacion.asignatura.elemento.Apuntes;
import aplicacion.asignatura.elemento.Elemento;
import aplicacion.asignatura.elemento.resolucion.Resolucion;
import aplicacion.asignatura.elemento.resolucion.Respuesta;
import aplicacion.asignatura.elemento.test.Opcion;
import aplicacion.asignatura.elemento.test.OpcionUnica;
import aplicacion.asignatura.elemento.test.PreguntaOpcion;
import es.uam.eps.padsof.emailconnection.FailedInternetConnectionException;
import es.uam.eps.padsof.emailconnection.InvalidEmailAddressException;

public class AsignaturaTest {

	private Asignatura asig;
	private Alumno alum;
	private Solicitud sol;
	
	@Before
	public void setUp() throws FileNotFoundException, ClassNotFoundException, IOException {
		Aplicacion.getInstance().logIn("profesor", "profesor");
		asig = new Asignatura("Asignatura 1");
		alum = new Alumno("nia", "contrasena", "correo.electronico@email.com", "Alumno", "Alumnez");
	}
	
	@Test
	public void testAnadirSolicitud1() {
		sol = new Solicitud("Hola", alum, asig);
		assertTrue(asig.anadirSolicitud(sol));
	}
	
	@Test
	public void testAnadirSolicitud2() {
		sol = new Solicitud("Hola", alum, asig);
		asig.anadirSolicitud(sol);
		assertFalse(asig.anadirSolicitud(sol));
	}
	
	@Test
	public void testAceptarSolicitud1() throws InvalidEmailAddressException, FailedInternetConnectionException {
		sol = new Solicitud("Hola", alum, asig);
		asig.anadirSolicitud(sol);
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
	public void testCalcularNotaAsig1() throws InvalidEmailAddressException, FailedInternetConnectionException {
		LocalDate fi = LocalDate.now();
		LocalDate ff = LocalDate.now().plusDays(5);
		aplicacion.asignatura.elemento.test.Test test = new aplicacion.asignatura.elemento.test.Test("Test 1", true, asig, "Descripcion del test.", fi, ff, false, 100.0, 2.0);
		PreguntaOpcion preg = new OpcionUnica("Pregunta 1", 10.0, 0.0);
		Opcion opc = new Opcion(1, "Opcion 1", true);
		preg.anadirOpcion(opc);
		Resolucion res = new Resolucion(test);
		Respuesta resp = new Respuesta(preg);
		test.anadirPregunta(preg);
		resp.anadirOpcion(opc);
		res.anadirRespuesta(resp);
		test.anadirResolucion(res);
		assertTrue(asig.calcularNotaAsig(alum) == 10.0);
	}
	
	@Test
	public void testCalcularNotaAsig2() throws InvalidEmailAddressException, FailedInternetConnectionException {
		assertTrue(asig.calcularNotaAsig(alum) == 0.0);
	}
}
