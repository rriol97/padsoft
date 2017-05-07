package aplicacion.GUI.paneles.profesor.test;

import aplicacion.GUI.acciones.ActionVolverAsig;
import aplicacion.GUI.acciones.profesor.test.ActionCrearTest;
import aplicacion.clases.Asignatura;
import aplicacion.clases.elemento.Tema;

/**
 * Clase que implementa el panel de creacion de un test.
 * @author Adrian Fernandez
 * @author Ricardo Riol
 *
 */
public class PanelCrearTest extends PanelAbstractoCrearTest {
	private static final long serialVersionUID = 1L;
	public PanelCrearTest(Asignatura asig, Tema tema){
		super(asig,tema);
		this.cancelar.addActionListener(new ActionVolverAsig(asig));
		this.aceptar.addActionListener(new ActionCrearTest(this, asig, tema));
	}
}
