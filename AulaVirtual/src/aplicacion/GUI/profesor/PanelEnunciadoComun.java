package aplicacion.GUI.profesor;

import java.awt.Font;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.SpringLayout;

import aplicacion.GUI.SpringUtilities;
import aplicacion.GUI.general.Frame;
import aplicacion.clases.elemento.test.Test;

public class PanelEnunciadoComun extends JPanel {

	private static final long serialVersionUID = 1L;
	private JLabel enun;
	private JTextArea enunciado;
	private JComboBox<String> tipo;
	private JButton anadir;
	private JButton cancelar;
	private JButton aceptar;
	
	public PanelEnunciadoComun(Test t){
		SpringLayout layout = new SpringLayout();
		this.setLayout(layout);
		
		JPanel preg = new JPanel();
		SpringLayout layoutAna = new SpringLayout();
		preg.setLayout(layoutAna);
		this.anadir = new JButton ("Añadir Pregunta");
		//this.anadir.addActionListener(new ActionAnadirPregunta(test));
		preg.add(this.anadir);
		preg.setVisible(true);
		
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
		
		String[]tiposPreg = {"Respuesta única","Respuesta múltiple","Si/No","Respuesta Corta"};
		this.tipo = new JComboBox<String>(tiposPreg);
		
		JPanel panel_botones = new JPanel();
		this.cancelar = new JButton ("Cancelar");
		this.aceptar = new JButton ("Aceptar");
		panel_botones.setLayout(new BoxLayout(panel_botones, 0));
		panel_botones.add(cancelar);
		panel_botones.add(aceptar);	
		
		this.add(preg);
		this.add(panelEnun);
		this.add(tipo);
		this.add(panel_botones);
		SpringUtilities.makeCompactGrid(this, 4, 1, 5, 5, 5, 5);
		this.setVisible(true);
	}
	
	public String getEnunciado(){
		return this.enunciado.getText();
	}
	
	public String getTipoPreg(){
		return (String) this.tipo.getSelectedItem();
	}
}
