package aplicacion.GUI.Profesor;

import java.awt.Dimension;
import java.awt.Font;


import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SpringLayout;

public class PanelCrearAsig extends JPanel {
	
	JLabel texto;
	JTextField campo_asig;
	
	public PanelCrearAsig(){
		SpringLayout layout = new SpringLayout();
		this.setLayout(layout);
		
		this.texto = new JLabel ("Nombre de la asignatura");
		this.texto.setFont(new Font ("Arial",12,18));
		
		this.campo_asig = new JTextField();
		//campo_asig.setPreferredSize(new Dimension((int)Frame.WIDTH/23,(int)Frame.HEIGHT/23));
		
		JButton acp = new JButton("Aceptar");
		JButton c = new JButton ("Cancelar");
		
		
		this.add(texto);
		this.add(campo_asig);
		//this.add(acp);
		this.add(c);
		
		layout.putConstraint(SpringLayout.NORTH,this.texto,200, SpringLayout.NORTH,this);
		layout.putConstraint(SpringLayout.WEST,this.texto,300, SpringLayout.WEST,this);
		layout.putConstraint(SpringLayout.WEST,this.campo_asig,300, SpringLayout.WEST,this);
		layout.putConstraint(SpringLayout.NORTH,this.campo_asig,8, SpringLayout.SOUTH,this.texto);
		layout.putConstraint(SpringLayout.WEST,c,450, SpringLayout.WEST,this);
		layout.putConstraint(SpringLayout.NORTH,this.campo_asig,50, SpringLayout.SOUTH,this.campo_asig);
		
		this.setVisible(true);
		
	}
	
	public String getNombreAsig(){
		return this.campo_asig.getText();
	}
}
