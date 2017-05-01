package aplicacion.GUI.profesor;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SpringLayout;

import aplicacion.GUI.SpringUtilities;
import aplicacion.GUI.acciones.ActionVolverAsig;
import aplicacion.GUI.acciones.profesor.ActionCrearTema;
import aplicacion.GUI.acciones.profesor.ActionEle;
import aplicacion.GUI.general.Frame;
import aplicacion.clases.Asignatura;

	public class PanelCrearTema extends JPanel {
		private static final long serialVersionUID = 1L;
		private JLabel nombre;
		private JComboBox<String> visibilidad;
		private JTextField text;
		private JButton cancelar;
		private JButton aceptar;
		
		public PanelCrearTema(Asignatura asig){
			this.setLayout(new SpringLayout());
			JPanel aux = new JPanel();
			SpringLayout layout = new SpringLayout();
			aux.setLayout(layout);
			this.nombre = new JLabel("Nombre");
			this.nombre.setFont(new Font("Arial",12,18));
			this.text = new JTextField();
			this.text.setPreferredSize(new Dimension((int)Frame.WIDTH/4,(int)Frame.HEIGHT/14));
			String[]visi = {"Visible", "No visible"};
			this.visibilidad = new JComboBox<String>(visi);
			this.visibilidad.setPreferredSize(new Dimension((int)Frame.WIDTH/4,(int)Frame.HEIGHT/25));
			aux.add(this.nombre);
			aux.add(text);
			aux.add(this.visibilidad);
			layout.putConstraint(SpringLayout.NORTH,this.nombre,(int) Frame.HEIGHT/30 ,SpringLayout.NORTH, this);
			layout.putConstraint(SpringLayout.WEST,this.nombre,0 ,SpringLayout.WEST,this);
			layout.putConstraint(SpringLayout.NORTH,this.text,(int) Frame.HEIGHT/15,SpringLayout.NORTH, this);
			layout.putConstraint(SpringLayout.WEST,this.text,0,SpringLayout.WEST,this.nombre);
			layout.putConstraint(SpringLayout.WEST,this.visibilidad,0,SpringLayout.WEST,this);
			layout.putConstraint(SpringLayout.NORTH,this.visibilidad,5,SpringLayout.SOUTH,this.text);
			aux.setVisible(true);
			
			JPanel panel_botones = new JPanel();
			this.cancelar = new JButton ("Cancelar");
			this.aceptar = new JButton ("Aceptar");
			panel_botones.setLayout(new BoxLayout(panel_botones, 0));
			panel_botones.add(cancelar);
			cancelar.addActionListener(new ActionVolverAsig(asig));
			panel_botones.add(aceptar);
			aceptar.addActionListener(new ActionCrearTema(asig,this));			
			JPanel panelVacio = new JPanel();
			this.add(aux);
			this.add(panelVacio);
			this.add(panel_botones);
			
			SpringUtilities.makeCompactGrid(this, 3, 1, 5, 5, 5, 5);
		}
		
		public String getSelec(){
			return (String) this.visibilidad.getSelectedItem();
		}
		
		public String getNombre(){
			return (String) this.text.getText();
		}
	}
	
