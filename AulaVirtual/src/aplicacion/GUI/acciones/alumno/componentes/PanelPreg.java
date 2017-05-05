package aplicacion.GUI.acciones.alumno.componentes;

import java.util.ArrayList;
import java.util.List;

import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.SpringLayout;

import aplicacion.GUI.acciones.alumno.ActionSeleccionOpc;
import aplicacion.GUI.acciones.alumno.ActionSeleccionOpcM;
import aplicacion.clases.elemento.test.Opcion;
import aplicacion.clases.elemento.test.OpcionMultiple;
import aplicacion.clases.elemento.test.Pregunta;
import aplicacion.clases.elemento.test.PreguntaOpcion;
import aplicacion.clases.elemento.test.RespuestaLibre;

/**
 * Clase que implementa un panel auxiliar. Muestra una pregunta. Utilizada en PanelTestAlum.
 * @author Adrian Fernandez
 * @author Ricardo Riol
 *
 */
public class PanelPreg extends JPanel {
	private static final long serialVersionUID = 1L;
	
	private Pregunta pregunta;
	private List <Opcion> seleccionadas;
	JTextField respuesta;

	public PanelPreg (Pregunta p) {
		this.pregunta = p;
		this.seleccionadas = new ArrayList<Opcion>();
		SpringLayout l = new SpringLayout();
		this.setLayout(l);
		
		JLabel etiqueta_enunciado = new JLabel (p.getEnunciado());
		this.add(etiqueta_enunciado);
		
		JPanel panel_opcion = new JPanel();
		panel_opcion.setLayout(new BoxLayout(panel_opcion, 1));
		
		if (p instanceof PreguntaOpcion) {
			PreguntaOpcion po = (PreguntaOpcion)p;
			List <Opcion> opciones = po.getOpciones();
			if(po.isAleatoria()) {
				opciones = po.desordenar();
			}
			if (po instanceof OpcionMultiple) {
				for (Opcion o: opciones) {
					JCheckBox casilla_opcion = new JCheckBox(o.getTexto());
					casilla_opcion.addActionListener(new ActionSeleccionOpcM(this, casilla_opcion, o));
					panel_opcion.add(casilla_opcion);
				}
			} else {
				ButtonGroup grupo_opcion = new ButtonGroup();
				for (Opcion o: opciones) {
					JRadioButton casilla_opcion = new JRadioButton(o.getTexto());
					casilla_opcion.addActionListener(new ActionSeleccionOpc(this, casilla_opcion, o));
					grupo_opcion.add(casilla_opcion);
					panel_opcion.add(casilla_opcion);
				}	
			}
				
		} else if (p instanceof RespuestaLibre) {
			JTextField campo_respuesta = new JTextField();
			panel_opcion.add(campo_respuesta);
			this.respuesta = campo_respuesta;
		}
		
		this.add(panel_opcion);
		l.putConstraint(SpringLayout.NORTH, panel_opcion,5, SpringLayout.SOUTH, etiqueta_enunciado);
		l.putConstraint(SpringLayout.WEST, panel_opcion, 40, SpringLayout.WEST, this);
	}

	public Pregunta getPregunta() {
		return pregunta;
	}
	
	public List<Opcion> getSeleccionadas() {
		return seleccionadas;
	}
	
	public JTextField getRespuesta() {
		return respuesta;
	}
}
