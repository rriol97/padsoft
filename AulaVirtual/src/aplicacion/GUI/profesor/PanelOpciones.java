package aplicacion.GUI.profesor;

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
import aplicacion.GUI.acciones.profesor.ActionAceptarOpc;
import aplicacion.GUI.acciones.profesor.ActionCancelarOpc;
import aplicacion.GUI.general.Frame;
import aplicacion.clases.elemento.Tema;
import aplicacion.clases.elemento.test.OpcionUnica;
import aplicacion.clases.elemento.test.Test;

public class PanelOpciones extends JPanel {
	
	private JTextField a;
	private JCheckBox correcta;
	
	public PanelOpciones (OpcionUnica opc){
		this.setLayout(new SpringLayout());
		
		JPanel text = new JPanel();
		text.setVisible(true);
		
		JPanel content = new JPanel();
		SpringLayout lay = new SpringLayout();
		content.setLayout(lay);
		JLabel r = new JLabel("Texto de la opcion");
		r.setFont(new Font("Arial",12,20));
		 a = new JTextField ();
		a.setPreferredSize(new Dimension((int)Frame.WIDTH/2,(int)Frame.HEIGHT/25));
		content.add(a);
		content.add(r);
		lay.putConstraint(SpringLayout.NORTH, a, 6, SpringLayout.SOUTH, r);
		
		JPanel check = new JPanel();
		check.setLayout(new SpringLayout());
		correcta = new JCheckBox ("Respuesta Correcta");
		check.add(correcta);
		check.setVisible(true);
		
		JPanel panel_botones = new JPanel();
		JButton cancelar = new JButton ("Cancelar");
		JButton aceptar = new JButton ("Aceptar");
		panel_botones.setLayout(new BoxLayout(panel_botones, 0));
		panel_botones.add(cancelar); 
		//cancelar.addActionListener(new ActionCancelarOpc(this));
		//aceptar.addActionListener(new ActionAceptarOpc(p,this));
		panel_botones.add(aceptar);
		
		this.add(text);
		this.add(content);
		this.add(check);
		this.add(new JPanel());
		this.add(panel_botones);
		
		 SpringUtilities.makeCompactGrid(this, 5, 1, 5, 5, 5, 5);
		
	}
	
	public String getContent(){
		return this.a.getText();
	}
}
