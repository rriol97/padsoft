package aplicacion.GUI.acciones.profesor.test;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import aplicacion.GUI.paneles.profesor.test.PanelEditarOpciones;
import aplicacion.GUI.frame.Frame;
import aplicacion.GUI.paneles.profesor.test.PanelCrearOpcUnic;
import aplicacion.clases.elemento.test.Opcion;
import aplicacion.clases.elemento.test.OpcionUnica;
import aplicacion.clases.elemento.test.Test;

public class ActionEditarOpcUnic implements ActionListener {
	
	private PanelCrearOpcUnic q;
	private OpcionUnica p;
	private Test t;
	
	public ActionEditarOpcUnic (PanelCrearOpcUnic q, OpcionUnica p, Test t){
		this.q = q;
		this.p = p;
		this.t = t;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		Opcion sel = q.getSel();
		if (sel == null) {
			JOptionPane.showMessageDialog(q, "Elija una opcion");
			return;
		}
		
		PanelEditarOpciones opc = new PanelEditarOpciones(sel, p, t);
		opc.setContent(sel.getTexto());
		opc.setCorrecta(sel.isCorrecta());
		Frame.getInstance().cambiarPanel(opc,1);
	}

}
