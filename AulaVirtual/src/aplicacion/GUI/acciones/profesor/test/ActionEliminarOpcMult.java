package aplicacion.GUI.acciones.profesor.test;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import aplicacion.GUI.controlador.Controlador;
import aplicacion.GUI.paneles.profesor.test.PanelOpcMult;
import aplicacion.clases.elemento.test.Opcion;
import aplicacion.clases.elemento.test.OpcionMultiple;
import aplicacion.clases.elemento.test.Test;

public class ActionEliminarOpcMult implements ActionListener {

	private PanelOpcMult p;
	private Test t;
	private OpcionMultiple u;
	
	public ActionEliminarOpcMult(PanelOpcMult p, Test t, OpcionMultiple u){
		this.p = p;
		this.t = t;
		this.u = u;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		Opcion sel = p.getSel();
		if (sel == null) {
			JOptionPane.showMessageDialog(p, "Elija una opcion");
		}
		
		Controlador.getInstance().eliminarOpc(this.u, sel, t);
	}
}
