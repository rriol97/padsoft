package aplicacion.GUI.acciones.profesor;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import aplicacion.GUI.controlador.Controlador;
import aplicacion.GUI.general.Frame;
import aplicacion.GUI.profesor.PanelAnadirPregunta;
import aplicacion.GUI.profesor.PanelPregSiNo;
import aplicacion.clases.elemento.Tema;
import aplicacion.clases.elemento.test.Test;

public class ActionCrearPreguntaSiNo implements ActionListener {
	
	private Test t;
	private Tema w;
	private PanelPregSiNo p;
	
	public ActionCrearPreguntaSiNo(Test t, Tema w, PanelPregSiNo p){
		this.t = t;
		this.w = w;
		this.p = p;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (this.p.getEnunciado().equals("")){
			JOptionPane.showMessageDialog(this.p,"Introduzca el enunciado");
		} else if (this.p.getValor()==null){
			JOptionPane.showMessageDialog(this.p,"Introduzca el valor de la pregunta");
		} else if (this.p.getPenalizacion()==null){
			JOptionPane.showMessageDialog(this.p,"Introduzca el la penalizacion por fallo");
		} else{
			Controlador.getInstance().crearPregSiNo(t,this.p.getEnunciado(),this.p.getValor(),this.p.getPenalizacion(),this.p.getRespuesta(),this.p.getTextOpc1(),this.p.getTextOpc2());
			Frame.getIntance().cambiarPanel(new PanelAnadirPregunta(t,w), 1);
		}
	}

}