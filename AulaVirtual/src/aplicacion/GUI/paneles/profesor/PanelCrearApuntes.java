package aplicacion.GUI.paneles.profesor;

import javax.swing.JTextArea;
import javax.swing.SpringLayout;

import aplicacion.GUI.SpringUtilities;
import aplicacion.GUI.acciones.ActionVolverAsig;
import aplicacion.GUI.acciones.profesor.ActionCrearApuntes;
import aplicacion.clases.Asignatura;
import aplicacion.clases.elemento.Tema;

/**
 * Clase que implementa el panel de la creacion de apuntes desde el punto de vista del profesor
 * @author Adrian Fernandez
 * @author Ricardo Riol
 * 
 */

public class PanelCrearApuntes extends PanelComun {
	private static final long serialVersionUID = 1L;
	
	private JTextArea apuntes;

	public PanelCrearApuntes(Asignatura asig, Tema tema){
		
		this.setLayout(new SpringLayout());

		this.cancelar.addActionListener(new ActionVolverAsig(asig));
		this.aceptar.addActionListener(new ActionCrearApuntes(this, asig, tema));
		
		
		this.apuntes = new JTextArea();
		this.apuntes.setLineWrap(true);
		
		this.add(aux);
		this.add(this.apuntes);
		this.add(panel_botones);
		
		SpringUtilities.makeCompactGrid(this, 3, 1, 5, 5, 5, 5);
		this.setVisible(true);
		
	}
	
	public String getTitulo(){
		return this.text.getText();
	}
	
	public String getContenido(){
		return this.apuntes.getText();
	}
	
	public String getSelec(){
		return (String) this.visibilidad.getSelectedItem();
	}
}
