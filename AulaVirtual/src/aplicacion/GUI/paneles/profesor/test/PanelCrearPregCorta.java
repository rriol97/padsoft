package aplicacion.GUI.paneles.profesor.test;

import aplicacion.GUI.acciones.profesor.test.ActionCrearPregCorta;
import aplicacion.clases.elemento.test.Test;

/**
 * Clase que implementa el panel de creacion de una pregunta de respuesta libre.
 * @author Adrian Fernandez
 * @author Ricardo Riol
 *
 */
public class PanelCrearPregCorta extends PanelAbstractResCorta {
	private static final long serialVersionUID = 1L;
	
	public PanelCrearPregCorta(Test t) {
		super(t);
		this.aceptar.addActionListener(new ActionCrearPregCorta(t,this));
		
	}	
}
