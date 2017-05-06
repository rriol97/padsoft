package aplicacion.GUI.paneles.profesor.test;

import aplicacion.GUI.acciones.profesor.test.ActionEditarPreguntaCorta;
import aplicacion.GUI.acciones.profesor.test.ActionEditarPreguntaSiNo;
import aplicacion.clases.elemento.test.Opcion;
import aplicacion.clases.elemento.test.RespuestaLibre;
import aplicacion.clases.elemento.test.Test;

public class PanelEditarPregCorta extends PanelAbstractResCorta {
	
	public PanelEditarPregCorta(RespuestaLibre preg,Test t) {
		super(t);
		this.setEnunciado(preg.getEnunciado());
		this.setValor(preg.getValor());
		this.setPenalizacion(preg.getPenalizacion());
		this.setRespuesta(preg.getSolucion());
		
		this.aceptar.addActionListener(new ActionEditarPreguntaCorta(preg,this,t));
	}

	private static final long serialVersionUID = 1L;

}
