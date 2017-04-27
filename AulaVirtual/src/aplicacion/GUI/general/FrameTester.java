package aplicacion.GUI.general;

import java.awt.BorderLayout;


import javax.swing.JFrame;


import aplicacion.GUI.componentes.PanelAsig2;


public class FrameTester {
	public static void main(String[] args) {
		Frame f = new Frame();
		String[] dataList = {"Andalucia", "Aragon", "Asturias", "Baleares", 
                 "Canarias", "Cantabria", "Castilla la Mancha", 
                 "Castilla y Leon", "Catalunya", "Extremadura", 
                 "Galicia", "Madrid", "Murcia", "Navarra", 
                 "Pais Vasco", "La Rioja", "Pais Valenciano", 
                 "Ceuta", "Melilla"};
		//f.cambiarPanel(new PanelSolAsig());
		PanelAsig2 a = new PanelAsig2(dataList);
		f.add(a, BorderLayout.WEST);
		//f.setSize(200, 200);
		f.setVisible(true);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
