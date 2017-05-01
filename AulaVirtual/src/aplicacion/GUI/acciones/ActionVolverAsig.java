package aplicacion.GUI.acciones;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import aplicacion.GUI.general.Frame;
import aplicacion.GUI.profesor.PanelAsigProf;
import aplicacion.clases.Asignatura;

public class ActionVolverAsig implements ActionListener{
	
	private Asignatura asig;
	
	public ActionVolverAsig(Asignatura asig){
		this.asig = asig;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Frame.getIntance().cambiarPanel(new PanelAsigProf(this.asig),1);
	}
}
