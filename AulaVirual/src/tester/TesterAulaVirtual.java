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

public class TesterAulaVirtual {

	public static void main(String[] args) throws IOException, ClassNotFoundException {
		
		Aplicacion.getInstance().leerAlumnosDeFichero("alumnos.txt");
		
		for (Alumno alum : Aplicacion.getInstance().getAlumnos()){
			System.out.println(alum);
		}
		
		System.out.println(Aplicacion.getInstance().logIn("profesor","profesor"));
		
		Asignatura cirel = new Asignatura("CIREL");
		Aplicacion.getInstance().anadirAsignatura(cirel);
		Asignatura edyl = new Asignatura("EDyL");
		Aplicacion.getInstance().anadirAsignatura(edyl);
		Asignatura adsoft = new Asignatura("ADSOFT");
		Aplicacion.getInstance().anadirAsignatura(adsoft);
		System.out.println(Aplicacion.getInstance().getAsignaturas());
		
		Aplicacion.getInstance().eliminarAsignatura(cirel);
		System.out.println(Aplicacion.getInstance().getAsignaturas());
		
		Tema tema1_edyl = new Tema("Combinatoria", true, edyl);
		Apuntes apuntes_tema1edyl = new Apuntes ("Introducci�n a la combinatoria", true, "(apuntes de combinatoria)", edyl);
		tema1_edyl.anadirElemento(apuntes_tema1edyl);
		Test test1_edyl = new Test("Prueba1", true, edyl, "Este examen tendr� 10 preguntas de diferentes tipos. Las preguntas tipo test bajar�n nota en el caso de que se falle y no puntur� si se dejan en blanco.", 10, LocalDate.now().plusDays(3), LocalDate.now().plusDays(5), true , 30, 1);
		tema1_edyl.anadirElemento(test1_edyl);
		//Intentar hacer con opcion
		PreguntaOpcion p1 = new OpcionUnica("�Cu�ntas posibles contrase�as se pueden hacer, si la contrase�a es 4 d�gitos y solo se utilizan los n�meros del 1 al 10", 1, 0.5, false);
		Opcion opcion_p11 = new Opcion (1, "10^3", false,false);
		p1.anadirOpcion(opcion_p11);
		Opcion opcion_p12 = new Opcion (2, "10^4", true, false);
		p1.anadirOpcion(opcion_p12);
		Opcion opcion_p13 = new Opcion (3, "10^2", false,false);
		p1.anadirOpcion(opcion_p13);
		test1_edyl.anadirPregunta(p1);
		System.out.println(tema1_edyl);
		
		Aplicacion.getInstance().logOut();
		
		System.out.println(Aplicacion.getInstance().logIn("1264", "s.ll"));
		
		Alumno alum = Aplicacion.getInstance().getAlumnoActual();
		Solicitud sol = new Solicitud("Hola soy"+alum.getNombre()+" "+alum.getApellidos()+"y quiero inscribirme en su asignatura", alum, edyl);
		alum.enviarSolicitud(sol);
		
		Aplicacion.getInstance().logOut();
		
		System.out.println(sol);
		System.out.println(Aplicacion.getInstance().logIn("profesor", "profesor"));
		edyl.aceptarSolicitud(sol);
		
		Aplicacion.getInstance().logOut();
		
		System.out.println(Aplicacion.getInstance().logIn("1264", "s.ll"));
		Alumno alum2 = Aplicacion.getInstance().getAlumnoActual();
		
		Resolucion res = new Resolucion (test1_edyl);
		alum2.anadirResolucion(res);
		
		for (Pregunta p : test1_edyl.getPreguntas()){
			if (p instanceof OpcionUnica || p instanceof OpcionMultiple || p instanceof SiNo){
				Opcion seleccionada = new Opcion(2,"10^4",true,true);
				p.responderPregunta(res, seleccionada,"");
			} else {
				p.responderPregunta(res,null, "(respuesta)");
			}
			
		}
		System.out.println(res);
		
		Aplicacion.getInstance().logOut();
		System.out.println(Aplicacion.getInstance().logIn("profesor","profesor"));
		
		
		for (Resolucion resolution :test1_edyl.getResoluciones()){
			resolution.calcularNota();
			System.out.println(resolution);
		}
		
		Aplicacion.getInstance().logOut();
		
		
	}

}
