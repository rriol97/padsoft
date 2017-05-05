package aplicacion.GUI.paneles.alumno.componentes;

import java.util.List;

import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.SpringLayout;

import aplicacion.clases.elemento.test.Opcion;
import aplicacion.clases.elemento.test.OpcionMultiple;
import aplicacion.clases.elemento.test.Pregunta;
import aplicacion.clases.elemento.test.PreguntaOpcion;
import aplicacion.clases.elemento.test.RespuestaLibre;
import aplicacion.clases.resolucion.Respuesta;

/**
 * Clase que implementa un panel auxiliar. Muestra una respuesta. Utilizada en PanelSol.
 * @author Adrian Fernandez
 * @author Ricardo Riol
 *
 */
public class PanelResp extends JPanel {
	private static final long serialVersionUID = 1L;

	public PanelResp (Respuesta resp) {
		SpringLayout l = new SpringLayout();
		this.setLayout(l);
		
		Pregunta p = resp.getPregunta();
		
		JLabel etiqueta_enunciado = new JLabel (p.getEnunciado());
		this.add(etiqueta_enunciado);
		
		JPanel panel_opcion = new JPanel();
		panel_opcion.setLayout(new BoxLayout(panel_opcion, 1));
		
		if (p instanceof PreguntaOpcion) {
			PreguntaOpcion po = (PreguntaOpcion)p;
			List <Opcion> opciones = po.getOpciones();
			List <Opcion> marcadas = resp.getOpcionesSeleccionadas();
			if (po instanceof OpcionMultiple) {
				for (Opcion o: opciones) {
					JCheckBox casilla_opcion = new JCheckBox(o.getTexto());
					if (marcadas.contains(o)) {
						casilla_opcion.setSelected(true);
					}
					casilla_opcion.setEnabled(false);
					panel_opcion.add(casilla_opcion);
				}
			} else {
				ButtonGroup grupo_opcion = new ButtonGroup();
				for (Opcion o: opciones) {
					JRadioButton casilla_opcion = new JRadioButton(o.getTexto());
					if (marcadas.contains(o)) {
						casilla_opcion.setSelected(true);
					}
					casilla_opcion.setEnabled(false);
					grupo_opcion.add(casilla_opcion);
					panel_opcion.add(casilla_opcion);
				}	
			}
				
		} else if (p instanceof RespuestaLibre) {
			JTextField campo_respuesta = new JTextField();
			campo_respuesta.setText(resp.getRespuesta());
			campo_respuesta.setEnabled(false);
			panel_opcion.add(campo_respuesta);
		}
		
		this.add(panel_opcion);
		l.putConstraint(SpringLayout.NORTH, panel_opcion,5, SpringLayout.SOUTH, etiqueta_enunciado);
		l.putConstraint(SpringLayout.WEST, panel_opcion, 40, SpringLayout.WEST, this);
	}
}
