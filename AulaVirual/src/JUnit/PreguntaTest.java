package JUnit;

import static org.junit.Assert.*;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.LocalDate;

import org.junit.Before;
import org.junit.Test;

import aplicacion.Alumno;
import aplicacion.Aplicacion;
import aplicacion.asignatura.Asignatura;
import aplicacion.asignatura.elemento.resolucion.Resolucion;
import aplicacion.asignatura.elemento.resolucion.Respuesta;
import aplicacion.asignatura.elemento.test.Pregunta;
import aplicacion.asignatura.elemento.test.RespuestaLibre;
import es.uam.eps.padsof.emailconnection.FailedInternetConnectionException;
import es.uam.eps.padsof.emailconnection.InvalidEmailAddressException;

public class PreguntaTest {

	private Pregunta pregunta;
	private aplicacion.asignatura.elemento.test.Test test;
	private Asignatura asignatura;
	private Respuesta respuesta;
	private Resolucion resolucion;
	
	@Before
	public void setUp() throws FileNotFoundException, ClassNotFoundException, IOException, InvalidEmailAddressException, FailedInternetConnectionException{
		pregunta = new RespuestaLibre("�Cu�ntas pel�culas hay de Harry Potter?", 1.0,0.5,"ocho");
		asignatura = new Asignatura("CMC");
		test = new aplicacion.asignatura.elemento.test.Test("test", true, asignatura, "",LocalDate.now(), LocalDate.now().plusDays(3), false, 20.0, 1.0 );
		resolucion = new Resolucion(test);
		respuesta = new Respuesta (pregunta);
		
		Aplicacion.getInstance().logIn("profesor","profesor");
		Aplicacion.getInstance().anadirAsignatura(asignatura);
		asignatura.anadirElemento(test);
		test.anadirPregunta(pregunta);
		Aplicacion.getInstance().logOut();
		Aplicacion.getInstance().logIn("1264", "s.ll");
		Alumno alum = Aplicacion.getInstance().getAlumnoActual();
		alum.anadirResolucion(resolucion);
		resolucion.anadirRespuesta(respuesta);
		test.anadirResolucion(resolucion);
		respuesta.setRespuesta("ocho");
		Aplicacion.getInstance().logOut();
		Aplicacion.getInstance().logIn("profesor", "profesor");
		
		for (Resolucion resolution :test.getResoluciones()){
			resolution.calcularNota();
		}
		
		
		
	}
	
	
	@Test
	public void testGetPorcentajeAciertos() {
		boolean a = false;
		for (Pregunta pregunta: test.getPreguntas()) {
			if (pregunta.getPorcentajeciertos()==100.0){
				a = true;
			}
		}		
		
		assertEquals(a,true);
	}
	
	@Test
	public void testGetPorcentajeFallos() {
		boolean a = false;
		for (Pregunta pregunta: test.getPreguntas()) {
			if (pregunta.getPorcentajeFallos()==0.0){
				a = true;
			}
		}		
		
		assertEquals(a,true);
	}
	
	@Test
	public void testGetPorcentajeNsnc() {
		boolean a = false;
		for (Pregunta pregunta: test.getPreguntas()) {
			if (pregunta.getPorcentajeNsnc()==0.0){
				a = true;
			}
		}		
		
		assertEquals(a,true);
	}
	
	public void testAnadirRespuesta1(){
		Respuesta respuesta = new Respuesta(pregunta);
		assertTrue(pregunta.anadirRespuesta(respuesta));
	}
	
	public void testAnadirRespuesta2(){
		assertFalse(pregunta.anadirRespuesta(null));
	}
	
	public void TestEliminarRespuesta1(){
		assertTrue(pregunta.eliminarRespuesta(respuesta));
	}
	
	public void TestEliminarRespuesta2(){
		assertFalse(pregunta.eliminarRespuesta(respuesta));
	}
	
	public void TestcalcularRespuestas(){
		boolean a = false;
		if (pregunta.getPorcentajeciertos() == 1){
			a = true;
		}
		assertTrue(a);
	}
	
	public void TestresponderPregunta(){
		boolean a = false;
		if (pregunta.getNumRespuestas()==1){
			a = true;
		}
		assertTrue(a);	
	}

}
