package tester;

import java.io.IOException;
import java.time.LocalDate;

import aplicacion.Alumno;
import aplicacion.Aplicacion;
import aplicacion.Solicitud;
import aplicacion.asignatura.Asignatura;
import aplicacion.asignatura.elemento.Apuntes;
import aplicacion.asignatura.elemento.Tema;
import aplicacion.asignatura.elemento.resolucion.Resolucion;
import aplicacion.asignatura.elemento.test.Opcion;
import aplicacion.asignatura.elemento.test.OpcionMultiple;
import aplicacion.asignatura.elemento.test.OpcionUnica;
import aplicacion.asignatura.elemento.test.Pregunta;
import aplicacion.asignatura.elemento.test.PreguntaOpcion;
import aplicacion.asignatura.elemento.test.SiNo;
import aplicacion.asignatura.elemento.test.Test;
import es.uam.eps.padsof.emailconnection.FailedInternetConnectionException;
import es.uam.eps.padsof.emailconnection.InvalidEmailAddressException;
/**
 * Esta clase implementa un peque�o programa para probar por encima la funionalidad de la aplicacion
 * @author Ricardo Riol 
 * 		   Adrian Fernandez Amador
 *
 */
public class TesterAulaVirtual {

	public static void main(String[] args) throws IOException, ClassNotFoundException, InvalidEmailAddressException, FailedInternetConnectionException {
		
		Aplicacion.getInstance().leerAlumnosDeFichero("alumnos.txt");
		
		for (Alumno alum : Aplicacion.getInstance().getAlumnos()){
			System.out.println(alum);
		}
		
		System.out.println("\n");
		Aplicacion.getInstance().logIn("profesor","profesor");
		
		Asignatura cirel = new Asignatura("CIREL");
		Aplicacion.getInstance().anadirAsignatura(cirel);
		
		Asignatura edyl = new Asignatura("EDyL");
		Aplicacion.getInstance().anadirAsignatura(edyl);
		
		Aplicacion.getInstance().save();
		
		Asignatura adsoft = new Asignatura("ADSOFT");
		Aplicacion.getInstance().anadirAsignatura(adsoft);
		
		System.out.println("Asignaturas");
		for (Asignatura asig:Aplicacion.getInstance().getAsignaturas()){
			System.out.println("  "+asig);
		}
		
		Aplicacion.getInstance().eliminarAsignatura(cirel);
		System.out.println("\nAsignaturas");
		for (Asignatura asig:Aplicacion.getInstance().getAsignaturas()){
			System.out.println("  "+asig);
		}
		
		System.out.println("\n"+edyl);
		Tema tema1_edyl = new Tema("Tema 1: Combinatoria", true, edyl);
		
		Apuntes apuntes_tema1edyl = new Apuntes ("Introduccion a la combinatoria", true, "(apuntes de combinatoria)", edyl);
		tema1_edyl.anadirElemento(apuntes_tema1edyl);
		
		Test test1_edyl = new Test("Prueba1", true, edyl, "Este examen tendra 10 preguntas de diferentes tipos. Las preguntas tipo test bajaran nota en el caso de que se falle y no puntuan si se dejan en blanco.", LocalDate.now().plusDays(3), LocalDate.now().plusDays(5), true , 30, 1);
		tema1_edyl.anadirElemento(test1_edyl);
		
		PreguntaOpcion p1 = new OpcionUnica("Cuantas posibles contrasenas se pueden hacer, si la contrasena es 4 digitos y solo se utilizan los numeros del 1 al 10", 1, 0.5);
		test1_edyl.anadirPregunta(p1);
		
		Opcion opcion_p11 = new Opcion (1, "10^3", false);
		p1.anadirOpcion(opcion_p11);
		
		Opcion opcion_p12 = new Opcion (2, "10^4", true);
		p1.anadirOpcion(opcion_p12);
		
		Opcion opcion_p13 = new Opcion (3, "10^2", false);
		p1.anadirOpcion(opcion_p13);
		
		System.out.println(tema1_edyl);
		
		Aplicacion.getInstance().logOut();
		
		Aplicacion.getInstance().logIn("1264", "s.ll");
		
		Alumno alum = Aplicacion.getInstance().getAlumnoActual();
		Solicitud sol = new Solicitud("Hola soy "+alum.getNombre()+" "+alum.getApellidos()+"y quiero inscribirme en su asignatura", alum, edyl);
		alum.enviarSolicitud(sol);
		
		Aplicacion.getInstance().logOut();
		
		Aplicacion.getInstance().logIn("profesor", "profesor");
		System.out.println(sol);
		edyl.aceptarSolicitud(sol);
		
		Aplicacion.getInstance().logOut();
		
		Aplicacion.getInstance().logIn("1264", "s.ll");
		Alumno alum2 = Aplicacion.getInstance().getAlumnoActual();
		
		Resolucion res = new Resolucion (test1_edyl, alum2);
		
		for (Pregunta p : test1_edyl.getPreguntas()){
			if (p instanceof OpcionUnica || p instanceof OpcionMultiple || p instanceof SiNo){
				Opcion seleccionada = new Opcion(2,"10^4",true);
				p.responderPregunta(res, seleccionada,"");
			} else {
				p.responderPregunta(res,null, "(respuesta)");
			}
			
		}
		System.out.println(res);
		
		Aplicacion.getInstance().logOut();
		Aplicacion.getInstance().logIn("profesor","profesor");
		
		
		for (Resolucion resolution :test1_edyl.getResoluciones()){
			resolution.calcularNota();
			System.out.println(resolution);
		}
		
		Aplicacion.getInstance().logOut();
		
		Aplicacion.getInstance().load();
		System.out.println(Aplicacion.getInstance().getAsignaturas());
		
	}

}
