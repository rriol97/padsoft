package aplicacion.GUI.paneles.profesor.test;

import java.awt.Dimension;
import java.awt.Font;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SpringLayout;

import aplicacion.GUI.SpringUtilities;
import aplicacion.GUI.acciones.profesor.test.ActionAceptarOpc;
import aplicacion.GUI.acciones.profesor.test.ActionCancelarOpc;
import aplicacion.GUI.general.Frame;
import aplicacion.clases.elemento.test.PreguntaOpcion;
import aplicacion.clases.elemento.test.Test;

public class PanelOpciones extends JPanel {
	private static final long serialVersionUID = 1L;
	
	private JTextField texto;
	private JCheckBox correcta;
	
	public PanelOpciones (PreguntaOpcion opc, Test t){
		this.setLayout(new SpringLayout());
		
		JPanel text = new JPanel();
		text.setVisible(true);
		
		JPanel content = new JPanel();
		SpringLayout lay = new SpringLayout();
		content.setLayout(lay);
		JLabel r = new JLabel("Texto de la opcion");
		r.setFont(new Font("Arial",12,20));
		texto = new JTextField ();
		texto.setPreferredSize(new Dimension((int)Frame.WIDTH/2,(int)Frame.HEIGHT/25));
		content.add(texto);
		content.add(r);
		lay.putConstraint(SpringLayout.NORTH, texto, 6, SpringLayout.SOUTH, r);
		
		JPanel check = new JPanel();
		check.setLayout(new SpringLayout());
		correcta = new JCheckBox ("Respuesta Correcta");
		check.add(correcta);
		check.setVisible(true);
		
		JPanel panel_botones = new JPanel();
		JButton cancelar = new JButton ("Cancelar");
		cancelar.addActionListener(new ActionCancelarOpc(opc,t));
		JButton aceptar = new JButton ("Aceptar");
		aceptar.addActionListener(new ActionAceptarOpc(this, opc, t));
		panel_botones.setLayout(new BoxLayout(panel_botones, 0));
		panel_botones.add(cancelar);
		panel_botones.add(aceptar);
		
		this.add(text);
		this.add(content);
		this.add(check);
		this.add(new JPanel());
		this.add(panel_botones);
		
		 SpringUtilities.makeCompactGrid(this, 5, 1, 5, 5, 5, 5);
		
	}
	
	public String getContent(){
		return this.texto.getText();
	}
	
	public void setContent(String t){
		this.texto.setText(t);
	}
	
	public void setCorrecta (boolean sel){
		this.correcta.setSelected(sel);
	}
	
	public boolean isCorrecta() {
		return this.correcta.isSelected();
	}
}
