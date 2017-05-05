package aplicacion.GUI.acciones.profesor.test;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;

public class ActionAnadirPregunta implements ActionListener {
	private JPanel p;
	
	public ActionAnadirPregunta(JPanel p){
		this.p = p;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		this.p.setVisible(true);
	}
}
