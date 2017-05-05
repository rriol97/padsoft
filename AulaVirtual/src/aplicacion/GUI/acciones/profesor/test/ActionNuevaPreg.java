package aplicacion.GUI.acciones.profesor.test;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import aplicacion.GUI.general.Frame;
import aplicacion.GUI.paneles.profesor.test.PanelAnadirPregunta;
import aplicacion.GUI.paneles.profesor.test.PanelCrearPregOpcMult;
import aplicacion.GUI.paneles.profesor.test.PanelCrearPregOpcUnic;
import aplicacion.GUI.paneles.profesor.test.PanelPregCorta;
import aplicacion.GUI.paneles.profesor.test.PanelPregSiNo;
import aplicacion.clases.elemento.test.Test;

public class ActionNuevaPreg implements ActionListener {
	private Test t;
	private PanelAnadirPregunta p;
	
	public ActionNuevaPreg(Test t, PanelAnadirPregunta p){
		this.t = t;
		this.p = p;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if (this.p.getTipoPreg().equals("Respuesta unica")){
			Frame.getIntance().cambiarPanel(new PanelCrearPregOpcUnic(t), 1);
		} else if (this.p.getTipoPreg().equals("Respuesta multiple")){
			Frame.getIntance().cambiarPanel(new PanelCrearPregOpcMult(t), 1);
		} else if ((this.p.getTipoPreg().equals("Si/No"))){
			Frame.getIntance().cambiarPanel(new PanelPregSiNo(t), 1);
		} else {
			Frame.getIntance().cambiarPanel(new PanelPregCorta(t), 1);
		}
	}

}
