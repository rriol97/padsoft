package aplicacion.GUI.paneles.profesor.test;

import aplicacion.GUI.SpringUtilities;
import aplicacion.GUI.acciones.profesor.test.ActionEditarPregOpcUnic;
import aplicacion.clases.elemento.test.OpcionUnica;
import aplicacion.clases.elemento.test.Test;

/**
 * Clase que implementa el panel de edicion de una pregunta de opcion unica.
 * @author Adrian Fernandez
 * @author Ricardo Riol
 *
 */
public class PanelEditarPregOpcUnic extends PanelEnunciado {
	private static final long serialVersionUID = 1L;

	public PanelEditarPregOpcUnic(Test t, OpcionUnica ou) {
		super(t);
		this.aceptar.addActionListener(new ActionEditarPregOpcUnic(this, t, ou));

		this.add(this.panelEnun);
		this.add(this.opciones);
		this.add(this.panel_botones);
		
		SpringUtilities.makeCompactGrid(this, 3, 1, 5, 5, 5, 5);
	}
}
