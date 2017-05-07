package aplicacion.GUI.paneles.profesor.test;

import aplicacion.GUI.acciones.ActionVolverAsigDeTest;
import aplicacion.GUI.acciones.profesor.test.ActionEliminarPreg;
import aplicacion.GUI.acciones.profesor.test.ActionModificarPreg;
import aplicacion.GUI.acciones.profesor.test.ActionNuevaPreg;
import aplicacion.clases.elemento.test.Test;

/**
 * Clase que implementa el panel en el que se anaden preguntas a un test.
 * @author Adrian Fernandez
 * @author Ricardo Riol
 *
 */
public class PanelAnadirPregunta extends PanelAbstractoAnadirPreg {
	private static final long serialVersionUID = 1L;
	
	public PanelAnadirPregunta(Test t){
		super(t);
		this.anadir.addActionListener(new ActionNuevaPreg(this, t));
		this.cancelar.addActionListener(new ActionVolverAsigDeTest(t));
		modificar.addActionListener(new ActionModificarPreg(this, t));
		eliminar.addActionListener(new ActionEliminarPreg(this, t));

 		
	}
	
}
