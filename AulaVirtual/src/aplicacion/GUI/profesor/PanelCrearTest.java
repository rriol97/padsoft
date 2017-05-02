package aplicacion.GUI.profesor;

import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.SpringLayout;

import aplicacion.GUI.SpringUtilities;
import aplicacion.GUI.acciones.ActionVolverAsig;
import aplicacion.clases.Asignatura;

public class PanelCrearTest extends PanelComun {
	private static final long serialVersionUID = 1L;
	private JComboBox<String> ordenPreguntas;
	//private JComboBox<String> fechaInicio;
	private JComboBox<String> visibilidad;

	
	public PanelCrearTest(Asignatura asig){
		super();
		this.setLayout(new SpringLayout());
		
		this.cancelar.addActionListener(new ActionVolverAsig(asig));
		//this.aceptar.addActionListener(new ActionCrearApuntes(asig,this));
		
		JPanel panel_elecciones = new JPanel();
		panel_elecciones.setLayout(new SpringLayout());
		String[]orden = {"Ordenadas","No Ordenadas"};
		this.ordenPreguntas = new JComboBox<String>(orden);
		panel_elecciones.add(this.ordenPreguntas);
		
		this.add(aux);
		this.add(panel_elecciones);
		this.add(panel_botones);
		
		
		SpringUtilities.makeCompactGrid(this, 3, 1, 5, 5, 5, 5);
		
	}
	
	public String getSelec(){
		return (String) this.visibilidad.getSelectedItem();
	}
	
	public String getOrden(){
		return (String) this.ordenPreguntas.getSelectedItem();
	}
}
