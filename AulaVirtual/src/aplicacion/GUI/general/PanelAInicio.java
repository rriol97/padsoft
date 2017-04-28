package aplicacion.GUI.general;

import java.awt.BorderLayout;

import javax.swing.*;

import aplicacion.GUI.componentes.PanelAsig;
import aplicacion.GUI.componentes.PanelAsig2;
import aplicacion.GUI.componentes.PanelSolAsig;

public class PanelAInicio extends JPanel {
	private static final long serialVersionUID = 1L;

	public PanelAInicio (String []data, JTree tree) {
		this.setLayout(new BorderLayout());
		this.add(new PanelAsig2(data),BorderLayout.WEST);
		this.add(new PanelAsig(tree), BorderLayout.CENTER);
		//this.add(new PanelSolAsig(data),BorderLayout.CENTER);
		this.setVisible(false);
	}
}
