package aplicacion.GUI.paneles.profesor.test;

import java.awt.Dimension;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SpringLayout;

import aplicacion.GUI.acciones.profesor.test.ActionCancelarPreg;
import aplicacion.GUI.general.Frame;
import aplicacion.clases.elemento.test.Test;

public abstract class PanelEnunciado extends JPanel {
	private static final long serialVersionUID = 1L;
	protected JPanel panelEnun;
	private JLabel enun;
	private JTextArea enunciado;
	protected JPanel panel_botones;
	protected JPanel opciones;
	private JTextField c_valor;
	private JTextField c_penal; 
	protected JButton aceptar;
	
	public PanelEnunciado(Test t){

		this.setLayout(new SpringLayout());
		
		this.panelEnun = new JPanel();
		SpringLayout layout = new SpringLayout();
		panelEnun.setLayout(layout);
		this.enun = new JLabel("Enunciado");
		this.enunciado = new JTextArea ();
		this.enunciado.setLineWrap(true);
		this.enunciado.setPreferredSize(new Dimension((int)Frame.WIDTH,(int)Frame.HEIGHT/10));
		panelEnun.add(this.enun);
		panelEnun.add(enunciado);
		layout.putConstraint(SpringLayout.NORTH, this.enunciado, 10, SpringLayout.SOUTH, this.enun);
		this.setVisible(true);
		
		
		this.opciones = new JPanel();
		SpringLayout layoutOpc = new SpringLayout();
		this.opciones.setLayout(layoutOpc);
		JLabel valor = new JLabel("Valor");
		JLabel penalizacion = new JLabel ("Penalizacion");
		c_valor = new JTextField();
		c_valor.setPreferredSize(new Dimension((int)Frame.WIDTH/4,(int)Frame.HEIGHT/27));
		c_penal = new JTextField();
		c_penal.setPreferredSize(new Dimension((int)Frame.WIDTH/4,(int)Frame.HEIGHT/27));
		this.opciones.add(valor);
		this.opciones.add(penalizacion);
		this.opciones.add(c_valor);
		this.opciones.add(c_penal);
		layoutOpc.putConstraint(SpringLayout.WEST, c_valor, 100, SpringLayout.WEST, this.opciones);
		layoutOpc.putConstraint(SpringLayout.WEST, c_penal, 100, SpringLayout.WEST, this.opciones);
		layoutOpc.putConstraint(SpringLayout.NORTH, penalizacion, 20, SpringLayout.SOUTH, valor);
		layoutOpc.putConstraint(SpringLayout.NORTH, c_penal, 30, SpringLayout.SOUTH, c_valor);
		layoutOpc.putConstraint(SpringLayout.NORTH, c_penal, 20, SpringLayout.SOUTH, valor);
		layoutOpc.putConstraint(SpringLayout.NORTH, penalizacion, 20, SpringLayout.SOUTH, c_valor);
		this.opciones.setVisible(true);
		
		
		panel_botones = new JPanel();
		JButton cancelar = new JButton ("Cancelar");
		aceptar = new JButton ("Aceptar");
		panel_botones.setLayout(new BoxLayout(panel_botones, 0));
		panel_botones.add(cancelar); 
		cancelar.addActionListener(new ActionCancelarPreg(t));
		panel_botones.add(aceptar);	
		
	}
	
	public Double getValor(){
		return Double.parseDouble(this.c_valor.getText());
	}
	
	public Double getPenalizacion(){
		return Double.parseDouble(this.c_penal.getText());
	}
	
	public String getEnunciado (){
		return this.enunciado.getText();
	}
}
