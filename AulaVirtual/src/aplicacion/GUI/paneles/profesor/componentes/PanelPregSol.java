package aplicacion.GUI.paneles.profesor.componentes;

import java.util.List;

import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.SpringLayout;

import aplicacion.GUI.SpringUtilities;
import aplicacion.clases.elemento.test.Opcion;
import aplicacion.clases.elemento.test.OpcionMultiple;
import aplicacion.clases.elemento.test.Pregunta;
import aplicacion.clases.elemento.test.PreguntaOpcion;
import aplicacion.clases.elemento.test.RespuestaLibre;

public class PanelPregSol extends JPanel {
	private static final long serialVersionUID = 1L;

	public PanelPregSol (Pregunta p) {
		SpringLayout l = new SpringLayout();
		this.setLayout(l);
		
		JLabel etiqueta_enunciado = new JLabel (p.getEnunciado());
		this.add(etiqueta_enunciado);
		
		JPanel panel_opcion = new JPanel();
		panel_opcion.setLayout(new BoxLayout(panel_opcion, 1));
		
		if (p instanceof PreguntaOpcion) {
			PreguntaOpcion po = (PreguntaOpcion)p;
			List <Opcion> opciones = po.getOpciones();
			List <Opcion> correctas = po.getCorrectas();
			if (po instanceof OpcionMultiple) {
				for (Opcion o: opciones) {
					JCheckBox casilla_opcion = new JCheckBox(o.getTexto());
					if (correctas.contains(o)) {
						casilla_opcion.setSelected(true);
					}
					casilla_opcion.setEnabled(false);
					panel_opcion.add(casilla_opcion);
				}
			} else {
				ButtonGroup grupo_opcion = new ButtonGroup();
				for (Opcion o: opciones) {
					JRadioButton casilla_opcion = new JRadioButton(o.getTexto());
					if (correctas.contains(o)) {
						casilla_opcion.setSelected(true);
					}
					casilla_opcion.setEnabled(false);
					grupo_opcion.add(casilla_opcion);
					panel_opcion.add(casilla_opcion);
				}	
			}
				
		} else if (p instanceof RespuestaLibre) {
			RespuestaLibre rl = (RespuestaLibre)p;
			JTextField campo_respuesta = new JTextField();
			campo_respuesta.setText(rl.getSolucion());
			campo_respuesta.setEnabled(false);
			panel_opcion.add(campo_respuesta);
		}
		
		this.add(panel_opcion);
		
		JPanel panel_porcentajes = new JPanel();
		panel_porcentajes.setLayout(new SpringLayout());
		
		double aciertos = p.getPorcentajeAciertos();
		JLabel etiqueta_aciertos = new JLabel("Porcentaje de aciertos: " + aciertos + "%");
		panel_porcentajes.add(etiqueta_aciertos);
		double fallos = p.getPorcentajeFallos();
		JLabel etiqueta_fallos = new JLabel("Porcentaje de fallos: " + fallos + "%");
		panel_porcentajes.add(etiqueta_fallos);
		double nsnc = p.getPorcentajeNsnc();
		JLabel etiqueta_nsnc = new JLabel("Porcentaje de ns/nc: " + nsnc + "%");
		panel_porcentajes.add(etiqueta_nsnc);
		
		SpringUtilities.makeGrid(panel_porcentajes, 3, 1, 0, 0, 5, 5);
		this.add(panel_porcentajes);
		
		l.putConstraint(SpringLayout.NORTH, panel_opcion, 5, SpringLayout.SOUTH, etiqueta_enunciado);
		l.putConstraint(SpringLayout.WEST, panel_opcion, 40, SpringLayout.WEST, this);
		
		l.putConstraint(SpringLayout.WEST, panel_porcentajes, 20, SpringLayout.EAST, panel_opcion);
	}
}
