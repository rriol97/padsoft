package aplicacion.GUI.profesor;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SpringLayout;

import aplicacion.GUI.SpringUtilities;
import aplicacion.GUI.acciones.ActionCancelar;
import aplicacion.GUI.acciones.profesor.ActionAceptarSol;
import aplicacion.GUI.acciones.profesor.ActionDenegarSol;
import aplicacion.clases.Solicitud;

/**
 * Clase que implementa el panel que muestra una solicitud a un profesor.
 * @author Adrian Fernandez
 * @author Ricardo Riol
 *
 */
public class PanelSolProf extends JPanel {
	private static final long serialVersionUID = 1L;
	
	private Solicitud sol;

	public PanelSolProf (Solicitud sol) {
		this.sol = sol;
		this.setLayout(new SpringLayout());
		
		JLabel etiqueta_solicitante = new JLabel("Solicitud enviada por: " + sol.getAlumno());
		this.add(etiqueta_solicitante);
		
		JLabel etiqueta_texto = new JLabel(sol.getTexto());
		this.add(etiqueta_texto);
		
		JPanel panel_botones = new JPanel();
		panel_botones.setLayout(new BoxLayout(panel_botones, 0));
		
		JButton boton_cancelar = new JButton("Cancelar");
		boton_cancelar.addActionListener(new ActionCancelar());
		panel_botones.add(boton_cancelar);
		JButton boton_denegar = new JButton("Rechazar");
		boton_denegar.addActionListener(new ActionDenegarSol(this));
		panel_botones.add(boton_denegar);
		JButton boton_aceptar = new JButton("Aceptar");
		boton_aceptar.addActionListener(new ActionAceptarSol(this));
		panel_botones.add(boton_aceptar);
		
		this.add(panel_botones);
		
		SpringUtilities.makeCompactGrid(this, 3, 1, 5, 5, 5, 5);
		
		this.setVisible(true);
	}
	
	public Solicitud getSolicitud() {
		return this.sol;
	}
}
