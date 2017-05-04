package aplicacion.GUI.acciones.profesor;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import aplicacion.GUI.controlador.Controlador;
import aplicacion.GUI.general.Frame;
import aplicacion.GUI.profesor.PanelAnadirPregunta;
import aplicacion.GUI.profesor.PanelPregCorta;
import aplicacion.clases.elemento.Tema;
import aplicacion.clases.elemento.test.Test;

public class ActionCrearPregCorta implements ActionListener {

	private Test t;
	private Tema w;
	private PanelPregCorta p;
	
	public ActionCrearPregCorta(Test t, Tema w,PanelPregCorta p){
		this.t = t;
		this.p = p;
		this.w = w;
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
			Controlador.getInstance().crearPregCorta(t,this.p.getEnunciado(),this.p.getValor(),this.p.getPenalizacion(),this.p.getRespuesta());
			Frame.getIntance().cambiarPanel(new PanelAnadirPregunta(t,w), 1);
		}	
	}
	
}
