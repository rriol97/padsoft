package aplicacion.GUI.profesor;

import java.awt.Font;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.SpringLayout;

import aplicacion.GUI.SpringUtilities;
import aplicacion.GUI.general.Frame;
import aplicacion.clases.elemento.test.Test;

public abstract class PanelEnunciadoComun extends JPanel {

	private static final long serialVersionUID = 1L;
	protected JLabel enun;
	protected JTextArea enunciado;
	protected JComboBox<String> tipo;
	
	public PanelEnunciadoComun(Test t){
		SpringLayout layout = new SpringLayout();
		this.setLayout(layout);
		
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
		
		this.add(panelEnun);
		this.add(tipo);
		
		SpringUtilities.makeCompactGrid(this, 2, 1, 5, 5, 5, 5);
		this.setVisible(true);
	}
	
	public String getEnunciado(){
		return this.enunciado.getText();
	}
	
	public String getTipoPreg(){
		return (String) this.tipo.getSelectedItem();
	}
}
