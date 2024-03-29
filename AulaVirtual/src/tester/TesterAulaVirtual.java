package tester;

import java.io.IOException;
import java.time.LocalDate;

import aplicacion.clases.Alumno;
import aplicacion.clases.Aplicacion;
import aplicacion.clases.Asignatura;
import aplicacion.clases.Solicitud;
import aplicacion.clases.elemento.Apuntes;
import aplicacion.clases.elemento.Tema;
import aplicacion.clases.elemento.test.Opcion;
import aplicacion.clases.elemento.test.OpcionMultiple;
import aplicacion.clases.elemento.test.OpcionUnica;
import aplicacion.clases.elemento.test.Pregunta;
import aplicacion.clases.elemento.test.PreguntaOpcion;
import aplicacion.clases.elemento.test.SiNo;
import aplicacion.clases.elemento.test.Test;
import aplicacion.clases.resolucion.Resolucion;
import es.uam.eps.padsof.emailconnection.FailedInternetConnectionException;
import es.uam.eps.padsof.emailconnection.InvalidEmailAddressException;

/**
 * Esta clase implementa un pequeno programa para probar por encima la funionalidad de la aplicacion.
 * @author Ricardo Riol 
 * @author Adrian Fernandez Amador
 *
 */
public class TesterAulaVirtual {

	public static void main(String[] args) throws IOException, ClassNotFoundException, InvalidEmailAddressException, FailedInternetConnectionException {
		
		Aplicacion.getInstance().leerAlumnosDeFichero("alumnos.txt");
		Aplicacion.getInstance().leerProfesorDeFichero("profesor.txt");
		
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
		
		Test test1_edyl = new Test("Prueba1", true, edyl, "Este examen tendra 1 pregunta de diferentes tipos. Las preguntas tipo test bajaran nota en el caso de que se falle y no puntuan si se dejan en blanco.", LocalDate.now().plusDays(3), LocalDate.now().plusDays(5), true , 30, 1);
		tema1_edyl.anadirElemento(test1_edyl);
		
		PreguntaOpcion p1 = new OpcionUnica("Cuantas posibles contrasenas se pueden hacer, si la contrasena es 4 digitos y solo se utilizan los numeros del 1 al 10", 1, 0.5);
		test1_edyl.anadirPregunta(p1);
		
		Opcion opcion_p11 = new Opcion ("10^3", false);
		p1.anadirOpcion(opcion_p11);
		
		Opcion opcion_p12 = new Opcion ("10^4", true);
		p1.anadirOpcion(opcion_p12);
		
		Opcion opcion_p13 = new Opcion ("10^2", false);
		p1.anadirOpcion(opcion_p13);
		
		System.out.println(tema1_edyl);
		
		Aplicacion.getInstance().logOut();
		Aplicacion.getInstance().logIn("1264", "s.ll");
		
		Alumno alumno1 = Aplicacion.getInstance().getAlumnoActual();
		Solicitud sol1 = new Solicitud("Hola soy "+alumno1.getNombre()+" "+alumno1.getApellidos()+"y quiero inscribirme en su asignatura", alumno1, edyl);
		alumno1.enviarSolicitud(sol1);
		
		Aplicacion.getInstance().logOut();
		Aplicacion.getInstance().logIn("1289", "JoA");
		
		Alumno alumno2 = Aplicacion.getInstance().getAlumnoActual();
		Solicitud sol2 = new Solicitud("Hola soy "+alumno2.getNombre()+" "+alumno2.getApellidos()+"y quiero inscribirme en su asignatura", alumno2, edyl);
		alumno2.enviarSolicitud(sol2);
		
		Aplicacion.getInstance().logOut();
		
		
		Aplicacion.getInstance().logIn("1258", "anuel.Bl");
		
		Alumno alumno3 = Aplicacion.getInstance().getAlumnoActual();
		Solicitud sol3 = new Solicitud("Hola soy "+alumno3.getNombre()+" "+alumno3.getApellidos()+"y quiero inscribirme en su asignatura", alumno3, edyl);
		alumno3.enviarSolicitud(sol3);
		
		Aplicacion.getInstance().logOut();	
		
		Aplicacion.getInstance().logIn("profesor", "profesor");
		System.out.println(sol1);
		edyl.aceptarSolicitud(sol1);
		
		System.out.println(sol2);
		edyl.aceptarSolicitud(sol2);
		
		System.out.println(sol3);
		edyl.aceptarSolicitud(sol3);
		
		Aplicacion.getInstance().logOut();
		Aplicacion.getInstance().logIn("1264", "s.ll");
		
		Resolucion res = new Resolucion (test1_edyl, alumno1);
		
		for (Pregunta p : test1_edyl.getPreguntas()){
			if (p instanceof OpcionUnica || p instanceof OpcionMultiple || p instanceof SiNo){
				Opcion seleccionada = new Opcion("10^4",true);
				p.responderPregunta(res, seleccionada,"");
			} else {
				p.responderPregunta(res,null, "(respuesta)");
			}
			
		}
		System.out.println(res);
		
		
		Aplicacion.getInstance().logIn("1289", "JoA");
		
		Resolucion res2 = new Resolucion (test1_edyl, alumno2);
		
		for (Pregunta p : test1_edyl.getPreguntas()){
			if (p instanceof OpcionUnica || p instanceof OpcionMultiple || p instanceof SiNo){
				Opcion seleccionada = new Opcion("10^3",false);
				p.responderPregunta(res2, seleccionada,"");
			} else {
				p.responderPregunta(res2,null, "(respuesta)");
			}
			
		}
		System.out.println(res2);
		
		
		Aplicacion.getInstance().logIn("1258", "anuel.B1");
		
		Resolucion res3 = new Resolucion (test1_edyl, alumno3);
		
		for (Pregunta p : test1_edyl.getPreguntas()){
			if (p instanceof OpcionUnica || p instanceof OpcionMultiple || p instanceof SiNo){
				p.responderPregunta(res3, null, "");
			} else {
				p.responderPregunta(res3, null, "(respuesta)");
			}
			
		}
		System.out.println(res3);
		
		Aplicacion.getInstance().logOut();
		Aplicacion.getInstance().logIn("profesor","profesor");
		
		for (Resolucion resolution :test1_edyl.getResoluciones()){
			resolution.calcularNota();
			System.out.println(resolution);
		}
		
		System.out.println("\n" + edyl.calcularNotaAsig(alumno1));
		System.out.println(edyl.calcularNotaAsig(alumno2));
		System.out.println(edyl.calcularNotaAsig(alumno3));
		
		Aplicacion.getInstance().logOut();
		
		Aplicacion.getInstance().load();
		System.out.println("Asignaturas");
		for (Asignatura asig:Aplicacion.getInstance().getAsignaturas()){
			System.out.println("  "+asig);
		}
		
		System.out.println(edyl.getSolicitudes());
	}

}
