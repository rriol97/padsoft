package aplicacion.GUI.general;

import java.util.ArrayList;
import java.util.List;

import aplicacion.GUI.componentes.PanelSolAsig;

public class FrameTester {
	public static void main(String[] args) {
		Frame f = new Frame();
		List<String> l = new ArrayList<String>();
		l.add("aaaaaa");
		l.add("bbbbbbbbbbbbbbbbbbbbbbbb");
		f.cambiarPanel(new PanelSolAsig(l));
	
	}
}
