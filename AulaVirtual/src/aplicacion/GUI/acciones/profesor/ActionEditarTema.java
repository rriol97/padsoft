package aplicacion.GUI.acciones.profesor;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import aplicacion.GUI.general.Frame;
import aplicacion.GUI.paneles.profesor.PanelAsigProf;
import aplicacion.GUI.paneles.profesor.PanelEditarTema;
import aplicacion.clases.elemento.Tema;

public class ActionEditarTema implements ActionListener {
	private PanelEditarTema vista;
	private Tema tema;
	
	public ActionEditarTema (PanelEditarTema vista, Tema tema) {
		this.vista = vista;
		this.tema = tema;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if (vista.getVisible().getSelectedItem() != null) {
			if (vista.getVisible().getSelectedItem().toString() == "Visible") {
				try {
					tema.setVisible(true);
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			} else if (vista.getVisible().getSelectedItem().toString() == "No visible") {
				try {
					tema.setVisible(false);
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		}
		Frame.getInstance().cambiarPanel(new PanelAsigProf(tema.getAsignatura()), 1);
	}
}
