package aplicacion.GUI.acciones.profesor.test;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import aplicacion.GUI.controlador.Controlador;
import aplicacion.GUI.frame.Frame;
import aplicacion.GUI.paneles.profesor.test.PanelAnadirPregunta;
import aplicacion.GUI.paneles.profesor.test.PanelCrearPregCorta;
import aplicacion.clases.elemento.test.Test;

public class ActionCrearPregCorta implements ActionListener {

	private Test t;
	private PanelCrearPregCorta p;
	
	public ActionCrearPregCorta(Test t,PanelCrearPregCorta p){
		this.t = t;
		this.p = p;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		Double valor = this.p.getValor();
		if (this.p.getEnunciado().equals("")){
			JOptionPane.showMessageDialog(this.p,"Introduzca el enunciado");
		} else if (valor == null){
			valor = t.getValorDefecto();
		} else if (this.p.getPenalizacion() == null){
			JOptionPane.showMessageDialog(this.p,"Introduzca el la penalizacion por fallo");
		} else{
			Controlador.getInstance().crearPregCorta(t,this.p.getEnunciado(),valor,this.p.getPenalizacion(),this.p.getRespuesta());
			Frame.getInstance().cambiarPanel(new PanelAnadirPregunta(t), 1);
		}	
	}
	
}
