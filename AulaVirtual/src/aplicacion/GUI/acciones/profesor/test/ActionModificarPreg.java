package aplicacion.GUI.acciones.profesor.test;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import aplicacion.GUI.general.Frame;
import aplicacion.GUI.paneles.profesor.test.PanelAnadirPregunta;
import aplicacion.GUI.paneles.profesor.test.PanelCrearPregOpcMult;
import aplicacion.GUI.paneles.profesor.test.PanelCrearPregOpcUnic;
import aplicacion.GUI.paneles.profesor.test.PanelCrearPregCorta;
import aplicacion.GUI.paneles.profesor.test.PanelCrearPregSiNo;
import aplicacion.GUI.paneles.profesor.test.PanelEditarPregCorta;
import aplicacion.GUI.paneles.profesor.test.PanelEditarPregOpcMult;
import aplicacion.GUI.paneles.profesor.test.PanelEditarPregOpcUnic;
import aplicacion.GUI.paneles.profesor.test.PanelEditarPregSiNo;
import aplicacion.clases.elemento.test.OpcionMultiple;
import aplicacion.clases.elemento.test.OpcionUnica;
import aplicacion.clases.elemento.test.Pregunta;
import aplicacion.clases.elemento.test.RespuestaLibre;
import aplicacion.clases.elemento.test.SiNo;
import aplicacion.clases.elemento.test.Test;

public class ActionModificarPreg implements ActionListener {
	PanelAnadirPregunta vista;
	Test t;
	
	public ActionModificarPreg (PanelAnadirPregunta vista, Test t) {
		this.vista = vista;
		this.t = t;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		Pregunta sel = this.vista.getSeleccionada();
		if (sel == null) {
			JOptionPane.showMessageDialog(vista, "Elige una pregunta");
		}
		
		if (sel instanceof OpcionUnica){
			OpcionUnica ou = (OpcionUnica) sel;
			PanelEditarPregOpcUnic p = new PanelEditarPregOpcUnic(t, ou);
			p.setEnunciado(sel.getEnunciado());
			p.setValor(sel.getValor());
			p.setPenalizacion(sel.getPenalizacion());
			Frame.getInstance().cambiarPanel(p, 1);
		} else if (sel instanceof OpcionMultiple){
			OpcionMultiple ou = (OpcionMultiple) sel;
			PanelEditarPregOpcMult p = new PanelEditarPregOpcMult(t, ou);
			p.setEnunciado(sel.getEnunciado());
			p.setValor(sel.getValor());
			p.setPenalizacion(sel.getPenalizacion());
			Frame.getInstance().cambiarPanel(p, 1);
		} else if (sel instanceof SiNo){
			Frame.getInstance().cambiarPanel(new PanelEditarPregSiNo((SiNo) sel,t), 1);
		} else if (sel instanceof RespuestaLibre) {
			Frame.getInstance().cambiarPanel(new PanelEditarPregCorta((RespuestaLibre)sel,t), 1);
		}
		
	}

}
