package aplicacion.GUI.profesor;

import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SpringLayout;

import aplicacion.GUI.general.Frame;
import aplicacion.clases.Aplicacion;
import aplicacion.clases.Asignatura;

public class PanelCrearEle extends JPanel {
	private static final long serialVersionUID = 1L;
	
	private JComboBox<String> listaElem;
	private JButton aceptar;
	private JButton cancelar;
	
	public PanelCrearEle(Asignatura asig){
		SpringLayout layout = new SpringLayout();
		this.setLayout(layout);
		
		String[] tipoElem = {"Test","Apuntes","Tema"};
		this.listaElem = new JComboBox<String>(tipoElem);
		JScrollPane scrollingElem = new JScrollPane(this.listaElem);
		
		this.setPreferredSize(new Dimension((int)Frame.WIDTH/5,(int)Frame.HEIGHT/5));
		
		JLabel etiq = new JLabel("Tipo de elemento");
		etiq.setFont(new Font("Arial",12,20));
		
		 aceptar = new JButton ("Aceptar");
		 aceptar.setPreferredSize(new Dimension((int)Frame.WIDTH/10,(int)Frame.HEIGHT/25));
		 cancelar= new JButton ("Cancelar");
		 cancelar.setPreferredSize(new Dimension((int)Frame.WIDTH/10,(int)Frame.HEIGHT/25));
		 
		 this.add(etiq);
		 this.add(scrollingElem);
		 this.add(aceptar);
		 this.add(cancelar);
		
		 layout.putConstraint(SpringLayout.NORTH,etiq,200 ,SpringLayout.NORTH, this);
		 layout.putConstraint(SpringLayout.WEST,etiq ,290,SpringLayout.WEST ,this);
		 layout.putConstraint(SpringLayout.WEST,scrollingElem,20, SpringLayout.EAST,etiq);
		 layout.putConstraint(SpringLayout.NORTH,scrollingElem,200, SpringLayout.NORTH,this);
		 layout.putConstraint(SpringLayout.NORTH,cancelar,60, SpringLayout.SOUTH,scrollingElem);
		 layout.putConstraint(SpringLayout.WEST,cancelar,290, SpringLayout.WEST,this);
		 layout.putConstraint(SpringLayout.WEST,aceptar,3, SpringLayout.EAST,cancelar);
		 layout.putConstraint(SpringLayout.NORTH,aceptar,60, SpringLayout.SOUTH,scrollingElem);
		 
		 this.setVisible(true);
	}
	
    public String getOpcSel(Aplicacion ap){
    	return (String) this.listaElem.getSelectedItem();
    	
    }
}
