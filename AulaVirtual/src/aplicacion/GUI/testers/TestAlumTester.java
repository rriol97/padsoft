package aplicacion.GUI.testers;

import java.time.LocalDate;

import javax.swing.JFrame;

import aplicacion.GUI.alumno.PanelTestAlum;
import aplicacion.clases.Asignatura;
import aplicacion.clases.elemento.test.Opcion;
import aplicacion.clases.elemento.test.OpcionUnica;
import aplicacion.clases.elemento.test.PreguntaOpcion;
import aplicacion.clases.elemento.test.Test;

public class TestAlumTester {
	
	public static void main (String[] args) {
		Asignatura edyl = new Asignatura("EDyL");
		Test test1_edyl = new Test("Prueba1", true, edyl, "Este examen tendra 1 pregunta de diferentes tipos. Las preguntas tipo test bajaran nota en el caso de que se falle y no puntuan si se dejan en blanco.", LocalDate.now().plusDays(3), LocalDate.now().plusDays(5), true , 30, 1);	
		
		PreguntaOpcion p1 = new OpcionUnica("Cuantas posibles contrasenas se pueden hacer, si la contrasena es 4 digitos y solo se utilizan los numeros del 1 al 10", 1, 0.5,1);
		test1_edyl.anadirPregunta(p1);
		
		Opcion opcion_p11 = new Opcion (1, "10^3", false);
		p1.anadirOpcion(opcion_p11);
		
		Opcion opcion_p12 = new Opcion (2, "10^4", true);
		p1.anadirOpcion(opcion_p12);
		
		Opcion opcion_p13 = new Opcion (3, "10^2", false);
		p1.anadirOpcion(opcion_p13);
		
		JFrame f = new JFrame();
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setSize(500, 500);
		f.add(new PanelTestAlum(test1_edyl));
		f.setVisible(true);
	}
}
