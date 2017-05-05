package aplicacion.GUI.paneles.alumno.componentes;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SpringLayout;

import aplicacion.GUI.SpringUtilities;
import aplicacion.clases.elemento.test.Opcion;
import aplicacion.clases.elemento.test.Pregunta;
import aplicacion.clases.elemento.test.PreguntaOpcion;
import aplicacion.clases.elemento.test.RespuestaLibre;
import aplicacion.clases.resolucion.Resolucion;
import aplicacion.clases.resolucion.Respuesta;

/**
 * Clase que implementa un panel auxiliar. Muestra una respuesta y la solucion de la pregunta respondida. Utilizada en PanelResAlum.
 * @author Adrian Fernandez
 * @author Ricardo Riol
 *
 */
public class PanelSol extends JPanel {
	private static final long serialVersionUID = 1L;

	public PanelSol (Pregunta p, Resolucion res) {
		this.setLayout(new SpringLayout());
		
		for (Respuesta resp: res.getRespuestas()) {
			if (resp.getPregunta().equals(p)) {
				this.add(new PanelResp(resp));
			}
		}
		
		String msg = "Solucion:";
		if (p instanceof PreguntaOpcion) {
			PreguntaOpcion po = (PreguntaOpcion)p;
			for (Opcion o: po.getOpciones()) {
				if (o.isCorrecta()) {
					msg = msg + " " + o.getTexto() + ",";
				}
			}
			
		} else {
			RespuestaLibre rl = (RespuestaLibre)p;
			msg = msg + " " + rl.getSolucion();
		}
		
		JLabel etiqueta_solucion = new JLabel(msg);
		this.add(etiqueta_solucion);
		
		SpringUtilities.makeCompactGrid(this, 2, 1, 0, 0, 5, 5);
	}
}
