package aplicacion.GUI.general;

import java.awt.BorderLayout;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;

import aplicacion.GUI.componentes.PanelSolAsig;

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
		PanelSolAsig a = new PanelSolAsig(dataList);
		f.add(a, BorderLayout.WEST);
		//f.setSize(200, 200);
		f.setVisible(true);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
