package JUnit;

import static org.junit.Assert.*;


import org.junit.Test;

import aplicacion.clases.Alumno;
import aplicacion.clases.Asignatura;
import aplicacion.clases.Solicitud;



public class SolicitudTest {

	@Test
	public void TestSolicitud() {
		Asignatura asig = new Asignatura ("Matematicas");
		Alumno alum = new Alumno ("123","123","rri@es.ccom","Alfredo","Riol");
		Solicitud opc = new Solicitud("Hola", alum, asig);
		assertNotNull(opc);
	}

}
