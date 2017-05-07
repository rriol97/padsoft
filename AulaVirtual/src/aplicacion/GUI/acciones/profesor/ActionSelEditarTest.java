package aplicacion.GUI.acciones.profesor;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import aplicacion.GUI.frame.Frame;
import aplicacion.GUI.paneles.profesor.test.PanelModificarTest;
import aplicacion.clases.elemento.test.Test;

public class ActionSelEditarTest implements ActionListener {
	private Test test;
	private Object padre;
	
	public ActionSelEditarTest (Test test, Object padre) {
		this.test = test;
		this.padre = padre;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if (test.getResoluciones().size() == 0) {
			Frame.getInstance().cambiarPanel(new PanelModificarTest(test.getAsignatura(),padre,test), 1);
		} else {
			JOptionPane.showMessageDialog(Frame.getInstance(), "No se puede editar un test que ya ha sido resuelto");
		}
	}
}
