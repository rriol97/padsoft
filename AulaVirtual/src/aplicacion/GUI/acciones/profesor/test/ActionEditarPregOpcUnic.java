package aplicacion.GUI.acciones.profesor.test;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import aplicacion.GUI.controlador.Controlador;
import aplicacion.GUI.paneles.profesor.test.PanelEditarPregOpcUnic;
import aplicacion.clases.elemento.test.OpcionUnica;
import aplicacion.clases.elemento.test.Test;

public class ActionEditarPregOpcUnic implements ActionListener {
	private PanelEditarPregOpcUnic vista;
	private Test t;
	private OpcionUnica ou;	
	
	public ActionEditarPregOpcUnic (PanelEditarPregOpcUnic p, Test t, OpcionUnica ou){
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
		Controlador.getInstance().editarPregOpcUnic(t, ou, this.vista.getEnunciado(), this.vista.getValor(), this.vista.getPenalizacion());
	}

}
