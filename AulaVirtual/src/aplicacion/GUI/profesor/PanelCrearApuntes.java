package aplicacion.GUI.profesor;

import java.awt.Dimension;
import java.awt.Font;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SpringLayout;

import aplicacion.GUI.SpringUtilities;
import aplicacion.GUI.acciones.ActionVolverAsig;
import aplicacion.GUI.acciones.profesor.ActionCrearApuntes;
import aplicacion.GUI.general.Frame;
import aplicacion.clases.Asignatura;

/**
 * 
 * @author Ricardo Riol y Adrián Fernández
 * Clase que implementa el panel de la creacion de apuntes desde el punto de vista del profesor
 */

public class PanelCrearApuntes extends JPanel {
	private static final long serialVersionUID = 1L;
	private JLabel titulo;
	private JTextField titApuntes;
	private JTextArea apuntes;
	private JComboBox<String> visibilidad;
	private JButton c;
	private JButton acp;
	
	public PanelCrearApuntes(Asignatura asig){
		
		this.setLayout(new SpringLayout());
		
		JPanel aux = new JPanel();
		SpringLayout layout = new SpringLayout();
		aux.setLayout(layout);
		this.titulo = new JLabel("Nombre");
		this.titulo.setFont(new Font("Arial",12,18));
		this.titApuntes = new JTextField();
		this.titApuntes.setPreferredSize(new Dimension((int)Frame.WIDTH/4,(int)Frame.HEIGHT/14));
		String[]visi = {"Visible", "No visible"};
		this.visibilidad = new JComboBox<String>(visi);
		this.visibilidad.setPreferredSize(new Dimension((int)Frame.WIDTH/4,(int)Frame.HEIGHT/25));
		aux.add(this.titulo);
		aux.add(this.titApuntes);
		aux.add(this.visibilidad);
		layout.putConstraint(SpringLayout.NORTH,this.titulo,(int) Frame.HEIGHT/30 ,SpringLayout.NORTH, this);
		layout.putConstraint(SpringLayout.WEST,this.titulo,0 ,SpringLayout.WEST,this);
		layout.putConstraint(SpringLayout.NORTH,this.titApuntes,(int) Frame.HEIGHT/15,SpringLayout.NORTH, this);
		layout.putConstraint(SpringLayout.WEST,this.titApuntes,0,SpringLayout.WEST,this.titulo);
		layout.putConstraint(SpringLayout.WEST,this.visibilidad,0,SpringLayout.WEST,this);
		layout.putConstraint(SpringLayout.NORTH,this.visibilidad,5,SpringLayout.SOUTH,this.titApuntes);
		aux.setVisible(true);
		
		JPanel panel_botones = new JPanel();
		this.c = new JButton ("Cancelar");
		this.acp = new JButton ("Aceptar");
		panel_botones.setLayout(new BoxLayout(panel_botones, 0));
		panel_botones.add(c);
		c.addActionListener(new ActionVolverAsig(asig));
		panel_botones.add(acp);
		acp.addActionListener(new ActionCrearApuntes(asig,this));
		
		
		this.apuntes = new JTextArea();
		this.apuntes.setLineWrap(true);
		
		this.add(aux);
		this.add(this.apuntes);
		this.add(panel_botones);
		
		SpringUtilities.makeCompactGrid(this, 3, 1, 5, 5, 5, 5);
		this.setVisible(true);
		
	}
	
	public String getTitulo(){
		return this.titApuntes.getText();
	}
	
	public String getContenido(){
		return this.apuntes.getText();
	}
	
	public String getSelec(){
		return (String) this.visibilidad.getSelectedItem();
	}
}
