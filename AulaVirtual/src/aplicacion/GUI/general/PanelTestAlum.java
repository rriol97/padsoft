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
		this.setLayout(new BoxLayout(this, 1));
		
		JPanel panel_nombre = new JPanel();
		SpringLayout l1 = new SpringLayout();
		panel_nombre.setLayout(l1);
		JLabel etiqueta_nombre = new JLabel (t.getNombre());
		panel_nombre.add(etiqueta_nombre);
		l1.putConstraint(SpringLayout.NORTH, etiqueta_nombre, 5, SpringLayout.NORTH, panel_nombre);
		l1.putConstraint(SpringLayout.WEST, etiqueta_nombre, 5, SpringLayout.WEST, panel_nombre);
		this.add(panel_nombre);
		
		List <Pregunta> preguntas = t.getPreguntas();
		if (t.isAleatorio()) {
			preguntas = t.desordenar();
		}
		
		for (Pregunta p: preguntas) {
			JPanel panel_pregunta = new JPanel();
			SpringLayout l2 = new SpringLayout();
			panel_pregunta.setLayout(l2);
			
			JLabel etiqueta_enunciado = new JLabel (p.getEnunciado());
			panel_pregunta.add(etiqueta_enunciado);
			l2.putConstraint(SpringLayout.NORTH, etiqueta_enunciado, 10, SpringLayout.NORTH, panel_pregunta);
			l2.putConstraint(SpringLayout.WEST, etiqueta_enunciado, 5, SpringLayout.WEST, panel_pregunta);
			
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
			l2.putConstraint(SpringLayout.NORTH, panel_opcion,5, SpringLayout.SOUTH, etiqueta_enunciado);
			l2.putConstraint(SpringLayout.WEST, panel_opcion, 45, SpringLayout.WEST, panel_pregunta);
			this.add(panel_pregunta);
		}
		
		JPanel panel_botones = new JPanel();
		SpringLayout l3 = new SpringLayout();
		panel_botones.setLayout(l3);
		JButton boton_volver = new JButton("Volver");
		panel_botones.add(boton_volver);
		l3.putConstraint(SpringLayout.NORTH, boton_volver, 5, SpringLayout.NORTH, panel_botones);
		l3.putConstraint(SpringLayout.WEST, boton_volver, 5, SpringLayout.WEST, panel_botones);
		JButton boton_finalizar = new JButton("Finalizar");
		panel_botones.add(boton_finalizar);
		l3.putConstraint(SpringLayout.NORTH, boton_finalizar, 5, SpringLayout.NORTH, panel_botones);
		l3.putConstraint(SpringLayout.WEST, boton_finalizar, 5, SpringLayout.EAST, boton_volver);
		this.add(panel_botones);
	}
}
