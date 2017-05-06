package aplicacion.GUI.acciones.profesor.test;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import aplicacion.GUI.paneles.profesor.test.PanelEditarOpciones;
import aplicacion.GUI.frame.Frame;
import aplicacion.GUI.paneles.profesor.test.PanelCrearOpcMult;
import aplicacion.clases.elemento.test.Opcion;
import aplicacion.clases.elemento.test.PreguntaOpcion;
import aplicacion.clases.elemento.test.Test;

public class ActionEditarOpcMult implements ActionListener {
	private PanelCrearOpcMult q;
	private Test t;
	private PreguntaOpcion p;
	
	public ActionEditarOpcMult (PanelCrearOpcMult q,Test t, PreguntaOpcion p){
		this.p = p;
		this.q = q;
		this.t = t;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		Opcion sel = q.getSel();
		if (sel == null) {
			JOptionPane.showMessageDialog(q, "Elija una opcion");
		}
		
		PanelEditarOpciones opc = new PanelEditarOpciones(sel, p, t);
		opc.setContent(sel.getTexto());
		opc.setCorrecta(sel.isCorrecta());
		Frame.getInstance().cambiarPanel(opc,1);
	}

}
