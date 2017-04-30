package aplicacion.GUI.Alumno;

import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.TreeSelectionModel;

import aplicacion.clases.Asignatura;
import aplicacion.clases.elemento.Elemento;
import aplicacion.clases.elemento.Tema;

/**
 * Clase que implementa el panel mostrado cuando un alumno consulta una de sus asignaturas.
 * @author Adrian Fernandez
 * @author Ricardo Riol
 *
 */
public class PanelAsig extends JPanel {
	private static final long serialVersionUID = 1L;
	
	public PanelAsig (Asignatura asig) {
		DefaultMutableTreeNode raiz = new DefaultMutableTreeNode(asig.getNombre());
		final JTree arbol = new JTree (raiz);
		arbol.getSelectionModel().setSelectionMode(TreeSelectionModel.SINGLE_TREE_SELECTION);
		arbol.setFont(new Font("Arial",20, 25));
		
		for (Elemento e: asig.getElementos()) {
			raiz.add(getNode(e));
		}
		
		/*arbol.addTreeSelectionListener(new TreeSelectionListener() {
			public void valueChanged(TreeSelectionEvent e) {
				Object nodo = arbol.getLastSelectedPathComponent();
				int[] indiceNodosSeleccionados = arbol.getSelectionRows();
				TreePath[] pathNodosSeleccionados = arbol.getSelectionPaths();
			}
		});*/
		
		JScrollPane tree = new JScrollPane(arbol);
		tree.setPreferredSize(new Dimension((int)(Frame.WIDTH/1.3),(int)(Frame.HEIGHT/1.1)));
		this.add(tree);
	}
	
	/**
	 * Metodo que obtiene el arbol asociado a un elemento.
	 * @param e Elemento que se quiere obtener el arbol.
	 * @return Nodo raiz del arbol.
	 */
	private DefaultMutableTreeNode getNode (Elemento e) {
		DefaultMutableTreeNode node = new DefaultMutableTreeNode(e.getNombre());
		if (e instanceof Tema) {
			Tema et = (Tema)e;
			for (Elemento ele: et.getElementos()){
				node.add(getNode(ele));
			}
		}
		return node;
	}
}
