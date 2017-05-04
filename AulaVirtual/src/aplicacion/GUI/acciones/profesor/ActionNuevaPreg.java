package aplicacion.GUI.acciones.profesor;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import aplicacion.GUI.general.Frame;
import aplicacion.GUI.profesor.PanelAnadirPregunta;
import aplicacion.GUI.profesor.PanelPregCorta;
import aplicacion.GUI.profesor.PanelPregSiNo;
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
			JOptionPane.showMessageDialog(this.p, "Por implemetar");
		} else if (this.p.getTipoPreg().equals("Respuesta multiple")){
			JOptionPane.showMessageDialog(this.p, "Por implemetar");
		} else if ((this.p.getTipoPreg().equals("Si/No"))){
			Frame.getIntance().cambiarPanel(new PanelPregSiNo(t,w), 1);
		} else {
			Frame.getIntance().cambiarPanel(new PanelPregCorta(t,w), 1);
		}
	}

}
