package aplicacion.GUI.acciones.profesor;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;

import aplicacion.clases.elemento.test.Test;

public class ActionAnadirPregunta implements ActionListener {
	private Test test;
	private JPanel p;
	
	public ActionAnadirPregunta(Test t, JPanel p){
		this.test = t;
		this.p = p;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		this.p.setVisible(true);
	}
	
}
