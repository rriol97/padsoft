package aplicacion.GUI.acciones.profesor.test;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import aplicacion.GUI.controlador.Controlador;
import aplicacion.GUI.frame.Frame;
import aplicacion.GUI.paneles.profesor.test.PanelModificarPregTest;
import aplicacion.GUI.paneles.profesor.test.PanelModificarTest;
import aplicacion.clases.elemento.test.Test;

public class ActionEditarPregTest implements ActionListener {

	private Test t;
	private PanelModificarTest a;
	
	public ActionEditarPregTest(PanelModificarTest a, Test t){
		this.t = t;
		this.a = a;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		Controlador.getInstance().modificarTest(t,a.getNombre(),a.getSelec(),a.getOrden(),a.getFechaIni(),a.getFechaFin(),a.getVpd(),a.getPeso());
		Frame.getInstance().cambiarPanel(new PanelModificarPregTest(t), 1);
	}

}
