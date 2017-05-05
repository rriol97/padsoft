package aplicacion.GUI.paneles.alumno;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SpringLayout;

import aplicacion.GUI.SpringUtilities;
import aplicacion.GUI.acciones.ActionVolverAsig;
import aplicacion.GUI.paneles.alumno.componentes.PanelResp;
import aplicacion.clases.elemento.test.Test;
import aplicacion.clases.resolucion.Resolucion;
import aplicacion.clases.resolucion.Respuesta;

/**
 * Clase que implementa el panel mostrado cuando un alumno consulta una de sus resoluciones.
 * @author Adrian Fernandez
 * @author Ricardo Riol
 *
 */
public class PanelResAlum extends JPanel {
	private static final long serialVersionUID = 1L;
	
	public PanelResAlum (Resolucion res) {
		this.setLayout(new SpringLayout());
		
		Test t = res.getTest();
		JLabel etiqueta_nombre = new JLabel (t.getNombre());
		this.add(etiqueta_nombre);
		
		for (Respuesta resp: res.getRespuestas()) {
			this.add(new PanelResp(resp));
		}
		
		JButton boton_volver = new JButton("Volver");
		boton_volver.addActionListener(new ActionVolverAsig(t.getAsignatura()));
		this.add(boton_volver);
		
		SpringUtilities.makeCompactGrid(this, t.getPreguntas().size() + 2, 1, 5, 5, 5, 5);
	}
}
