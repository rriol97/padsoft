package JUnit;

import static org.junit.Assert.*;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.LocalDate;

import org.junit.Before;
import org.junit.Test;

import aplicacion.clases.Alumno;
import aplicacion.clases.Asignatura;
import aplicacion.clases.elemento.test.Pregunta;
import aplicacion.clases.elemento.test.RespuestaLibre;
import aplicacion.clases.resolucion.Resolucion;
import aplicacion.clases.resolucion.Respuesta;
import es.uam.eps.padsof.emailconnection.FailedInternetConnectionException;
import es.uam.eps.padsof.emailconnection.InvalidEmailAddressException;

public class PreguntaTest {

	private Pregunta pregunta;
	private aplicacion.clases.elemento.test.Test test;
	private Asignatura asignatura;
	private Respuesta respuesta;
	private Resolucion resolucion;
	private Alumno alum;
	
	@Before
	public void setUp() throws FileNotFoundException, ClassNotFoundException, IOException, InvalidEmailAddressException, FailedInternetConnectionException{
		alum = new Alumno("nia", "contrasena", "correo.electronico@email.com", "Alumno", "Alumnez");
		pregunta = new RespuestaLibre("�Cuantas pel�culas hay de Harry Potter?", 1.0,0.5,"ocho");
		asignatura = new Asignatura("CMC");
		test = new aplicacion.clases.elemento.test.Test("test", true, asignatura, "",LocalDate.now(), LocalDate.now().plusDays(3), false, 20.0, 1.0 );
		asignatura.anadirElemento(test);
		test.anadirPregunta(pregunta);		
		resolucion = new Resolucion(test, alum);
		respuesta = new Respuesta (pregunta);
		resolucion.anadirRespuesta(respuesta);
		respuesta.setRespuesta("ocho");
		
		for (Resolucion resolution :test.getResoluciones()){
			resolution.calcularNota();
		}
	}
	
	@Test
	public void testGetPorcentajeAciertos() {
		boolean a = false;
		for (Pregunta pregunta: test.getPreguntas()) {
			if (pregunta.getPorcentajeAciertos()==100.0){
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
		if (pregunta.getPorcentajeAciertos() == 1){
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
