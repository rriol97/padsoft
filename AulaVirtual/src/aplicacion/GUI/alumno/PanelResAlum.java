package aplicacion.GUI.alumno;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SpringLayout;

import aplicacion.GUI.SpringUtilities;
import aplicacion.GUI.componentes.PanelPreg;
import aplicacion.GUI.componentes.PanelSol;
import aplicacion.clases.elemento.test.Pregunta;
import aplicacion.clases.elemento.test.Test;
import aplicacion.clases.resolucion.Resolucion;
import es.uam.eps.padsof.emailconnection.FailedInternetConnectionException;
import es.uam.eps.padsof.emailconnection.InvalidEmailAddressException;

/**
 * Clase que implementa el panel mostrado cuando un alumno consulta una de sus resoluciones.
 * @author Adrian Fernandez
 * @author Ricardo Riol
 *
 */
public class PanelResAlum extends JPanel {
	private static final long serialVersionUID = 1L;
	
	public PanelResAlum (Resolucion res) throws InvalidEmailAddressException, FailedInternetConnectionException {
		this.setLayout(new SpringLayout());
		
		Test t = res.getTest();
		JLabel etiqueta_nombre = new JLabel (t.getNombre());
		this.add(etiqueta_nombre);
		
		if (t.isFechaValida()) {
			// TODO intentar implementarlo en otro sitio
			res.calcularNota();
			for (Pregunta p: t.getPreguntas()) {
				this.add(new PanelSol(p, res));
			}
		} else {
			for (Pregunta p: t.getPreguntas()) {
				this.add(new PanelPreg(p));
			}
		}
		
		JButton boton_volver = new JButton("Volver");
		this.add(boton_volver);
		
		SpringUtilities.makeCompactGrid(this, t.getPreguntas().size() + 2, 1, 5, 5, 5, 5);
	}
}
