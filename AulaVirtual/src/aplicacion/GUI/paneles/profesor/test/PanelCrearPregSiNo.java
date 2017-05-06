package aplicacion.GUI.paneles.profesor.test;

import aplicacion.GUI.acciones.profesor.test.ActionCrearPreguntaSiNo;
import aplicacion.clases.elemento.test.Test;

public class PanelCrearPregSiNo extends PanelAbstractSiNo {
	private static final long serialVersionUID = 1L;
	
	public PanelCrearPregSiNo(Test t){
		super(t);
		this.aceptar.addActionListener(new ActionCrearPreguntaSiNo(t,this));
		
	}
}
