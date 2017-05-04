package aplicacion.GUI.acciones.profesor;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import aplicacion.GUI.general.Frame;
import aplicacion.GUI.profesor.PanelAnadirPregunta;
import aplicacion.clases.elemento.Tema;
import aplicacion.clases.elemento.test.Test;

public class ActionCancelarPreg implements ActionListener {
	
	private Test t;
	private Tema w;
	
	public ActionCancelarPreg(Test t, Tema w){
		this.t = t;
		this.w = w;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Frame.getIntance().cambiarPanel(new PanelAnadirPregunta(t,w), 1);

	}

}