package aplicacion.GUI.paneles.profesor.test;


import aplicacion.GUI.acciones.profesor.test.ActionEliminarPreg;
import aplicacion.GUI.acciones.profesor.test.ActionModificarPreg;
import aplicacion.GUI.acciones.profesor.test.ActionNuevaPreg;
import aplicacion.GUI.acciones.profesor.test.ActionVolverAsigDeModTest;
import aplicacion.clases.elemento.test.Test;

public class PanelModificarPregTest  extends PanelAbstractoAnadirPreg {
	public PanelModificarPregTest(Test t) {
		super(t);
		this.anadir.addActionListener(new ActionNuevaPreg(this,t));
		this.cancelar.addActionListener(new ActionVolverAsigDeModTest(t));
		modificar.addActionListener(new ActionModificarPreg(this,t));
		eliminar.addActionListener(new ActionEliminarPreg(this,t));
	}

	private static final long serialVersionUID = 1L;

}
