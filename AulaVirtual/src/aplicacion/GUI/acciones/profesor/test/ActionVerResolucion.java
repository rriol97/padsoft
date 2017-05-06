package aplicacion.GUI.acciones.profesor.test;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import aplicacion.GUI.frame.Frame;
import aplicacion.GUI.paneles.alumno.PanelCorrAlum;
import aplicacion.GUI.paneles.profesor.test.PanelVisualizarTest;

public class ActionVerResolucion implements ActionListener {
	private PanelVisualizarTest vista;
	
	public ActionVerResolucion (PanelVisualizarTest vista) {
		this.vista =  vista;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		Frame.getInstance().cambiarPanel(new PanelCorrAlum(vista.getSeleccion()  ), 1);
	}

}
