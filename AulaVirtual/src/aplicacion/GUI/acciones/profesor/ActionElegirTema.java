package aplicacion.GUI.acciones.profesor;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import aplicacion.GUI.general.Frame;
import aplicacion.GUI.paneles.profesor.PanelCrearApuntes;
import aplicacion.GUI.paneles.profesor.PanelCrearEle;
import aplicacion.GUI.paneles.profesor.PanelCrearTema;
import aplicacion.GUI.paneles.profesor.test.PanelCrearTest;
import aplicacion.clases.Asignatura;
import aplicacion.clases.elemento.Tema;

public class ActionElegirTema implements ActionListener {
	
	private PanelCrearEle panel;
	private Asignatura asig;

	public ActionElegirTema(PanelCrearEle p, Asignatura asig){
		this.panel = p;
		this.asig = asig;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (panel.getOpcSel().equals("Apuntes")){
			Tema tema = panel.getTemaSel();
			if (tema != null) {
				Frame.getInstance().cambiarPanel(new PanelCrearApuntes(asig, tema),1);
			} else{
				JOptionPane.showMessageDialog(this.panel,"Elija el tema de los apuntes");
			}
		} else if (panel.getOpcSel().equals("Tema")){
			Tema tema = panel.getTemaSel();
			Frame.getInstance().cambiarPanel(new PanelCrearTema(asig, tema), 1);
		} else {
			Tema tema = panel.getTemaSel();
			if (tema != null) {
				Frame.getInstance().cambiarPanel(new PanelCrearTest(asig, tema), 1);
			} else{
				JOptionPane.showMessageDialog(this.panel,"Elija el tema del test");
			}
		}
	}
}

