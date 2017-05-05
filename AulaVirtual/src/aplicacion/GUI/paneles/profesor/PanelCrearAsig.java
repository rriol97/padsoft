package aplicacion.GUI.paneles.profesor;

import java.awt.Dimension;
import java.awt.Font;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SpringLayout;

import aplicacion.GUI.SpringUtilities;
import aplicacion.GUI.acciones.ActionCancelar;
import aplicacion.GUI.acciones.profesor.ActionAceptarCrearAsig;
import aplicacion.GUI.general.Frame;

/**
 * Clase que implementa el panel de creacion de asignaturas de un profesor.
 * @author Adrian Fernandez
 * @author Ricardo Riol
 *
 */
public class PanelCrearAsig extends JPanel {
	private static final long serialVersionUID = 1L;
	
	private JTextField campo_asig;
	
	public PanelCrearAsig(){
		SpringLayout layout = new SpringLayout();
		this.setLayout(layout);
		
		JPanel aux = new JPanel();
		JLabel texto = new JLabel ("Nombre de la asignatura");
		texto.setFont(new Font ("Arial",12,18));
		
		this.campo_asig = new JTextField();
		campo_asig.setPreferredSize(new Dimension((int)Frame.WIDTH/6,(int)Frame.HEIGHT/23));
		
		JButton acp = new JButton("Aceptar");
		acp.addActionListener(new ActionAceptarCrearAsig(this));
		JButton c = new JButton ("Cancelar");
		c.addActionListener(new ActionCancelar());
		
		
		aux.add(texto);
		texto.setLabelFor(campo_asig);
		aux.add(campo_asig);
		this.add(new JPanel());
		this.add(aux);
		
		JPanel panel_botones = new JPanel();
		panel_botones.setLayout(new BoxLayout(panel_botones, 0));
		panel_botones.add(c);
		panel_botones.add(acp);
		this.add(panel_botones);
		
		SpringUtilities.makeCompactGrid(this, 3, 1, 5, 0, 5, 5);
	}
	
	public String getNombreAsig(){
		return this.campo_asig.getText();
	}
}
