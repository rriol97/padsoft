package aplicacion.GUI.paneles.profesor.test;

import javax.swing.JComboBox;

import aplicacion.GUI.SpringUtilities;
import aplicacion.GUI.acciones.profesor.test.ActionCrearOpcMult;
import aplicacion.clases.elemento.test.Test;

/**
 * Clase que implementa el panel de creacion de una pregunta de opcion multiple.
 * @author Adrian Fernandez
 * @author Ricardo Riol
 *
 */
public class PanelCrearPregOpcMult extends PanelEnunciado{
	private static final long serialVersionUID = 1L;
	
	JComboBox<String> ordenPreguntas;
	
	public PanelCrearPregOpcMult(Test t) {
		super(t);
		this.aceptar.addActionListener(new ActionCrearOpcMult(this,t));

		this.add(this.panelEnun);
		this.add(this.opciones);
		
		String[]orden = {"Ordenadas","No Ordenadas"};
		this.ordenPreguntas = new JComboBox<String>(orden);
		this.add(this.ordenPreguntas);
		
		this.add(this.panel_botones);
		
		SpringUtilities.makeCompactGrid(this, 4, 1, 5, 5, 5, 5);
	}
	
	public boolean getOrden() {
		if (this.ordenPreguntas.getSelectedItem().equals("Ordenadas")) {
			return false;
		}
		return true;
	}
}


