package aplicacion.GUI.paneles.profesor.test;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.SpringLayout;

import aplicacion.GUI.SpringUtilities;
import aplicacion.clases.elemento.test.Test;

public abstract class PanelAbstractResCorta extends PanelEnunciado {
	private static final long serialVersionUID = 1L;
	private JTextArea respuesta;
	
	public PanelAbstractResCorta(Test t){
		super(t);
		SpringLayout layout = new SpringLayout();
		this.setLayout(layout);
		
		JPanel a = new JPanel();
		a.setLayout(new SpringLayout());
		JLabel sol = new JLabel("Solucion");
		this.respuesta = new JTextArea();
		this.respuesta.setLineWrap(true);
		this.respuesta.add(new JLabel("Solucion"));
		a.add(sol);
		a.add(this.respuesta);
		SpringUtilities.makeCompactGrid(a,2, 1, 5, 5, 5, 5);
		
		
		this.add(this.panelEnun);
		this.add(this.opciones);
		this.add(a);
		this.add(this.panel_botones);
		
		SpringUtilities.makeCompactGrid(this,4, 1, 5, 5, 5, 5);
		this.setVisible(true);
		
	}

	public String getRespuesta(){
		return this.respuesta.getText();
	}
	
	public void setRespuesta(String s){
		this.respuesta.setText(s);
		return;
	}
}	

