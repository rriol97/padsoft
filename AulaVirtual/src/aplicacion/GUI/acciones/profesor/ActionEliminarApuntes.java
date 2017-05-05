package aplicacion.GUI.acciones.profesor;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import aplicacion.GUI.general.Frame;
import aplicacion.GUI.paneles.profesor.PanelAsigProf;
import aplicacion.clases.Asignatura;
import aplicacion.clases.elemento.Apuntes;
import aplicacion.clases.elemento.Tema;

public class ActionEliminarApuntes implements ActionListener {
	private Apuntes apuntes; 
	private Object padre;
	
	public ActionEliminarApuntes (Apuntes apuntes, Object padre) {
		this.apuntes = apuntes;
		this.padre = padre;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if (this.padre instanceof Asignatura) {
			Asignatura asig = (Asignatura) this.padre;
			try {
				asig.eliminarElemento(this.apuntes);
			} catch (Exception e1) {
				e1.printStackTrace();
			}
			Frame.getIntance().cambiarPanel(new PanelAsigProf(this.apuntes.getAsignatura()), 1);
		} else if (this.padre instanceof Tema) {
			Tema t = (Tema) this.padre;
			t.eliminarElemento(this.apuntes);
			Frame.getIntance().cambiarPanel(new PanelAsigProf(this.apuntes.getAsignatura()), 1);
		}
	}
}
