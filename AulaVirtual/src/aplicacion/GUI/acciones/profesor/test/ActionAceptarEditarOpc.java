package aplicacion.GUI.acciones.profesor.test;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import aplicacion.GUI.general.Frame;
import aplicacion.GUI.paneles.profesor.test.PanelEditarOpciones;
import aplicacion.GUI.paneles.profesor.test.PanelCrearOpcMult;
import aplicacion.GUI.paneles.profesor.test.PanelCrearOpcUnic;
import aplicacion.clases.elemento.test.Opcion;
import aplicacion.clases.elemento.test.OpcionMultiple;
import aplicacion.clases.elemento.test.OpcionUnica;
import aplicacion.clases.elemento.test.PreguntaOpcion;
import aplicacion.clases.elemento.test.Test;

public class ActionAceptarEditarOpc implements ActionListener {
	PanelEditarOpciones vista;
	Opcion opc;
	PreguntaOpcion p;
	Test t;
	
	public ActionAceptarEditarOpc (PanelEditarOpciones vista, Opcion opc, PreguntaOpcion p, Test t) {
		this.vista = vista;
		this.opc = opc;
		this.p = p;
		this.t = t;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		opc.setTexto(vista.getContent());
		
		boolean correcta = vista.isCorrecta();
		if (correcta) {
			if (p instanceof OpcionUnica) {
				OpcionUnica ou = (OpcionUnica) p;
				if (ou.getCorrectas().size() > 0 && opc.isCorrecta() == false) {
					JOptionPane.showMessageDialog(vista, "Ya existe otra opcion correcta");
					return;
				}
			}
		}
		opc.setCorrecta(correcta);
		
		if (p instanceof OpcionUnica) {
			OpcionUnica ou = (OpcionUnica) p;
			Frame.getInstance().cambiarPanel(new PanelCrearOpcUnic(ou, t), 1);
		} else if (p instanceof OpcionMultiple) {
			OpcionMultiple om = (OpcionMultiple) p;
			Frame.getInstance().cambiarPanel(new PanelCrearOpcMult(om, t), 1);
		}
	}

}
