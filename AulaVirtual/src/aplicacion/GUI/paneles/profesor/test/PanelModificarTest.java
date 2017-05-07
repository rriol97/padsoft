package aplicacion.GUI.paneles.profesor.test;

import aplicacion.GUI.acciones.ActionVolverAsig;
import aplicacion.GUI.acciones.profesor.test.ActionEditarPregTest;
import aplicacion.clases.Asignatura;
import aplicacion.clases.elemento.Tema;
import aplicacion.clases.elemento.test.Test;

public class PanelModificarTest extends PanelAbstractoCrearTest {
	public PanelModificarTest(Asignatura asig, Object padre, Test t) {
		super(asig, (Tema)padre);
		this.setNombre(t.getNombre());
		this.setSele(t.isVisible());
		this.setOrden(t.isAleatorio());
		this.setFechaIni(t.getFechaIni());
		this.setFechaFin(t.getFechaFin());
		this.setVpd(t.getValorDefecto());
		this.setPeso(t.getPeso());
		
		this.cancelar.addActionListener(new ActionVolverAsig(asig));
		this.aceptar.addActionListener(new ActionEditarPregTest(this,t));
	}

	private static final long serialVersionUID = 1L;

}
