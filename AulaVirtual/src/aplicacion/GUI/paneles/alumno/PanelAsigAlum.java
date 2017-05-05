package aplicacion.GUI.paneles.alumno;

import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTree;
import javax.swing.SpringLayout;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.TreeSelectionModel;

import aplicacion.GUI.SpringUtilities;
import aplicacion.GUI.acciones.alumno.ActionConsultarNotas;
import aplicacion.GUI.general.Frame;
import aplicacion.clases.Aplicacion;
import aplicacion.clases.Asignatura;
import aplicacion.clases.elemento.Apuntes;
import aplicacion.clases.elemento.Elemento;
import aplicacion.clases.elemento.Tema;
import aplicacion.clases.elemento.test.Test;
import aplicacion.clases.resolucion.Resolucion;

/**
 * Clase que implementa el panel mostrado cuando un alumno consulta una de sus asignaturas.
 * @author Adrian Fernandez
 * @author Ricardo Riol
 *
 */
public class PanelAsigAlum extends JPanel {
	private static final long serialVersionUID = 1L;
	
	public PanelAsigAlum (Asignatura asig) {
		this.setLayout(new SpringLayout());
		
		DefaultMutableTreeNode raiz = new DefaultMutableTreeNode(asig);
		final JTree arbol = new JTree (raiz);
		arbol.getSelectionModel().setSelectionMode(TreeSelectionModel.SINGLE_TREE_SELECTION);
		arbol.setFont(new Font("Arial",12, 18));
		
		for (Elemento e: asig.getElementos()) {
			raiz.add(getNode(e));
		}
		expandAllNodes(arbol, 0, arbol.getRowCount());

		arbol.addTreeSelectionListener(new TreeSelectionListener(){
			public void valueChanged(TreeSelectionEvent e) {
				DefaultMutableTreeNode nodo = ((DefaultMutableTreeNode) arbol.getLastSelectedPathComponent());
				Object o = nodo.getUserObject();
				if (o instanceof Test) {
					Test t = (Test) o;
					Resolucion res = Aplicacion.getInstance().getAlumnoActual().encontrarResolucion(t);
					if (res == null) {
						if (t.isFechaValida()) {
							Frame.getInstance().cambiarPanel(new PanelTestAlum(t), 1);
						} else if (t.isTerminado()) {
							JOptionPane.showMessageDialog(Frame.getInstance(), "El plazo de realizacion ha terminado");
						} else {
							JOptionPane.showMessageDialog(Frame.getInstance(), "El plazo de realizacion no ha comenzado");
						}
					} else {
						if (t.isTerminado() == false) {
							Frame.getInstance().cambiarPanel(new PanelResAlum(res), 1);
						} else {
							try {
								res.calcularNota();
							} catch (Exception e1) {
								e1.printStackTrace();
							}
							Frame.getInstance().cambiarPanel(new PanelCorrAlum(res), 1);
						}
					}
				} else if (o instanceof Apuntes) {
					Apuntes ap = (Apuntes) o;
					Frame.getInstance().cambiarPanel(new PanelApunAlum(ap), 1);
				}
			}
		});
				
		JScrollPane tree = new JScrollPane(arbol);
		tree.setPreferredSize(new Dimension((int)(4.5*Frame.WIDTH/6),(int)(Frame.HEIGHT/1.25)));
		this.add(tree);
		
		JButton boton_nota = new JButton("Nota");
		boton_nota.addActionListener(new ActionConsultarNotas(asig));
		this.add(boton_nota);
		
		SpringUtilities.makeCompactGrid(this, 2, 1, 5, 5, 5, 5);
	}
	
	/**
	 * Metodo que obtiene el arbol asociado a un elemento.
	 * @param e Elemento que se quiere obtener el arbol.
	 * @return Nodo raiz del arbol.
	 */
	private DefaultMutableTreeNode getNode (Elemento e) {
		if (e.isVisible() == false) {
			return new DefaultMutableTreeNode("Contenido no visible");
		}
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
