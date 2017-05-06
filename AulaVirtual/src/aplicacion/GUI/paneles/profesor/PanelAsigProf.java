package aplicacion.GUI.paneles.profesor;

import java.awt.Dimension;
import java.awt.Font;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
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
import aplicacion.GUI.acciones.profesor.ActionConsultarNotasProf;
import aplicacion.GUI.acciones.profesor.ActionCrearEle;
import aplicacion.GUI.acciones.profesor.ActionEliminarAsig;
import aplicacion.GUI.acciones.profesor.ActionSeleccionExpulsar;
import aplicacion.GUI.acciones.profesor.ActionSeleccionReadmitir;
import aplicacion.GUI.frame.Frame;
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
	JList <Alumno> alumnoMatr;
	
	public PanelAsigProf (Asignatura asig) {
		this.asig = asig;
		this.setLayout(new SpringLayout());
		
		JPanel izq = new JPanel();
		izq.setLayout(new SpringLayout());

		DefaultMutableTreeNode raiz = new DefaultMutableTreeNode(asig);
		final JTree arbol = new JTree (raiz);
		arbol.getSelectionModel().setSelectionMode(TreeSelectionModel.SINGLE_TREE_SELECTION);
		arbol.setFont(new Font("Arial",12, 18));
		
		if (asig.getElementos().isEmpty() == false) {
			for (Elemento e: asig.getElementos()) {
				raiz.add(getNode(e));
			}
		}
		expandAllNodes(arbol, 0, arbol.getRowCount());
		
		arbol.addTreeSelectionListener(new TreeSelectionListener(){
			public void valueChanged(TreeSelectionEvent e) {
				DefaultMutableTreeNode nodo = ((DefaultMutableTreeNode) arbol.getLastSelectedPathComponent());
				Object o = nodo.getUserObject();
				if (o instanceof Asignatura) {
					return;
				}
				Object padre = ((DefaultMutableTreeNode) nodo.getParent()).getUserObject();
				if (o instanceof Tema) {
					Tema tema = (Tema) o;
					Frame.getInstance().cambiarPanel(new PanelEditarTema(tema, padre), 1);
				} else if (o instanceof Apuntes) {
					Apuntes apuntes = (Apuntes) o;
					Frame.getInstance().cambiarPanel(new PanelEditarApuntes(apuntes, padre), 1);
				} else if (o instanceof Test) {
					Test test = (Test) o;
					if (test.isTerminado()) {
						try {
							test.corregir();
						} catch (Exception e1) {
							e1.printStackTrace();
						}
					}
					Frame.getInstance().cambiarPanel(new PanelVisualizarTest(test, padre), 1);
				}
			}
		});
		
		JScrollPane tree = new JScrollPane(arbol);
		tree.setPreferredSize(new Dimension((int)(4*Frame.WIDTH/6),(int)(Frame.HEIGHT/1.25)));
		izq.add(tree);
		
		JPanel botones = new JPanel();
		botones.setLayout(new BoxLayout(botones,0));
		
		JButton eliminarAsig = new JButton ("Eliminar asignatura");
		eliminarAsig.addActionListener(new ActionEliminarAsig(asig));
		botones.add(eliminarAsig);
		JButton boton_crear = new JButton("Crear elemento");
		boton_crear.addActionListener(new ActionCrearEle(this));
		botones.add(boton_crear);
		izq.add(botones);
		
		SpringUtilities.makeCompactGrid(izq, 2, 1, 5, 5, 5, 5);

		JPanel der = new JPanel();
		der.setLayout(new SpringLayout());
		
		JLabel etiqueta_alumnos = new JLabel ("Alumnos");
		etiqueta_alumnos.setFont(new Font("Arial",12,18));
        der.add(etiqueta_alumnos);
		
        Alumno[] alumnos = new Alumno[asig.getMatriculados().size()];
		int i = 0;
		for (Alumno a: asig.getMatriculados()) {
			alumnos[i] = a;
			i++;
		}
		
		alumnoMatr = new JList<Alumno>(alumnos);
		JScrollPane scrollingListOne = new JScrollPane(alumnoMatr);
		der.add(scrollingListOne);
		
		JButton boton_nota = new JButton("Nota alumno");
		boton_nota.addActionListener(new ActionConsultarNotasProf(this, asig));
		der.add(boton_nota);
		
		JPanel panel_botones = new JPanel();
		panel_botones.setLayout(new BoxLayout(panel_botones,0));
		JButton boton_expulsar = new JButton("Expulsar alumnos");
		boton_expulsar.addActionListener(new ActionSeleccionExpulsar(this));
		panel_botones.add(boton_expulsar);
		JButton boton_readmitir = new JButton("Readmitir alumnos");
		boton_readmitir.addActionListener(new ActionSeleccionReadmitir(this));
		panel_botones.add(boton_readmitir);
		der.add(panel_botones);
		
		SpringUtilities.makeCompactGrid(der, 4, 1, 5, 5, 5, 5);
		
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
	
	public Alumno getSel() {
		return this.alumnoMatr.getSelectedValue();
	}
}
