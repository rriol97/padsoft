package aplicacion.GUI.Alumno;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SpringLayout;

import aplicacion.GUI.SpringUtilities;
import aplicacion.clases.elemento.Apuntes;

/**
 * Clase que implementa el panel que muestra unos apuntes de una asignatura.
 * @author Adrian Fernandez
 * @author Ricardo Riol
 *
 */
public class PanelApunAlum extends JPanel {
	private static final long serialVersionUID = 1L;

	public PanelApunAlum (Apuntes apun) {
		this.setLayout(new SpringLayout());
		
		JLabel etiqueta_nombre = new JLabel (apun.getNombre());
		this.add(etiqueta_nombre);
		
		JLabel etiqueta_texto = new JLabel (apun.getTexto());
		this.add(etiqueta_texto);
		
		JButton boton_volver = new JButton("Volver");
		this.add(boton_volver);
		
		SpringUtilities.makeCompactGrid(this, 3, 1, 5, 5, 5, 5);
	}
}
