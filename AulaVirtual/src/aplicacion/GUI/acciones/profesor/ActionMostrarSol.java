package aplicacion.GUI.acciones.profesor;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import aplicacion.GUI.frame.Frame;
import aplicacion.GUI.paneles.profesor.PanelSolPendientes;
import aplicacion.clases.Aplicacion;

public class ActionMostrarSol implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent e) {
		PanelSolPendientes ventana = new PanelSolPendientes(Aplicacion.getInstance());
		Frame.getInstance().cambiarPanel(ventana, 1);
		Frame.getInstance().repaint();
		ventana.setVisible(true);
	}

}
