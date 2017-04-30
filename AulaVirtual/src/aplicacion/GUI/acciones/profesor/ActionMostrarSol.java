package aplicacion.GUI.acciones.profesor;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import aplicacion.GUI.general.Frame;
import aplicacion.GUI.profesor.PanelSolPendientes;
import aplicacion.clases.Aplicacion;

public class ActionMostrarSol implements ActionListener{

	@Override
	public void actionPerformed(ActionEvent e) {
		PanelSolPendientes ventana = new PanelSolPendientes(Aplicacion.getInstance());
		Frame.getIntance().cambiarPanel(ventana, 1);
		Frame.getIntance().repaint();
		ventana.setVisible(true);
	}

}
