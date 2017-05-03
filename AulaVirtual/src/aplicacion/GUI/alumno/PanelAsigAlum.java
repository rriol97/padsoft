package aplicacion.GUI.alumno;

import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTree;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.TreeSelectionModel;

import aplicacion.GUI.acciones.alumno.ActionApuntes;
import aplicacion.GUI.acciones.alumno.ActionManejarTest;
import aplicacion.GUI.general.Frame;
import aplicacion.clases.Asignatura;
import aplicacion.clases.elemento.Apuntes;
import aplicacion.clases.elemento.Elemento;
import aplicacion.clases.elemento.Tema;
import aplicacion.clases.elemento.test.Test;

/**
 * Clase que implementa el panel mostrado cuando un alumno consulta una de sus asignaturas.
 * @author Adrian Fernandez
 * @author Ricardo Riol
 *
 */
public class PanelAsigAlum extends JPanel {
	private static final long serialVersionUID = 1L;
	
	public PanelAsigAlum (Asignatura asig) {
		DefaultMutableTreeNode raiz = new DefaultMutableTreeNode(asig);
		final JTree arbol = new JTree (raiz);
		arbol.getSelectionModel().setSelectionMode(TreeSelectionModel.SINGLE_TREE_SELECTION);
		arbol.setFont(new Font("Arial",20, 25));
		
		for (Elemento e: asig.getElementos()) {
			raiz.add(getNode(e));
		}
		
		arbol.addTreeSelectionListener(new TreeSelectionListener(){
			public void valueChanged(TreeSelectionEvent e) {
				DefaultMutableTreeNode nodo = ((DefaultMutableTreeNode) arbol.getLastSelectedPathComponent());
				Object o = nodo.getUserObject();
				if (o instanceof Test) {
					Test t = (Test) o;
					new ActionManejarTest(t);
				} else if (o instanceof Apuntes) {
					Apuntes ap = (Apuntes) o;
					new ActionApuntes(ap);
				}
			}
		});
		
		expandAllNodes(arbol, 0, arbol.getRowCount());
				
		JScrollPane tree = new JScrollPane(arbol);
		tree.setPreferredSize(new Dimension((int)(4.5*Frame.WIDTH/6),(int)(Frame.HEIGHT/1.15)));
		this.add(tree);
	}
	
	/**
	 * Metodo que obtiene el arbol asociado a un elemento.
	 * @param e Elemento que se quiere obtener el arbol.
	 * @return Nodo raiz del arbol.
	 */
	private DefaultMutableTreeNode getNode (Elemento e) {
		DefaultMutableTreeNode node = new DefaultMutableTreeNode(e);
		if (e instanceof Tema) {
			Tema et = (Tema)e;
			for (Elemento ele: et.getElementos()){
				node.add(getNode(ele));
			}
		}
		return node;
	}
	
	/**
	 * Matodo pata expandir el arbol de la asignatura.
	 * @param tree Arbol a expandir.
	 * @param startingIndex Indice de inicio.
	 * @param rowCount Contador de filas.
	 */
	private void expandAllNodes(JTree tree, int startingIndex, int rowCount){
	    for(int i=startingIndex;i<rowCount;++i){
	        tree.expandRow(i);
	    }

	    if(tree.getRowCount()!=rowCount){
	        expandAllNodes(tree, rowCount, tree.getRowCount());
	    }
	}
}
