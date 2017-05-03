package aplicacion.GUI.profesor;

import java.util.List;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SpringLayout;

import aplicacion.GUI.SpringUtilities;
import aplicacion.GUI.acciones.ActionVolverAsig;
import aplicacion.GUI.componentes.PanelPreg;
import aplicacion.clases.elemento.test.Pregunta;
import aplicacion.clases.elemento.test.Test;

public class PanelVisualizarTest extends JPanel {
	private static final long serialVersionUID = 1L;
	
	public PanelVisualizarTest (Test t) {
		this.setLayout(new SpringLayout());
		
		JLabel etiqueta_nombre = new JLabel (t.getNombre());
		this.add(etiqueta_nombre);
		
		List <Pregunta> preguntas = t.getPreguntas();
		if (t.isAleatorio()) {
			preguntas = t.desordenar();
		}
		
		for (Pregunta p: preguntas) {
			PanelPreg pp = new PanelPreg(p);
			this.add(pp);
		}
		
		JButton boton_volver = new JButton("Volver");
		boton_volver.addActionListener(new ActionVolverAsig(t.getAsignatura()));
		this.add(boton_volver);
		
		SpringUtilities.makeCompactGrid(this, t.getPreguntas().size() + 2, 1, 5, 5, 5, 5);
	}
}
