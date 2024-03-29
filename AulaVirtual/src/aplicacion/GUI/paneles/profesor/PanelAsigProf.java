package aplicacion.GUI.paneles.profesor;

import java.awt.Dimension;
import java.awt.Font;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTree;
import javax.swing.SpringLayout;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.TreeSelectionModel;

import aplicacion.GUI.SpringUtilities;
import aplicacion.GUI.acciones.profesor.ActionCrearEle;
import aplicacion.GUI.acciones.profesor.ActionEliminarAsig;
import aplicacion.GUI.acciones.profesor.ActionSeleccionExpulsar;
import aplicacion.GUI.acciones.profesor.ActionSeleccionReadmitir;
import aplicacion.GUI.general.Frame;
import aplicacion.GUI.paneles.profesor.test.PanelEditarTest;
import aplicacion.GUI.paneles.profesor.test.PanelVisualizarTest;
import aplicacion.clases.Alumno;
import aplicacion.clases.Asignatura;
import aplicacion.clases.elemento.Apuntes;
import aplicacion.clases.elemento.Elemento;
import aplicacion.clases.elemento.Tema;
import aplicacion.clases.elemento.test.Test;

/**
 * Clase que implementa el panel que muestra una asignatura a un profesor.
 * @author Adrian Fernandez
 * @author Ricardo Riol
 *
 */
public class PanelAsigProf extends JPanel {
	private static final long serialVersionUID = 1L;

	private Asignatura asig;
	
	public PanelAsigProf (Asignatura asig) {
		this.asig = asig;
		this.setLayout(new SpringLayout());
		
		JPanel izq = new JPanel();
		izq.setLayout(new SpringLayout());

		DefaultMutableTreeNode raiz = new DefaultMutableTreeNode(asig);
		final JTree arbol = new JTree (raiz);
		arbol.getSelectionModel().setSelectionMode(TreeSelectionModel.SINGLE_TREE_SELECTION);
		arbol.setFont(new Font("Arial",20, 25));
		
		for (Elemento e: asig.getElementos()) {
			raiz.add(getNode(e));
		}
		expandAllNodes(arbol, 0, arbol.getRowCount());
		
		arbol.addTreeSelectionListener(new TreeSelectionListener(){
			public void valueChanged(TreeSelectionEvent e) {
				DefaultMutableTreeNode nodo = ((DefaultMutableTreeNode) arbol.getLastSelectedPathComponent());
				Object padre = ((DefaultMutableTreeNode) nodo.getParent()).getUserObject();
				Object o = nodo.getUserObject();
				if (o instanceof Tema) {
					Tema tema = (Tema) o;
					Frame.getIntance().cambiarPanel(new PanelEditarTema(tema, padre), 1);
				} else if (o instanceof Apuntes) {
					Apuntes apuntes = (Apuntes) o;
					Frame.getIntance().cambiarPanel(new PanelEditarApuntes(apuntes, padre), 1);
				} else if (o instanceof Test) {
					Test test = (Test) o;
					if (test.isFechaValida() == false && test.isTerminado() == false) {
						Frame.getIntance().cambiarPanel(new PanelEditarTest(test, padre), 1);
					} else {
						Frame.getIntance().cambiarPanel(new PanelVisualizarTest(test), 1);
					}
				}
			}
		});
		
		JScrollPane tree = new JScrollPane(arbol);
		tree.setPreferredSize(new Dimension((int)(4*Frame.WIDTH/6),(int)(Frame.HEIGHT/1.25)));
		izq.add(tree);
		
		JPanel botones = new JPanel();
		botones.setLayout(new BoxLayout(botones,0));
		
		JButton boton_crear = new JButton("Crear elemento");
		boton_crear.addActionListener(new ActionCrearEle(this));
		botones.add(boton_crear);
		JButton eliminarAsig = new JButton ("Eliminar asignatura");
		eliminarAsig.addActionListener(new ActionEliminarAsig(asig));
		botones.add(eliminarAsig);
		izq.add(botones);
		
		SpringUtilities.makeCompactGrid(izq, 2, 1, 5, 5, 5, 5);

		JPanel der = new JPanel();
		der.setLayout(new SpringLayout());
		
		String[] alumnos = new String [asig.getMatriculados().size()];
		int i = 0;
		for (Alumno a: asig.getMatriculados()) {
			alumnos[i] = a.toString();
			i++;
		}
		
		JList <String> alumnoMatr = new JList<String>(alumnos);
		JScrollPane scrollingListOne = new JScrollPane(alumnoMatr);
		der.add(scrollingListOne);
		
		JPanel panel_botones = new JPanel();
		panel_botones.setLayout(new BoxLayout(panel_botones,0));
		JButton boton_expulsar = new JButton("Expulsar alumno");
		boton_expulsar.addActionListener(new ActionSeleccionExpulsar(this));
		panel_botones.add(boton_expulsar);
		JButton boton_readmitir = new JButton("Readmitir alumno");
		boton_readmitir.addActionListener(new ActionSeleccionReadmitir(this));
		panel_botones.add(boton_readmitir);
		der.add(panel_botones);
		
		SpringUtilities.makeCompactGrid(der, 2, 1, 5, 5, 5, 5);
		
		this.add(izq);
		this.add(der);
		SpringUtilities.makeCompactGrid(this, 1, 2, 5, 5, 5, 5);
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

	public Asignatura getAsignatura() {
		return this.asig;
	}
}
