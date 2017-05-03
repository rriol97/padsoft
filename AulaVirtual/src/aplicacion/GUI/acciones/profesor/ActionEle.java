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
import aplicacion.clases.elemento.Tema;

public class ActionEle implements ActionListener {
	
	private PanelCrearEle panel;
	private Asignatura asig;

	public ActionEle(PanelCrearEle p, Asignatura asig){
		this.panel = p;
		this.asig = asig;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (panel.getOpcSel().equals("Apuntes")){
			Tema tema = panel.getTemaSel();
			if (tema != null) {
				Frame.getIntance().cambiarPanel(new PanelCrearApuntes(asig, tema),1);
			} else{
				JOptionPane.showMessageDialog(this.panel,"Elija el tema de los apuntes");
			}
		} else if (panel.getOpcSel().equals("Tema")){
			Tema tema = panel.getTemaSel();
			Frame.getIntance().cambiarPanel(new PanelCrearTema(asig, tema), 1);
		} else {
			Tema tema = panel.getTemaSel();
			if (tema != null) {
				Frame.getIntance().cambiarPanel(new PanelCrearTest(asig, tema), 1);
			} else{
				JOptionPane.showMessageDialog(this.panel,"Elija el tema del test");
			}
		}
	}
}

