package aplicacion.GUI.acciones.profesor.test;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import aplicacion.GUI.controlador.Controlador;
import aplicacion.GUI.paneles.profesor.test.PanelCrearPregOpcMult;
import aplicacion.clases.elemento.test.Test;

public class ActionCrearOpcMult implements ActionListener {
	private PanelCrearPregOpcMult vista;
	private Test t;
	
	public ActionCrearOpcMult (PanelCrearPregOpcMult p,Test t){
		this.vista = p;
		this.t = t;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		Double valor = this.vista.getValor();
		if (this.vista.getEnunciado().equals("")){
			JOptionPane.showMessageDialog(this.vista,"Introduzca el enunciado");
		} else if (valor == null){
			valor = t.getValorDefecto();
		} else if (this.vista.getPenalizacion()==null){
			JOptionPane.showMessageDialog(this.vista,"Introduzca la penalizacion por fallo");
		}
		Controlador.getInstance().crearPregOpcMult(t,this.vista.getEnunciado(),valor,this.vista.getPenalizacion(), this.vista.getOrden());

	}
}
