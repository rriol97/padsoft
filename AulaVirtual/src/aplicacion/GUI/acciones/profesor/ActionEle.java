package aplicacion.GUI.acciones.profesor;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import aplicacion.GUI.general.Frame;
import aplicacion.GUI.profesor.PanelCrearApuntes;
import aplicacion.GUI.profesor.PanelCrearEle;
import aplicacion.GUI.profesor.PanelCrearTema;
import aplicacion.GUI.profesor.PanelCrearTest;
import aplicacion.clases.Asignatura;

public class ActionEle implements ActionListener {
	
	private Asignatura asig;
	private PanelCrearEle panel;

	public ActionEle(Asignatura asig, PanelCrearEle p){
		this.asig = asig;
		this.panel = p;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (panel.getOpcSel().equals("Apuntes")){
			Frame.getIntance().cambiarPanel(new PanelCrearApuntes(asig),1);
		} else if (panel.getOpcSel().equals("Tema")){
			Frame.getIntance().cambiarPanel(new PanelCrearTema(asig), 1);
		} else{
			Frame.getIntance().cambiarPanel(new PanelCrearTest(asig), 1);
		}
	}
}

