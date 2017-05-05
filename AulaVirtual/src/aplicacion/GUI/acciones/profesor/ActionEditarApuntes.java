package aplicacion.GUI.acciones.profesor;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import aplicacion.GUI.paneles.profesor.PanelEditarApuntes;
import aplicacion.clases.elemento.Apuntes;

public class ActionEditarApuntes implements ActionListener {
	private PanelEditarApuntes vista;
	private Apuntes apuntes;
	
	public ActionEditarApuntes (PanelEditarApuntes vista, Apuntes apuntes) {
		this.vista = vista;
		this.apuntes = apuntes;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if (vista.getVisible().getSelectedItem() != null) {
			if (vista.getVisible().getSelectedItem().toString() == "Visible") {
				try {
					apuntes.setVisible(true);
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			} else if (vista.getVisible().getSelectedItem().toString() == "No visible") {
				try {
					apuntes.setVisible(false);
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		}
		apuntes.setTexto(this.vista.getTexto().getText());
	}
}
