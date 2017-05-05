package aplicacion.GUI.acciones.profesor;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import aplicacion.GUI.general.Frame;
import aplicacion.GUI.paneles.profesor.PanelAsigProf;
import aplicacion.clases.Asignatura;
import aplicacion.clases.elemento.Tema;

public class ActionEliminarTema implements ActionListener {
	private Tema tema;
	private Object padre;
	
	public ActionEliminarTema (Tema tema, Object padre) {
		this.tema = tema;
		this.padre = padre;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if (this.padre instanceof Asignatura) {
			Asignatura asig = (Asignatura) this.padre;
			try {
				asig.eliminarElemento(this.tema);
			} catch (Exception e1) {
				e1.printStackTrace();
			}
			Frame.getInstance().cambiarPanel(new PanelAsigProf(this.tema.getAsignatura()), 1);
		} else if (this.padre instanceof Tema) {
			Tema t = (Tema) this.padre;
			t.eliminarElemento(this.tema);
			Frame.getInstance().cambiarPanel(new PanelAsigProf(this.tema.getAsignatura()), 1);
		}
	}

}
