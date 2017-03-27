package JUnit;

import static org.junit.Assert.*;


import org.junit.Test;

import aplicacion.Alumno;
import aplicacion.Solicitud;
import aplicacion.asignatura.Asignatura;



public class SolicitudTest {

	@Test
	public void TestSolicitud() {
		Asignatura asig = new Asignatura ("Matemáticas");
		Alumno alum = new Alumno ("123","123","rri@es.ccom","Alfredo","Riol");
		Solicitud opc = new Solicitud("Hola", alum, asig);
		assertNotNull(opc);
	}

}
