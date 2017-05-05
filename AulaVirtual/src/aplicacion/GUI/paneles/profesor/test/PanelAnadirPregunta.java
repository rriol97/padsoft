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
import javax.swing.JTextArea;
import javax.swing.ListSelectionModel;
import javax.swing.SpringLayout;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import aplicacion.GUI.SpringUtilities;
import aplicacion.GUI.acciones.ActionVolverAsigDeTest;
import aplicacion.GUI.acciones.profesor.test.ActionFinTest;
import aplicacion.GUI.acciones.profesor.test.ActionNuevaPreg;
import aplicacion.GUI.general.Frame;
import aplicacion.clases.elemento.test.Pregunta;
import aplicacion.clases.elemento.test.SiNo;
import aplicacion.clases.elemento.test.Test;

public class PanelAnadirPregunta extends JPanel implements ListSelectionListener {

	private static final long serialVersionUID = 1L;
	private Test t;
	private JButton finTest;
	private JTextArea enunciado;
	private JComboBox<String> tipo;
	private JButton anadir;
	private JButton cancelar;
	private JList<Pregunta> listaPreg;
	
	public PanelAnadirPregunta(Test t){
		SpringLayout layout = new SpringLayout();
		this.setLayout(layout);
		this.t = t;
		
		JPanel preg = new JPanel();
		SpringLayout layoutAna = new SpringLayout();
		preg.setLayout(layoutAna);
		this.anadir = new JButton ("Anadir Pregunta");
		this.finTest = new JButton ("Finalizar Test");
		this.setPreferredSize(new Dimension ((int)Frame.WIDTH/10, (int)Frame.HEIGHT/8));
		this.setPreferredSize(new Dimension ((int)Frame.WIDTH/6, (int)Frame.HEIGHT/4));
		preg.add(this.anadir);
		preg.add(this.finTest);
		layoutAna.putConstraint(SpringLayout.WEST, this.finTest, 10, SpringLayout.EAST, this.anadir);
		preg.setVisible(true);

		JPanel tipoPreg = new JPanel();
		SpringLayout layoutPreg = new SpringLayout();
		tipoPreg.setLayout(layoutPreg);
		String[]tiposPreg = {"Respuesta unica","Respuesta multiple","Si/No","Respuesta Corta"};
		this.tipo = new JComboBox<String>(tiposPreg);
		this.tipo.setPreferredSize(new Dimension ((int)Frame.WIDTH/2,(int)(Frame.HEIGHT/20)));
		tipoPreg.add(this.tipo);
		JLabel r = new JLabel ("Tipo de Pregunta");
		this.setFont(new Font ("Arial",12,18));
		tipoPreg.add(r);
		layoutPreg.putConstraint(SpringLayout.WEST, this.tipo, (int)Frame.WIDTH/8, SpringLayout.WEST, r);
		
		
		this.anadir.addActionListener(new ActionNuevaPreg(t, this));
		this.finTest.addActionListener(new ActionFinTest(t));
		
		
		Pregunta[] preguntas = new Pregunta[t.getPreguntas().size()];
 		int i = 0;
 		for (Pregunta p: t.getPreguntas()) {
 			preguntas[i] = p;
 			i++;
 		}
		
 		JPanel aux = new JPanel();
 		SpringLayout lay = new SpringLayout();
 		aux.setLayout(lay);
		this.listaPreg = new JList<Pregunta> (preguntas);
		this.listaPreg.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
 		JScrollPane scrolling_Preg = new JScrollPane(this.listaPreg);
 		JLabel listPreg = new JLabel("Listado de Preguntas");
 		aux.add(listPreg);
 		aux.add(scrolling_Preg);
 		scrolling_Preg.setPreferredSize(new Dimension((int)Frame.WIDTH/2,(int)(Frame.HEIGHT/5)));
 		lay.putConstraint(SpringLayout.NORTH, scrolling_Preg, 10, SpringLayout.SOUTH, listPreg);
 		listaPreg.addListSelectionListener(this);
		
		JPanel panel_botones = new JPanel();
		this.cancelar = new JButton ("Cancelar");
		panel_botones.setLayout(new BoxLayout(panel_botones, 0));
		panel_botones.add(cancelar); 
		this.cancelar.addActionListener(new ActionVolverAsigDeTest(t));
		
		this.add(preg);
		//this.add(panelEnun);
		this.add(aux);
		this.add(tipoPreg);
		this.add(panel_botones);
		SpringUtilities.makeCompactGrid(this,4, 1, 5, 5, 5, 5);
		this.setVisible(true);
	}
	
	public String getEnunciado(){
		return this.enunciado.getText();
	}
	
	public String getTipoPreg(){
		return (String) this.tipo.getSelectedItem();
	}

	@Override
	public void valueChanged(ListSelectionEvent e) {
		Pregunta p = this.listaPreg.getSelectedValue();
		if (p instanceof SiNo){
			Frame.getIntance().cambiarPanel(new PanelPregSiNo(this.t), 1);
			this.t.eliminarPregunta(p);
		}
	}
}
