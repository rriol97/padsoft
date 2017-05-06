package aplicacion.GUI.acciones.profesor.test;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import aplicacion.GUI.controlador.Controlador;
import aplicacion.GUI.paneles.profesor.test.PanelEditarPregOpcMult;
import aplicacion.clases.elemento.test.OpcionMultiple;
import aplicacion.clases.elemento.test.Test;

public class ActionEditarPregOpcMult implements ActionListener {
	private PanelEditarPregOpcMult vista;
	private Test t;
	private OpcionMultiple ou;	
	
	public ActionEditarPregOpcMult (PanelEditarPregOpcMult p, Test t, OpcionMultiple ou){
		this.vista = p;
		this.t = t;
		this.ou = ou;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if (this.vista.getEnunciado().equals("")){
			JOptionPane.showMessageDialog(this.vista,"Introduzca el enunciado");
		} else if (this.vista.getValor()==null){
			JOptionPane.showMessageDialog(this.vista,"Introduzca el valor de la pregunta");
		} else if (this.vista.getPenalizacion()==null){
			JOptionPane.showMessageDialog(this.vista,"Introduzca la penalizacion por fallo");
		}
		Controlador.getInstance().editarPregOpcMult(t, ou, this.vista.getEnunciado(), this.vista.getValor(), this.vista.getPenalizacion());
	}
}
