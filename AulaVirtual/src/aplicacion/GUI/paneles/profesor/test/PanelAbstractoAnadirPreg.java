package aplicacion.GUI.paneles.profesor.test;

import java.awt.Dimension;
import java.awt.Font;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import javax.swing.SpringLayout;
import aplicacion.GUI.SpringUtilities;
import aplicacion.GUI.acciones.profesor.test.ActionFinTest;
import aplicacion.GUI.frame.Frame;
import aplicacion.clases.elemento.test.Pregunta;
import aplicacion.clases.elemento.test.Test;

/**
 * Clase que implementa el panel en el que se anaden y se modifican preguntas las de un test.
 * @author Adrian Fernandez
 * @author Ricardo Riol
 *
 */
public abstract class PanelAbstractoAnadirPreg extends JPanel{
	private static final long serialVersionUID = 1L;
	protected JComboBox<String> tipo;
	protected JList<Pregunta> listaPreg;
	protected JButton anadir;
	protected JButton modificar;
	protected JButton eliminar;
	protected JButton cancelar;
	
	public PanelAbstractoAnadirPreg(Test t){
		SpringLayout layout = new SpringLayout();
		this.setLayout(layout);
		this.setPreferredSize(new Dimension ((int)Frame.WIDTH/6, (int)Frame.HEIGHT/4));
		
		JPanel panel_tipoPreg = new JPanel();
		panel_tipoPreg.setLayout(new SpringLayout());
		
		JLabel etiqueta_tipo = new JLabel ("Elija tipo de pregunta:");
		this.setFont(new Font ("Arial",12,18));
		panel_tipoPreg.add(new JPanel());
		panel_tipoPreg.add(etiqueta_tipo);
		
		
		String[]tiposPreg = {"Respuesta unica","Respuesta multiple","Si/No","Respuesta Corta"};
		this.tipo = new JComboBox<String>(tiposPreg);
		this.tipo.setPreferredSize(new Dimension ((int)Frame.WIDTH/2,(int)(Frame.HEIGHT/40)));
		panel_tipoPreg.add(this.tipo);
		
		anadir = new JButton ("Anadir Pregunta");
		panel_tipoPreg.add(anadir);
		
		SpringUtilities.makeCompactGrid(panel_tipoPreg, 4, 1, 0, 0, 5, 5);
		this.add(panel_tipoPreg);
		
		JPanel aux = new JPanel();
 		aux.setLayout(new SpringLayout());
 		
 		JLabel etiqueta_preguntas = new JLabel("Listado de Preguntas");
 		aux.add(etiqueta_preguntas);
		
		Pregunta[] preguntas = new Pregunta[t.getPreguntas().size()];
 		int i = 0;
 		for (Pregunta p: t.getPreguntas()) {
 			preguntas[i] = p;
 			i++;
 		}
 		
		this.listaPreg = new JList<Pregunta> (preguntas);
		this.listaPreg.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
 		JScrollPane scrolling_preg = new JScrollPane(this.listaPreg);
 		scrolling_preg.setPreferredSize(new Dimension((int)Frame.WIDTH/2,(int)(Frame.HEIGHT/5)));
 		aux.add(scrolling_preg);
 		
 		SpringUtilities.makeCompactGrid(aux, 2, 1, 0, 0, 5, 5);
 		
 		JPanel panel_preg = new JPanel();
 		panel_preg.setLayout(new SpringLayout());
		
 		JPanel panel_botones1 = new JPanel();
 		panel_botones1.setLayout(new BoxLayout(panel_botones1, 1));
 		
		modificar = new JButton ("Modificar Pregunta");
		panel_botones1.add(modificar);
		eliminar = new JButton ("Eliminar Pregunta");
		panel_botones1.add(eliminar);
		
		panel_preg.add(aux);
		panel_preg.add(panel_botones1);
		SpringUtilities.makeCompactGrid(panel_preg, 1, 2, 0, 0, 5, 5);
		this.add(panel_preg);
		
		JPanel panel_botones2 = new JPanel();
		panel_botones2.setLayout(new BoxLayout(panel_botones2, 0));
		cancelar = new JButton ("Cancelar");
		panel_botones2.add(cancelar);
		JButton finalizar = new JButton ("Finalizar");
		finalizar.addActionListener(new ActionFinTest(t));
		panel_botones2.add(finalizar);
		
		this.add(panel_botones2);
		
		SpringUtilities.makeCompactGrid(this,3, 1, 5, 5, 5, 5);
 		
	}
	
	public String getTipoPreg(){
		return (String) this.tipo.getSelectedItem();
	}

	public Pregunta getSeleccionada() {
		return this.listaPreg.getSelectedValue();
	}
	
	
}
