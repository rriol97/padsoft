package aplicacion.GUI.acciones;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import aplicacion.GUI.general.Frame;
import aplicacion.GUI.paneles.profesor.PanelAsigProf;
import aplicacion.clases.Asignatura;
import aplicacion.clases.elemento.Tema;
import aplicacion.clases.elemento.test.Test;

public class ActionVolverAsigDeTest implements ActionListener{

	private Test t;
	
	public ActionVolverAsigDeTest(Test t){
		this.t = t;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		Asignatura asig = t.getAsignatura();
		Tema tema = t.getTema();
		tema.eliminarElemento(t);
		Frame.getIntance().cambiarPanel(new PanelAsigProf(asig), 1);
	}

}
