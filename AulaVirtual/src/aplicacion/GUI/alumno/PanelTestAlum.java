package aplicacion.GUI.alumno;

import java.util.List;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SpringLayout;

import aplicacion.GUI.SpringUtilities;
import aplicacion.GUI.acciones.ActionVolverAsig;
import aplicacion.GUI.acciones.alumno.ActionRealizarTest;
import aplicacion.GUI.componentes.PanelPreg;
import aplicacion.clases.Asignatura;
import aplicacion.clases.elemento.test.Pregunta;
import aplicacion.clases.elemento.test.Test;

/**
 * Clase que implementa el panel que se le muestra a un alumno cuando quiere inspeccionar una asignatura.
 * @author Adrian Fernandez
 * @author Ricardo Riol
 *
 */
public class PanelTestAlum extends JPanel {
	private static final long serialVersionUID = 1L;

	private Asignatura asig;
	
	public PanelTestAlum (Test t) {
		this.asig = t.getAsignatura();
		this.setLayout(new SpringLayout());
		
		JLabel etiqueta_nombre = new JLabel (t.getNombre());
		this.add(etiqueta_nombre);
		
		List <Pregunta> preguntas = t.getPreguntas();
		if (t.isAleatorio()) {
			preguntas = t.desordenar();
		}
		
		for (Pregunta p: preguntas) {
			this.add(new PanelPreg(p));
		}
		
		JPanel panel_botones = new JPanel();
		panel_botones.setLayout(new BoxLayout(panel_botones, 0));
		JButton boton_volver = new JButton("Volver");
		boton_volver.addActionListener(new ActionVolverAsig(this.asig));
		panel_botones.add(boton_volver);
		JButton boton_finalizar = new JButton("Finalizar");
		boton_finalizar.addActionListener(new ActionRealizarTest(this));
		panel_botones.add(boton_finalizar);
		this.add(panel_botones);
		
		SpringUtilities.makeCompactGrid(this, t.getPreguntas().size() + 2, 1, 5, 5, 5, 5);
	}
}
