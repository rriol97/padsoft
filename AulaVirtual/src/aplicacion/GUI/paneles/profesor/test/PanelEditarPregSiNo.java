package aplicacion.GUI.paneles.profesor.test;

import aplicacion.GUI.acciones.profesor.test.ActionEditarPreguntaSiNo;
import aplicacion.clases.elemento.test.Opcion;
import aplicacion.clases.elemento.test.SiNo;
import aplicacion.clases.elemento.test.Test;

/**
 * Clase que implementa el panel de edicion de una pregunta si/no.
 * @author Adrian Fernandez
 * @author Ricardo Riol
 *
 */
public class PanelEditarPregSiNo extends PanelAbstractSiNo {
	private static final long serialVersionUID = 1L;

	public PanelEditarPregSiNo(SiNo preg, Test t){
		super(t);
		this.setEnunciado(preg.getEnunciado());
		this.setValor(preg.getValor());
		this.setPenalizacion(preg.getPenalizacion());
		for (Opcion p :preg.getCorrectas()){
			if (p.getTexto().equals(this.si.getText())){
				this.si.setSelected(true);
			} else{
				this.no.setSelected(true);
			}
			
		}
	
		this.aceptar.addActionListener(new ActionEditarPreguntaSiNo(preg,this,t));
	}
	

}
