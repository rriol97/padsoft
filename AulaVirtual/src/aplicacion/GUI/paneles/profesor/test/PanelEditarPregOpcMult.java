package aplicacion.GUI.paneles.profesor.test;

import aplicacion.GUI.SpringUtilities;
import aplicacion.GUI.acciones.profesor.test.ActionEditarPregOpcMult;
import aplicacion.clases.elemento.test.OpcionMultiple;
import aplicacion.clases.elemento.test.Test;

/**
 * Clase que implementa el panel de edicion de una pregunta de opcion multiple.
 * @author Adrian Fernandez
 * @author Ricardo Riol
 *
 */
public class PanelEditarPregOpcMult extends PanelEnunciado {
	
	private static final long serialVersionUID = 1L;

	public PanelEditarPregOpcMult(Test t, OpcionMultiple om) {
		super(t);
		this.aceptar.addActionListener(new ActionEditarPregOpcMult(this, t, om));

		this.add(this.panelEnun);
		this.add(this.opciones);
		this.add(this.panel_botones);
		
		SpringUtilities.makeCompactGrid(this, 3, 1, 5, 5, 5, 5);
	}
}
