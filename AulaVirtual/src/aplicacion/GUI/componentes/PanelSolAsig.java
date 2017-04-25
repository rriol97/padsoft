package aplicacion.GUI.componentes;

import java.awt.BorderLayout;

import java.util.List;

import javax.swing.JList;
import javax.swing.JPanel;


public class PanelSolAsig extends JPanel {
	private static final long serialVersionUID = 1L;
	
	public PanelSolAsig(List <String> nombres) {
		this.setLayout(new BorderLayout());
		
		JList lista_asig = new JList ();
		
		for (String n: nombres) {
			
		}
	}
	
}
