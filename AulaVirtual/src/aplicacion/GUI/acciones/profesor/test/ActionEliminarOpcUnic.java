package aplicacion.GUI.acciones.profesor.test;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import aplicacion.GUI.controlador.Controlador;
import aplicacion.GUI.paneles.profesor.test.PanelOpcUnic;
import aplicacion.clases.elemento.test.Opcion;
import aplicacion.clases.elemento.test.OpcionUnica;
import aplicacion.clases.elemento.test.Test;

public class ActionEliminarOpcUnic implements ActionListener {

	private PanelOpcUnic p;
	private Test t;
	private OpcionUnica u;
	
	public ActionEliminarOpcUnic(PanelOpcUnic p, Test t, OpcionUnica u){
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
