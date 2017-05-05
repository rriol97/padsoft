package aplicacion.GUI.paneles.profesor.test;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.SpringLayout;

import aplicacion.clases.elemento.test.Test;

public class PanelCrearPreg extends JPanel {
	private static final long serialVersionUID = 1L;
	private JButton anadir;
	private JComboBox<String> tipoPregunta;
	
	public PanelCrearPreg (Test test){
		this.setLayout(new SpringLayout());
		
		JPanel preg = new JPanel();
		SpringLayout layoutAna = new SpringLayout();
		preg.setLayout(layoutAna);
		this.anadir = new JButton ("Anadir Pregunta");
		preg.add(this.anadir);
		layoutAna.putConstraint(SpringLayout.NORTH,this.anadir, 10, SpringLayout.NORTH, preg);
		preg.setVisible(true);
		
		JPanel tipoPreg = new JPanel();
		SpringLayout layoutTipo = new SpringLayout();
		String[]tipos = {"Respuesta unica", "Respuesta multiple", "Si/No","Respuesta corta"};
		this.tipoPregunta = new JComboBox<String>(tipos);
		tipoPreg.add(this.tipoPregunta);
		layoutTipo.putConstraint(SpringLayout.NORTH,this.anadir, 10, SpringLayout.NORTH, preg);
	}
}
