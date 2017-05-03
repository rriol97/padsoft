package aplicacion.GUI.profesor;

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

import aplicacion.GUI.SpringUtilities;
<<<<<<< HEAD
=======
import aplicacion.GUI.acciones.ActionVolverAsig;
>>>>>>> refs/remotes/origin/master
import aplicacion.GUI.acciones.ActionVolverAsigDeTest;
import aplicacion.GUI.acciones.profesor.ActionAnadirPregunta;
import aplicacion.GUI.general.Frame;
import aplicacion.clases.elemento.Tema;
import aplicacion.clases.elemento.test.Pregunta;
import aplicacion.clases.elemento.test.Test;

public class PanelAnadirPregunta extends JPanel {

	private static final long serialVersionUID = 1L;
	private JButton finTest;
	private JTextArea enunciado;
	private JComboBox<String> tipo;
	private JButton anadir;
	private JButton cancelar;
	private JButton aceptar;
	private JList<Pregunta> listaPreg;
	
	public PanelAnadirPregunta(Test t,Tema w){
		SpringLayout layout = new SpringLayout();
		this.setLayout(layout);
		
		JPanel preg = new JPanel();
		SpringLayout layoutAna = new SpringLayout();
		preg.setLayout(layoutAna);
		this.anadir = new JButton ("A�adir Pregunta");
		this.finTest = new JButton ("Finalizar Test");
		this.setPreferredSize(new Dimension ((int)Frame.WIDTH/10, (int)Frame.HEIGHT/8));
		this.setPreferredSize(new Dimension ((int)Frame.WIDTH/6, (int)Frame.HEIGHT/4));
		preg.add(this.anadir);
		preg.add(this.finTest);
		layoutAna.putConstraint(SpringLayout.WEST, this.finTest, 10, SpringLayout.EAST, this.anadir);
		preg.setVisible(true);
		/**
		JPanel panelEnun = new JPanel();
		SpringLayout layoutEn = new SpringLayout();
		this.setLayout(layoutEn);
		this.enun = new JLabel("Enunciado");
		this.enun.setFont(new Font("Arial",12,18));
		panelEnun.add(this.enun);
		this.enunciado = new JTextArea();
		this.enunciado.setLineWrap(true);
		panelEnun.add(this.enunciado);
		
		layoutEn.putConstraint(SpringLayout.WEST, enun,(int) Frame.WIDTH/10,SpringLayout.WEST,this);
		layoutEn.putConstraint(SpringLayout.NORTH, enun,(int) Frame.WIDTH/10,SpringLayout.NORTH,this);
		layoutEn.putConstraint(SpringLayout.NORTH, enunciado,5,SpringLayout.NORTH,enun);
		layoutEn.putConstraint(SpringLayout.WEST, enunciado,(int) Frame.WIDTH/10,SpringLayout.WEST,this);
		*/
		JPanel tipoPreg = new JPanel();
		SpringLayout layoutPreg = new SpringLayout();
		tipoPreg.setLayout(layoutPreg);
		String[]tiposPreg = {"Respuesta �nica","Respuesta m�ltiple","Si/No","Respuesta Corta"};
		this.tipo = new JComboBox<String>(tiposPreg);
		this.tipo.setPreferredSize(new Dimension ((int)Frame.WIDTH/2,(int)(Frame.HEIGHT/20)));
		tipoPreg.add(this.tipo);
		JLabel r = new JLabel ("Tipo de Pregunta");
		this.setFont(new Font ("Arial",12,18));
		tipoPreg.add(r);
		tipoPreg.setVisible(false);
		layoutPreg.putConstraint(SpringLayout.WEST, this.tipo, (int)Frame.WIDTH/8, SpringLayout.WEST, r);
		
		
		this.anadir.addActionListener(new ActionAnadirPregunta(t, tipoPreg));
		
		
		Pregunta[] preguntas = new Pregunta[t.getPreguntas().size()];
 		int i = 0;
 		for (Pregunta p: t.getPreguntas()) {
 			preguntas[i] = p;
 			i++;
 		}
		
		this.listaPreg = new JList<Pregunta> (preguntas);
		this.listaPreg.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
 		JScrollPane scrolling_Preg = new JScrollPane(this.listaPreg);
 		//scrolling_Preg.setPreferredSize(new Dimension((int)Frame.WIDTH/3,(int)(Frame.HEIGHT)));
		
		JPanel panel_botones = new JPanel();
		this.cancelar = new JButton ("Cancelar");
		this.aceptar = new JButton ("Aceptar");
		panel_botones.setLayout(new BoxLayout(panel_botones, 0));
		panel_botones.add(cancelar); 
		this.cancelar.addActionListener(new ActionVolverAsigDeTest(t,w));
		panel_botones.add(aceptar);	
		
		this.add(preg);
		//this.add(panelEnun);
		this.add(scrolling_Preg);
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
}
