package aplicacion.GUI.acciones.profesor;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JRadioButton;

import aplicacion.GUI.general.Frame;
import aplicacion.GUI.profesor.PanelCrearPregOpcUnic;
import aplicacion.GUI.profesor.PanelOpciones;
import aplicacion.clases.elemento.Tema;
import aplicacion.clases.elemento.test.Test;

public class ActionAceptarOpc implements ActionListener {
	private PanelCrearPregOpcUnic p;
	private PanelOpciones r;
	
	public ActionAceptarOpc(PanelCrearPregOpcUnic p, PanelOpciones r){
		this.p = p;
		this.r  = r;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		String t = this.r.getContent();
		JRadioButton opc = new JRadioButton(t);
		//this.p.anadirPanel(opc);
		this.r.setVisible(false);
	

	}

}
