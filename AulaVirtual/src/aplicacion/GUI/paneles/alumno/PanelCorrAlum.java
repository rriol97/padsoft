package aplicacion.GUI.paneles.alumno;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SpringLayout;

import aplicacion.GUI.SpringUtilities;
import aplicacion.GUI.acciones.ActionVolverAsig;
import aplicacion.GUI.paneles.alumno.componentes.PanelSol;
import aplicacion.clases.elemento.test.Pregunta;
import aplicacion.clases.elemento.test.Test;
import aplicacion.clases.resolucion.Resolucion;

/**
 * Clase que implementa el panel mostrado cuando un alumno accede a la correccion de un test.
 * @author Adrian Fernandez
 * @author Ricardo Riol
 *
 */
public class PanelCorrAlum extends JPanel {
	private static final long serialVersionUID = 1L;
	
	public PanelCorrAlum (Resolucion res) {
		this.setLayout(new SpringLayout());
		
		Test t = res.getTest();
		JLabel etiqueta_nombre = new JLabel (t.getNombre());
		this.add(etiqueta_nombre);
		
		for (Pregunta p: t.getPreguntas()) {
			this.add(new PanelSol(p, res));
		}
		
		JLabel etiqueta_nota = new JLabel("Nota: " + res.getNota());
		this.add(etiqueta_nota);
		
		JButton boton_volver = new JButton("Volver");
		boton_volver.addActionListener(new ActionVolverAsig(t.getAsignatura()));
		this.add(boton_volver);
		
		SpringUtilities.makeCompactGrid(this, t.getPreguntas().size() + 3, 1, 5, 5, 5, 5);
	}
}
