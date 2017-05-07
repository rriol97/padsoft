package aplicacion.GUI.paneles.profesor.test;

import aplicacion.GUI.acciones.profesor.test.ActionCrearPreguntaSiNo;
import aplicacion.clases.elemento.test.Test;

/**
 * Clase que implementa el panel de creaciond e una pregunta si/no.
 * @author Adrian Fernandez
 * @author Ricardo Riol
 *
 */
public class PanelCrearPregSiNo extends PanelAbstractSiNo {
	private static final long serialVersionUID = 1L;
	
	public PanelCrearPregSiNo(Test t){
		super(t);
		this.aceptar.addActionListener(new ActionCrearPreguntaSiNo(t,this));
		
	}
}
