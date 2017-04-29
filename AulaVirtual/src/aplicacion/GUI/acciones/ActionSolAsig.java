package aplicacion.GUI.acciones;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import aplicacion.GUI.componentes.PanelSolAsig;
import aplicacion.GUI.general.Frame;

public class ActionSolAsig implements ActionListener{

	@Override
	public void actionPerformed(ActionEvent e) {
		String[]asig = {"aaa","nnn"};
		PanelSolAsig ventana = new PanelSolAsig(asig);
		Frame.getIntance().cambiarPanel(ventana);
		ventana.setVisible(true);
	}

}
