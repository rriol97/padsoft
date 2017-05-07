package aplicacion.GUI.acciones.profesor.test;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import aplicacion.GUI.frame.Frame;
import aplicacion.GUI.paneles.profesor.test.PanelAbstractoAnadirPreg;
import aplicacion.GUI.paneles.profesor.test.PanelCrearPregOpcMult;
import aplicacion.GUI.paneles.profesor.test.PanelCrearPregOpcUnic;
import aplicacion.GUI.paneles.profesor.test.PanelCrearPregCorta;
import aplicacion.GUI.paneles.profesor.test.PanelCrearPregSiNo;
import aplicacion.clases.elemento.test.Test;

public class ActionNuevaPreg implements ActionListener {
	private Test t;
	private PanelAbstractoAnadirPreg p;
	public ActionNuevaPreg(PanelAbstractoAnadirPreg p, Test t){
		this.p = p;
		this.t = t;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if (this.p.getTipoPreg().equals("Respuesta unica")){
			Frame.getInstance().cambiarPanel(new PanelCrearPregOpcUnic(t), 1);
		} else if (this.p.getTipoPreg().equals("Respuesta multiple")){
			Frame.getInstance().cambiarPanel(new PanelCrearPregOpcMult(t), 1);
		} else if ((this.p.getTipoPreg().equals("Si/No"))){
			Frame.getInstance().cambiarPanel(new PanelCrearPregSiNo(t), 1);
		} else {
			Frame.getInstance().cambiarPanel(new PanelCrearPregCorta(t), 1);
		}
	}

}
