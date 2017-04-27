package aplicacion.GUI.testers;


import javax.swing.JFrame;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.TreeSelectionModel;
import aplicacion.GUI.general.Frame;
import aplicacion.GUI.general.PanelAInicio;

public class FrameTester {
	public static void main(String[] args) {
		Frame f = new Frame();
		String[] dataList = {"Andalucia", "Aragon", "Asturias", "Baleares", 
                 "Canarias", "Cantabria", "Castilla la Mancha", 
                 "Castilla y Leon", "Catalunya", "Extremadura", 
                 "Galicia", "Madrid", "Murcia", "Navarra", 
                 "Pais Vasco", "La Rioja", "Pais Valenciano", 
                 "Ceuta", "Melilla","aaaaa","bbb","ccc","dddd","dddd","dddd","dddd","dddd","dddd","dddd","dddd","dddd","dddd","dddd","dddd","dddd","dddd","dddd","dddd","dddd","dddd","dddd","dddd","dddd","dddd","dddd","dddd","dddd","dddd","dddd","dddd","dddd","dddd","dddd","dddd","dddd","dddd","dddd","dddd","dddd","dddd"};
		//f.cambiarPanel(new PanelSolAsig());
	
		DefaultMutableTreeNode raiz = new DefaultMutableTreeNode("Apuntes de PADS");
		final JTree arbol = new JTree (raiz);
		 arbol.getSelectionModel().setSelectionMode(TreeSelectionModel.SINGLE_TREE_SELECTION);
		raiz.add(new DefaultMutableTreeNode("tema 1"));
		raiz.add(new DefaultMutableTreeNode("tema 2"));
		DefaultMutableTreeNode repositorio = new DefaultMutableTreeNode("repositorio de ejemplos"); repositorio.add(new DefaultMutableTreeNode("ejemplo 1"));
		raiz.add(repositorio);
		
		
		PanelAInicio c = new PanelAInicio(dataList, arbol);
		f.add(c);

		
		f.setVisible(true);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        
        
	}
}
