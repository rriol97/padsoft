package aplicacion.GUI.paneles.profesor.test;


import aplicacion.GUI.SpringUtilities;
import aplicacion.GUI.acciones.profesor.test.ActionCrearOpcUnic;
import aplicacion.clases.elemento.test.Test;

public class PanelCrearPregOpcUnic extends PanelEnunciado{
	private static final long serialVersionUID = 1L;
	
	public PanelCrearPregOpcUnic(Test t) {
		super(t);
		this.aceptar.addActionListener(new ActionCrearOpcUnic(this,t));

		this.add(this.panelEnun);
		this.add(this.opciones);
		this.add(this.panel_botones);
		
		SpringUtilities.makeCompactGrid(this, 3, 1, 5, 5, 5, 5);
	}
}
