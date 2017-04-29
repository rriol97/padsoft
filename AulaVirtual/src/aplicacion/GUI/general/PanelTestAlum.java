package aplicacion.GUI.general;

import java.util.List;

import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
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
import aplicacion.clases.elemento.test.Test;

public class PanelTestAlum extends JPanel {
	private static final long serialVersionUID = 1L;

	public PanelTestAlum (Test t) {
		SpringLayout l = new SpringLayout();
		this.setLayout(l);
		
		JLabel etiqueta_nombre = new JLabel (t.getNombre());
		this.add(etiqueta_nombre);
		l.putConstraint(SpringLayout.NORTH, etiqueta_nombre, 10, SpringLayout.NORTH, this);
		l.putConstraint(SpringLayout.WEST, etiqueta_nombre, 10, SpringLayout.WEST, this);
		
		List <Pregunta> preguntas = t.getPreguntas();
		if (t.isAleatorio()) {
			preguntas = t.desordenar();
		}
		
		JPanel panel_preguntas = new JPanel();
		panel_preguntas.setLayout(new BoxLayout(panel_preguntas, 1));
		
		for (Pregunta p: preguntas) {
			JPanel panel_pregunta = new JPanel();
			SpringLayout layout = new SpringLayout();
			panel_pregunta.setLayout(layout);
			
			JLabel etiqueta_enunciado = new JLabel (p.getEnunciado());
			panel_pregunta.add(etiqueta_enunciado);
			layout.putConstraint(SpringLayout.NORTH, etiqueta_enunciado, 10, SpringLayout.NORTH, panel_pregunta);
			
			JPanel panel_opcion = new JPanel();
			panel_opcion.setLayout(new BoxLayout(panel_opcion, 1));
			
			if (p instanceof PreguntaOpcion) {
				PreguntaOpcion po = (PreguntaOpcion)p;
				List <Opcion> opciones = po.getOpciones();
				if(po.isAleatoria()) {
					/*opciones = po.desordenar();*/
				}
				if (po instanceof OpcionMultiple) {
					for (Opcion o: opciones) {
						JCheckBox casilla_opcion = new JCheckBox(o.getTexto());
						panel_opcion.add(casilla_opcion);
					}
				} else {
					ButtonGroup grupo_opcion = new ButtonGroup();
					for (Opcion o: opciones) {
						JRadioButton casilla_opcion = new JRadioButton(o.getTexto());
						grupo_opcion.add(casilla_opcion);
						panel_opcion.add(casilla_opcion);
					}	
				}
					
			} else if (p instanceof RespuestaLibre) {
				JTextField campo_respuesta = new JTextField();
				panel_opcion.add(campo_respuesta);
			}
			
			panel_pregunta.add(panel_opcion);
			layout.putConstraint(SpringLayout.NORTH, panel_opcion,5, SpringLayout.SOUTH, etiqueta_enunciado);
			layout.putConstraint(SpringLayout.WEST, panel_opcion, 40, SpringLayout.WEST, panel_pregunta);
			panel_preguntas.add(panel_pregunta);
		}
		
		this.add(panel_preguntas);
		l.putConstraint(SpringLayout.NORTH, panel_preguntas, 10, SpringLayout.SOUTH, etiqueta_nombre);
		l.putConstraint(SpringLayout.WEST, panel_preguntas, 10, SpringLayout.WEST, this);
		
		
		JPanel panel_botones = new JPanel();
		panel_botones.setLayout(new BoxLayout(panel_botones, 0));
		JButton boton_volver = new JButton("Volver");
		panel_botones.add(boton_volver);
		JButton boton_finalizar = new JButton("Finalizar");
		panel_botones.add(boton_finalizar);
		this.add(panel_botones);
		l.putConstraint(SpringLayout.NORTH, panel_botones, -10, SpringLayout.SOUTH, panel_preguntas);
		l.putConstraint(SpringLayout.WEST, panel_botones, 10, SpringLayout.WEST, this);
	}
}
