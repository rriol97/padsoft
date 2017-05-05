package aplicacion.GUI.acciones.profesor.test;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import aplicacion.GUI.general.Frame;
import aplicacion.GUI.paneles.profesor.test.PanelAnadirPregunta;
import aplicacion.GUI.paneles.profesor.test.PanelCrearPregOpcUnic;
import aplicacion.GUI.paneles.profesor.test.PanelPregCorta;
import aplicacion.GUI.paneles.profesor.test.PanelPregSiNo;
import aplicacion.clases.elemento.Tema;
import aplicacion.clases.elemento.test.Test;

public class ActionNuevaPreg implements ActionListener {
	private Test t;
	private PanelAnadirPregunta p;
	private Tema w;
	
	public ActionNuevaPreg(Test t, PanelAnadirPregunta p, Tema w){
		this.t = t;
		this.p = p;
		this.w = w;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if (this.p.getTipoPreg().equals("Respuesta unica")){
			Frame.getIntance().cambiarPanel(new PanelCrearPregOpcUnic(t,w), 1);
		} else if (this.p.getTipoPreg().equals("Respuesta multiple")){
			Frame.getIntance().cambiarPanel(new PanelCrearPregOpcUnic(t,w), 1);
		} else if ((this.p.getTipoPreg().equals("Si/No"))){
			Frame.getIntance().cambiarPanel(new PanelPregSiNo(t,w), 1);
		} else {
			Frame.getIntance().cambiarPanel(new PanelPregCorta(t,w), 1);
		}
	}

}
