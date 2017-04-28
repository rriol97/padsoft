package aplicacion.GUI.componentes;

import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTree;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.TreePath;
import javax.swing.tree.TreeSelectionModel;

import aplicacion.GUI.general.Frame;

public class PanelAsig extends JPanel {
	private static final long serialVersionUID = 1L;
	
	public PanelAsig (JTree arbol) {
		
		arbol.getSelectionModel().setSelectionMode(TreeSelectionModel.SINGLE_TREE_SELECTION);
		arbol.setFont(new Font("Arial",20, 25));
		arbol.addTreeSelectionListener(new TreeSelectionListener() {
			public void valueChanged(TreeSelectionEvent e) {
				Object nodo = arbol.getLastSelectedPathComponent();
				int[] indiceNodosSeleccionados = arbol.getSelectionRows();
				TreePath[] pathNodosSeleccionados = arbol.getSelectionPaths();
			}
		});
		
		JScrollPane tree = new JScrollPane(arbol);
		tree.setPreferredSize(new Dimension((int)(Frame.WIDTH/1.3),(int)(Frame.HEIGHT/1.1)));
		this.add(tree);
	}
}
