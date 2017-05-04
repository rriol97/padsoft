package aplicacion.GUI.profesor;




import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.SpringLayout;

import aplicacion.GUI.SpringUtilities;
import aplicacion.GUI.acciones.profesor.ActionCrearPreguntaSiNo;
import aplicacion.clases.elemento.Tema;
import aplicacion.clases.elemento.test.Test;

public class PanelPregSiNo extends PanelEnunciado {
	private static final long serialVersionUID = 1L;
	private JRadioButton si;
	private JRadioButton no;
	private ButtonGroup grupo;
	
	public PanelPregSiNo(Test t,Tema w){
		super(t,w);
		SpringLayout layout = new SpringLayout();
		this.setLayout(layout);
		
		this.aceptar.addActionListener(new ActionCrearPreguntaSiNo(t,w,this));
		
		JPanel respuestas = new JPanel();
		respuestas.setLayout(new BoxLayout(respuestas,1));
		this.si = new JRadioButton("Sí");
		this.no = new JRadioButton("No");
		this.si.setSelected(true);
		grupo = new ButtonGroup();
		grupo.add(this.si);
		grupo.add(this.no);
		respuestas.add(this.si);
		respuestas.add(this.no);
		respuestas.setVisible(true);
		
		this.add(this.panelEnun);
		this.add(this.opciones);
		this.add(respuestas);
		this.add(new JPanel());
		this.add(this.panel_botones);

		SpringUtilities.makeCompactGrid(this,5, 1, 5, 5, 5, 5);
		this.setVisible(true);
		
	}
		
	public String getRespuesta(){
		if (this.si.isSelected()){
			return "Si";
		} else{
			return "No";
		}
	}
	
	public String getTextOpc1(){
		return this.si.getText();
	}
	
	public String getTextOpc2(){
		return this.no.getText();
	}
	
	
}
