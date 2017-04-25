package JUnit;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ AlumnoTest.class,
	AplicacionTest.class,
	AsignaturaTest.class,
	ElementoTest.class,
	OpcionMultipleTest.class,
	OpcionTest.class,
	OpcionUnicaTest.class,
	PreguntaOpcionTest.class,
	PreguntaTest.class,
	ResolucionTest.class,
	RespuestaLibreTest.class,
	RespuestaTest.class,
	SiNoTest.class,
	SolicitudTest.class,
	TemaTest.class,
	TestTest.class
	})

public class AllTest {
	
}
